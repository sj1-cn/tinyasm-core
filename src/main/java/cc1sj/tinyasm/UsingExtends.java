package cc1sj.tinyasm;

public interface UsingExtends {
	default ClassHeader extends_(Class<?> clazz) {
		return extends_(Clazz.of(clazz));
	}

	default ClassHeader extends_(String clazz) {
		return extends_(Clazz.of(clazz));
	}

	ClassHeader extends_(Clazz clazz);

}
