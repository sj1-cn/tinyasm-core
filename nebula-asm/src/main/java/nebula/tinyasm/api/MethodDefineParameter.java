package nebula.tinyasm.api;

import static nebula.tinyasm.util.TypeUtils.arrayOf;
import static nebula.tinyasm.util.TypeUtils.signatureOf;
import static nebula.tinyasm.util.TypeUtils.typeOf;

import java.util.List;

import org.objectweb.asm.Type;

import nebula.tinyasm.ClassField;

interface MethodDefineParameter<CR> {
	CR parameter(ClassField field);

	default CR parameter(Field parameter) {
		return parameter(parameter.name, parameter.type);
	}

	default CR parameter(Field... parameters) {
		CR cr = null;
		for (Field parameter : parameters) {
			cr = parameter(parameter.name, parameter.type);
		}
		return cr;
	}

	default CR parameterGeneric(Field parameter, Class<?>... signatureClasses) {
		return parameterGeneric(parameter.name, parameter.type, signatureOf(parameter.type, signatureClasses));
	}

	default CR parameter(Field parameter, String signature) {
		return parameterGeneric(parameter.name, parameter.type, signature);
	}

	default CR parameter(Field parameter, Type... signatureTypes) {
		return parameterGeneric(parameter.name, parameter.type, signatureOf(parameter.type, signatureTypes));
	}

	default CR parameter(List<Field> params) {
		CR cr = null;
		for (Field parameter : params) {
			cr = parameter(parameter.name, parameter.type);
		}
		return cr;
	}

	default CR parameter(String fieldName, Class<?> fieldClass) {
		return parameter(fieldName, typeOf(fieldClass));
	}

	default CR parameter(String fieldName, Class<?> fieldClass, Class<?>... signatureClasses) {
		return parameterGeneric(fieldName, typeOf(fieldClass), signatureOf(typeOf(fieldClass), signatureClasses));
	}

	default CR parameter(String fieldName, Class<?> fieldClass, String signature) {
		return parameterGeneric(fieldName, typeOf(fieldClass), signature);
	}

	default CR parameter(String fieldName, Class<?> fieldClass, Type... signatureTypes) {
		return parameterGeneric(fieldName, typeOf(fieldClass), signatureOf(typeOf(fieldClass), signatureTypes));
	}

	CR parameter(String fieldName, Type fieldType);

	default CR parameter(String fieldName, Type fieldType, boolean array) {
		return parameter(fieldName, arrayOf(fieldType, false));
	}

	default CR parameter(String fieldName, Type fieldType, Class<?>... signatureClasses) {
		return parameterGeneric(fieldName, fieldType, signatureOf(fieldType, signatureClasses));
	}

	CR parameterGeneric(String fieldName, Type fieldType, String signature);

	default CR parameter(String fieldName, Type fieldType, Type... signatureTypes) {
		return parameterGeneric(fieldName, fieldType, signatureOf(fieldType, signatureTypes));
	}

	default CR parameter(Type annotationType, Object value, String fieldName, Class<?> fieldClass,
			Class<?>... signatureClasses) {
		return parameterGenericWithAnnotation(annotationType, value, fieldName, typeOf(fieldClass),
				signatureOf(typeOf(fieldClass), signatureClasses));
	}

	default CR parameterWithAnnotation(Class<?> annotationClass, Field parameter) {
		return parameterWithAnnotation(typeOf(annotationClass), null, parameter.name, parameter.type);
	}

	default CR parameterWithAnnotation(Class<?> annotationClass, Field parameter, Class<?>... signatureClasses) {
		return parameterGenericWithAnnotation(typeOf(annotationClass), null, parameter.name, parameter.type,
				signatureOf(parameter.type, signatureClasses));
	}

	default CR parameterWithAnnotation(Class<?> annotationClass, Field parameter, String signature) {
		return parameterGenericWithAnnotation(typeOf(annotationClass), null, parameter.name, parameter.type, signature);
	}

	default CR parameterWithAnnotation(Class<?> annotationClass, Field parameter, Type... signatureTypes) {
		return parameterGenericWithAnnotation(typeOf(annotationClass), null, parameter.name, parameter.type,
				signatureOf(parameter.type, signatureTypes));
	}

	default CR parameterWithAnnotation(Class<?> annotationClass, Object value, Field parameter) {
		return parameterWithAnnotation(typeOf(annotationClass), value, parameter.name, parameter.type);
	}

	default CR parameterWithAnnotation(Class<?> annotationClass, Object value, Field parameter,
			Class<?>... signatureClasses) {
		return parameterGenericWithAnnotation(typeOf(annotationClass), value, parameter.name, parameter.type,
				signatureOf(parameter.type, signatureClasses));
	}

