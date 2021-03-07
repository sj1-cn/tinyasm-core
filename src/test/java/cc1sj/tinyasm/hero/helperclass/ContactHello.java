package cc1sj.tinyasm.hero.helperclass;

import cc1sj.tinyasm.hero.advasmproxy.PojoSample;

public class ContactHello {
	public void say() {
		PojoSample hello = new PojoSample();

		hello.setName("wangshilian");
		String name = hello.getName();
		hello.setName(name);
		hello.setAgeShort((short) 10);
		short age = hello.getAgeShort();
		hello.setAgeShort(age);
		short age2 = (short) (age + 10);
		hello.setAgeShort(age2);

		hello.setAgeShort2((short) 10);
		Short ageShort2 = hello.getAgeShort2();
		hello.setAgeShort2(ageShort2);
	}
}
