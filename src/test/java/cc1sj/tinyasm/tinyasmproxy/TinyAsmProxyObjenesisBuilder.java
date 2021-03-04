package cc1sj.tinyasm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;
import org.objenesis.instantiator.ObjectInstantiator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableMap;

class TinyAsmProxyObjenesisBuilder {
	Objenesis objenesis = new ObjenesisStd(); // or ObjenesisSerializer
	Logger log = LoggerFactory.getLogger(getClass());

	Map<String, ObjectInstantiator<?>> knownBrokeres;
//	final BrokerInstanceBuilderClassMaker instanceBuilder;

	ReentrantLock lock = new ReentrantLock();

	public TinyAsmProxyObjenesisBuilder() {
		knownBrokeres = ImmutableMap.of();
//		instanceBuilder = new BrokerInstanceBuilderClassMaker();
	}

	public void clear() {
		knownBrokeres = ImmutableMap.of();
	}

	static int count = 0;

	public <T> T builder(Class<T> target, TinyAsmBuilderContext context, String name) {

		ObjectInstantiator<?> builder = knownBrokeres.get(target.getName());

		if (builder != null) {
			return make(builder, name, context);
		}

		lock.lock();
		try {

			builder = knownBrokeres.get(target.getName());
			if (builder != null) {
				return make(builder, name, context);
			}

			count++;
			
			{
				String standardProxyClassName = target.getName() + "TinyAsmProxy";
				
				
		        try {
		        	Class<?> clzBroker =Class.forName(standardProxyClassName);
					builder = objenesis.getInstantiatorOf(clzBroker);
		        } catch (ClassNotFoundException e) {
		        }
			}
			

			// 构建代理类
			if (builder == null) {
//				String proxyClassSuffix = 
				String proxyClassName =  this.getClass().getName() + "_" +  target.getName().replace('.', '_')+ count;
				byte[] code;
				if (target.isInterface()) {
					code = TinyAsmProxyForInterfaceAsmBuilder.dump2(target, proxyClassName);
				} else {
					code = TinyAsmProxyForClassAsmBuilder.dump2(target, proxyClassName);
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
				builder = objenesis.getInstantiatorOf(clzBroker);
			}

			ImmutableMap.Builder<String, ObjectInstantiator<?>> mapBuilder = ImmutableMap.builder();

			this.knownBrokeres = mapBuilder.putAll(knownBrokeres).put(target.getName(), builder).build();

			return make(builder, name, context);

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
    public static boolean isPresent(String name) {
        try {
            Thread.currentThread().getContextClassLoader().loadClass(name);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
	@SuppressWarnings("unchecked")
	protected <T> T make(ObjectInstantiator<?> builder, String name, TinyAsmBuilderContext context) {
		T t = (T) builder.newInstance();
		TinyAsmProxyRuntimeReferNameObject o = (TinyAsmProxyRuntimeReferNameObject) t;
		o.__init(context, name);
		return t;
	}
}
