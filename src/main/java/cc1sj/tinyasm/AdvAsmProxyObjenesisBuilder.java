package cc1sj.tinyasm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;
import org.objenesis.instantiator.ObjectInstantiator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class AdvAsmProxyObjenesisBuilder {
	Objenesis objenesis = new ObjenesisStd(); // or ObjenesisSerializer
	Logger log = LoggerFactory.getLogger(getClass());

	Map<String, ObjectInstantiator<?>> knownBrokeres;
//	final BrokerInstanceBuilderClassMaker instanceBuilder;

	ReentrantLock lock = new ReentrantLock();

	public AdvAsmProxyObjenesisBuilder() {
		knownBrokeres = new HashMap<String, ObjectInstantiator<?>>();
		this.knownBrokeres.put(Object.class.getName(), objenesis.getInstantiatorOf(ObjectAdvAsmProxy.class));
	}

	public void clear() {
		knownBrokeres = new HashMap<String, ObjectInstantiator<?>>();
	}

	static int count = 0;

	public <T> T buildProxyClass(Class<?> target, Class<?> typeParameter, ThreadLocal<AdvContext> _contextThreadLocal, int magicNumber) {

		String key = target.getName() + "_" + typeParameter.getName();

		ObjectInstantiator<?> builder = knownBrokeres.get(key);

		if (builder != null) {
			return make(builder, _contextThreadLocal, magicNumber);
		}

		lock.lock();
		try {

			builder = knownBrokeres.get(key);
			if (builder != null) {
				return make(builder, _contextThreadLocal, magicNumber);
			}

			count++;

			{
				String standardProxyClassName = key + "ObjenesisAdvAsmProxy";

				try {
					Class<?> clzBroker = Class.forName(standardProxyClassName);
					builder = objenesis.getInstantiatorOf(clzBroker);
				} catch (ClassNotFoundException e) {
				}
			}

			// 构建代理类
			if (builder == null) {
//				String proxyClassSuffix = 
				String proxyClassName = this.getClass().getName() + "_" + key.replace('.', '_') + count;
				byte[] code;
				if (target.isInterface()) {
					code = AdvAsmProxyGenericInterfaceAdvAsmBuilder.dump2(target, typeParameter, proxyClassName);
				} else {
//					code = AdvAsmProxyClassAdvAsmBuilder.dump2(target, proxyClassName);
					throw new UnsupportedOperationException();
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

			this.knownBrokeres.put(key, builder);

			return make(builder, _contextThreadLocal, magicNumber);

		} catch (ClassFormatError e) {
			log.error("", e);
			throw new RuntimeException(target.getName(), e);
		} catch (Exception e) {
			log.error("", e);
			throw new RuntimeException(target.getName(), e);
		} finally {
			lock.unlock();
		}
	}

	public <T> T buildProxyClass(Class<T> target, ThreadLocal<AdvContext> _contextThreadLocal, int magicNumber) {

		ObjectInstantiator<?> builder = knownBrokeres.get(target.getName());

		if (builder != null) {
			return make(builder, _contextThreadLocal, magicNumber);
		}

		lock.lock();
		try {

			builder = knownBrokeres.get(target.getName());
			if (builder != null) {
				return make(builder, _contextThreadLocal, magicNumber);
			}

			count++;

			{
				String standardProxyClassName = target.getName() + "ObjenesisAdvAsmProxy";

				try {
					Class<?> clzBroker = Class.forName(standardProxyClassName);
					builder = objenesis.getInstantiatorOf(clzBroker);
				} catch (ClassNotFoundException e) {
				}
			}

			// 构建代理类
			if (builder == null) {
//				String proxyClassSuffix = 
				String proxyClassName = this.getClass().getName() + "_" + target.getName().replace('.', '_') + count;
				byte[] code;
				if (target.isInterface()) {
					code = AdvAsmProxyInterfaceAdvAsmBuilder.dump2(target, proxyClassName);
				} else {
					code = AdvAsmProxyClassAdvAsmBuilder.dump2(target, proxyClassName);
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

			this.knownBrokeres.put(target.getName(), builder);

			return make(builder, _contextThreadLocal, magicNumber);

		} catch (ClassFormatError e) {
			log.error("", e);
			throw new RuntimeException(target.getName(), e);
		} catch (Exception e) {
			log.error("", e);
			throw new RuntimeException(target.getName(), e);
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
	protected <T> T make(ObjectInstantiator<?> builder, ThreadLocal<AdvContext> _contextThreadLocal, int magicNumber) {
		T t = (T) builder.newInstance();
		AdvRuntimeReferNameObject o = (AdvRuntimeReferNameObject) t;
		o.set__Context(_contextThreadLocal, (byte) magicNumber);
		return t;
	}
}
