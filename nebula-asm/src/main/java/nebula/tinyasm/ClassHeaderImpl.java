package nebula.tinyasm;

import static nebula.tinyasm.util.TypeUtils.classnameOf;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.objectweb.asm.ClassVisitor;

import nebula.tinyasm.data.Annotation;
import nebula.tinyasm.data.ClassBody;
import nebula.tinyasm.data.ClassHeader;
import nebula.tinyasm.data.GenericClazz;

class ClassHeaderImpl implements ClassHeader {
	final String name;
	GenericClazz clazz;

	GenericClazz superClazz;

	int access;
	final ClassVisitor cv;
	final List<Annotation> annotations = new ArrayList<>();

	final List<GenericClazz> interfaces = new ArrayList<>();

	ClassBodyImpl classBuilderImpl;

	public ClassHeaderImpl(ClassVisitor cv, String name) {
		super();
		this.cv = cv;
		this.name = name;
	}

	public ClassHeaderImpl(ClassVisitor cv, String name, Class<?> superClazz) {
		super();
		this.cv = cv;
		this.name = name;
		this.superClazz = new GenericClazz(classnameOf(superClazz), null);
	}

	public ClassHeaderImpl(ClassVisitor cv, String name, String superClazz) {
		super();
		this.cv = cv;
		this.name = name;
		this.superClazz = new GenericClazz(superClazz, null);
	}

	@Override
	public ClassHeader access(int access) {
		this.access |= access;
		return this;
	}

	@Override
	public ClassHeader annotation(Annotation annotation) {
		annotations.add(annotation);
		return this;
	}

	@Override
	public ClassBody body() {
		makeClassBuilder();
		return classBuilderImpl;
	}

	@Override
	public ClassBuilder body(Consumer<ClassBody> mb) {
		makeClassBuilder();
		mb.accept(classBuilderImpl);
		return null;
	}

	@Override
	public ClassHeader eXtend(String clazz) {
		this.superClazz = new GenericClazz(clazz, new String[0]);
		return this;
	}

	@Override
	public ClassHeader eXtend(String clazz, String... genericClazz) {
		this.superClazz = new GenericClazz(clazz, genericClazz);
		return this;
	}

	@Override
	public ClassHeader imPlements(String clazz) {
		interfaces.add(new GenericClazz(clazz, new String[0]));
		return null;
	}

	@Override
	public ClassHeader imPlements(String clazz, String... genericClazz) {
		interfaces.add(new GenericClazz(clazz, genericClazz));
		return this;
	}

	ClassBuilder makeClassBuilder() {

		if (access == 0) {// ACC_PUBLIC + ACC_SUPER
			this.ACC_PUBLIC();
			this.ACC_SUPER();
		}

		if (superClazz == null) {
			this.eXtend(Object.class);
		}

		classBuilderImpl = new ClassBodyImpl(cv, this);
		return classBuilderImpl;
	}

}
