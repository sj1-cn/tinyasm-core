package cc1sj.tinyasm;

import java.util.List;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.signature.SignatureReader;

public class AdvMethodInfo {
	// Return Type 来源于方法descriptor
	Type originalReturnType;
	Type[] originalParamTypes;

	// 来源于方法signature
	Clazz signatureReturnClazz = null;
	Clazz[] signatureParamsClazzes = null;

	// 解析ClassVariable
	Clazz prepareDerivedReturnClazz = null;
	Clazz[] derivedParamClazzes;
	public Clazz derivedReturnClazz;
	public boolean needBridge;
	public ClazzFormalTypeParameter[] typeParamenterClazzes;

	static public Clazz resolveClassVariable(Clazz clazz, List<ClazzFormalTypeParameter> formalTypeParameters) {
		if (clazz instanceof ClazzVariable) {
			for (int i = 0; i < formalTypeParameters.size(); i++) {
				ClazzFormalTypeParameter formalTypeParameter = formalTypeParameters.get(i);
				if (formalTypeParameter.name.equals(((ClazzVariable) clazz).name)) {
					if (formalTypeParameter.getActualClazz() != null) {
						return formalTypeParameter.getActualClazz();
					} else {
						// return formalTypeParameter;
					}
					break;
				}
			}
		} else if (clazz instanceof ClazzWithTypeArguments) {
			ClazzWithTypeArguments clazzWithTypeArguments = (ClazzWithTypeArguments) clazz;
			boolean changed = false;
			ClazzTypeArgument[] typeArguments = clazzWithTypeArguments.getTypeArguments();
			ClazzTypeArgument[] genericParameterClazzResolved = new ClazzTypeArgument[typeArguments.length];
			for (int i = 0; i < typeArguments.length; i++) {
				ClazzTypeArgument typeArgument = typeArguments[i];
				Clazz clazzResolved = resolveClassVariable(typeArgument.clazz, formalTypeParameters);
				if (typeArgument != clazzResolved) {
					changed = true;
				}
				genericParameterClazzResolved[i] = Clazz.typeArgument(typeArgument.getWildcard(), clazzResolved);
			}
			if (changed) {
				return Clazz.of(clazzWithTypeArguments.getBaseClazz(), genericParameterClazzResolved);
			}
		}

		return clazz;
	}

	static public AdvMethodInfo parseMethodInfo(String descriptor, String signature, List<ClazzFormalTypeParameter> formalTypeParameters) {
		AdvMethodInfo methodInfo = new AdvMethodInfo();
		// Return Type 来源于方法descriptor
		methodInfo.originalReturnType = Type.getReturnType(descriptor);
		methodInfo.originalParamTypes = Type.getArgumentTypes(descriptor);

		// 来源于方法signature
		methodInfo.signatureReturnClazz = null;
		methodInfo.signatureParamsClazzes = null;

		// 解析ClassVariable
		methodInfo.prepareDerivedReturnClazz = null;
		methodInfo.derivedParamClazzes = new Clazz[methodInfo.originalParamTypes.length];

		methodInfo.needBridge = false;
		if (signature != null) {

			ClassSignaturewwww classSignaturewwww = null;
			classSignaturewwww = new ClassSignaturewwww(Opcodes.ASM9);
			SignatureReader sr = new SignatureReader(signature);
			sr.accept(classSignaturewwww);
			classSignaturewwww.finish();

			methodInfo.signatureParamsClazzes = classSignaturewwww.paramsClazzes;
			methodInfo.signatureReturnClazz = classSignaturewwww.returnClazz;

			for (int i = 0; i < methodInfo.signatureParamsClazzes.length; i++) {
				Clazz signatureParamsClazz = methodInfo.signatureParamsClazzes[i];
				Clazz derivedClazz = resolveClassVariable(signatureParamsClazz, formalTypeParameters);
				methodInfo.derivedParamClazzes[i] = derivedClazz;
				methodInfo.needBridge |= signatureParamsClazz instanceof ClazzVariable;
			}

			methodInfo.needBridge |= classSignaturewwww.returnClazz instanceof ClazzVariable;

			methodInfo.prepareDerivedReturnClazz = resolveClassVariable(methodInfo.signatureReturnClazz, formalTypeParameters);

			if (methodInfo.prepareDerivedReturnClazz == null) {
				methodInfo.prepareDerivedReturnClazz = Clazz.of(Type.VOID_TYPE);
			}

			methodInfo.typeParamenterClazzes = classSignaturewwww.typeParamenterClazzes;
		} else {
			methodInfo.prepareDerivedReturnClazz = Clazz.of(methodInfo.originalReturnType);
			for (int i = 0; i < methodInfo.originalParamTypes.length; i++) {
				methodInfo.derivedParamClazzes[i] = Clazz.of(methodInfo.originalParamTypes[i]);
			}
		}

		methodInfo.derivedReturnClazz = methodInfo.prepareDerivedReturnClazz;
		return methodInfo;
	}

	static public String getMethodDescriptor(final Clazz methodReturnClazz, Clazz[] methodParamClazzes) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append('(');
		for (Clazz argumentType : methodParamClazzes) {
			stringBuilder.append(argumentType.getDescriptor());
		}
		stringBuilder.append(')');
		stringBuilder.append(methodReturnClazz.getDescriptor());
		return stringBuilder.toString();
	}

	static public String getMethodSignature(ClazzFormalTypeParameter[] methodFormalTypeParameters, Clazz[] methodParamClazzes, final Clazz methodReturnClazz) {
		String actualSignature;
		boolean needSignature = false;
		{
			StringBuilder sb = new StringBuilder();
			if (methodFormalTypeParameters != null && methodFormalTypeParameters.length > 0) {
				sb.append('<');
				for (int i = 0; i < methodFormalTypeParameters.length; i++) {
					ClazzFormalTypeParameter type = methodFormalTypeParameters[i];
					sb.append(type.signatureOf());
				}
				sb.append('>');
				needSignature = true;
			}

			sb.append("(");
			for (Clazz param : methodParamClazzes) {
				if (param.needSignature()) {
					sb.append(param.signatureAnyway());
					needSignature = true;
				} else {
					sb.append(param.getDescriptor());
				}
			}
			sb.append(")");
			needSignature |= methodReturnClazz.needSignature();
			sb.append(methodReturnClazz.signatureAnyway());

			String signatureFromParameter = sb.toString();

			if (needSignature) {
				actualSignature = signatureFromParameter;
			} else {
				actualSignature = null;
			}
		}
		return actualSignature;
	}
}