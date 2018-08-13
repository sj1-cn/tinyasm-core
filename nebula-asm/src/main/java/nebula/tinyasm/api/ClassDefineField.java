package nebula.tinyasm.api;

import static nebula.tinyasm.util.TypeUtils.signatureOf;
import static nebula.tinyasm.util.TypeUtils.typeOf;
import static org.objectweb.asm.Opcodes.ACC_PRIVATE;

import org.objectweb.asm.Type;

public interface ClassDefineField<CB> {

	default CB fField(int access, Class<?> annotationClazz, Object value, String fieldName, Class<?> fieldClazz) {
		return mvField(access, typeOf(annotationClazz), value, fieldName, typeOf(fieldClazz));
	}

	default CB fField(int access, String fieldName, Class<?> fieldClazz, String signature) {
		return mvField(access, fieldName, typeOf(fieldClazz), signature);
	}

	default CB fField(int access, String annotationClazz, Object value, String fieldName, String fieldClazz) {
		return mvField(access, typeOf(annotationClazz), value, fieldName, typeOf(fieldClazz));
	}

	default CB fField(int access, String fieldName, String fieldClazz, String signature) {
		return mvField(access, fieldName, typeOf(fieldClazz), signature);
	}

	default CB field(int access, Class<?> annotationClazz, Object value, String fieldName, Class<?> fieldClazz) {
		return mvField(access, typeOf(annotationClazz), value, fieldName, typeOf(fieldClazz));
	}

	default CB field(int access, Class<?> annotationClazz, Object value, String fieldName, Class<?> fieldClazz,
			boolean isarray) {
		return mvField(access, typeOf(annotationClazz), value, fieldName, typeOf(fieldClazz, isarray));
	}

	default CB field(int access, Class<?> annotationClazz, Object value, String fieldName, Class<?> fieldClazz,
			String signature) {
		return mvField(access, typeOf(annotationClazz), value, fieldName, typeOf(fieldClazz), signature);
	}

	default CB field(int access, Class<?> annotationClazz, Object value, String fieldName, Class<?> fieldClazz,
			String signature, boolean isarray) {
		return mvField(access, typeOf(annotationClazz), value, fieldName, typeOf(fieldClazz, isarray), signature);
	}

	default CB field(int access, Class<?> annotationClazz, String fieldName, Class<?> fieldClazz) {
		return mvField(access, typeOf(annotationClazz), null, fieldName, typeOf(fieldClazz));
	}

	default CB field(int access, Class<?> annotationClazz, String fieldName, Class<?> fieldClazz, boolean isarray) {
		return mvField(access, typeOf(annotationClazz), null, fieldName, typeOf(fieldClazz, isarray));
	}

	default CB field(int access, String fieldName, Class<?> fieldClazz) {
		return mvField(access, fieldName, typeOf(fieldClazz));
	}

	default CB field(int access, String fieldName, Class<?> fieldClazz, boolean isarray) {
		return mvField(access, fieldName, typeOf(fieldClazz, isarray));
	}

	default CB field(int access, String fieldName, Class<?> fieldClazz, String signature, boolean isarray) {
		return mvField(access, fieldName, typeOf(fieldClazz, isarray), signature);
	}

	default CB field(int access, String annotationClazz, Object value, String fieldName, String fieldClazz,
			boolean isarray) {
		return mvField(access, typeOf(annotationClazz), value, fieldName, typeOf(fieldClazz, isarray));
	}

	default CB field(int access, String annotationClazz, Object value, String fieldName, String fieldClazz,
			String signature) {
		return mvField(access, typeOf(annotationClazz), value, fieldName, typeOf(fieldClazz), signature);
	}

	default CB field(int access, String annotationClazz, Object value, String fieldName, String fieldClazz,
			String signature, boolean isarray) {
		return mvField(access, typeOf(annotationClazz), value, fieldName, typeOf(fieldClazz, isarray), signature);
	}

	default CB field(int access, String fieldName, String fieldClazz) {
		return mvField(access, fieldName, typeOf(fieldClazz));
	}

	default CB field(int access, String fieldName, String fieldClazz, boolean isarray) {
		return mvField(access, fieldName, typeOf(fieldClazz, isarray));
	}

	default CB field(int access, String fieldName, String fieldClazz, String signature, boolean isarray) {
		return mvField(access, fieldName, typeOf(fieldClazz, isarray), signature);
	}

	default CB field(String fieldName, Class<?> fieldClazz) {
		return mvField(ACC_PRIVATE, fieldName, typeOf(fieldClazz));
	}

	default CB field(String fieldName, Class<?> fieldClazz, boolean isarray) {
		return mvField(ACC_PRIVATE, fieldName, typeOf(fieldClazz, isarray));
	}

	default CB field(String fieldName, Class<?> fieldClazz, boolean isarray, Class<?>... signatureClasses) {
		return mvField(ACC_PRIVATE, fieldName, typeOf(fieldClazz, isarray),
				signatureOf(typeOf(fieldClazz), signatureClasses));
	}

	default CB field(String fieldName, Class<?> fieldClazz, boolean isarray, String signature) {
		return mvField(ACC_PRIVATE, fieldName, typeOf(fieldClazz, isarray), signature);
	}

	default CB field(String fieldName, Class<?> fieldClazz, Class<?>... signatureClasses) {
		return mvField(ACC_PRIVATE, fieldName, typeOf(fieldClazz), signatureOf(typeOf(fieldClazz), signatureClasses));
	}

	default CB field(String fieldName, Class<?> fieldClazz, String signature) {
		return mvField(ACC_PRIVATE, fieldName, typeOf(fieldClazz), signature);
	}

