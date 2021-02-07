package nebula.tinyasm;

import org.objectweb.asm.Type;

interface Clazz {
	Type getType();

	String signatureAnyway() ;

	String signatureWhenNeed();

	boolean needSignature() ;
	String getDescriptor() ;
}