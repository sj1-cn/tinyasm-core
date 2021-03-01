package cc1sj.tinyasm.hero;

import static org.junit.Assert.*;

import org.junit.Test;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

public class TestByteBuddy {
	@Test
	public void testName() throws Exception {
		Class<?> dynamicType = new ByteBuddy().subclass(Object.class).method(ElementMatchers.named("toString"))
				.intercept(FixedValue.value("Hello World!")).make().load(getClass().getClassLoader()).getLoaded();

//		assertThat(dynamicType.newInstance().toString(), is("Hello World!"));
	}
}
