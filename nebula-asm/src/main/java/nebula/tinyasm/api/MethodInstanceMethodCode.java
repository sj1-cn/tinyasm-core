package nebula.tinyasm.api;

@Deprecated
public interface MethodInstanceMethodCode<M, C extends MethodCode<M, C>> extends MethodCode<M, C> {
	final static int THIS_INDEX = 0;
	final static String THIS = "this";

	@Deprecated
	M useThis();

	@Deprecated
	M useTopThis();
}
