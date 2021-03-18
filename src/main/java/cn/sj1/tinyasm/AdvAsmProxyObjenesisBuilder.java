package cn.sj1.tinyasm;

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

	public <T> T buildProxyClass(ThreadLocal<AdvContext> _contextThreadLocal, int magicNumber, Class<?> target, Class<?>... typeParameters) {

		String key = target.getName() + "_" + Adv.join(typeParameters, t -> t.getName());

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
					code = AdvAsmProxyClassAdvAsmBuilder.dumpInterface(target, typeParameters, proxyClassName);
				} else {
					code = AdvAsmProxyClassAdvAsmBuilder.dumpClass(target, typeParameters, proxyClassName);
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

	public <T> T buildProxyClass(ThreadLocal<AdvContext> _contextThreadLocal, Class<T> target, int magicNumber) {

		String key = target.getName();

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
					code = AdvAsmProxyClassAdvAsmBuilder.dumpInterface(target, proxyClassName);
				} else {
					code = AdvAsmProxyClassAdvAsmBuilder.dumpClass(target, proxyClassName);
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

	public <T> T buildMagicProxyClass(ThreadLocal<AdvContext> _contextThreadLocal, Class<T> target, int magicNumber, Class<?>... typeParameters) {

//		String key = target.getName() + "_" + Adv.join(typeParameters, t -> t.getName());
		Class<?> clzBroker;

		lock.lock();
		try {

			count++;

			{
				String standardProxyClassName = target.getName() + "ObjenesisAdvAsmProxy";

				try {
					clzBroker = Class.forName(standardProxyClassName);
					return makeMagicProxy(clzBroker, _contextThreadLocal, magicNumber);
				} catch (ClassNotFoundException e) {
				}
			}
			{
//				String proxyClassSuffix = 
				String proxyClassName = this.getClass().getName() + "_" + target.getName().replace('.', '_') + count;
				byte[] code;
				code = AdvAsmProxyMagicClassAdvAsmBuilder.dumpMagic(target, typeParameters, proxyClassName);

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

				clzBroker = TinyAsmClassLoader.defineClass(proxyClassName, code);

				TinyAsmClassLoader.doResolveClass(clzBroker);

			}

			return makeMagicProxy(clzBroker, _contextThreadLocal, magicNumber);

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

	public <T> T buildMagicProxyClass(ThreadLocal<AdvContext> _contextThreadLocal, Class<T> target, int magicNumber) {

		Class<?> clzBroker;

		lock.lock();
		try {

			count++;

			{
				String standardProxyClassName = target.getName() + "ObjenesisAdvAsmProxy";

				try {
					clzBroker = Class.forName(standardProxyClassName);
					return makeMagicProxy(clzBroker, _contextThreadLocal, magicNumber);
				} catch (ClassNotFoundException e) {
				}
			}
			{
//				String proxyClassSuffix = 
				String proxyClassName = this.getClass().getName() + "_" + target.getName().replace('.', '_') + count;
				byte[] code;
				code = AdvAsmProxyMagicClassAdvAsmBuilder.dumpMagic(target, proxyClassName);

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

				clzBroker = TinyAsmClassLoader.defineClass(proxyClassName, code);

				TinyAsmClassLoader.doResolveClass(clzBroker);

			}

			return makeMagicProxy(clzBroker, _contextThreadLocal, magicNumber);

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

	@SuppressWarnings("unchecked")
	private <T> T makeMagicProxy(Class<?> clzBroker, ThreadLocal<AdvContext> _contextThreadLocal, int magicNumber) {
		try {
			T t = (T) clzBroker.getConstructor().newInstance();
			AdvRuntimeReferNameObject o = (AdvRuntimeReferNameObject) t;
			o.set__Context(_contextThreadLocal, (byte) magicNumber);
			return t;
		} catch (Exception e) {
			throw new UnsupportedOperationException(e);
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
