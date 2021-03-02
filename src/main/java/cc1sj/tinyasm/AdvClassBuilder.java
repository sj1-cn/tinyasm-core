package cc1sj.tinyasm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.objectweb.asm.Opcodes.*;

public class AdvClassBuilder
		implements AfterClassModifier, AfterClassName, AfterClassExtends, AfterClassImplements, AdvClassBody, AfterModifier {
	int access = 0;
	String className;
	Clazz _extends;
	List<Clazz> _implements = new ArrayList<>();
	Map<String, Clazz> maps = new HashMap<>();
	ClassBody classBody;

	int memberAccess = 0;

	public void access(int accPublic) {
		this.access |= accPublic;
	}

	@Override
	public AfterClassName class_(String className) {
		this.className = className;
		return this;
	}

	@Override
	public AfterClassExtends extends_(Class<?> _extends) {
		this._extends = Clazz.of(_extends);
		return this;
	}

	@Override
	public AfterClassImplements implements_(Class<?> _implement) {
		this._implements.add(Clazz.of(_implement));
		return this;
	}

	@Override
	public AdvClassBody enterClassBody() {
		ClassHeader ch;
		if (_extends != null) {
			ch = ClassBuilder.make(className, _extends);
		} else {
			ch = ClassBuilder.make(className);
		}

		if (_implements != null && _implements.size() > 0) {
			for (Clazz clazz : _implements) {
				ch.implement(clazz);
			}
		}

		classBody = ch.body();

		return this;
	}

	@Override
	public AfterMethodName method(String methodName) {
		AdvMethodBuilder methodBuilder = new AdvMethodBuilder(classBody, memberAccess, methodName);
		return methodBuilder;
	}

	@Override
	public AfterModifier public_() {
		this.memberAccess |= ACC_PUBLIC;
		return this;
	}

	@Override
	public AfterModifier protected_() {
		this.memberAccess |= ACC_PROTECTED;
		return this;
	}

	@Override
	public AfterModifier private_() {
		this.memberAccess |= ACC_PRIVATE;
		return this;
	}

	@Override
	public byte[] end() {
		return classBody.end().toByteArray();
	}

	// TODO
	@Override
	public <T> T field(String string, Class<T> class1) {

		classBody.field(string, Clazz.of(class1));
		return null;
	}

}
