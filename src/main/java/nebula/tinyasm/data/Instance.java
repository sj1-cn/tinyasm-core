package nebula.tinyasm.data;

public interface Instance {
	InvokerPrepare inter(String methodName);

	InvokerPrepare virtual(String methodName);

	InvokerPrepare special(String methodName);
	
	void set(String varname);
}
