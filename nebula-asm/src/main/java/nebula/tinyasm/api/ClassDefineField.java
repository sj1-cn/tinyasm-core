package nebula.tinyasm.api;

import static nebula.tinyasm.util.TypeUtils.*;
import static org.objectweb.asm.Opcodes.ACC_PRIVATE;

import org.objectweb.asm.Type;

public interface ClassDefineField<CR>{

	default CR field(Field field) {
		return field(field.name, field.type);
	}

	default CR field(Field field, Class<?>... signatureClasses) {
		return field(field.name, field.type, signatureOf(field.type, signatureClasses));
	}

	default CR field(Field field, String signature) {
		return field(field.name, field.type, signature);
	}

	default CR field(Field field, Type... signatureTypes) {
		return field(field.name, field.type, signatureOf(field.type, signatureTypes));
	}

	default CR field(int access, Class<?> annotationClass, Object value, String fieldName, Class<?> fieldClass) {
		return field(access, typeOf(annotationClass), value, fieldName, typeOf(fieldClass));
	}

	default CR field(int access, Class<?> annotationClass, String fieldName, Class<?> fieldClass) {
		return field(access, typeOf(annotationClass), null, fieldName, typeOf(fieldClass));
	}

	default CR field(int access, String fieldName, Class<?> fieldClass) {
		return field(access, fieldName, typeOf(fieldClass));
	}

	CR field(int access, String fieldName, Type fieldType);

	default CR field(int access, String fieldName, Type fieldType, boolean array) {
		return field(access, fieldName, arrayOf(fieldType, array));
	}

	CR field(int access, String fieldName, Type fieldType, String signature);

	CR field(int access, Type annotationType, Object value, String fieldName, Type fieldType);

	CR field(int access, Type annotationType, Object value, String fieldName, Type fieldType, String signature);

	default CR field(String fieldName, Class<?> fieldClass) {
		return field(fieldName, typeOf(fieldClass));
	}

	default CR field(String fieldName, Class<?> fieldClass, Class<?>... signatureClasses) {
		return field(fieldName, typeOf(fieldClass), signatureOf(typeOf(fieldClass), signatureClasses));
	}
	
	default CR field(String fieldName, Class<?> fieldClass, String signature) {
		return field(fieldName, typeOf(fieldClass), signature);
	}

	default CR field(String fieldName, Class<?> fieldClass, Type... signatureTypes) {
		return field(fieldName, typeOf(fieldClass), signatureOf(typeOf(fieldClass), signatureTypes));
	}

	default CR field(String fieldName, String fieldClass, String... signatureClasses) {
		return field(fieldName, typeOf(fieldClass), signatureOf(typeOf(fieldClass), typeOf(signatureClasses)));
	}

	default CR field(String fieldName, Type fieldType) {
		return field(ACC_PRIVATE, fieldName, fieldType);
	}

	default CR field(String fieldName, Type fieldType, Class<?>... signatureClasses) {
		return field(fieldName, fieldType, signatureOf(fieldType, signatureClasses));
	}

	default CR field(String fieldName, Type fieldType, String signature) {
		return field(ACC_PRIVATE, fieldName, fieldType, signature);
	}

	default CR field(String fieldName, Type fieldType, Type... signatureTypes) {
		return field(fieldName, fieldType, signatureOf(fieldType, signatureTypes));
	}

	default CR field(Type annotationType, String fieldName, Class<?> fieldClass, String signature) {
		return fieldWithAnnotation(annotationType, null, fieldName, typeOf(fieldClass), signature);
	}

	default CR field(Type annotationType, String fieldName, Class<?> fieldClass, Type... signatureTypes) {
		return fieldWithAnnotation(annotationType, null, fieldName, typeOf(fieldClass),
				signatureOf(typeOf(fieldClass), signatureTypes));
	}

	default CR fieldWithAnnotation(Class<?> annotationClass, Field field) {
		return fieldWithAnnotation(typeOf(annotationClass), null, field.name, field.type);
	}

	default CR fieldWithAnnotation(Class<?> annotationClass, Field field, Class<?>... signatureClasses) {
		return fieldWithAnnotation(typeOf(annotationClass), null, field.name, field.type, signatureOf(field.type, signatureClasses));
	}

	default CR fieldWithAnnotation(Class<?> annotationClass, Field field, String signature) {
		return fieldWithAnnotation(typeOf(annotationClass), null, field.name, field.type, signature);
	}

	default CR fieldWithAnnotation(Class<?> annotationClass, Field field, Type... signatureTypes) {
		return fieldWithAnnotation(typeOf(annotationClass), null, field.name, field.type, signatureOf(field.type, signatureTypes));
	}

	default CR fieldWithAnnotation(Class<?> annotationClass, Object value, Field field) {
		return fieldWithAnnotation(typeOf(annotationClass), value, field.name, field.type);
	}

