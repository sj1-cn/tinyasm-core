package nebula.tinyasm;

import java.util.List;

import nebula.tinyasm.data.ClassAnnotation;
import nebula.tinyasm.data.Field;

import static org.objectweb.asm.Opcodes.*;

interface WithDefineField<T> {

	default T field(List<Field> fields) {
		T t = null;
		for (Field field : fields) {
			t = field(field.name, GenericClazz.clazz(field.clazz));
		}
		return t;
	}

	default T field(String name, String clazz) {
		return field(name, GenericClazz.clazz(clazz));
	}

	default T field(String name, Class<?> clazz) {
		return field(name, GenericClazz.clazz(clazz));
	}

	default T field(String name, GenericClazz clazz) {
		return field(ACC_PRIVATE, name, GenericClazz.clazz(clazz));
	}

	default T field(Class<?> annotation, String name, String clazz) {
		return field(ClassAnnotation.annotation(annotation), name, GenericClazz.clazz(clazz));
	}

	default T field(Class<?> annotation, String name, Class<?> clazz) {
		return field(ClassAnnotation.annotation(annotation), name, GenericClazz.clazz(clazz));
	}

	default T field(Class<?> annotation, String name, GenericClazz clazz) {
		return field(ClassAnnotation.annotation(annotation), name, GenericClazz.clazz(clazz));
	}

	default T field(ClassAnnotation annotation, String name, String clazz) {
		return field(ClassAnnotation.annotation(annotation), name, GenericClazz.clazz(clazz));
	}

	default T field(ClassAnnotation annotation, String name, Class<?> clazz) {
		return field(ClassAnnotation.annotation(annotation), name, GenericClazz.clazz(clazz));
	}

	default T field(ClassAnnotation annotation, String name, GenericClazz clazz) {
		return field(ACC_PRIVATE, annotation, name, clazz);
	}

	default T field(String name, String clazz, boolean isarray) {
		return field(name, GenericClazz.clazz(clazz, isarray));
	}

	default T field(String name, Class<?> clazz, boolean isarray) {
		return field(name, GenericClazz.clazz(clazz, isarray));
	}

	default T field(Class<?> annotation, String name, String clazz, boolean isarray) {
		return field(ClassAnnotation.annotation(annotation), name, GenericClazz.clazz(clazz, isarray));
	}

	default T field(Class<?> annotation, String name, Class<?> clazz, boolean isarray) {
		return field(ClassAnnotation.annotation(annotation), name, GenericClazz.clazz(clazz, isarray));
	}

	default T field(ClassAnnotation annotation, String name, String clazz, boolean isarray) {
		return field(ClassAnnotation.annotation(annotation), name, GenericClazz.clazz(clazz, isarray));
	}

	default T field(ClassAnnotation annotation, String name, Class<?> clazz, boolean isarray) {
		return field(ClassAnnotation.annotation(annotation), name, GenericClazz.clazz(clazz, isarray));
	}

	default T field(int access, String name, String clazz) {
		return field(access, name, GenericClazz.clazz(clazz));
	}

	default T field(int access, String name, Class<?> clazz) {
		return field(access, name, GenericClazz.clazz(clazz));
	}

	T field(int access, String name, GenericClazz clazz);

	default T field(int access, Class<?> annotation, String name, String clazz) {
		return field(access, ClassAnnotation.annotation(annotation), name, GenericClazz.clazz(clazz));
	}

	default T field(int access, Class<?> annotation, String name, Class<?> clazz) {
		return field(access, ClassAnnotation.annotation(annotation), name, GenericClazz.clazz(clazz));
	}

	default T field(int access, Class<?> annotation, String name, GenericClazz clazz) {
		return field(access, ClassAnnotation.annotation(annotation), name, GenericClazz.clazz(clazz));
	}

	default T field(int access, ClassAnnotation annotation, String name, String clazz) {
		return field(access, ClassAnnotation.annotation(annotation), name, GenericClazz.clazz(clazz));
	}

	default T field(int access, ClassAnnotation annotation, String name, Class<?> clazz) {
		return field(access, ClassAnnotation.annotation(annotation), name, GenericClazz.clazz(clazz));
	}

	T field(int access, ClassAnnotation annotation, String name, GenericClazz clazz);

	default T field(int access, String name, String clazz, boolean isarray) {
		return field(access, name, GenericClazz.clazz(clazz, isarray));
	}

	default T field(int access, String name, Class<?> clazz, boolean isarray) {
		return field(access, name, GenericClazz.clazz(clazz, isarray));
	}

	default T field(int access, Class<?> annotation, String name, String clazz, boolean isarray) {
		return field(access, ClassAnnotation.annotation(annotation), name, GenericClazz.clazz(clazz, isarray));
	}

	default T field(int access, Class<?> annotation, String name, Class<?> clazz, boolean isarray) {
		return field(access, ClassAnnotation.annotation(annotation), name, GenericClazz.clazz(clazz, isarray));
	}

	default T field(int access, ClassAnnotation annotation, String name, String clazz, boolean isarray) {
		return field(access, ClassAnnotation.annotation(annotation), name, GenericClazz.clazz(clazz, isarray));
	}

	default T field(int access, ClassAnnotation annotation, String name, Class<?> clazz, boolean isarray) {
		return field(access, ClassAnnotation.annotation(annotation), name, GenericClazz.clazz(clazz, isarray));
	}
}