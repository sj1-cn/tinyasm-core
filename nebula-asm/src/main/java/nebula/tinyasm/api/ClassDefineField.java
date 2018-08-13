package nebula.tinyasm.api;

import static nebula.tinyasm.util.TypeUtils.*;
import static org.objectweb.asm.Opcodes.ACC_PRIVATE;

import org.objectweb.asm.Type;

import nebula.tinyasm.data.Field;

public interface ClassDefineField<CB>{

	default CB field(Field field) {
		return field(field.name, field.type);
	}

	default CB field(Field field, Class<?>... signatureClasses) {
		return field(field.name, field.type, signatureOf(field.type, signatureClasses));
	}

	default CB field(Field field, String signature) {
		return field(field.name, field.type, signature);
	}

	default CB field(Field field, Type... signatureTypes) {
		return field(field.name, field.type, signatureOf(field.type, signatureTypes));
	}

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

	default CB field(int access, String fieldName, Type fieldType, boolean array) {
		return field(access, fieldName, arrayOf(fieldType, array));
	}

	CB field(int access, String fieldName, Type fieldType, String signature);

	CB field(int access, Type annotationType, Object value, String fieldName, Type fieldType);

	CB field(int access, Type annotationType, Object value, String fieldName, Type fieldType, String signature);

	default CB field(String fieldName, Class<?> fieldClass) {
		return field(fieldName, typeOf(fieldClass));
	}

	default CB field(String fieldName, Class<?> fieldClass, Class<?>... signatureClasses) {
		return field(fieldName, typeOf(fieldClass), signatureOf(typeOf(fieldClass), signatureClasses));
	}
	
	default CB field(String fieldName, Class<?> fieldClass, String signature) {
		return field(fieldName, typeOf(fieldClass), signature);
	}

	default CB field(String fieldName, Class<?> fieldClass, Type... signatureTypes) {
		return field(fieldName, typeOf(fieldClass), signatureOf(typeOf(fieldClass), signatureTypes));
	}

	default CB field(String fieldName, String fieldClass, String... signatureClasses) {
		return field(fieldName, typeOf(fieldClass), signatureOf(typeOf(fieldClass), typeOf(signatureClasses)));
	}

	default CB field(String fieldName, Type fieldType) {
		return field(ACC_PRIVATE, fieldName, fieldType);
	}

	default CB field(String fieldName, Type fieldType, Class<?>... signatureClasses) {
		return field(fieldName, fieldType, signatureOf(fieldType, signatureClasses));
	}

	default CB field(String fieldName, Type fieldType, String signature) {
		return field(ACC_PRIVATE, fieldName, fieldType, signature);
	}

	default CB field(String fieldName, Type fieldType, Type... signatureTypes) {
		return field(fieldName, fieldType, signatureOf(fieldType, signatureTypes));
	}

	default CB field(Type annotationType, String fieldName, Class<?> fieldClass, String signature) {
		return fieldWithAnnotation(annotationType, null, fieldName, typeOf(fieldClass), signature);
	}

	default CB field(Type annotationType, String fieldName, Class<?> fieldClass, Type... signatureTypes) {
		return fieldWithAnnotation(annotationType, null, fieldName, typeOf(fieldClass),
				signatureOf(typeOf(fieldClass), signatureTypes));
	}

	default CB fieldWithAnnotation(Class<?> annotationClass, Field field) {
		return fieldWithAnnotation(typeOf(annotationClass), null, field.name, field.type);
	}

	default CB fieldWithAnnotation(Class<?> annotationClass, Field field, Class<?>... signatureClasses) {
		return fieldWithAnnotation(typeOf(annotationClass), null, field.name, field.type, signatureOf(field.type, signatureClasses));
	}

	default CB fieldWithAnnotation(Class<?> annotationClass, Field field, String signature) {
		return fieldWithAnnotation(typeOf(annotationClass), null, field.name, field.type, signature);
	}

	default CB fieldWithAnnotation(Class<?> annotationClass, Field field, Type... signatureTypes) {
		return fieldWithAnnotation(typeOf(annotationClass), null, field.name, field.type, signatureOf(field.type, signatureTypes));
	}

	default CB fieldWithAnnotation(Class<?> annotationClass, Object value, Field field) {
		return fieldWithAnnotation(typeOf(annotationClass), value, field.name, field.type);
	}

	default CB fieldWithAnnotation(Class<?> annotationClass, Object value, Field field, Class<?>... signatureClasses) {
		return fieldWithAnnotation(typeOf(annotationClass), value, field.name, field.type, signatureOf(field.type, signatureClasses));
	}

