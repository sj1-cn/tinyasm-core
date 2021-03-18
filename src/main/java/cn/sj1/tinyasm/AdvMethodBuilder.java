package cn.sj1.tinyasm;

import java.util.ArrayList;
import java.util.List;

public class AdvMethodBuilder implements AdvAfterMethodName, AdvAfterParameter, AdvAfterThrows, AdvAfterReturn, AdvAfterCode {
	private final int memberAccess;
	private final ClassBody classBody;
	private final String methodName;

	private final List<Parameter> _parameters = new ArrayList<>();
	private final List<Clazz> _throws = new ArrayList<>();

	private Clazz returnClazz;

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
	public AdvAfterParameter parameter_(String name, Clazz clazz) {
		_parameters.add(new Parameter(name, clazz));
		return this;
	}

	@Override
	public AdvAfterParameter parameter_(String name, Class<?> clazz) {
		_parameters.add(new Parameter(name, Clazz.of(clazz)));
		return this;
	}

	@Override
	public AdvAfterThrows throws_(Class<?>... exceptiones) {
		for (Class<?> exception : exceptiones) {
			_throws.add(Clazz.of(exception));
		}
		return this;
	}

//	@Override
	private MethodCode enterBody() {

		MethodHeader mh = classBody.method(memberAccess, methodName);
		if (returnClazz != null) {
			mh.return_(returnClazz);
		}
		for (Parameter parameter : _parameters) {
			mh.parameter(parameter.name, parameter.clazz);
		}
		if (_throws.size() > 0) {
			for (Clazz clazz : _throws) {
				mh.throws_(clazz);
			}
		}
		MethodCode code = mh.begin();

		return code;
	}

	private MethodCode _methodCode;

	@Override
	public AdvAfterCode code(ConsumerWithException<MethodCode> block) {
		try {
			_methodCode = enterBody();
			AdvContext context =  Adv.enterCode(_methodCode);
			context.exec(block);
			context.clear();
			Adv.exitCode();
			_methodCode.END();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return this;
	}

	@Override
	public AdvAfterReturn return_(Clazz clazz) {
		this.returnClazz = clazz;
		return this;
	}

	@Override
	public AdvAfterReturn return_(Class<?> clazz) {
		this.returnClazz = Clazz.of(clazz);
		return this;
	}

}
