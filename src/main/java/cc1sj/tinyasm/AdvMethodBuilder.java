package cc1sj.tinyasm;

import java.util.ArrayList;
import java.util.List;

public class AdvMethodBuilder implements AfterMethodName, AfterParameter, AfterThrows, AfterReturn, AfterCode {
	int memberAccess;
	final ClassBody classBody;
	final String methodName;

	final List<Parameter> _parameters = new ArrayList<>();
	final List<Clazz> _throws = new ArrayList<>();

	Clazz returnClazz;

	static class Parameter {
		String name;
		Clazz clazz;

		public Parameter(String name, Clazz clazz) {
			super();
			this.name = name;
			this.clazz = clazz;
		}

	}

	public AdvMethodBuilder(ClassBody classBody, int memberAccess, String methodName) {
		this.classBody = classBody;
		this.memberAccess = memberAccess;
		this.methodName = methodName;
	}

	@Override
	public AfterParameter parameter_(String name, Class<?> clazz) {
		_parameters.add(new Parameter(name, Clazz.of(clazz)));
		return this;
	}

	@Override
	public AfterThrows throws_(Class<?> exception) {
		_throws.add(Clazz.of(exception));
		return this;
	}

//	@Override
	private MethodCode enterBody() {

		MethodHeader mh = classBody.method(memberAccess, methodName);
		if (returnClazz != null) {
			mh.reTurn(returnClazz);
		}
		for (Parameter parameter : _parameters) {
			mh.parameter(parameter.name, parameter.clazz);
		}
		if (_throws.size() > 0) {
			for (Clazz clazz : _throws) {
				mh.tHrow(clazz);
			}
		}
		MethodCode code = mh.begin();

		return code;
	}

	MethodCode _methodCode;

	@Override
	public AfterCode code(ConsumerWithException<MethodCode> block) {
		try {
			_methodCode = enterBody();
			Adv.enterCode(_methodCode).execBlock(block);
//			block.accept(_methodCode);
			Adv.exitCode();
			_methodCode.END();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return this;
	}

	@Override
	public AfterReturn return_(Clazz clazz) {
		this.returnClazz = clazz;
		return this;
	}

}
