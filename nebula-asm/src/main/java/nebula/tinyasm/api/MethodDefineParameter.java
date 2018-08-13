package nebula.tinyasm.api;

import static nebula.tinyasm.util.TypeUtils.arrayOf;
import static nebula.tinyasm.util.TypeUtils.signatureOf;
import static nebula.tinyasm.util.TypeUtils.typeOf;

import java.util.List;

import org.objectweb.asm.Type;

import nebula.tinyasm.data.ClassField;
import nebula.tinyasm.data.Field;

interface MethodDefineParameter<MC> {
	MethodHeader<MC> parameter(ClassField field);

	default MethodHeader<MC> parameter(Field parameter) {
		return parameter(parameter.name, parameter.type);
	}

	default MethodHeader<MC> parameter(Field... parameters) {
		MethodHeader<MC> cr = null;
		for (Field parameter : parameters) {
			cr = parameter(parameter.name, parameter.type);
		}
		return cr;
	}

	default MethodHeader<MC> parameterGeneric(Field parameter, Class<?>... signatureClasses) {
		return parameterGeneric(parameter.name, parameter.type, signatureOf(parameter.type, signatureClasses));
	}

	default MethodHeader<MC> parameter(Field parameter, String signature) {
		return parameterGeneric(parameter.name, parameter.type, signature);
	}

	default MethodHeader<MC> parameter(Field parameter, Type... signatureTypes) {
		return parameterGeneric(parameter.name, parameter.type, signatureOf(parameter.type, signatureTypes));
	}

	default MethodHeader<MC> parameter(List<Field> params) {
		MethodHeader<MC> cr = null;
		for (Field parameter : params) {
			cr = parameter(parameter.name, parameter.type);
		}
		return cr;
	}

	default MethodHeader<MC> parameter(String fieldName, Class<?> fieldClass) {
		return parameter(fieldName, typeOf(fieldClass));
	}

	default MethodHeader<MC> parameter(String fieldName, Class<?> fieldClass, Class<?>... signatureClasses) {
		return parameterGeneric(fieldName, typeOf(fieldClass), signatureOf(typeOf(fieldClass), signatureClasses));
	}

	default MethodHeader<MC> parameter(String fieldName, Class<?> fieldClass, String signature) {
		return parameterGeneric(fieldName, typeOf(fieldClass), signature);
	}

	default MethodHeader<MC> parameter(String fieldName, Class<?> fieldClass, Type... signatureTypes) {
		return parameterGeneric(fieldName, typeOf(fieldClass), signatureOf(typeOf(fieldClass), signatureTypes));
	}

	MethodHeader<MC> parameter(String fieldName, Type fieldType);

	default MethodHeader<MC> parameter(String fieldName, Type fieldType, boolean array) {
		return parameter(fieldName, arrayOf(fieldType, false));
	}

	default MethodHeader<MC> parameter(String fieldName, Type fieldType, Class<?>... signatureClasses) {
		return parameterGeneric(fieldName, fieldType, signatureOf(fieldType, signatureClasses));
	}

	MethodHeader<MC> parameterGeneric(String fieldName, Type fieldType, String signature);

	default MethodHeader<MC> parameter(String fieldName, Type fieldType, Type... signatureTypes) {
		return parameterGeneric(fieldName, fieldType, signatureOf(fieldType, signatureTypes));
	}

	default MethodHeader<MC> parameter(Type annotationType, Object value, String fieldName, Class<?> fieldClass,
			Class<?>... signatureClasses) {
		return parameterGenericWithAnnotation(annotationType, value, fieldName, typeOf(fieldClass),
				signatureOf(typeOf(fieldClass), signatureClasses));
	}

	default MethodHeader<MC> parameterWithAnnotation(Class<?> annotationClass, Field parameter) {
		return parameterWithAnnotation(typeOf(annotationClass), null, parameter.name, parameter.type);
	}