	default CR parameterWithAnnotation(Class<?> annotationClass, Object value, Field parameter, String signature) {
		return parameterGenericWithAnnotation(typeOf(annotationClass), value, parameter.name, parameter.type,
				signature);
	}

	default CR parameterWithAnnotation(Class<?> annotationClass, Object value, Field parameter,
			Type... signatureTypes) {
		return parameterGenericWithAnnotation(typeOf(annotationClass), value, parameter.name, parameter.type,
				signatureOf(parameter.type, signatureTypes));
	}

	default CR parameterWithAnnotation(Class<?> annotationClass, Object value, String fieldName, Class<?> fieldClass) {
		return parameterWithAnnotation(typeOf(annotationClass), value, fieldName, typeOf(fieldClass));
	}

	default CR parameterWithAnnotation(Class<?> annotationClass, Object value, String fieldName, Class<?> fieldClass,
			Class<?>... signatureClasses) {
		return parameterGenericWithAnnotation(typeOf(annotationClass), value, fieldName, typeOf(fieldClass),
				signatureOf(typeOf(fieldClass), signatureClasses));
	}

	default CR parameterWithAnnotation(Class<?> annotationClass, Object value, String fieldName, Class<?> fieldClass,
			String signature) {
		return parameterGenericWithAnnotation(typeOf(annotationClass), value, fieldName, typeOf(fieldClass), signature);
	}

	default CR parameterWithAnnotation(Class<?> annotationClass, Object value, String fieldName, Class<?> fieldClass,
			Type... signatureTypes) {
		return parameterGenericWithAnnotation(typeOf(annotationClass), value, fieldName, typeOf(fieldClass),
				signatureOf(typeOf(fieldClass), signatureTypes));
	}

	default CR parameterWithAnnotation(Class<?> annotationClass, Object value, String fieldName, Type fieldType) {
		return parameterWithAnnotation(typeOf(annotationClass), value, fieldName, fieldType);
	}

	default CR parameterWithAnnotation(Class<?> annotationClass, Object value, String fieldName, Type fieldType,
			Class<?>... signatureClasses) {
		return parameterGenericWithAnnotation(typeOf(annotationClass), value, fieldName, fieldType,
				signatureOf(fieldType, signatureClasses));
	}

	default CR parameterWithAnnotation(Class<?> annotationClass, Object value, String fieldName, Type fieldType,
			String signature) {
		return parameterGenericWithAnnotation(typeOf(annotationClass), value, fieldName, fieldType, signature);
	}

	default CR parameterWithAnnotation(Class<?> annotationClass, Object value, String fieldName, Type fieldType,
			Type... signatureTypes) {
		return parameterGenericWithAnnotation(typeOf(annotationClass), value, fieldName, fieldType,
				signatureOf(fieldType, signatureTypes));
	}

	default CR parameterWithAnnotation(Class<?> annotationClass, String fieldName, Class<?> fieldClass) {
		return parameterWithAnnotation(typeOf(annotationClass), null, fieldName, typeOf(fieldClass));
	}

	default CR parameterWithAnnotation(Class<?> annotationClass, String fieldName, Class<?> fieldClass,
			Class<?>... signatureClasses) {
		return parameterGenericWithAnnotation(typeOf(annotationClass), null, fieldName, typeOf(fieldClass),
				signatureOf(typeOf(fieldClass), signatureClasses));
	}

	default CR parameterWithAnnotation(Class<?> annotationClass, String fieldName, Class<?> fieldClass,
			String signature) {
		return parameterGenericWithAnnotation(typeOf(annotationClass), null, fieldName, typeOf(fieldClass), signature);
	}

	default CR parameterWithAnnotation(Class<?> annotationClass, String fieldName, Class<?> fieldClass,
			Type... signatureTypes) {
		return parameterGenericWithAnnotation(typeOf(annotationClass), null, fieldName, typeOf(fieldClass),
				signatureOf(typeOf(fieldClass), signatureTypes));
	}

	default CR parameterWithAnnotation(Class<?> annotationClass, String fieldName, Type fieldType) {
		return parameterWithAnnotation(typeOf(annotationClass), null, fieldName, fieldType);
	}

	default CR parameterWithAnnotation(Class<?> annotationClass, String fieldName, Type fieldType,
			Class<?>... signatureClasses) {
		return parameterGenericWithAnnotation(typeOf(annotationClass), null, fieldName, fieldType,
				signatureOf(fieldType, signatureClasses));
	}

	default CR parameterWithAnnotation(Class<?> annotationClass, String fieldName, Type fieldType, String signature) {
		return parameterGenericWithAnnotation(typeOf(annotationClass), null, fieldName, fieldType, signature);
	}

	default CR parameterWithAnnotation(Class<?> annotationClass, String fieldName, Type fieldType,
			Type... signatureTypes) {
		return parameterGenericWithAnnotation(typeOf(annotationClass), null, fieldName, fieldType,
				signatureOf(fieldType, signatureTypes));
	}

