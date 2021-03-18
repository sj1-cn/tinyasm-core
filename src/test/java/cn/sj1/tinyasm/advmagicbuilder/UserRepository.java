package cn.sj1.tinyasm.advmagicbuilder;

public class UserRepository implements Repository<User, String> {

	@Override
	public String update(User t) {
		return t.getName();
	}

}
