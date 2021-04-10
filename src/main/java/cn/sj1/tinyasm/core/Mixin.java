package cn.sj1.tinyasm.core;

import java.util.Stack;

import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;
import org.objenesis.instantiator.ObjectInstantiator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mixin {
	static Logger logger = LoggerFactory.getLogger(Mixin.class);

	@SuppressWarnings("unchecked")
	static public <T> ObjectInstantiator<T> build(Class<T> tclass) {

		String targetClassName = tclass.getName() + "Mixin";
		try {

			byte[] code = MixinAdvAsmBuilder.dumpMagic(tclass, targetClassName);
			Class<?> clzBroker = TinyAsmClassLoader.defineClass(targetClassName, code);

			Objenesis objenesis = new ObjenesisStd(); // or ObjenesisSerializer
			TinyAsmClassLoader.doResolveClass(clzBroker);
			ObjectInstantiator<T> builder = (ObjectInstantiator<T>) objenesis.getInstantiatorOf(clzBroker);
			return builder;
		} catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@SuppressWarnings("unchecked")
	static public <T> ObjectInstantiator<T> build(Class<T> tclass, Object[] params) {
		String targetClassName = tclass.getName() + "Mixin";
		try {

			byte[] code = MixinAdvAsmBuilder.dumpMagic(tclass, targetClassName, params);
			Class<?> clzBroker = TinyAsmClassLoader.defineClass(targetClassName, code);

			Objenesis objenesis = new ObjenesisStd(); // or ObjenesisSerializer
			TinyAsmClassLoader.doResolveClass(clzBroker);
			ObjectInstantiator<T> builder = (ObjectInstantiator<T>) objenesis.getInstantiatorOf(clzBroker);
			return builder;
		} catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	static public <T> ObjectInstantiator<T> build(Class<?> tclass, Class<?> typeArgument) {
		return build(tclass, typeArgument, new Object[0]);
	}

	@SuppressWarnings("unchecked")
	static public <T> ObjectInstantiator<T> build(Class<?> tclass, Class<?> typeArgument, Object[] params) {
		String targetClassName = tclass.getName() + "Mixin";
		try {

			byte[] code = MixinAdvAsmBuilder.dumpMagic(tclass, targetClassName, new Class[] { typeArgument }, params);
			Class<?> clzBroker = TinyAsmClassLoader.defineClass(targetClassName, code);

			Objenesis objenesis = new ObjenesisStd(); // or ObjenesisSerializer
			TinyAsmClassLoader.doResolveClass(clzBroker);
			ObjectInstantiator<T> builder = (ObjectInstantiator<T>) objenesis.getInstantiatorOf(clzBroker);
			return builder;
		} catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public static void __(ConsumerWithException<MethodCode> block) {
		_contextThreadLocal.get().exec(block);
	}

	public static <T> T getParam(Class<T> tclass) {
		return _contextThreadLocal.get().getParam(tclass);
	}

	public static <T> T getParam(int index) {
		return _contextThreadLocal.get().getParam(index);
	}

	/**********************************************
	 * enter method code
	 * 
	 * 
	 * 
	 * 
	 * 
	 ***********************************************/
	static private ThreadLocal<Stack<MixContext>> _contextThreadLocalStack = new ThreadLocal<>();
	static ThreadLocal<MixContext> _contextThreadLocal = new ThreadLocal<>();

	static int level = 0;

	static MixContext enterCode(MethodCode code, Object[] params) {
		level++;
		logger.debug("enter code level {}", level);
		MixContext newContext;
		if (_contextThreadLocal.get() != null) {
			if (_contextThreadLocalStack.get() == null) {
				_contextThreadLocalStack.set(new Stack<>());
			}
			_contextThreadLocalStack.get().push(_contextThreadLocal.get());
			logger.debug("_contextThreadLocalStack {}", _contextThreadLocalStack.get().size());
			newContext = new MixContext(code, params);
		} else {
			newContext = new MixContext(code, params);
		}

		_contextThreadLocal.set(newContext);
		return newContext;
	}

	static MixContext enterCode(MethodCode code) {
		level++;
		logger.debug("enter code level {}", level);
		MixContext newContext;
		if (_contextThreadLocal.get() != null) {
			if (_contextThreadLocalStack.get() == null) {
				_contextThreadLocalStack.set(new Stack<>());
			}
			_contextThreadLocalStack.get().push(_contextThreadLocal.get());
			logger.debug("_contextThreadLocalStack {}", _contextThreadLocalStack.get().size());
			newContext = new MixContext(_contextThreadLocal.get(), code);
		} else {
			newContext = new MixContext(code);
		}
		_contextThreadLocal.set(newContext);
		return newContext;
	}

	static void exitCode() {
		MixContext currentContext = _contextThreadLocal.get();
		currentContext.clear();
		if (_contextThreadLocalStack.get() != null && _contextThreadLocalStack.get().size() > 0) {
			logger.debug("_contextThreadLocalStack {}", _contextThreadLocalStack.get().size());
			_contextThreadLocal.set(_contextThreadLocalStack.get().pop());
		} else {
			_contextThreadLocal.set(null);
		}
		logger.debug("exit  code level {}", level);
		level--;
	}

}