	default CB fieldWithAnnotation(Class<?> annotationClass, Object value, Field field, String signature) {
		return fieldWithAnnotation(typeOf(annotationClass), value, field.name, field.type, signature);
	}

	default CB fieldWithAnnotation(Class<?> annotationClass, Object value, Field field, Type... signatureTypes) {
		return fieldWithAnnotation(typeOf(annotationClass), value, field.name, field.type, signatureOf(field.type, signatureTypes));
	}

	default CB fieldWithAnnotation(Class<?> annotationClass, Object value, String fieldName, Class<?> fieldClass) {
		return fieldWithAnnotation(typeOf(annotationClass), value, fieldName, typeOf(fieldClass));
	}

	default CB fieldWithAnnotation(Class<?> annotationClass, Object value, String fieldName, Class<?> fieldClass,
			Class<?>... signatureClasses) {
		return fieldWithAnnotation(typeOf(annotationClass), value, fieldName, typeOf(fieldClass),
				signatureOf(typeOf(fieldClass), signatureClasses));
	}

	default CB fieldWithAnnotation(Class<?> annotationClass, Object value, String fieldName, Class<?> fieldClass, String signature) {
		return fieldWithAnnotation(typeOf(annotationClass), value, fieldName, typeOf(fieldClass), signature);
	}

	default CB fieldWithAnnotation(Class<?> annotationClass, Object value, String fieldName, Class<?> fieldClass,
			Type... signatureTypes) {
		return fieldWithAnnotation(typeOf(annotationClass), value, fieldName, typeOf(fieldClass),
				signatureOf(typeOf(fieldClass), signatureTypes));
	}

	default CB fieldWithAnnotation(Class<?> annotationClass, Object value, String fieldName, Type fieldType) {
		return fieldWithAnnotation(typeOf(annotationClass), value, fieldName, fieldType);
	}

	default CB fieldWithAnnotation(Class<?> annotationClass, Object value, String fieldName, Type fieldType,
			Class<?>... signatureClasses) {
		return fieldWithAnnotation(typeOf(annotationClass), value, fieldName, fieldType, signatureOf(fieldType, signatureClasses));
	}

	default CB fieldWithAnnotation(Class<?> annotationClass, Object value, String fieldName, Type fieldType, String signature) {
		return fieldWithAnnotation(typeOf(annotationClass), value, fieldName, fieldType, signature);
	}
	
	default CB fieldWithAnnotation(Class<?> annotationClass, Object value, String fieldName, Type fieldType, Type... signatureTypes) {
		return fieldWithAnnotation(typeOf(annotationClass), value, fieldName, fieldType, signatureOf(fieldType, signatureTypes));
	}

	default CB fieldWithAnnotation(Class<?> annotationClass, String fieldName, Class<?> fieldClass) {
		return fieldWithAnnotation(typeOf(annotationClass), null, fieldName, typeOf(fieldClass));
	}
	default CB fieldWithAnnotation(Class<?> annotationClass, String fieldName, Class<?> fieldClass, Class<?>... signatureClasses) {
		return fieldWithAnnotation(typeOf(annotationClass), null, fieldName, typeOf(fieldClass),
				signatureOf(typeOf(fieldClass), signatureClasses));
	}
	
	default CB fieldWithAnnotation(Class<?> annotationClass, String fieldName, Class<?> fieldClass, String signature) {
		return fieldWithAnnotation(typeOf(annotationClass), null, fieldName, typeOf(fieldClass), signature);
	}

	default CB fieldWithAnnotation(Class<?> annotationClass, String fieldName, Class<?> fieldClass, Type... signatureTypes) {
		return fieldWithAnnotation(typeOf(annotationClass), null, fieldName, typeOf(fieldClass),
				signatureOf(typeOf(fieldClass), signatureTypes));
	}

	default CB fieldWithAnnotation(Class<?> annotationClass, String fieldName, Type fieldType) {
		return fieldWithAnnotation(typeOf(annotationClass), null, fieldName, fieldType);
	}

	default CB fieldWithAnnotation(Class<?> annotationClass, String fieldName, Type fieldType, Class<?>... signatureClasses) {
		return fieldWithAnnotation(typeOf(annotationClass), null, fieldName, fieldType, signatureOf(fieldType, signatureClasses));
	}

	default CB fieldWithAnnotation(Class<?> annotationClass, String fieldName, Type fieldType, String signature) {
		return fieldWithAnnotation(typeOf(annotationClass), null, fieldName, fieldType, signature);
	}

	default CB fieldWithAnnotation(Class<?> annotationClass, String fieldName, Type fieldType, Type... signatureTypes) {
		return fieldWithAnnotation(typeOf(annotationClass), null, fieldName, fieldType, signatureOf(fieldType, signatureTypes));
	}

