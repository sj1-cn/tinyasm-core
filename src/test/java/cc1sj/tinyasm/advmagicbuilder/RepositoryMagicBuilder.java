package cc1sj.tinyasm.advmagicbuilder;
import static cc1sj.tinyasm.Adv.*;

public class RepositoryMagicBuilder<E extends WithIdKey, R> implements Repository<E, R> {

	@Override
	public R update(E t) {
		_line(code->{
			code.LOAD("t");
			code.VIRTUAL("getName").return_(String.class).INVOKE();
			code.RETURNTop();
		});
		return null;
	}

}
