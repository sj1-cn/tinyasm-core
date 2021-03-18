package cn.sj1.tinyasm.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TinyAsmClassLoader extends ClassLoader {
	static Logger log = LoggerFactory.getLogger(TinyAsmClassLoader.class);

	public TinyAsmClassLoader() {
		super(TinyAsmClassLoader.class.getClassLoader());
	}

	static TinyAsmClassLoader instance;

	public static final Class<?> defineClass(String name, byte[] b) {
		if (log.isTraceEnabled()) {
			log.trace("defineClass [ " + name + " ]");
		}
		if (instance == null) instance = new TinyAsmClassLoader();
		return instance.defineClass(name, b, 0, b.length);
	}

	static ClassLoader getInstance() {
		if (instance == null) instance = new TinyAsmClassLoader();
		return instance;
	}

	public static void doResolveClass(Class<?> clzBroker) {
		if (instance == null) instance = new TinyAsmClassLoader();
		instance.resolveClass(clzBroker);
	}
}