	default CB fieldWithAnnotation(String annotationClass, String fieldName, Class<?> fieldClass) {
		return fieldWithAnnotation(typeOf(annotationClass), null, fieldName, typeOf(fieldClass));
	}

	default CB fieldWithAnnotation(String annotationClass, String fieldName, String fieldClass) {
		return fieldWithAnnotation(typeOf(annotationClass), null, fieldName, typeOf(fieldClass));
	}

	default CB fieldWithAnnotation(Type annotationType, Field field, Class<?>... signatureClasses) {
		return fieldWithAnnotation(annotationType, null, field.name, field.type, signatureOf(field.type, signatureClasses));
	}

	default CB fieldWithAnnotation(Type annotationType, Field field, String signature) {
		return fieldWithAnnotation(annotationType, null, field.name, field.type, signature);
	}

	default CB fieldWithAnnotation(Type annotationType, Field field, Type... signatureTypes) {
		return fieldWithAnnotation(annotationType, null, field.name, field.type, signatureOf(field.type, signatureTypes));
	}

	default CB fieldWithAnnotation(Type annotationType, Object value, Field field, Class<?>... signatureClasses) {
		return fieldWithAnnotation(annotationType, value, field.name, field.type, signatureOf(field.type, signatureClasses));
	}

	default CB fieldWithAnnotation(Type annotationType, Object value, Field field, String signature) {
		return fieldWithAnnotation(annotationType, value, field.name, field.type, signature);
	}

	default CB fieldWithAnnotation(Type annotationType, Object value, Field field, Type... signatureTypes) {
		return fieldWithAnnotation(annotationType, value, field.name, field.type, signatureOf(field.type, signatureTypes));
	}

	default CB fieldWithAnnotation(Type annotationType, Object value, String fieldName, Class<?> fieldClass) {
		return fieldWithAnnotation(annotationType, value, fieldName, typeOf(fieldClass));
	}

	default CB fieldWithAnnotation(Type annotationType, Object value, String fieldName, Class<?> fieldClass,
			Class<?>... signatureClasses) {
		return fieldWithAnnotation(annotationType, value, fieldName, typeOf(fieldClass),
				signatureOf(typeOf(fieldClass), signatureClasses));
	}

	default CB fieldWithAnnotation(Type annotationType, Object value, String fieldName, Class<?> fieldClass, String signature) {
		return fieldWithAnnotation(annotationType, value, fieldName, typeOf(fieldClass), signature);
	}

	default CB fieldWithAnnotation(Type annotationType, Object value, String fieldName, Class<?> fieldClass, Type... signatureTypes) {
		return fieldWithAnnotation(annotationType, value, fieldName, typeOf(fieldClass),
				signatureOf(typeOf(fieldClass), signatureTypes));
	}

	default CB fieldWithAnnotation(Type annotationType, Object value, String fieldName, Type fieldType) {
		return field(ACC_PRIVATE, annotationType, value, fieldName, fieldType);
	}

	default CB fieldWithAnnotation(Type annotationType, Object value, String fieldName, Type fieldType,
			Class<?>... signatureClasses) {
		return fieldWithAnnotation(annotationType, value, fieldName, fieldType, signatureOf(fieldType, signatureClasses));
	}

	default CB fieldWithAnnotation(Type annotationType, Object value, String fieldName, Type fieldType, String signature) {
		return field(ACC_PRIVATE, annotationType, value, fieldName, fieldType, signature);
	}

	default CB fieldWithAnnotation(Type annotationType, Object value, String fieldName, Type fieldType, Type... signatureTypes) {
		return fieldWithAnnotation(annotationType, value, fieldName, fieldType, signatureOf(fieldType, signatureTypes));
	}

	default CB fieldWithAnnotation(Type annotationType, String fieldName, Class<?> fieldClass) {
		return fieldWithAnnotation(annotationType, null, fieldName, typeOf(fieldClass));
	}

	default CB fieldWithAnnotation(Type annotationType, String fieldName, Class<?> fieldClass, Class<?>... signatureClasses) {
		return fieldWithAnnotation(annotationType, null, fieldName, typeOf(fieldClass),
				signatureOf(typeOf(fieldClass), signatureClasses));
	}

	default CB fieldWithAnnotation(Type annotationType, String fieldName, Type fieldType, Class<?>... signatureClasses) {
		return fieldWithAnnotation(annotationType, null, fieldName, fieldType, signatureOf(fieldType, signatureClasses));
	}

	default CB fieldWithAnnotation(Type annotationType, String fieldName, Type fieldType, Type... signatureTypes) {
		return fieldWithAnnotation(annotationType, null, fieldName, fieldType, signatureOf(fieldType, signatureTypes));
	}
}