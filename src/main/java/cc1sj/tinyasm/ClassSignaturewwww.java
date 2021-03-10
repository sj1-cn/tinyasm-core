package cc1sj.tinyasm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.objectweb.asm.Type;
import org.objectweb.asm.signature.SignatureVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ClassSignaturewwww extends SignatureVisitor {
	static Logger logger = LoggerFactory.getLogger(ClassSignaturewwww.class);

	private int level = 0;
	private boolean array = false;

	String indent() {
		StringBuilder sb = new StringBuilder();
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

	ClassSignaturewwww(int api) {
		super(api);
//		this.referedTypes = referedTypes;
	}

	String header = "root";

	@Override
	public void visitFormalTypeParameter(String name) {
		logger.trace("{}visitFormalTypeParameter({})", indent(), name);
		HolderFormalTypeParameter sb = new HolderFormalTypeParameter(name);
		typeParameterClassList.add(sb);
		list = sb.children;
		super.visitFormalTypeParameter(name);
	}

	@Override
	public SignatureVisitor visitClassBound() { // L
		logger.trace("{}visitClassBound()", indent());
		return this;
	}

	@Override
	public SignatureVisitor visitInterfaceBound() {
		logger.trace("{}visitInterfaceBound()", indent());
		return this;
	}

	@Override
	public SignatureVisitor visitSuperclass() {
		logger.trace("{}visitSuperclass()", indent());
		list = superClassList;
		return this;
	}

	@Override
	public SignatureVisitor visitInterface() {
		logger.trace("{}visitInterface()", indent());
		list = interfacesClassList;
		return this;
	}

	@Override
	public SignatureVisitor visitParameterType() {
		logger.trace("{}visitParameterType()", indent());
		typeArgument = DEFAULT_TypeArgument;
		list = paramsClassList;
		return this;
	}

	@Override
	public SignatureVisitor visitReturnType() {
		logger.trace("{}visitReturnType()", indent());
		typeArgument = DEFAULT_TypeArgument;
		list = returnClassList;
		
		array=false;
		typeArgument = DEFAULT_TypeArgument;
		
		return this;
	}

	@Override
	public SignatureVisitor visitExceptionType() {
		logger.trace("{}visitExceptionType()", indent());
		return this;
	}

	@Override
	public void visitBaseType(char descriptor) {
		logger.trace("{}visitBaseType({})", indent(), descriptor);
		HolderClazz holderClazz;
		if (array) {
			holderClazz = new HolderClazz(Clazz.of(Type.getType(String.valueOf(descriptor)), true));
		} else {
			holderClazz = new HolderClazz(Clazz.of(Type.getType(String.valueOf(descriptor))));
		}
		list.add(holderClazz);

	}

	@Override
	public void visitTypeVariable(String name) {
		logger.trace("{}visitTypeVariable({})", indent(), name);
		if (typeArgument > DEFAULT_TypeArgument) {
			if (array) {
				list.add(new HolderClazz(Clazz.typeArgument(typeArgument, Clazz.typeVariableOf(name, array))));
			} else {
				list.add(new HolderClazz(Clazz.typeArgument(typeArgument, Clazz.typeVariableOf(name, array))));
			}
		} else {
			if (array) {
				list.add(new HolderClazz(Clazz.typeVariableOf(name, array)));
			} else {
				list.add(new HolderClazz(Clazz.typeVariableOf(name, array)));
			}
		}
		typeArgument = DEFAULT_TypeArgument;
	}

	@Override
	public SignatureVisitor visitArrayType() {
		array = true;
		logger.trace("{}visitArrayType()", indent());
		return this;
	}

	static String toSimpleName(String str) {
		return str.substring(str.lastIndexOf('.') + 1, str.length());
	}

	@Override
	public void visitClassType(String name) {
		logger.trace("{}visitClassType({})", indent(), name);
		level++;
		HolderClazz holderClazz;
		if (typeArgument > DEFAULT_TypeArgument) {

			holderClazz = new HolderTypeArgument(typeArgument, Clazz.of(toSimpleName(name)));
		} else {
			if (array) {
				holderClazz = new HolderClazz(Clazz.of(toSimpleName(name), true));
			} else {
				holderClazz = new HolderClazz(Clazz.of(toSimpleName(name)));
			}
		}
		list.add(holderClazz);
		listStack.push(list);
		list = holderClazz.getChildren();
//		sb.set(null); = holderClazz;

		typeArgument = DEFAULT_TypeArgument;
	}

	@Override
	public void visitInnerClassType(String name) {
		logger.trace("{}visitInnerClassType({})", indent(), name);
		super.visitInnerClassType(name);
	}

	final static char DEFAULT_TypeArgument = (char) 0;
	char typeArgument = DEFAULT_TypeArgument;

	@Override
	public void visitTypeArgument() {
		logger.trace("{}visitTypeArgument()", indent());
		list.add(new HolderClazz(Clazz.typeUnboundedTypeArgument()));
		array = false;
	}

	@Override
	public SignatureVisitor visitTypeArgument(char wildcard) {
		logger.trace("{}visitTypeArgument({})", indent(), wildcard);
		typeArgument = wildcard;
		return this;
	}

	@Override
	public void visitEnd() {
		list = listStack.pop();
		array = false;
		level--;
		logger.trace("{}visitEnd()", indent());
		super.visitEnd();
	}

	private List<Holder<Clazz>> list;

	private Stack<List<Holder<Clazz>>> listStack = new Stack<List<Holder<Clazz>>>();

	Clazz returnClazz;
	Clazz superClazz;
	Clazz[] interfaceClazzes;
	ClazzFormalTypeParameter[] typeParamenterClazzes;
	Clazz[] paramsClazzes;

	public void finish() {
		returnClazz = returnClassList.size() > 0 ? returnClassList.get(0).get() : null;
		superClazz = superClassList.size() > 0 ? superClassList.get(0).get() : null;

		interfaceClazzes = extracted(interfacesClassList);
		typeParamenterClazzes = extractedtypeParameterClassList(typeParameterClassList);
		paramsClazzes = extracted(paramsClassList);

	}

	protected ClazzFormalTypeParameter[] extractedtypeParameterClassList(List<Holder<Clazz>> ee) {
		ClazzFormalTypeParameter[] interfaceClazzes = new ClazzFormalTypeParameter[ee.size()];
		for (int i = 0; i < interfaceClazzes.length; i++) {
			interfaceClazzes[i] = (ClazzFormalTypeParameter) ee.get(i).get();
		}
		return interfaceClazzes;
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
		ClazzFormalTypeParameter get() {
			return Clazz.formalTypeParameterOf(parameterName, children.get(0).get());
		}

		@Override
		public String toString() {
			return get().toString();
		}

	}

	class HolderTypeArgument extends HolderClazz {
		char wildcard;

		public HolderTypeArgument(char wildcard, Clazz baseClass) {
			super(baseClass);
			this.wildcard = wildcard;
		}

		@Override
		Clazz get() {
			if (children.size() > 0) {
				Clazz[] clazzes = new Clazz[children.size()];
				for (int i = 0; i < clazzes.length; i++) {
					clazzes[i] = children.get(i).get();
				}
				return Clazz.typeArgument(wildcard, Clazz.of(baseClass, clazzes));
			} else {
				return Clazz.typeArgument(wildcard, baseClass);
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
}