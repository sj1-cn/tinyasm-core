package cc1sj.tinyasm.hero;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableMap;

import cc1sj.tinyasm.MethodCode;

class TinyAsmProxyBuilder {
	Logger log = LoggerFactory.getLogger(getClass());

	Map<String, TinyAsmProxyRuntimeProxyFactory> knownBrokeres;
//	final BrokerInstanceBuilderClassMaker instanceBuilder;

	ReentrantLock lock = new ReentrantLock();

	public TinyAsmProxyBuilder() {
		knownBrokeres = ImmutableMap.of();
//		instanceBuilder = new BrokerInstanceBuilderClassMaker();
	}

	public void clear() {
		knownBrokeres = ImmutableMap.of();
	}

	static int count = 0;

	@SuppressWarnings("unchecked")
	public <T> T builder(Class<T> target, String name, MethodCode methodCode) {

		TinyAsmProxyRuntimeProxyFactory builder = knownBrokeres.get(target.getName());

		if (builder != null) {
			T broker = (T) builder.build(methodCode, name);
			return broker;
		}

		lock.lock();
		try {

			builder = knownBrokeres.get(target.getName());
			if (builder != null) {
				T broker = (T) builder.build(methodCode, name);
				return broker;
			}

			count++;
			String proxyClassSuffix = "Inner" + count;
			String proxyClassName = target.getName() + proxyClassSuffix;

			// 构建代理类
			{
				byte[] code;
				if (target.isInterface()) {
					code = TinyAsmProxyForInterfaceAsmBuilder.dump2(target, proxyClassSuffix);
				} else {
					code = TinyAsmProxyForClassBuilder.dump2(target, proxyClassSuffix);
				}

				if (log.isDebugEnabled()) {
					try {
						String filename = "tmp/" + proxyClassName + ".class";
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

				Class<?> clzBroker = TinyAsmClassLoader.defineClass(proxyClassName, code);
				TinyAsmClassLoader.doResolveClass(clzBroker);
			}

			// 构建代理构建类，主要是为了性能，避免每次都是用Class.newInstance() 来构建代理
			{
				String proxyBuilderClassName = proxyClassName + "_Builder";
				byte[] codeBuilder = TinyAsmProxyFactoryAsmBuilder.dump(proxyClassName, "_Builder");

				if (log.isDebugEnabled()) {
					try {
						String filename = "tmp/" + proxyBuilderClassName + ".class";
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

				Class<?> clzBuilder = TinyAsmClassLoader.defineClass(proxyBuilderClassName, codeBuilder);

				builder = (TinyAsmProxyRuntimeProxyFactory) clzBuilder.getDeclaredConstructor().newInstance();
			}

			ImmutableMap.Builder<String, TinyAsmProxyRuntimeProxyFactory> mapBuilder = ImmutableMap.builder();

			this.knownBrokeres = mapBuilder.putAll(knownBrokeres).put(target.getName(), builder).build();
			T broker = (T) builder.build(methodCode, name);
			return broker;

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
