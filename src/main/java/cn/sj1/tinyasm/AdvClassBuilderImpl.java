package cn.sj1.tinyasm;

import static cn.sj1.tinyasm.Adv.MAGIC_FIELDS_NUMBER;
import static cn.sj1.tinyasm.Adv.MAGIC_LOCALS_String;
import static org.objectweb.asm.Opcodes.ACC_PRIVATE;
import static org.objectweb.asm.Opcodes.ACC_PROTECTED;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;

import java.util.ArrayList;
import java.util.List;

public class AdvClassBuilderImpl implements UsingClassBody, AdvAfterClassModifier, AdvAfterClassName, AdvAfterClassExtends,
		AdvAfterClassImplements, AdvClassBuilder, AdvAfterModifier, AdvAfterClassEnd {

	private ThreadLocal<AdvContext> _contextThreadLocal;
	private int classAccess = 0;
	private String className;
	private Clazz _extends;
	private List<Clazz> _implements = new ArrayList<>();
	private ClassBody classBody;
	private int memberAccess = 0;
	ClassBuilder classBuilder;

	@Override
	public Clazz getClazz() {
		return Clazz.of(className);
	}

	@Override
	public Clazz getSuperClazz() {
		return this._extends;
	}

	@Override
	public ClassBody getClassBody() {
		return classBody;
	}

	public AdvClassBuilderImpl(ThreadLocal<AdvContext> _contextThreadLocal) {
		this._contextThreadLocal = _contextThreadLocal;
	}

	public void access(int accPublic) {
		this.classAccess |= accPublic;
	}

	@Override
	public AdvAfterClassName class_(String className) {
		this.className = className;
		return this;
	}

	@Override
	public AdvAfterClassExtends extends_(Clazz _extends) {
		this._extends = _extends;
		return this;
	}

	@Override
	public AdvAfterClassExtends extends_(Class<?> _extends) {
		this._extends = Clazz.of(_extends);
		return this;
	}

	@Override
	public AdvAfterClassImplements implements_(Class<?> interfaceClass) {
		this._implements.add(Clazz.of(interfaceClass));
		return this;
	}

	@Override
	public AdvAfterClassImplements implements_(Clazz... interfaceClass) {
		if (interfaceClass != null) {
			for (Clazz clazz : interfaceClass) {
				this._implements.add(clazz);
			}
		}
		return this;
	}

	@Override
	public AdvAfterClassImplements implements_(Class<?> interfaceClass, Class<?> genericClass) {
		this._implements.add(Clazz.of(interfaceClass, genericClass));
		return this;
	}

	@Override
	public AdvClassBuilder enterClassBody() {
		ClassHeader ch;
		if (_extends != null) {
			ch = ClassBuilder.class_(className, _extends);
		} else {
			ch = ClassBuilder.class_(className);
		}

		ch.access(classAccess);

		if (_implements != null && _implements.size() > 0) {
			for (Clazz clazz : _implements) {
				ch.implements_(clazz);
			}
		}

		classBody = ch.body();
		Adv.enterClass(this);
		return this;
	}

	@Override
	public AdvAfterMethodName method(String methodName) {
		AdvMethodBuilder methodBuilder = new AdvMethodBuilder(classBody, memberAccess, methodName);
		return methodBuilder;
	}

	@Override
	public AdvAfterMethodName method(int access, String methodName) {
		AdvMethodBuilder methodBuilder = new AdvMethodBuilder(classBody, access, methodName);
		return methodBuilder;
	}

	@Override
	public AdvAfterModifier public_() {
		this.memberAccess = ACC_PUBLIC;
		return this;
	}

	@Override
	public AdvAfterModifier protected_() {
		this.memberAccess = ACC_PROTECTED;
		return this;
	}

	@Override
	public AdvAfterModifier package_() {
		this.memberAccess = 0;
		return this;
	}

	@Override
	public AdvAfterModifier private_() {
		this.memberAccess = ACC_PRIVATE;
		return this;
	}

	@Override
	public AdvAfterClassEnd end() {
		Adv.exitClass();
		classBuilder = classBody.end();
		return this;
	}

	@Override
	public byte[] toByteArray() {
		return classBuilder.toByteArray();
	}

	public boolean_ field_boolean(String name) {
		int localsIndex = classBody.private_().field(name, boolean.class);
		return new boolean_Holder(_contextThreadLocal, (byte) (MAGIC_FIELDS_NUMBER + localsIndex));
	}

	public Boolean__ field_Boolean(String name) {
		int localsIndex = classBody.private_().field(name, boolean.class);
		return new Boolean__Holder(_contextThreadLocal, (byte) (MAGIC_FIELDS_NUMBER + localsIndex));
	}

	public byte field_byte(String name) {
		int localsIndex = classBody.private_().field(name, byte.class);
		return (byte) (MAGIC_FIELDS_NUMBER + localsIndex);
	}

	public short field_short(String name) {
		int localsIndex = classBody.private_().field(name, short.class);
		return (short) (MAGIC_FIELDS_NUMBER + localsIndex);
	}

	public int field_int(String name) {
		int localsIndex = classBody.private_().field(name, int.class);
		return (int) (MAGIC_FIELDS_NUMBER + localsIndex);
	}

	public long field_long(String name) {
		int localsIndex = classBody.private_().field(name, long.class);
		return (long) (MAGIC_FIELDS_NUMBER + localsIndex);
	}

	public float field_float(String name) {
		int localsIndex = classBody.private_().field(name, float.class);
		return (float) (MAGIC_FIELDS_NUMBER + localsIndex);
	}

	public double field_double(String name) {
		int localsIndex = classBody.private_().field(name, double.class);
		return (double) (MAGIC_FIELDS_NUMBER + localsIndex);
	}

	@SuppressWarnings("unchecked")
	public <T> T field(String name, Class<T> clazz) {

		int localsIndex = classBody.private_().field(name, clazz);

		if (clazz == Boolean.class) {
			throw new UnsupportedOperationException("请使用 field_boolean");
		} else if (clazz == Byte.class) {
			Byte key = (byte) (MAGIC_FIELDS_NUMBER + localsIndex);
			return (T) key;
		} else if (clazz == Character.class) {
			Character key = (char) (MAGIC_FIELDS_NUMBER + localsIndex);
			return (T) key;
		} else if (clazz == Short.class) {
			Short key = (short) (MAGIC_FIELDS_NUMBER + localsIndex);
			return (T) key;
		} else if (clazz == Integer.class) {
			Integer key = (int) (MAGIC_FIELDS_NUMBER + localsIndex);
			return (T) key;
		} else if (clazz == Long.class) {
			Long key = (long) (MAGIC_FIELDS_NUMBER + localsIndex);
			return (T) key;
		} else if (clazz == Float.class) {
			Double key = (double) (MAGIC_FIELDS_NUMBER + localsIndex);
			return (T) key;
		} else if (clazz == Double.class) {
			Double key = (double) (MAGIC_FIELDS_NUMBER + localsIndex);
			return (T) key;
		} else if (clazz == String.class) {
			String key = String.valueOf(MAGIC_LOCALS_String + localsIndex);
			return (T) key;
		} else {
			byte magicNumber = (byte) (MAGIC_FIELDS_NUMBER + localsIndex);
			T obj = Adv.buildProxyClass(clazz, magicNumber);
			return (T) obj;
//			return null;
//		} else {
//			throw new UnsupportedOperationException("Only accept tinyasm proxy object");
		}
	}

}
