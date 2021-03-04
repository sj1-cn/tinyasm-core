package cc1sj.tinyasm.tinyasmproxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Stack;
import java.util.function.Consumer;

import org.objectweb.asm.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cc1sj.tinyasm.MethodCode;

public class TinyAsmBuilder {


	// Need Change to ThreadLocal
//	static int _localsLast;
	static ThreadLocal<Stack<TinyAsmBuilderContext>> _contextThreadLocalStackThreadLocal = new ThreadLocal<>();
	static private ThreadLocal<TinyAsmBuilderContext> _contextThreadLocalThreadLocal = new ThreadLocal<>();

	static Logger logger = LoggerFactory.getLogger(TinyAsmBuilder.class);

//
//	static public <T> T var(Class<T> t) {
//		TinyAsmBuilderContext _contextThreadLocal = _contextThreadLocalThreadLocal.get();
//		MethodCode code = _contextThreadLocal.code;
//		int locals = code.define(String.valueOf("V" + (_contextThreadLocal._localsLast + 1)), t);
//		_contextThreadLocal._localsLast = locals;
//		return refer(code, t, locals);
//	}
//
//	static public int cst(int i) {
//		TinyAsmBuilderContext _contextThreadLocal = _contextThreadLocalThreadLocal.get();
//		MethodCode code = _contextThreadLocal.code;
//
//		code.LINE();
//		code.LOADConst(i);
//		return storeTopAndRefer(_contextThreadLocal.code, int.class);
//	}



	static public int inc(int l, int r) {
		TinyAsmBuilderContext _contextThreadLocal = _contextThreadLocalThreadLocal.get();
		MethodCode code = _contextThreadLocal.code;
		code.LINE();
		int locals = l - MAGIC_int;
		code.IINC(locals, r);
		return l;
	}

	static public <T> T getField(String name, Class<T> clazz) {
		TinyAsmBuilderContext _contextThreadLocal = _contextThreadLocalThreadLocal.get();
		MethodCode code = _contextThreadLocal.code;
		code.LINE();
		code.LOAD_THIS();
		code.GETFIELD_OF_THIS(name);
		return storeTopAndRefer(clazz);
	}

	static public <T> T param(String name, Class<T> clazz) {
		TinyAsmBuilderContext _contextThreadLocal = _contextThreadLocalThreadLocal.get();
		MethodCode code = _contextThreadLocal.code;
		int locals = code.codeLocalGetLocals(name);
		return refer(_contextThreadLocal.code, clazz, locals);
	}

	static public <T> void ret(T value) {
		TinyAsmBuilderContext _contextThreadLocal = _contextThreadLocalThreadLocal.get();
		MethodCode code = _contextThreadLocal.code;
		resolve(code, value);
		code.RETURNTop();
	}

	static public <T> void setField(String name, T value) {
		TinyAsmBuilderContext _contextThreadLocal = _contextThreadLocalThreadLocal.get();
		MethodCode code = _contextThreadLocal.code;
		code.LINE();
		code.LOAD_THIS();
		resolve(code, value);
		code.PUTFIELD_OF_THIS(name);
	}

	//	static public void whileLt(int left, int right, Consumer<MethodCode> block) {
//		
	TinyAsmBuilderContext _contextThreadLocal = _contextThreadLocalThreadLocal.get();
	MethodCode code = _contextThreadLocal.code;
//		code.LINE();
//		Label labelBlockEnd = new Label();
//		code.GOTO(labelBlockEnd);
//		Label labelBlockBegin = new Label();
//		code.visitLabel(labelBlockBegin);
//
//		block.accept(code);
//
//		code.visitLabel(labelBlockEnd);
//
//		code.LINE();
//		resolve(code, left);
//		resolve(code, right);
//		code.IF_ICMPLT(labelBlockBegin);
//	}