	default MethodHeader<MC> parameterWithAnnotation(Class<?> annotationClass, Field parameter,
			Class<?>... signatureClasses) {
		return parameterGenericWithAnnotation(typeOf(annotationClass), null, parameter.name, parameter.type,
				signatureOf(parameter.type, signatureClasses));
	}

	default MethodHeader<MC> parameterWithAnnotation(Class<?> annotationClass, Field parameter, String signature) {
		return parameterGenericWithAnnotation(typeOf(annotationClass), null, parameter.name, parameter.type, signature);
	}

	default MethodHeader<MC> parameterWithAnnotation(Class<?> annotationClass, Field parameter,
			Type... signatureTypes) {
		return parameterGenericWithAnnotation(typeOf(annotationClass), null, parameter.name, parameter.type,
				signatureOf(parameter.type, signatureTypes));
	}

	default MethodHeader<MC> parameterWithAnnotation(Class<?> annotationClass, Object value, Field parameter) {
		return parameterWithAnnotation(typeOf(annotationClass), value, parameter.name, parameter.type);
	}

	default MethodHeader<MC> parameterWithAnnotation(Class<?> annotationClass, Object value, Field parameter,
			Class<?>... signatureClasses) {
		return parameterGenericWithAnnotation(typeOf(annotationClass), value, parameter.name, parameter.type,
				signatureOf(parameter.type, signatureClasses));
	}

	default MethodHeader<MC> parameterWithAnnotation(Class<?> annotationClass, Object value, Field parameter,
			String signature) {
		return parameterGenericWithAnnotation(typeOf(annotationClass), value, parameter.name, parameter.type,
				signature);
	}

	default MethodHeader<MC> parameterWithAnnotation(Class<?> annotationClass, Object value, Field parameter,
			Type... signatureTypes) {
		return parameterGenericWithAnnotation(typeOf(annotationClass), value, parameter.name, parameter.type,
				signatureOf(parameter.type, signatureTypes));
	}

	default MethodHeader<MC> parameterWithAnnotation(Class<?> annotationClass, Object value, String fieldName,
			Class<?> fieldClass) {
		return parameterWithAnnotation(typeOf(annotationClass), value, fieldName, typeOf(fieldClass));
	}

	default MethodHeader<MC> parameterWithAnnotation(Class<?> annotationClass, Object value, String fieldName,
			Class<?> fieldClass, Class<?>... signatureClasses) {
		return parameterGenericWithAnnotation(typeOf(annotationClass), value, fieldName, typeOf(fieldClass),
				signatureOf(typeOf(fieldClass), signatureClasses));
	}

	default MethodHeader<MC> parameterWithAnnotation(Class<?> annotationClass, Object value, String fieldName,
			Class<?> fieldClass, String signature) {
		return parameterGenericWithAnnotation(typeOf(annotationClass), value, fieldName, typeOf(fieldClass), signature);
	}

	default MethodHeader<MC> parameterWithAnnotation(Class<?> annotationClass, Object value, String fieldName,
			Class<?> fieldClass, Type... signatureTypes) {
		return parameterGenericWithAnnotation(typeOf(annotationClass), value, fieldName, typeOf(fieldClass),
				signatureOf(typeOf(fieldClass), signatureTypes));
	}

	default MethodHeader<MC> parameterWithAnnotation(Class<?> annotationClass, Object value, String fieldName,
			Type fieldType) {
		return parameterWithAnnotation(typeOf(annotationClass), value, fieldName, fieldType);
	}

	default MethodHeader<MC> parameterWithAnnotation(Class<?> annotationClass, Object value, String fieldName,
			Type fieldType, Class<?>... signatureClasses) {
		return parameterGenericWithAnnotation(typeOf(annotationClass), value, fieldName, fieldType,
				signatureOf(fieldType, signatureClasses));
	}

	default MethodHeader<MC> parameterWithAnnotation(Class<?> annotationClass, Object value, String fieldName,
			Type fieldType, String signature) {
		return parameterGenericWithAnnotation(typeOf(annotationClass), value, fieldName, fieldType, signature);
	}

