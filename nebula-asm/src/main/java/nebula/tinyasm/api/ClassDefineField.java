package nebula.tinyasm.api;

import static nebula.tinyasm.util.TypeUtils.signatureOf;
import static nebula.tinyasm.util.TypeUtils.typeOf;
import static org.objectweb.asm.Opcodes.ACC_PRIVATE;

import org.objectweb.asm.Type;

public interface ClassDefineField<CB> {

	default CB field(int access, Class<?> annotationClass, Object value, String fieldName, Class<?> fieldClass) {
		return field(access, typeOf(annotationClass), value, fieldName, typeOf(fieldClass));
	}

	default CB field(int access, Class<?> annotationClass, String fieldName, Class<?> fieldClass) {
		return field(access, typeOf(annotationClass), null, fieldName, typeOf(fieldClass));
	}

	default CB field(int access, String fieldName, Class<?> fieldClass) {
		return field(access, fieldName, typeOf(fieldClass));
	}

	CB field(int access, String fieldName, Type fieldType);

	CB field(int access, String fieldName, Type fieldType, String signature);

	CB field(int access, Type annotationType, Object value, String fieldName, Type fieldType);

	CB field(int access, Type annotationType, Object value, String fieldName, Type fieldType, String signature);

	default CB field(String fieldName, Class<?> fieldClass) {
		return field(ACC_PRIVATE, fieldName, typeOf(fieldClass));
	}

	default CB field(String fieldName, Class<?> fieldClass, Class<?>... signatureClasses) {
		return field(ACC_PRIVATE, fieldName, typeOf(fieldClass), signatureOf(typeOf(fieldClass), signatureClasses));
	}

	default CB field(String fieldName, Class<?> fieldClass, String signature) {
		return field(ACC_PRIVATE, fieldName, typeOf(fieldClass), signature);
	}

	default CB field(String fieldName, String fieldClass, String... signatureClasses) {
		return field(ACC_PRIVATE, fieldName, typeOf(fieldClass),
				signatureOf(typeOf(fieldClass), typeOf(signatureClasses)));
	}

	default CB fieldWithAnnotation(Class<?> annotationClass, Object value, String fieldName, Class<?> fieldClass) {
		return field(ACC_PRIVATE, typeOf(annotationClass), value, fieldName, typeOf(fieldClass));
	}

	default CB fieldWithAnnotation(Class<?> annotationClass, Object value, String fieldName, Class<?> fieldClass,
			Class<?>... signatureClasses) {
		return field(ACC_PRIVATE, typeOf(annotationClass), value, fieldName, typeOf(fieldClass),
				signatureOf(typeOf(fieldClass), signatureClasses));
	}

	default CB fieldWithAnnotation(Class<?> annotationClass, Object value, String fieldName, Class<?> fieldClass,
			String signature) {
		return field(ACC_PRIVATE, typeOf(annotationClass), value, fieldName, typeOf(fieldClass), signature);
	}

	default CB fieldWithAnnotation(Class<?> annotationClass, String fieldName, Class<?> fieldClass) {
		return field(ACC_PRIVATE, typeOf(annotationClass), null, fieldName, typeOf(fieldClass));
	}

	default CB fieldWithAnnotation(Class<?> annotationClass, String fieldName, Class<?> fieldClass,
			Class<?>... signatureClasses) {
		return field(ACC_PRIVATE, typeOf(annotationClass), null, fieldName, typeOf(fieldClass),
				signatureOf(typeOf(fieldClass), signatureClasses));
	}

	default CB fieldWithAnnotation(Class<?> annotationClass, String fieldName, Class<?> fieldClass, String signature) {
		return field(ACC_PRIVATE, typeOf(annotationClass), null, fieldName, typeOf(fieldClass), signature);
	}

	default CB fieldWithAnnotation(String annotationClass, String fieldName, Class<?> fieldClass) {
		return field(ACC_PRIVATE, typeOf(annotationClass), null, fieldName, typeOf(fieldClass));
	}

	default CB fieldWithAnnotation(String annotationClass, String fieldName, String fieldClass) {
		return field(ACC_PRIVATE, typeOf(annotationClass), null, fieldName, typeOf(fieldClass));
	}
}