	static public <T> T ctor(Class<T> helloclass) {

		TinyAsmBuilderContext _contextThreadLocal = _contextThreadLocalThreadLocal.get();
		MethodCode code = _contextThreadLocal.code;
//		_locals++;
//		String key = String.valueOf(MAGICSTRING + _locals);
		code.LINE();
		code.NEW(helloclass);
		code.DUP();
		code.SPECIAL(helloclass, "<init>").INVOKE();

		int locals = code.define(String.valueOf("V" + (_contextThreadLocal._localsLast + 1)), helloclass);
		_contextThreadLocal._localsLast = locals;
		code.STORE(locals);
		String strKey = String.valueOf(MAGICSTRING + locals);

		T t = brokerBuilder.buildProxyClass(helloclass, _contextThreadLocal, strKey);
		return t;
	}

	static public <T> T ctor(Class<T> helloclass, Object... params) {

		TinyAsmBuilderContext _contextThreadLocal = _contextThreadLocalThreadLocal.get();
		MethodCode code = _contextThreadLocal.code;
		Constructor<?> c = matchConstruct(helloclass, params);
		if (c == null) throw new UnsupportedOperationException();

		code.LINE();
		code.NEW(helloclass);
		code.DUP();

		Class<?>[] paramTypes = c.getParameterTypes();

		for (int i = 0; i < params.length; i++) {
			resolve(code, paramTypes[i], params[i]);
		}

		code.SPECIAL(helloclass, "<init>").parameter(c.getParameterTypes()).INVOKE();

		int locals = code.define(String.valueOf("V" + (_contextThreadLocal._localsLast + 1)), helloclass);
		_contextThreadLocal._localsLast = locals;
		code.STORE(locals);
		String strKey = String.valueOf(MAGICSTRING + locals);

		T t = brokerBuilder.buildProxyClass(helloclass, _contextThreadLocal, strKey);
		return t;
	}

	protected static Constructor<?> matchConstruct(Class<?> helloclass, Object... params) {
		Constructor<?> c = null;
		for (Constructor<?> init : helloclass.getConstructors()) {
			if (init.getParameterCount() == params.length) {
				boolean matched = true;
				Class<?>[] definedParams = init.getParameterTypes();
				for (int i = 0; i < params.length; i++) {
					if (definedParams[i].getClass() == params[i].getClass()) {

					} else if (match(definedParams[i], params[i].getClass())) {

					} else {
						matched = false;
						break;
					}
				}
				if (matched) c = init;
			}
		}
		return c;
	}

	private static boolean match(Class<?> l, Class<?> r) {
		if (l.isPrimitive()) {
			return (l == byte.class && r == Byte.class) || (l == char.class && r == Character.class)
					|| (l == short.class && r == Short.class) || (l == int.class && r == Integer.class)
					|| (l == long.class && r == Long.class) || (l == float.class && r == Float.class)
					|| (l == double.class && r == Double.class);
		}
		return false;
	}

