package cc1sj.tinyasm.advasmproxy.subclassmethod;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClassBTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSay() {
		ClassB classB = new ClassB();
		classB.say1();
		classB.say2();
		classB.say1InB();
		classB.say2InB();
	}
}