	default CR fieldWithAnnotation(Class<?> annotationClass, Object value, Field field, Class<?>... signatureClasses) {
		return fieldWithAnnotation(typeOf(annotationClass), value, field.name, field.type, signatureOf(field.type, signatureClasses));
	}

	default CR fieldWithAnnotation(Class<?> annotationClass, Object value, Field field, String signature) {
		return fieldWithAnnotation(typeOf(annotationClass), value, field.name, field.type, signature);
	}

	default CR fieldWithAnnotation(Class<?> annotationClass, Object value, Field field, Type... signatureTypes) {
		return fieldWithAnnotation(typeOf(annotationClass), value, field.name, field.type, signatureOf(field.type, signatureTypes));
	}

	default CR fieldWithAnnotation(Class<?> annotationClass, Object value, String fieldName, Class<?> fieldClass) {
		return fieldWithAnnotation(typeOf(annotationClass), value, fieldName, typeOf(fieldClass));
	}

	default CR fieldWithAnnotation(Class<?> annotationClass, Object value, String fieldName, Class<?> fieldClass,
			Class<?>... signatureClasses) {
		return fieldWithAnnotation(typeOf(annotationClass), value, fieldName, typeOf(fieldClass),
				signatureOf(typeOf(fieldClass), signatureClasses));
	}

	default CR fieldWithAnnotation(Class<?> annotationClass, Object value, String fieldName, Class<?> fieldClass, String signature) {
		return fieldWithAnnotation(typeOf(annotationClass), value, fieldName, typeOf(fieldClass), signature);
	}

	default CR fieldWithAnnotation(Class<?> annotationClass, Object value, String fieldName, Class<?> fieldClass,
			Type... signatureTypes) {
		return fieldWithAnnotation(typeOf(annotationClass), value, fieldName, typeOf(fieldClass),
				signatureOf(typeOf(fieldClass), signatureTypes));
	}

	default CR fieldWithAnnotation(Class<?> annotationClass, Object value, String fieldName, Type fieldType) {
		return fieldWithAnnotation(typeOf(annotationClass), value, fieldName, fieldType);
	}

	default CR fieldWithAnnotation(Class<?> annotationClass, Object value, String fieldName, Type fieldType,
			Class<?>... signatureClasses) {
		return fieldWithAnnotation(typeOf(annotationClass), value, fieldName, fieldType, signatureOf(fieldType, signatureClasses));
	}

	default CR fieldWithAnnotation(Class<?> annotationClass, Object value, String fieldName, Type fieldType, String signature) {
		return fieldWithAnnotation(typeOf(annotationClass), value, fieldName, fieldType, signature);
	}
	
	default CR fieldWithAnnotation(Class<?> annotationClass, Object value, String fieldName, Type fieldType, Type... signatureTypes) {
		return fieldWithAnnotation(typeOf(annotationClass), value, fieldName, fieldType, signatureOf(fieldType, signatureTypes));
	}

	default CR fieldWithAnnotation(Class<?> annotationClass, String fieldName, Class<?> fieldClass) {
		return fieldWithAnnotation(typeOf(annotationClass), null, fieldName, typeOf(fieldClass));
	}
	default CR fieldWithAnnotation(Class<?> annotationClass, String fieldName, Class<?> fieldClass, Class<?>... signatureClasses) {
		return fieldWithAnnotation(typeOf(annotationClass), null, fieldName, typeOf(fieldClass),
				signatureOf(typeOf(fieldClass), signatureClasses));
	}
	
	default CR fieldWithAnnotation(Class<?> annotationClass, String fieldName, Class<?> fieldClass, String signature) {
		return fieldWithAnnotation(typeOf(annotationClass), null, fieldName, typeOf(fieldClass), signature);
	}

	default CR fieldWithAnnotation(Class<?> annotationClass, String fieldName, Class<?> fieldClass, Type... signatureTypes) {
		return fieldWithAnnotation(typeOf(annotationClass), null, fieldName, typeOf(fieldClass),
				signatureOf(typeOf(fieldClass), signatureTypes));
	}

	default CR fieldWithAnnotation(Class<?> annotationClass, String fieldName, Type fieldType) {
		return fieldWithAnnotation(typeOf(annotationClass), null, fieldName, fieldType);
	}

	default CR fieldWithAnnotation(Class<?> annotationClass, String fieldName, Type fieldType, Class<?>... signatureClasses) {
		return fieldWithAnnotation(typeOf(annotationClass), null, fieldName, fieldType, signatureOf(fieldType, signatureClasses));
	}

	default CR fieldWithAnnotation(Class<?> annotationClass, String fieldName, Type fieldType, String signature) {
		return fieldWithAnnotation(typeOf(annotationClass), null, fieldName, fieldType, signature);
	}