	default CR parameterWithAnnotation(Type annotationType, Field parameter, Class<?>... signatureClasses) {
		return parameterGenericWithAnnotation(annotationType, null, parameter.name, parameter.type,
				signatureOf(parameter.type, signatureClasses));
	}

	default CR parameterWithAnnotation(Type annotationType, Field parameter, String signature) {
		return parameterGenericWithAnnotation(annotationType, null, parameter.name, parameter.type, signature);
	}

	default CR parameterWithAnnotation(Type annotationType, Field parameter, Type... signatureTypes) {
		return parameterGenericWithAnnotation(annotationType, null, parameter.name, parameter.type,
				signatureOf(parameter.type, signatureTypes));
	}

	default CR parameterWithAnnotation(Type annotationType, Object value, Field parameter,
			Class<?>... signatureClasses) {
		return parameterGenericWithAnnotation(annotationType, value, parameter.name, parameter.type,
				signatureOf(parameter.type, signatureClasses));
	}

	default CR parameterWithAnnotation(Type annotationType, Object value, Field parameter, String signature) {
		return parameterGenericWithAnnotation(annotationType, value, parameter.name, parameter.type, signature);
	}

	default CR parameterWithAnnotation(Type annotationType, Object value, Field parameter, Type... signatureTypes) {
		return parameterGenericWithAnnotation(annotationType, value, parameter.name, parameter.type,
				signatureOf(parameter.type, signatureTypes));
	}

	default CR parameterWithAnnotation(Type annotationType, Object value, String fieldName, Class<?> fieldClass) {
		return parameterWithAnnotation(annotationType, value, fieldName, typeOf(fieldClass));
	}

	default CR parameterWithAnnotation(Type annotationType, Object value, String fieldName, Class<?> fieldClass,
			String signature) {
		return parameterGenericWithAnnotation(annotationType, value, fieldName, typeOf(fieldClass), signature);
	}

	default CR parameterWithAnnotation(Type annotationType, Object value, String fieldName, Class<?> fieldClass,
			Type... signatureTypes) {
		return parameterGenericWithAnnotation(annotationType, value, fieldName, typeOf(fieldClass),
				signatureOf(typeOf(fieldClass), signatureTypes));
	}

	CR parameterWithAnnotation(Type annotationType, Object value, String fieldName, Type fieldType);

	default CR parameterWithAnnotation(Type annotationType, Object value, String fieldName, Type fieldType,
			Class<?>... signatureClasses) {
		return parameterGenericWithAnnotation(annotationType, value, fieldName, fieldType,
				signatureOf(fieldType, signatureClasses));
	}

	CR parameterGenericWithAnnotation(Type annotationType, Object value, String fieldName, Type fieldType,
			String signature);

	default CR parameterGenericWithAnnotation(Type annotationType, Object value, String fieldName, Type fieldType,
			Type... signatureTypes) {
		return parameterGenericWithAnnotation(annotationType, value, fieldName, fieldType,
				signatureOf(fieldType, signatureTypes));
	}

	default CR parameterGenericWithAnnotation(Type annotationType, String fieldName, Class<?> fieldClass) {
		return parameterWithAnnotation(annotationType, null, fieldName, typeOf(fieldClass));
	}

	default CR parameterGenericWithAnnotation(Type annotationType, String fieldName, Class<?> fieldClass,
			Class<?>... signatureClasses) {
		return parameterGenericWithAnnotation(annotationType, null, fieldName, typeOf(fieldClass),
				signatureOf(typeOf(fieldClass), signatureClasses));
	}

	default CR parameterGenericWithAnnotation(Type annotationType, String fieldName, Class<?> fieldClass,
			String signature) {
		return parameterGenericWithAnnotation(annotationType, null, fieldName, typeOf(fieldClass), signature);
	}

	default CR parameterGenericWithAnnotation(Type annotationType, String fieldName, Class<?> fieldClass,
			Type... signatureTypes) {
		return parameterGenericWithAnnotation(annotationType, null, fieldName, typeOf(fieldClass),
				signatureOf(typeOf(fieldClass), signatureTypes));
	}

	default CR parameterGenericWithAnnotation(Type annotationType, String fieldName, Type fieldType,
			Class<?>... signatureClasses) {
		return parameterGenericWithAnnotation(annotationType, null, fieldName, fieldType,
				signatureOf(fieldType, signatureClasses));
	}

	default CR parameterGenericWithAnnotation(Type annotationType, String fieldName, Type fieldType,
			Type... signatureTypes) {
		return parameterGenericWithAnnotation(annotationType, null, fieldName, fieldType,
				signatureOf(fieldType, signatureTypes));
	}
}