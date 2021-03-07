package cc1sj.tinyasm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.signature.SignatureVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ClassSignaturewwww extends SignatureVisitor {
	static Logger logger = LoggerFactory.getLogger(ClassSignaturewwww.class);

//	@Override
//	public String toString() {
//		return sb.toString();
//	}

	int level = 0;
	boolean array = false;

	String indent() {
		StringBuilder sb = new StringBuilder();
		sb.append(header);
		sb.append("\t");
		for (int i = 0; i < level; i++) {
			sb.append('\t');
		}
		return sb.toString();
	}

	List<Holder<Clazz>> paramsClass = new ArrayList<>();
	Holder<Clazz> returnClass = new Holder<>();
	Holder<Clazz> superClass = new Holder<>();
	List<Holder<Clazz>> interfacesClass = new ArrayList<>();
	List<Holder<Clazz>> typeParameterClass = new ArrayList<>();;

	Holder<Clazz> sb;

	class Holder<T> {
		T t;

		T get() {
			return t;
		}

		void set(T t) {
			this.t = t;
		}

		@Override
		public String toString() {
			return t != null ? t.toString() : "";
		}
	}

	class HolderFormalTypeParameter extends Holder<Clazz> {
		String name;

		public HolderFormalTypeParameter(String name) {
			this.name = name;
		}

		@Override
		Clazz get() {
			return Clazz.formalTypeParameterOf(name, super.get());
		}

		@Override
		public String toString() {
			return get().toString();
		}

	}

//	Map<String, String> referedTypes;
	ClassSignaturewwww(int api) {
		super(api);
//		this.referedTypes = referedTypes;
	}

	String header = "root";

//	Map<String, String> referedTypes;
	ClassSignaturewwww(int api, String header) {
		super(api);
		this.header = header;
	}

	@Override
	public void visitFormalTypeParameter(String name) {
		logger.debug("{}visitFormalTypeParameter({})", indent(), name);
		sb = new HolderFormalTypeParameter(name);
		typeParameterClass.add(sb);
		super.visitFormalTypeParameter(name);
	}

	@Override
	public SignatureVisitor visitClassBound() { // :
//		sb = new Holder<>();
		logger.debug("{}visitClassBound()", indent());
		return this; // new ClassSignaturewwww(Opcodes.ASM9, header + "->visitClassBound");
	}

	@Override
	public SignatureVisitor visitInterfaceBound() {
		logger.debug("{}visitInterfaceBound()", indent());
		return this; // new ClassSignaturewwww(Opcodes.ASM9, header + "->visitInterfaceBound");
	}

	@Override
	public SignatureVisitor visitSuperclass() {
		sb = superClass = new Holder<>();
		logger.debug("{}visitSuperclass()", indent());
		return this; // new ClassSignaturewwww(Opcodes.ASM9, header + "->visitSuperclass");
	}

	@Override
	public SignatureVisitor visitInterface() {
		sb = new Holder<>();
		interfacesClass.add(sb);
		logger.debug("{}visitInterface()", indent());
		return this; // new ClassSignaturewwww(Opcodes.ASM9, header + "->visitInterface");
	}

	@Override
	public SignatureVisitor visitParameterType() {
		sb = new Holder<>();
		paramsClass.add(sb);
		logger.debug("{}visitParameterType()", indent());
		return this; // new ClassSignaturewwww(Opcodes.ASM9, header + "->visitParameterType");
	}

	@Override
	public SignatureVisitor visitReturnType() {
		sb = returnClass = new Holder<>();
		logger.debug("{}visitReturnType()", indent());
		return this; // new ClassSignaturewwww(Opcodes.ASM9, header + "->visitReturnType");
	}

	@Override
	public SignatureVisitor visitExceptionType() {
		logger.debug("{}visitExceptionType()", indent());
		return this; // new ClassSignaturewwww(Opcodes.ASM9, header + "->visitExceptionType");
	}

	@Override
	public void visitBaseType(char descriptor) {
		logger.debug("{}visitBaseType({})", indent(), descriptor);
		super.visitBaseType(descriptor);
	}

	@Override
	public void visitTypeVariable(String name) {
		sb.set(Clazz.typeVariableOf(name));
		logger.debug("{}visitTypeVariable({})", indent(), name);
		super.visitTypeVariable(name);
	}

	@Override
	public SignatureVisitor visitArrayType() {
		array = true;
		logger.debug("{}visitArrayType()", indent());
		return this; // new ClassSignaturewwww(Opcodes.ASM9, header + "->visitArrayType");
	}

	static String toSimpleName(String str) {
		return str.substring(str.lastIndexOf('.') + 1, str.length());
	}

	@Override
	public void visitClassType(String name) {

		if (array) {
			sb.set(Clazz.of(toSimpleName(name), true));
		} else {
			sb.set(Clazz.of(toSimpleName(name)));
		}

		logger.debug("{}visitClassType({})", indent(), name);
		level++;
		super.visitClassType(name);
	}

	@Override
	public void visitInnerClassType(String name) {
		logger.debug("{}visitInnerClassType({})", indent(), name);
		super.visitInnerClassType(name);
	}

	@Override
	public void visitTypeArgument() {
		logger.debug("{}visitTypeArgument()", indent());
		array = false;
		super.visitTypeArgument();
	}

	@Override
	public SignatureVisitor visitTypeArgument(char wildcard) {
//		sb.append(",");
		logger.debug("{}visitTypeArgument({})", indent(), wildcard);
		return this; // new ClassSignaturewwww(Opcodes.ASM9, header + "->visitTypeArgument");
	}

	@Override
	public void visitEnd() {
		array = false;
		level--;
		logger.debug("{}visitEnd()", indent());
		super.visitEnd();
	}
}