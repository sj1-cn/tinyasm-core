package cc1sj.tinyasm.hero;

import org.junit.Test;
import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;
import org.objenesis.instantiator.ObjectInstantiator;

public class ObjenesisTest {

	@Test
	public void testname() throws Exception {
//	Objenesis objenesis = new ObjenesisStd(); // or ObjenesisSerializer
//	Sample thingy1 = (Sample) objenesis.newInstance(Sample.class);

		// or (a little bit more efficient if you need to create many objects)

		Objenesis objenesis = new ObjenesisStd(); // or ObjenesisSerializer
		ObjectInstantiator<Sample> thingyInstantiator = objenesis.getInstantiatorOf(Sample.class);

		Sample thingy2 = (Sample) thingyInstantiator.newInstance();
		Sample thingy3 = (Sample) thingyInstantiator.newInstance();
		Sample thingy4 = (Sample) thingyInstantiator.newInstance();

	}
	

	@Test
	public void testInitStringInt() throws Exception {
//	Objenesis objenesis = new ObjenesisStd(); // or ObjenesisSerializer
//	Sample thingy1 = (Sample) objenesis.newInstance(Sample.class);

		// or (a little bit more efficient if you need to create many objects)

		Objenesis objenesis = new ObjenesisStd(); // or ObjenesisSerializer
		ObjectInstantiator<ColumnDefinition> thingyInstantiator = objenesis.getInstantiatorOf(ColumnDefinition.class);

		ColumnDefinition thingy2 = (ColumnDefinition) thingyInstantiator.newInstance();
//		Sample thingy3 = (Sample) thingyInstantiator.newInstance();
//		Sample thingy4 = (Sample) thingyInstantiator.newInstance();

	}
}
