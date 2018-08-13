package nebula.tinyasm;

import static nebula.tinyasm.util.TypeUtils.signatureOf;
import static nebula.tinyasm.util.TypeUtils.typeOf;

import java.util.function.Consumer;

import org.objectweb.asm.Label;
import org.objectweb.asm.Type;

public interface MethodCodeRealAdv<C extends MethodCodeRealAdv<C>> extends MethodCodeAdv, MethodCode<C> {

	C codeAccessLabel(Label label);

	C codeAccessLabel(Label label, int line);

	C block(Consumer<C> invocation);

	@Override
	default C var(String fieldName, Class<?> clz) {
		return vmVar(fieldName, typeOf(clz), null);
	}

	@Override
	default C var(String fieldName, Class<?> clz, boolean isarray) {
		return vmVar(fieldName, typeOf(clz), null);
	}

	@Override
	default C var(String fieldName, Class<?> clz, boolean isarray, Class<?>... signatureClasses) {
		return vmVar(fieldName, typeOf(clz, isarray), signatureOf(clz, signatureClasses));
	}

	@Override
	default C var(String fieldName, Class<?> clz, Class<?>... signatureClasses) {
		return vmVar(fieldName, typeOf(clz), signatureOf(clz, signatureClasses));
	}

	@Override
	default C var(String fieldName, String clz) {
		return vmVar(fieldName, typeOf(clz), null);
	}

	@Override
	default C var(String fieldName, String clz, boolean isarray) {
		return vmVar(fieldName, typeOf(clz, isarray), null);
	}

	@Override
	default C var(String fieldName, String clz, boolean isarray, Class<?>... signatureClasses) {
		return vmVar(fieldName, typeOf(clz, isarray), signatureOf(clz, signatureClasses));
	}

	@Override
	default C var(String fieldName, String clz, boolean isarray, String... signatureClasses) {
		return vmVar(fieldName, typeOf(clz, isarray), signatureOf(clz, signatureClasses));
	}

	@Override
	default C var(String fieldName, String clz, Class<?>... signatureClasses) {
		return vmVar(fieldName, typeOf(clz), signatureOf(clz, signatureClasses));
	}

	@Override
	default C var(String fieldName, String clz, String... signatureClasses) {
		return vmVar(fieldName, typeOf(clz), signatureOf(clz, signatureClasses));
	}

	C vmVar(String fieldName, Type fieldType, String signature);

	void end();

	Label codeNewLabel();
}