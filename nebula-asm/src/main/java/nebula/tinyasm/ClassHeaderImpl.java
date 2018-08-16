package nebula.tinyasm;

import static nebula.tinyasm.util.TypeUtils.nameOf;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.objectweb.asm.ClassVisitor;

import nebula.tinyasm.data.ClassAnnotation;

public class ClassHeaderImpl implements ClassHeader {

	static class Annotation {
		String clazz;
		Object value;

		public Annotation(String clazz, Object value) {
			this.clazz = clazz;
			this.value = value;
		}
	}

	final String name;
	GenericClazz clazz;

	GenericClazz superClazz;

	int access;
	final ClassVisitor cv;
	final List<ClassAnnotation> annotations = new ArrayList<>();

	final List<GenericClazz> interfaces = new ArrayList<>();

	ClassBuilderImpl classBuilderImpl;

	public ClassHeaderImpl(ClassVisitor cv, String name) {
		super();
		this.cv = cv;
		this.name = name;
	}

	public ClassHeaderImpl(ClassVisitor cv, String name, Class<?> superClazz) {
		super();
		this.cv = cv;
		this.name = name;
		this.superClazz = new GenericClazz(nameOf(superClazz), null);
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
	public ClassHeader annotation(ClassAnnotation annotation) {
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

		classBuilderImpl = new ClassBuilderImpl(cv, this);
		return classBuilderImpl;
	}

}
