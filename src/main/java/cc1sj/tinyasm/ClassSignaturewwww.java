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
		logger.debug("{}visitFormalTypeParameter({})", indent(), name);
		HolderFormalTypeParameter sb = new HolderFormalTypeParameter(name);
		typeParameterClassList.add(sb);
		list = sb.children;
		super.visitFormalTypeParameter(name);
	}

	@Override
	public SignatureVisitor visitClassBound() { // L
		logger.debug("{}visitClassBound()", indent());
		return this;
	}

	@Override
	public SignatureVisitor visitInterfaceBound() {
		logger.debug("{}visitInterfaceBound()", indent());
		return this;
	}

	@Override
	public SignatureVisitor visitSuperclass() {
		logger.debug("{}visitSuperclass()", indent());
		list = superClassList;
		return this;
	}

	@Override
	public SignatureVisitor visitInterface() {
		logger.debug("{}visitInterface()", indent());
		list = interfacesClassList;
		return this;
	}

	@Override
	public SignatureVisitor visitParameterType() {
		logger.debug("{}visitParameterType()", indent());
		typeArgument = DEFAULT_TypeArgument;
		list = paramsClassList;
		return this;
	}

	@Override
	public SignatureVisitor visitReturnType() {
		logger.debug("{}visitReturnType()", indent());
		typeArgument = DEFAULT_TypeArgument;
		list = returnClassList;
		return this;
	}

	@Override
	public SignatureVisitor visitExceptionType() {
		logger.debug("{}visitExceptionType()", indent());
		return this;
	}

	@Override
	public void visitBaseType(char descriptor) {
		logger.debug("{}visitBaseType({})", indent(), descriptor);
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
		logger.debug("{}visitTypeVariable({})", indent(), name);
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
		logger.debug("{}visitArrayType()", indent());
		return this;
	}

	static String toSimpleName(String str) {
		return str.substring(str.lastIndexOf('.') + 1, str.length());
	}

	@Override
	public void visitClassType(String name) {
		logger.debug("{}visitClassType({})", indent(), name);
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
		logger.debug("{}visitInnerClassType({})", indent(), name);
		super.visitInnerClassType(name);
	}

	final static char DEFAULT_TypeArgument = (char) 0;
	char typeArgument = DEFAULT_TypeArgument;

	@Override
	public void visitTypeArgument() {
		logger.debug("{}visitTypeArgument()", indent());
		list.add(new HolderClazz(Clazz.typeUnboundedTypeArgument()));
		array = false;
	}

	@Override
	public SignatureVisitor visitTypeArgument(char wildcard) {
		logger.debug("{}visitTypeArgument({})", indent(), wildcard);
		typeArgument = wildcard;
		return this;
	}

	@Override
	public void visitEnd() {
		list = listStack.pop();
		array = false;
		level--;
		logger.debug("{}visitEnd()", indent());
		super.visitEnd();
	}

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