	default CR fieldWithAnnotation(Class<?> annotationClass, String fieldName, Type fieldType, Type... signatureTypes) {
		return fieldWithAnnotation(typeOf(annotationClass), null, fieldName, fieldType, signatureOf(fieldType, signatureTypes));
	}

	default CR fieldWithAnnotation(String annotationClass, String fieldName, Class<?> fieldClass) {
		return fieldWithAnnotation(typeOf(annotationClass), null, fieldName, typeOf(fieldClass));
	}

	default CR fieldWithAnnotation(String annotationClass, String fieldName, String fieldClass) {
		return fieldWithAnnotation(typeOf(annotationClass), null, fieldName, typeOf(fieldClass));
	}

	default CR fieldWithAnnotation(Type annotationType, Field field, Class<?>... signatureClasses) {
		return fieldWithAnnotation(annotationType, null, field.name, field.type, signatureOf(field.type, signatureClasses));
	}

	default CR fieldWithAnnotation(Type annotationType, Field field, String signature) {
		return fieldWithAnnotation(annotationType, null, field.name, field.type, signature);
	}

	default CR fieldWithAnnotation(Type annotationType, Field field, Type... signatureTypes) {
		return fieldWithAnnotation(annotationType, null, field.name, field.type, signatureOf(field.type, signatureTypes));
	}

	default CR fieldWithAnnotation(Type annotationType, Object value, Field field, Class<?>... signatureClasses) {
		return fieldWithAnnotation(annotationType, value, field.name, field.type, signatureOf(field.type, signatureClasses));
	}

	default CR fieldWithAnnotation(Type annotationType, Object value, Field field, String signature) {
		return fieldWithAnnotation(annotationType, value, field.name, field.type, signature);
	}

	default CR fieldWithAnnotation(Type annotationType, Object value, Field field, Type... signatureTypes) {
		return fieldWithAnnotation(annotationType, value, field.name, field.type, signatureOf(field.type, signatureTypes));
	}

	default CR fieldWithAnnotation(Type annotationType, Object value, String fieldName, Class<?> fieldClass) {
		return fieldWithAnnotation(annotationType, value, fieldName, typeOf(fieldClass));
	}

	default CR fieldWithAnnotation(Type annotationType, Object value, String fieldName, Class<?> fieldClass,
			Class<?>... signatureClasses) {
		return fieldWithAnnotation(annotationType, value, fieldName, typeOf(fieldClass),
				signatureOf(typeOf(fieldClass), signatureClasses));
	}

	default CR fieldWithAnnotation(Type annotationType, Object value, String fieldName, Class<?> fieldClass, String signature) {
		return fieldWithAnnotation(annotationType, value, fieldName, typeOf(fieldClass), signature);
	}

	default CR fieldWithAnnotation(Type annotationType, Object value, String fieldName, Class<?> fieldClass, Type... signatureTypes) {
		return fieldWithAnnotation(annotationType, value, fieldName, typeOf(fieldClass),
				signatureOf(typeOf(fieldClass), signatureTypes));
	}

	default CR fieldWithAnnotation(Type annotationType, Object value, String fieldName, Type fieldType) {
		return field(ACC_PRIVATE, annotationType, value, fieldName, fieldType);
	}

	default CR fieldWithAnnotation(Type annotationType, Object value, String fieldName, Type fieldType,
			Class<?>... signatureClasses) {
		return fieldWithAnnotation(annotationType, value, fieldName, fieldType, signatureOf(fieldType, signatureClasses));
	}

	default CR fieldWithAnnotation(Type annotationType, Object value, String fieldName, Type fieldType, String signature) {
		return field(ACC_PRIVATE, annotationType, value, fieldName, fieldType, signature);
	}

	default CR fieldWithAnnotation(Type annotationType, Object value, String fieldName, Type fieldType, Type... signatureTypes) {
		return fieldWithAnnotation(annotationType, value, fieldName, fieldType, signatureOf(fieldType, signatureTypes));
	}

	default CR fieldWithAnnotation(Type annotationType, String fieldName, Class<?> fieldClass) {
		return fieldWithAnnotation(annotationType, null, fieldName, typeOf(fieldClass));
	}

	default CR fieldWithAnnotation(Type annotationType, String fieldName, Class<?> fieldClass, Class<?>... signatureClasses) {
		return fieldWithAnnotation(annotationType, null, fieldName, typeOf(fieldClass),
				signatureOf(typeOf(fieldClass), signatureClasses));
	}

	default CR fieldWithAnnotation(Type annotationType, String fieldName, Type fieldType, Class<?>... signatureClasses) {
		return fieldWithAnnotation(annotationType, null, fieldName, fieldType, signatureOf(fieldType, signatureClasses));
	}

	default CR fieldWithAnnotation(Type annotationType, String fieldName, Type fieldType, Type... signatureTypes) {
		return fieldWithAnnotation(annotationType, null, fieldName, fieldType, signatureOf(fieldType, signatureTypes));
	}
}