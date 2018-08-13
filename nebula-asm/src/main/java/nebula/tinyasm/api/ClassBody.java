package nebula.tinyasm.api;

import static nebula.tinyasm.util.TypeUtils.*;

import java.util.List;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import nebula.tinyasm.ClassBuilder;
import nebula.tinyasm.data.Field;

public interface ClassBody extends ToType, Opcodes, ClassDefineField<ClassBody>,
		ClassDefineStaticMethod<StaticMethodCode>, ClassDefineInstanceMethod<InstanceMethodCode> {

	default ClassBody annotation(Class<?> annotationClass) {
		return annotation(typeOf(annotationClass));
	}

	default ClassBody annotation(String annotationClass) {
		return annotation(typeOf(annotationClass));
	}

	default ClassBody annotation(Class<?> annotationClass, Object value) {
		return annotation(typeOf(annotationClass), value);
	}

	default ClassBody annotation(Type annotationType) {
		return annotation(annotationType, null);
	}

	ClassBody annotation(Type annotationType, Object value);

	ClassBuilder end();

	List<Field> getFields();

	Type getSuperType();

	Type referInnerClass(String innerClass);

	byte[] toByteArray();

	ClassVisitor visitor();

	void visitInnerClass(String name, String outerName, String innerName, int access);

}