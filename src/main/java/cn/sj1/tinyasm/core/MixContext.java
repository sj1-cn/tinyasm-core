package cn.sj1.tinyasm.core;

public class MixContext extends AdvContext {
	Object[] params;
	MixContext parent;

	public MixContext(MixContext parent, MethodCode code) {
		super(code);
	}

	public MixContext(MethodCode code) {
		super(code);
	}

	public MixContext(MethodCode code, Object[] params) {
		super(code);
		this.params = params;
	}

	@SuppressWarnings("unchecked")
	public <T> T getParam(Class<T> t) {
		for (Object object : params) {
			if (t.isAssignableFrom(object.getClass())) {
				return (T) object;
			}
		}
		throw new UnsupportedOperationException();
	}

	@SuppressWarnings("unchecked")
	public <T> T getParam(int index) {
		return (T) params[index];
	}
}
