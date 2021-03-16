package cc1sj.tinyasm.advmagicbuilder;

public class UserRepository implements Repository<User> {

	@Override
	public User update(User t) {
//		t.setName("hello");
		return t;
	}

}