	default MethodHeader<MC> parameterWithAnnotation(Class<?> annotationClass, Object value, String fieldName,
			Type fieldType, Type... signatureTypes) {
		return parameterGenericWithAnnotation(typeOf(annotationClass), value, fieldName, fieldType,
				signatureOf(fieldType, signatureTypes));
	}

	default MethodHeader<MC> parameterWithAnnotation(Class<?> annotationClass, String fieldName, Class<?> fieldClass) {
		return parameterWithAnnotation(typeOf(annotationClass), null, fieldName, typeOf(fieldClass));
	}

	default MethodHeader<MC> parameterWithAnnotation(Class<?> annotationClass, String fieldName, Class<?> fieldClass,
			Class<?>... signatureClasses) {
		return parameterGenericWithAnnotation(typeOf(annotationClass), null, fieldName, typeOf(fieldClass),
				signatureOf(typeOf(fieldClass), signatureClasses));
	}

	default MethodHeader<MC> parameterWithAnnotation(Class<?> annotationClass, String fieldName, Class<?> fieldClass,
			String signature) {
		return parameterGenericWithAnnotation(typeOf(annotationClass), null, fieldName, typeOf(fieldClass), signature);
	}

	default MethodHeader<MC> parameterWithAnnotation(Class<?> annotationClass, String fieldName, Class<?> fieldClass,
			Type... signatureTypes) {
		return parameterGenericWithAnnotation(typeOf(annotationClass), null, fieldName, typeOf(fieldClass),
				signatureOf(typeOf(fieldClass), signatureTypes));
	}

	default MethodHeader<MC> parameterWithAnnotation(Class<?> annotationClass, String fieldName, Type fieldType) {
		return parameterWithAnnotation(typeOf(annotationClass), null, fieldName, fieldType);
	}

	default MethodHeader<MC> parameterWithAnnotation(Class<?> annotationClass, String fieldName, Type fieldType,
			Class<?>... signatureClasses) {
		return parameterGenericWithAnnotation(typeOf(annotationClass), null, fieldName, fieldType,
				signatureOf(fieldType, signatureClasses));
	}

	default MethodHeader<MC> parameterWithAnnotation(Class<?> annotationClass, String fieldName, Type fieldType,
			String signature) {
		return parameterGenericWithAnnotation(typeOf(annotationClass), null, fieldName, fieldType, signature);
	}

	default MethodHeader<MC> parameterWithAnnotation(Class<?> annotationClass, String fieldName, Type fieldType,
			Type... signatureTypes) {
		return parameterGenericWithAnnotation(typeOf(annotationClass), null, fieldName, fieldType,
				signatureOf(fieldType, signatureTypes));
	}

	default MethodHeader<MC> parameterWithAnnotation(Type annotationType, Field parameter,
			Class<?>... signatureClasses) {
		return parameterGenericWithAnnotation(annotationType, null, parameter.name, parameter.type,
				signatureOf(parameter.type, signatureClasses));
	}

	default MethodHeader<MC> parameterWithAnnotation(Type annotationType, Field parameter, String signature) {
		return parameterGenericWithAnnotation(annotationType, null, parameter.name, parameter.type, signature);
	}

	default MethodHeader<MC> parameterWithAnnotation(Type annotationType, Field parameter, Type... signatureTypes) {
		return parameterGenericWithAnnotation(annotationType, null, parameter.name, parameter.type,
				signatureOf(parameter.type, signatureTypes));
	}

	default MethodHeader<MC> parameterWithAnnotation(Type annotationType, Object value, Field parameter,
			Class<?>... signatureClasses) {
		return parameterGenericWithAnnotation(annotationType, value, parameter.name, parameter.type,
				signatureOf(parameter.type, signatureClasses));
	}

