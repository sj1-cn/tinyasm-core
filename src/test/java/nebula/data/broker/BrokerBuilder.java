package nebula.data.broker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import com.google.common.collect.ImmutableMap;

import cc1sj.tinyasm.hero.TinyAsmClassLoader;

public class BrokerBuilder {
	Logger log = LoggerFactory.getLogger(getClass());

	Map<String, BrokerInstanceBuilder> knownBrokeres;
	final BrokerInstanceBuilderClassMaker instanceBuilder;

	ReentrantLock lock = new ReentrantLock();

	public BrokerBuilder() {
		knownBrokeres = ImmutableMap.of();
		instanceBuilder = new BrokerInstanceBuilderClassMaker();
	}

	public void clear() {
		knownBrokeres = ImmutableMap.of();
	}

	static int count = 0;

	public <T> T builder(Class<?> target) {

		BrokerInstanceBuilder builder = knownBrokeres.get(target.getName());

		if (builder != null) {
			Broker<T> broker = builder.build();
			return broker.get();
		}

		lock.lock();
		try {

			builder = knownBrokeres.get(target.getName());
			if (builder != null) {
				Broker<T> broker = builder.build();
				return broker.get();
			}

			count++;
			String typeName = target.getName() + "_BrokerAuto" + count;

			// 构建代理类
			{
				String innerTypeName = typeName.replace('.', '/');
				byte[] code;
				if (target.isInterface()) {

					ClassReader cr = new ClassReader(target.getName());
					ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);

					BrokerForInterfaceClassVisitor bw;
					bw = new BrokerForInterfaceClassVisitor(Opcodes.ASM4, cw, innerTypeName);
					cr.accept(bw, ClassReader.SKIP_CODE);

					String[] is = cr.getInterfaces();
					for (String s : is) {
						cr = new ClassReader(s);
						cr.accept(bw, ClassReader.SKIP_CODE);
					}

					code = cw.toByteArray();
				} else {
					ClassReader cr = new ClassReader(target.getName());
					ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);

					ClassVisitor bw;
					target.getConstructor();
					bw = new BrokerForClassClassVisitor(Opcodes.ASM4, cw, innerTypeName);
					cr.accept(bw, ClassReader.SKIP_CODE);
					code = cw.toByteArray();
				}

				if (log.isDebugEnabled()) {
					try {
						String filename = "tmp/" + typeName + ".class";
						String path = filename.substring(0, filename.lastIndexOf('/'));
						File file = new File(path);
						if (!file.exists()) {
							file.mkdir();
						}
						FileOutputStream fileOutputStream = new FileOutputStream(filename);
						fileOutputStream.write(code);
						fileOutputStream.close();
					} catch (FileNotFoundException e) {
						log.error("", e);
						throw new RuntimeException(e);
					}
				}

				Class<?> clzBroker = TinyAsmClassLoader.defineClass(typeName, code);
				TinyAsmClassLoader.doResolveClass(clzBroker);
			}

			// 构建代理构建类，主要是为了性能，避免每次都是用Class.newInstance() 来构建代理
			{
				String builderTypeName = typeName + "_Builder";
				byte[] codeBuilder = instanceBuilder.dump(typeName, builderTypeName);

				if (log.isDebugEnabled()) {
					try {
						String filename = "tmp/" + builderTypeName + ".class";
						String path = filename.substring(0, filename.lastIndexOf('/'));
						File file = new File(path);
						if (!file.exists()) {
							file.mkdir();
						}
						FileOutputStream fileOutputStream = new FileOutputStream(filename);
						fileOutputStream.write(codeBuilder);
						fileOutputStream.close();
					} catch (FileNotFoundException e) {
						log.error("", e);
						throw new RuntimeException(e);
					}
				}

				Class<?> clzBuilder = TinyAsmClassLoader.defineClass(builderTypeName, codeBuilder);

				builder = (BrokerInstanceBuilder) clzBuilder.getDeclaredConstructor().newInstance();
			}

			ImmutableMap.Builder<String, BrokerInstanceBuilder> mapBuilder = ImmutableMap.builder();

			this.knownBrokeres = mapBuilder.putAll(knownBrokeres).put(target.getName(), builder).build();
			BrokerHandler<T> broker = builder.build();
			return broker.get();

		} catch (ClassFormatError e) {
			log.error("", e);
			throw new RuntimeException(e);
		} catch (Exception e) {
			log.error("", e);
			throw new RuntimeException(e);
		} finally {
			lock.unlock();
		}
	}
}