	default CB field(String fieldName, String fieldClazz, boolean isarray, String... signatureClasses) {
		return mvField(ACC_PRIVATE, fieldName, typeOf(fieldClazz, isarray),
				signatureOf(typeOf(fieldClazz), typeOf(signatureClasses)));
	}

	default CB field(String fieldName, String fieldClazz, String... signatureClasses) {
		return mvField(ACC_PRIVATE, fieldName, typeOf(fieldClazz),
				signatureOf(typeOf(fieldClazz), typeOf(signatureClasses)));
	}

	default CB fieldWithAnnotation(Class<?> annotationClazz, Object value, String fieldName, Class<?> fieldClazz) {
		return mvField(ACC_PRIVATE, typeOf(annotationClazz), value, fieldName, typeOf(fieldClazz));
	}

	default CB fieldWithAnnotation(Class<?> annotationClazz, Object value, String fieldName, Class<?> fieldClazz,
			boolean isarray) {
		return mvField(ACC_PRIVATE, typeOf(annotationClazz), value, fieldName, typeOf(fieldClazz, isarray));
	}

	default CB fieldWithAnnotation(Class<?> annotationClazz, Object value, String fieldName, Class<?> fieldClazz,
			boolean isarray, Class<?>... signatureClasses) {
		return mvField(ACC_PRIVATE, typeOf(annotationClazz), value, fieldName, typeOf(fieldClazz, isarray),
				signatureOf(typeOf(fieldClazz), signatureClasses));
	}

	default CB fieldWithAnnotation(Class<?> annotationClazz, Object value, String fieldName, Class<?> fieldClazz,
			Class<?>... signatureClasses) {
		return mvField(ACC_PRIVATE, typeOf(annotationClazz), value, fieldName, typeOf(fieldClazz),
				signatureOf(typeOf(fieldClazz), signatureClasses));
	}

	default CB fieldWithAnnotation(Class<?> annotationClazz, Object value, String fieldName, Class<?> fieldClazz,
			String signature) {
		return mvField(ACC_PRIVATE, typeOf(annotationClazz), value, fieldName, typeOf(fieldClazz), signature);
	}

	default CB fieldWithAnnotation(Class<?> annotationClazz, Object value, String fieldName, Class<?> fieldClazz,
			String signature, boolean isarray) {
		return mvField(ACC_PRIVATE, typeOf(annotationClazz), value, fieldName, typeOf(fieldClazz, isarray), signature);
	}

	default CB fieldWithAnnotation(Class<?> annotationClazz, String fieldName, Class<?> fieldClazz) {
		return mvField(ACC_PRIVATE, typeOf(annotationClazz), null, fieldName, typeOf(fieldClazz));
	}

	default CB fieldWithAnnotation(Class<?> annotationClazz, String fieldName, Class<?> fieldClazz, boolean isarray) {
		return mvField(ACC_PRIVATE, typeOf(annotationClazz), null, fieldName, typeOf(fieldClazz, isarray));
	}

	default CB fieldWithAnnotation(Class<?> annotationClazz, String fieldName, Class<?> fieldClazz, boolean isarray,
			Class<?>... signatureClasses) {
		return mvField(ACC_PRIVATE, typeOf(annotationClazz), null, fieldName, typeOf(fieldClazz, isarray),
				signatureOf(typeOf(fieldClazz), signatureClasses));
	}

	default CB fieldWithAnnotation(Class<?> annotationClazz, String fieldName, Class<?> fieldClazz,
			Class<?>... signatureClasses) {
		return mvField(ACC_PRIVATE, typeOf(annotationClazz), null, fieldName, typeOf(fieldClazz),
				signatureOf(typeOf(fieldClazz), signatureClasses));
	}

	default CB fieldWithAnnotation(Class<?> annotationClazz, String fieldName, Class<?> fieldClazz, String signature) {
		return mvField(ACC_PRIVATE, typeOf(annotationClazz), null, fieldName, typeOf(fieldClazz), signature);
	}

	default CB fieldWithAnnotation(Class<?> annotationClazz, String fieldName, Class<?> fieldClazz, String signature,
			boolean isarray) {
		return mvField(ACC_PRIVATE, typeOf(annotationClazz), null, fieldName, typeOf(fieldClazz, isarray), signature);
	}

	default CB fieldWithAnnotation(String annotationClazz, String fieldName, Class<?> fieldClazz) {
		return mvField(ACC_PRIVATE, typeOf(annotationClazz), null, fieldName, typeOf(fieldClazz));
	}

	default CB fieldWithAnnotation(String annotationClazz, String fieldName, Class<?> fieldClazz, boolean isarray) {
		return mvField(ACC_PRIVATE, typeOf(annotationClazz), null, fieldName, typeOf(fieldClazz, isarray));
	}

	default CB fieldWithAnnotation(String annotationClazz, String fieldName, String fieldClazz) {
		return mvField(ACC_PRIVATE, typeOf(annotationClazz), null, fieldName, typeOf(fieldClazz));
	}

	default CB fieldWithAnnotation(String annotationClazz, String fieldName, String fieldClazz, boolean isarray) {
		return mvField(ACC_PRIVATE, typeOf(annotationClazz), null, fieldName, typeOf(fieldClazz, isarray));
	}

	CB mvField(int access, String fieldName, Type fieldClazz);

	CB mvField(int access, String fieldName, Type fieldClazz, String signature);

	CB mvField(int access, Type annotationClazz, Object value, String fieldName, Type fieldClazz);

	CB mvField(int access, Type annotationClazz, Object value, String fieldName, Type fieldClazz, String signature);

}