	default MethodHeader<MC> parameterWithAnnotation(Type annotationType, Object value, Field parameter,
			String signature) {
		return parameterGenericWithAnnotation(annotationType, value, parameter.name, parameter.type, signature);
	}

	default MethodHeader<MC> parameterWithAnnotation(Type annotationType, Object value, Field parameter,
			Type... signatureTypes) {
		return parameterGenericWithAnnotation(annotationType, value, parameter.name, parameter.type,
				signatureOf(parameter.type, signatureTypes));
	}

	default MethodHeader<MC> parameterWithAnnotation(Type annotationType, Object value, String fieldName,
			Class<?> fieldClass) {
		return parameterWithAnnotation(annotationType, value, fieldName, typeOf(fieldClass));
	}

	default MethodHeader<MC> parameterWithAnnotation(Type annotationType, Object value, String fieldName,
			Class<?> fieldClass, String signature) {
		return parameterGenericWithAnnotation(annotationType, value, fieldName, typeOf(fieldClass), signature);
	}

	default MethodHeader<MC> parameterWithAnnotation(Type annotationType, Object value, String fieldName,
			Class<?> fieldClass, Type... signatureTypes) {
		return parameterGenericWithAnnotation(annotationType, value, fieldName, typeOf(fieldClass),
				signatureOf(typeOf(fieldClass), signatureTypes));
	}

	MethodHeader<MC> parameterWithAnnotation(Type annotationType, Object value, String fieldName, Type fieldType);

	default MethodHeader<MC> parameterWithAnnotation(Type annotationType, Object value, String fieldName,
			Type fieldType, Class<?>... signatureClasses) {
		return parameterGenericWithAnnotation(annotationType, value, fieldName, fieldType,
				signatureOf(fieldType, signatureClasses));
	}

	MethodHeader<MC> parameterGenericWithAnnotation(Type annotationType, Object value, String fieldName, Type fieldType,
			String signature);

	default MethodHeader<MC> parameterGenericWithAnnotation(Type annotationType, Object value, String fieldName,
			Type fieldType, Type... signatureTypes) {
		return parameterGenericWithAnnotation(annotationType, value, fieldName, fieldType,
				signatureOf(fieldType, signatureTypes));
	}

	default MethodHeader<MC> parameterGenericWithAnnotation(Type annotationType, String fieldName,
			Class<?> fieldClass) {
		return parameterWithAnnotation(annotationType, null, fieldName, typeOf(fieldClass));
	}

	default MethodHeader<MC> parameterGenericWithAnnotation(Type annotationType, String fieldName, Class<?> fieldClass,
			Class<?>... signatureClasses) {
		return parameterGenericWithAnnotation(annotationType, null, fieldName, typeOf(fieldClass),
				signatureOf(typeOf(fieldClass), signatureClasses));
	}

	default MethodHeader<MC> parameterGenericWithAnnotation(Type annotationType, String fieldName, Class<?> fieldClass,
			String signature) {
		return parameterGenericWithAnnotation(annotationType, null, fieldName, typeOf(fieldClass), signature);
	}

	default MethodHeader<MC> parameterGenericWithAnnotation(Type annotationType, String fieldName, Class<?> fieldClass,
			Type... signatureTypes) {
		return parameterGenericWithAnnotation(annotationType, null, fieldName, typeOf(fieldClass),
				signatureOf(typeOf(fieldClass), signatureTypes));
	}

	default MethodHeader<MC> parameterGenericWithAnnotation(Type annotationType, String fieldName, Type fieldType,
			Class<?>... signatureClasses) {
		return parameterGenericWithAnnotation(annotationType, null, fieldName, fieldType,
				signatureOf(fieldType, signatureClasses));
	}

	default MethodHeader<MC> parameterGenericWithAnnotation(Type annotationType, String fieldName, Type fieldType,
			Type... signatureTypes) {
		return parameterGenericWithAnnotation(annotationType, null, fieldName, fieldType,
				signatureOf(fieldType, signatureTypes));
	}
}