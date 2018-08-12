package nebula.tinyasm.api;

import static nebula.tinyasm.api.TypeUtils.typeOf;

import org.objectweb.asm.Type;

@Deprecated
public interface ClassThisInstance extends Instance<MethodCallerInInstanceMethod, InstanceMethodCode> {
	Field fieldOf(String fieldName);
}
