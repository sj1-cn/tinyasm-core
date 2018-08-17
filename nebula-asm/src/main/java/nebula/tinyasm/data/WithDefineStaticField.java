package nebula.tinyasm.data;

import java.util.List;

import static org.objectweb.asm.Opcodes.*;

public interface WithDefineStaticField<T> {

	default T staticField(List<Field> fields) {
		T t = null;
		for (Field field : fields) {
			t = staticField(field.name, GenericClazz.clazz(field.clazz));
		}
		return t;
	}

	default T staticField(String name, String clazz) {
		return staticField(name, GenericClazz.generic(clazz));
	}

	default T staticField(String name, Class<?> clazz) {
		return staticField(name, GenericClazz.clazz(clazz));
	}

	default T staticField(String name, GenericClazz clazz) {
		return staticField(ACC_PRIVATE, name, GenericClazz.clazz(clazz));
	}

	default T staticField(Class<?> annotation, String name, String clazz) {
		return staticField(Annotation.annotation(annotation), name, GenericClazz.generic(clazz));
	}

	default T staticField(Class<?> annotation, String name, Class<?> clazz) {
		return staticField(Annotation.annotation(annotation), name, GenericClazz.clazz(clazz));
	}

	default T staticField(Class<?> annotation, String name, GenericClazz clazz) {
		return staticField(Annotation.annotation(annotation), name, GenericClazz.clazz(clazz));
	}

	default T staticField(Annotation annotation, String name, String clazz) {
		return staticField(Annotation.annotation(annotation), name, GenericClazz.generic(clazz));
	}

	default T staticField(Annotation annotation, String name, Class<?> clazz) {
		return staticField(Annotation.annotation(annotation), name, GenericClazz.clazz(clazz));
	}

	default T staticField(Annotation annotation, String name, GenericClazz clazz) {
		return staticField(ACC_PRIVATE, annotation, name, clazz);
	}

	default T staticField(String name, String clazz, boolean isarray) {
		return staticField(name, GenericClazz.clazz(clazz, isarray));
	}

	default T staticField(String name, Class<?> clazz, boolean isarray) {
		return staticField(name, GenericClazz.clazz(clazz, isarray));
	}

	default T staticField(Class<?> annotation, String name, String clazz, boolean isarray) {
		return staticField(Annotation.annotation(annotation), name, GenericClazz.clazz(clazz, isarray));
	}

	default T staticField(Class<?> annotation, String name, Class<?> clazz, boolean isarray) {
		return staticField(Annotation.annotation(annotation), name, GenericClazz.clazz(clazz, isarray));
	}

	default T staticField(Annotation annotation, String name, String clazz, boolean isarray) {
		return staticField(Annotation.annotation(annotation), name, GenericClazz.clazz(clazz, isarray));
	}

	default T staticField(Annotation annotation, String name, Class<?> clazz, boolean isarray) {
		return staticField(Annotation.annotation(annotation), name, GenericClazz.clazz(clazz, isarray));
	}

	default T staticField(int access, String name, String clazz) {
		return staticField(access, name, GenericClazz.generic(clazz));
	}

	default T staticField(int access, String name, Class<?> clazz) {
		return staticField(access, name, GenericClazz.clazz(clazz));
	}

	T staticField(int access, String name, GenericClazz clazz);

	default T staticField(int access, Class<?> annotation, String name, String clazz) {
		return staticField(access, Annotation.annotation(annotation), name, GenericClazz.generic(clazz));
	}

	default T staticField(int access, Class<?> annotation, String name, Class<?> clazz) {
		return staticField(access, Annotation.annotation(annotation), name, GenericClazz.clazz(clazz));
	}

	default T staticField(int access, Class<?> annotation, String name, GenericClazz clazz) {
		return staticField(access, Annotation.annotation(annotation), name, GenericClazz.clazz(clazz));
	}

	default T staticField(int access, Annotation annotation, String name, String clazz) {
		return staticField(access, Annotation.annotation(annotation), name, GenericClazz.generic(clazz));
	}

	default T staticField(int access, Annotation annotation, String name, Class<?> clazz) {
		return staticField(access, Annotation.annotation(annotation), name, GenericClazz.clazz(clazz));
	}

	T staticField(int access, Annotation annotation, String name, GenericClazz clazz);

	default T staticField(int access, String name, String clazz, boolean isarray) {
		return staticField(access, name, GenericClazz.clazz(clazz, isarray));
	}

	default T staticField(int access, String name, Class<?> clazz, boolean isarray) {
		return staticField(access, name, GenericClazz.clazz(clazz, isarray));
	}

	default T staticField(int access, Class<?> annotation, String name, String clazz, boolean isarray) {
		return staticField(access, Annotation.annotation(annotation), name, GenericClazz.clazz(clazz, isarray));
	}

	default T staticField(int access, Class<?> annotation, String name, Class<?> clazz, boolean isarray) {
		return staticField(access, Annotation.annotation(annotation), name, GenericClazz.clazz(clazz, isarray));
	}

	default T staticField(int access, Annotation annotation, String name, String clazz, boolean isarray) {
		return staticField(access, Annotation.annotation(annotation), name, GenericClazz.clazz(clazz, isarray));
	}

	default T staticField(int access, Annotation annotation, String name, Class<?> clazz, boolean isarray) {
		return staticField(access, Annotation.annotation(annotation), name, GenericClazz.clazz(clazz, isarray));
	}
}