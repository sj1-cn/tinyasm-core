package cc1sj.tinyasm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.signature.SignatureVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ClassSignaturewwww extends SignatureVisitor {
	static Logger logger = LoggerFactory.getLogger(ClassSignaturewwww.class);

	private int level = 0;
	private boolean array = false;

	String indent() {
		StringBuilder sb = new StringBuilder();
		sb.append(header);
		sb.append("\t");
		for (int i = 0; i < level; i++) {
			sb.append('\t');
		}
		return sb.toString();
	}

	private List<Holder<Clazz>> paramsClassList = new ArrayList<>();
	private List<Holder<Clazz>> returnClassList = new ArrayList<>();
	private List<Holder<Clazz>> superClassList = new ArrayList<>();
	private List<Holder<Clazz>> interfacesClassList = new ArrayList<>();
	private List<Holder<Clazz>> typeParameterClassList = new ArrayList<>();;

//	Holder<Clazz> sb;

	private List<Holder<Clazz>> list;

	private Stack<List<Holder<Clazz>>> listStack = new Stack<List<Holder<Clazz>>>();

	Clazz returnClazz;
	Clazz superClazz;
	Clazz[] interfaceClazzes;
	Clazz[] typeParamenterClazzes;
	Clazz[] paramsClazzes;

	public void finish() {
		returnClazz = returnClassList.size() > 0 ? returnClassList.get(0).get() : null;
		superClazz = superClassList.size() > 0 ? superClassList.get(0).get() : null;

		interfaceClazzes = extracted(interfacesClassList);
		typeParamenterClazzes = extracted(typeParameterClassList);
		paramsClazzes = extracted(paramsClassList);

	}

	protected Clazz[] extracted(List<Holder<Clazz>> ee) {
		Clazz[] interfaceClazzes = new Clazz[ee.size()];
		for (int i = 0; i < interfaceClazzes.length; i++) {
			interfaceClazzes[i] = ee.get(i).get();
		}
		return interfaceClazzes;
	}

	abstract class Holder<T> {
		abstract T get();
	}

	class HolderFormalTypeParameter extends Holder<Clazz> {
		String parameterName;
		List<Holder<Clazz>> children = new ArrayList<>();

		public HolderFormalTypeParameter(String parameterName) {
			this.parameterName = parameterName;
		}

		@Override
		Clazz get() {
			return Clazz.formalTypeParameterOf(parameterName, children.get(0).get());
		}

		@Override
		public String toString() {
			return get().toString();
		}

	}

	class HolderClazz extends Holder<Clazz> {
		Clazz baseClass;
		List<Holder<Clazz>> children = new ArrayList<>();

		public HolderClazz(Clazz name) {
			this.baseClass = name;
		}

		@Override
		Clazz get() {
			if (children.size() > 0) {
				Clazz[] clazzes = new Clazz[children.size()];
				for (int i = 0; i < clazzes.length; i++) {
					clazzes[i] = children.get(i).get();
				}
				return Clazz.of(baseClass, clazzes);
			} else {
				return baseClass;
			}
		}

		public List<Holder<Clazz>> getChildren() {
			return children;
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
		logger.trace("{}visitFormalTypeParameter({})", indent(), name);
		HolderFormalTypeParameter sb = new HolderFormalTypeParameter(name);
		typeParameterClassList.add(sb);
		list = sb.children;
		super.visitFormalTypeParameter(name);
	}

	@Override
	public SignatureVisitor visitClassBound() { // :
//		sb = new Holder<>();
		logger.trace("{}visitClassBound()", indent());
		return this; // new ClassSignaturewwww(Opcodes.ASM9, header + "->visitClassBound");
	}

	@Override
	public SignatureVisitor visitInterfaceBound() {
		logger.trace("{}visitInterfaceBound()", indent());
		return this; // new ClassSignaturewwww(Opcodes.ASM9, header + "->visitInterfaceBound");
	}

	@Override
	public SignatureVisitor visitSuperclass() {
		list = superClassList;
		logger.trace("{}visitSuperclass()", indent());
		return this; // new ClassSignaturewwww(Opcodes.ASM9, header + "->visitSuperclass");
	}

	@Override
	public SignatureVisitor visitInterface() {
//		sb = new Holder<>();
		list = interfacesClassList;
		logger.trace("{}visitInterface()", indent());
		return this; // new ClassSignaturewwww(Opcodes.ASM9, header + "->visitInterface");
	}

	@Override
	public SignatureVisitor visitParameterType() {
		list = paramsClassList;
//		sb = new Holder<>();
//		paramsClass.add(sb);
		logger.trace("{}visitParameterType()", indent());
		return this; // new ClassSignaturewwww(Opcodes.ASM9, header + "->visitParameterType");
	}

	@Override
	public SignatureVisitor visitReturnType() {
		list = returnClassList;
		logger.trace("{}visitReturnType()", indent());
		return this; // new ClassSignaturewwww(Opcodes.ASM9, header + "->visitReturnType");
	}

	@Override
	public SignatureVisitor visitExceptionType() {
		logger.trace("{}visitExceptionType()", indent());
		return this; // new ClassSignaturewwww(Opcodes.ASM9, header + "->visitExceptionType");
	}

	@Override
	public void visitBaseType(char descriptor) {
		logger.trace("{}visitBaseType({})", indent(), descriptor);
		super.visitBaseType(descriptor);
	}

	@Override
	public void visitTypeVariable(String name) {
		list.add(new HolderClazz(Clazz.typeVariableOf(name)));
		logger.trace("{}visitTypeVariable({})", indent(), name);
		super.visitTypeVariable(name);
	}

	@Override
	public SignatureVisitor visitArrayType() {
		array = true;
		logger.trace("{}visitArrayType()", indent());
		return this; // new ClassSignaturewwww(Opcodes.ASM9, header + "->visitArrayType");
	}

	static String toSimpleName(String str) {
		return str.substring(str.lastIndexOf('.') + 1, str.length());
	}

	@Override
	public void visitClassType(String name) {
		HolderClazz holderClazz;
		if (array) {
			holderClazz = new HolderClazz(Clazz.of(toSimpleName(name), true));
		} else {
			holderClazz = new HolderClazz(Clazz.of(toSimpleName(name)));
		}
		list.add(holderClazz);
		listStack.push(list);
		list = holderClazz.getChildren();
//		sb.set(null); = holderClazz;

		logger.trace("{}visitClassType({})", indent(), name);
		level++;
		super.visitClassType(name);
	}

	@Override
	public void visitInnerClassType(String name) {
		logger.trace("{}visitInnerClassType({})", indent(), name);
		super.visitInnerClassType(name);
	}

	@Override
	public void visitTypeArgument() {
		logger.trace("{}visitTypeArgument()", indent());
		array = false;

		super.visitTypeArgument();
	}

	@Override
	public SignatureVisitor visitTypeArgument(char wildcard) {
//		sb.append(",");
		logger.trace("{}visitTypeArgument({})", indent(), wildcard);
		return this; // new ClassSignaturewwww(Opcodes.ASM9, header + "->visitTypeArgument");
	}

	@Override
	public void visitEnd() {
		list = listStack.pop();
		array = false;
		level--;
		logger.trace("{}visitEnd()", indent());
		super.visitEnd();
	}
}