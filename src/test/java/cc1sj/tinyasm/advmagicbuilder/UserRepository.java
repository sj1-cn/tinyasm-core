package cc1sj.tinyasm.advmagicbuilder;

public class UserRepository implements Repository<User, String> {

	@Override
	public String update(User t) {
		return t.getName();
	}

}
