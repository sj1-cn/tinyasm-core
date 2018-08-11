package nebula.tinyasm.util;

public class ClassUtils {
	public static String toSimpleName(String className) {
		return className.substring(className.lastIndexOf('.') + 1);
	}
}
