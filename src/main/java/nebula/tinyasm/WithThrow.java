package nebula.tinyasm;

import nebula.tinyasm.util.GenericClazz;
import nebula.tinyasm.util.TypeUtils;

public interface WithThrow<T> {

	default MethodHeader tHrow(Class<?> clazz) {
		return tHrow(TypeUtils.generic(clazz));
	}

	default MethodHeader tHrow(Class<?>... clazzes) {
		MethodHeader mh = null;
		for (Class<?> clazz : clazzes) {
			mh = tHrow(TypeUtils.generic(clazz));
		}
		return mh;
	}

	default MethodHeader tHrow(String... clazzes) {
		MethodHeader mh = null;
		for (String clazz : clazzes) {
			mh = tHrow(TypeUtils.generic(clazz));
		}
		return mh;
	}

	MethodHeader tHrow(GenericClazz clazz);

	default MethodHeader tHrow(String clazz) {
		return tHrow(TypeUtils.generic(clazz));
	}
}