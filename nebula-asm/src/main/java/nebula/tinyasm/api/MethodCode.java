package nebula.tinyasm.api;

import static nebula.tinyasm.util.TypeUtils.arrayOf;
import static nebula.tinyasm.util.TypeUtils.typeOf;

import java.util.function.Consumer;

import org.objectweb.asm.Label;
import org.objectweb.asm.Type;

import nebula.tinyasm.SmartOpcode;
import nebula.tinyasm.util.Field;

public interface MethodCode<C extends MethodCode<C>> extends SmartOpcode {

	C codeAccessLabel(Label label);

	C codeAccessLabel(Label label, int line);

	C block(Consumer<C> invocation);

	C code();

	default C def(Field field) {
		return def(field.name, field.type);
	}

	default C def(String fieldName, Class<?> clz) {
		return def(fieldName, typeOf(clz));
	}

	default C def(String fieldName, Class<?> clz, Class<?>... signatureClasses) {
		return def(fieldName, typeOf(clz), typeOf(signatureClasses));
	}

	default C def(String fieldName, Class<?> clz, String signature) {
		return def(fieldName, typeOf(clz), signature);
	}

	default C def(String fieldName, Class<?> clz, Type... signatureTypes) {
		return def(fieldName, typeOf(clz), signatureTypes);
	}

	default C def(String fieldName, Type fieldType, boolean array) {
		return def(fieldName, arrayOf(fieldType, array));
	}

	C def(String fieldName, Type fieldType, String signature);

	default C def(String fieldName, Type fieldType, Type... signatureTypes) {
		String signature = null;
		if (signatureTypes != null && signatureTypes.length > 0) {
			StringBuilder sb = new StringBuilder();
			sb.append("L");
			sb.append(fieldType.getInternalName());
			sb.append("<");
			for (Type signatureType : signatureTypes) {
				sb.append(signatureType.getDescriptor());
			}
			sb.append(">;");
			signature = sb.toString();
		}
		return def(fieldName, fieldType, signature);
	}

	void end();

	C line(int line);

	C line();

	Label codeNewLabel();
}