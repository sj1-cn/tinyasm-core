package cc1sj.tinyasm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cc1sj.tinyasm.Adv.*;

import static org.objectweb.asm.Opcodes.*;

public class AdvClassBuilderImpl implements AfterClassModifier, AfterClassName, AfterClassExtends, AfterClassImplements, AdvClassBuilder,
		AfterModifier, AfterClassEnd {

	int classAccess = 0;
	String className;
	Clazz _extends;
	List<Clazz> _implements = new ArrayList<>();
	Map<String, Clazz> maps = new HashMap<>();
	ClassBody classBody;

	int memberAccess = 0;
	ThreadLocal<AdvContext> _contextThreadLocal;

	public AdvClassBuilderImpl(ThreadLocal<AdvContext> _contextThreadLocal) {
		this._contextThreadLocal = _contextThreadLocal;
	}

	public void access(int accPublic) {
		this.classAccess |= accPublic;
	}

	@Override
	public AfterClassName class_(String className) {
		this.className = className;
		return this;
	}

	@Override
	public AfterClassExtends extends_(Class<?> _extends) {
		this._extends = Clazz.of(_extends);
		return this;
	}

	@Override
	public AfterClassImplements implements_(Class<?> _implement) {
		this._implements.add(Clazz.of(_implement));
		return this;
	}

	@Override
	public AdvClassBuilder enterClassBody() {
		ClassHeader ch;
		if (_extends != null) {
			ch = ClassBuilder.make(className, _extends);
		} else {
			ch = ClassBuilder.make(className);
		}

		if (_implements != null && _implements.size() > 0) {
			for (Clazz clazz : _implements) {
				ch.implement(clazz);
			}
		}

		classBody = ch.body();

		return this;
	}

	@Override
	public AfterMethodName method(String methodName) {
		AdvMethodBuilder methodBuilder = new AdvMethodBuilder(classBody, memberAccess, methodName);
		return methodBuilder;
	}

	@Override
	public AfterMethodName method(int access, String methodName) {
		AdvMethodBuilder methodBuilder = new AdvMethodBuilder(classBody, access, methodName);
		return methodBuilder;
	}


	@Override
	public AfterModifier public_() {
		this.memberAccess |= ACC_PUBLIC;
		return this;
	}

	@Override
	public AfterModifier protected_() {
		this.memberAccess |= ACC_PROTECTED;
		return this;
	}

	@Override
	public AfterModifier private_() {
		this.memberAccess |= ACC_PRIVATE;
		return this;
	}

	ClassBuilder classBuilder;

	@Override
	public AfterClassEnd end() {
		classBuilder = classBody.end();
		return this;
	}

	@Override
	public byte[] toByteArray() {
		return classBuilder.toByteArray();
	}

	public boolean_ field_boolean(String name) {
		int localsIndex = classBody.field(name, boolean.class);
		return new boolean_Holder(_contextThreadLocal, (byte) (MAGIC_FIELD_NUMBER + localsIndex));
	}

	public Boolean__ field_Boolean(String name) {
		int localsIndex = classBody.field(name, boolean.class);
		return new Boolean__Holder(_contextThreadLocal, (byte) (MAGIC_FIELD_NUMBER + localsIndex));
	}

	public byte field_byte(String name) {
		int localsIndex = classBody.field(name, byte.class);
		return (byte) (MAGIC_FIELD_NUMBER + localsIndex);
	}

	public short field_short(String name) {
		int localsIndex = classBody.field(name, short.class);
		return (short) (MAGIC_FIELD_NUMBER + localsIndex);
	}

	public int field_int(String name) {
		int localsIndex = classBody.field(name, int.class);
		return (int) (MAGIC_FIELD_NUMBER + localsIndex);
	}

	public long field_long(String name) {
		int localsIndex = classBody.field(name, long.class);
		return (long) (MAGIC_FIELD_NUMBER + localsIndex);
	}

	public float field_float(String name) {
		int localsIndex = classBody.field(name, float.class);
		return (float) (MAGIC_FIELD_NUMBER + localsIndex);
	}

	public double field_double(String name) {
		int localsIndex = classBody.field(name, double.class);
		return (double) (MAGIC_FIELD_NUMBER + localsIndex);
	}

	@SuppressWarnings("unchecked")
	public <T> T field(String name, Class<T> clazz) {

		int localsIndex = classBody.field(name, clazz);

		if (clazz == Boolean.class) {
			throw new UnsupportedOperationException("请使用 field_boolean");
		} else if (clazz == Byte.class) {
			Byte key = (byte) (MAGIC_FIELD_NUMBER + localsIndex);
			return (T) key;
		} else if (clazz == Character.class) {
			Character key = (char) (MAGIC_FIELD_NUMBER + localsIndex);
			return (T) key;
		} else if (clazz == Short.class) {
			Short key = (short) (MAGIC_FIELD_NUMBER + localsIndex);
			return (T) key;
		} else if (clazz == Integer.class) {
			Integer key = (int) (MAGIC_FIELD_NUMBER + localsIndex);
			return (T) key;
		} else if (clazz == Long.class) {
			Long key = (long) (MAGIC_FIELD_NUMBER + localsIndex);
			return (T) key;
		} else if (clazz == Float.class) {
			Double key = (double) (MAGIC_FIELD_NUMBER + localsIndex);
			return (T) key;
		} else if (clazz == Double.class) {
			Double key = (double) (MAGIC_FIELD_NUMBER + localsIndex);
			return (T) key;
		} else if (clazz == String.class) {
			String key = String.valueOf(MAGIC_LOCALS_String + localsIndex);
			return (T) key;
		} else {
			byte magicNumber = (byte) (MAGIC_FIELD_NUMBER + localsIndex);
			T obj = Adv.buildProxyClass(clazz, magicNumber);
			return (T) obj;
//			return null;
//		} else {
//			throw new UnsupportedOperationException("Only accept tinyasm proxy object");
		}
	}
}