	public static <T> T storeTopAndRefer(MethodCode code, Class<T> t) {
		if (t == boolean.class) {
			return (T) Boolean.valueOf(false);
		} else {
			TinyAsmBuilderContext _contextThreadLocal = _contextThreadLocalThreadLocal.get();
			int locals = code.define(String.valueOf("V" + (_contextThreadLocal._localsLast + 1)), t);
			_contextThreadLocal._localsLast = locals;
			code.STORE(locals);
			return refer(code, t, locals);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T refer(MethodCode code, Class<T> t, int locals) {
		TinyAsmBuilderContext _contextThreadLocal = _contextThreadLocalThreadLocal.get();

		if (t.isPrimitive()) {
			if (t == boolean.class) {
				return (T) Boolean.valueOf(false);
			} else if (t == byte.class) {
				Byte key = (byte) (MAGIC_byte + locals);
				return (T) key;
			} else if (t == char.class) {
				Character key = (char) (MAGIC_char + locals);
				return (T) key;
			} else if (t == short.class) {
				Short key = (short) (MAGIC_short + locals);
				return (T) key;
			} else if (t == int.class) {
				Integer key = (int) (MAGIC_int + locals);
				return (T) key;
			} else if (t == long.class) {
				Long key = (long) (MAGIC_long + locals);
				return (T) key;
			} else if (t == float.class) {
				Float key = (float) (MAGIC_float + locals);
				return (T) key;
			} else if (t == double.class) {
				Double key = (double) (MAGIC_double + locals);
				return (T) key;
			}
		} else {
			if (t == boolean.class) {
				throw new UnsupportedOperationException();
			} else if (t == Byte.class) {
				Byte key = (byte) (MAGIC_byte + locals);
				return (T) key;
			} else if (t == Character.class) {
				Character key = (char) (MAGIC_char + locals);
				return (T) key;
			} else if (t == Short.class) {
				Short key = (short) (MAGIC_short + locals);
				return (T) key;
			} else if (t == Integer.class) {
				Integer key = (int) (MAGIC_int + locals);
				return (T) key;
			} else if (t == Long.class) {
				Long key = (long) (MAGIC_long + locals);
				return (T) key;
			} else if (t == Float.class) {
				Float key = (float) (MAGIC_float + locals);
				return (T) key;
			} else if (t == Double.class) {
				Double key = (double) (MAGIC_double + locals);
				return (T) key;
			} else if (t == String.class) {
				String key = String.valueOf(MAGICSTRING + locals);
				return (T) key;
			} else if (t.isInterface()) {
				String strKey = String.valueOf(MAGICSTRING + locals);
				T proxy = brokerBuilder.buildProxyClass(t, _contextThreadLocal, strKey);
				return proxy;
			} else if (!Modifier.isFinal(t.getModifiers())) {
				String strKey = String.valueOf(MAGICSTRING + locals);
				T proxy = brokerBuilder.buildProxyClass(t, _contextThreadLocal, strKey);
				return proxy;
			} else {
				return null;
			}

		}

		return null;
	}

	static public void resolveBasic(MethodCode code, Object obj) {
		Class<?> vc = obj.getClass();
		if (vc.isPrimitive()) {
			if (vc == byte.class) {
				resolve(code, ((Byte) obj).byteValue());
			} else if (vc == char.class) {
				resolve(code, ((Character) obj).charValue());
			} else if (vc == short.class) {
				resolve(code, ((Short) obj).shortValue());
			} else if (vc == int.class) {
				resolve(code, ((Integer) obj).intValue());
			} else if (vc == long.class) {
				resolve(code, ((Long) obj).longValue());
			} else if (vc == float.class) {
				resolve(code, ((Float) obj).floatValue());
			} else if (vc == double.class) {
				resolve(code, ((Double) obj).doubleValue());
			}
		} else {
			if (vc == Byte.class) {
				resolve(code, ((Byte) obj));
			} else if (vc == Character.class) {
				resolve(code, ((Character) obj));
			} else if (vc == Short.class) {
				resolve(code, ((Short) obj));
			} else if (vc == Integer.class) {
				resolve(code, ((Integer) obj));
			} else if (vc == Long.class) {
				resolve(code, ((Long) obj));
			} else if (vc == Float.class) {
				resolve(code, ((Float) obj));
			} else if (vc == Double.class) {
				resolve(code, ((Double) obj));
			} else if (vc == Byte.class) {
				resolve(code, ((Byte) obj));
			} else if (vc == Byte.class) {
				resolve(code, ((Byte) obj));
			} else if (obj instanceof TinyAsmProxyRuntimeReferNameObject) {
				String name = ((TinyAsmProxyRuntimeReferNameObject) obj).get__ReferName();
				int locals = Integer.valueOf(name.substring(MAGICSTRING.length()));
				code.LOAD(locals);
			} else {
				throw new UnsupportedOperationException("Only accept tinyasm proxy object");
			}
		}
	}
}
