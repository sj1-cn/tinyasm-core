package nebula.tinyasm;

import static nebula.tinyasm.util.TypeUtils.typeOf;

import org.objectweb.asm.Label;
import org.objectweb.asm.Type;

import nebula.tinyasm.api.ClassBody;

public class MyBankAccountBuilder {

	public static byte[] dump() throws Exception {

		ClassBody cw = ClassBuilder.make("com.nebula.cqrs.core.asm.MyBankAccount");
		cw.annotation("com/nebula/cqrs/core/CqrsEntity");
		cw.annotation("org/axonframework/spring/stereotype/Aggregate");

		cw.fieldWithAnnotation("org/axonframework/commandhandling/model/AggregateIdentifier", "axonBankAccountId",
				String.class);
		cw.field("overdraftLimit", long.class);
		cw.field("balance", long.class);

		visitDefine_init(cw);
		visitDefine_init_withfields(cw);
		visitDefine_deposit(cw);
		visitDefine_withdraw(cw);
		visitDefine_onCreated(cw);
		visitDefine_onMoneyAdded(cw);
		visitDefine_onMoneySubtracted(cw);

		cw.end();

		return cw.toByteArray();
	}

	private static void visitDefine_init_withfields(ClassBody cw) {
		cw.publicMethod("<init>")
			.parameter("axonBankAccountId", String.class)
			.parameter("overdraftLimit", long.class)
			.code(mc -> {
				mc.line(38).INITObject();
				mc.line(39).LOADThis();
				mc.LOAD("axonBankAccountId");
				mc.LOAD("overdraftLimit");
				mc.INVOKESPECIAL(typeOf("com.nebula.cqrs.core.asm.MyBankAccount"), null, "onCreated",
						typeOf(String.class), typeOf(long.class));
				mc.line(40).RETURN();
			});
	}

	private static void visitDefine_deposit(ClassBody cw) {
		cw.publicMethod(boolean.class, "deposit").parameter("amount", long.class).code(mc -> {
			mc.line(44).LOADThis();
			mc.LOAD("amount");
			mc.INVOKESPECIAL(typeOf("com.nebula.cqrs.core.asm.MyBankAccount"), null, "onMoneyAdded", Type.LONG_TYPE);
			mc.line(45).LOADConstByte(1);
			mc.RETURNTop();
		});
	}

	private static void visitDefine_withdraw(ClassBody cw) {
		{
			cw.publicMethod(boolean.class, "withdraw").parameter("amount", long.class).code(mc -> {
				mc.line(50).LOAD("amount");

				mc.LOADThisField("balance", Type.LONG_TYPE);
				mc.LOADThisField("overdraftLimit", Type.LONG_TYPE);
				mc.ADD();

				mc.CMP();
				Label ifEnd = mc.codeNewLabel();
				mc.IFGT(ifEnd);

				mc.line(51).LOADThis();
				mc.LOAD("amount");
				mc.INVOKESPECIAL(typeOf("com.nebula.cqrs.core.asm.MyBankAccount"), null, "onMoneySubtracted",
						Type.LONG_TYPE);
				mc.line(52).LOADConstByte(1);
				mc.RETURNTop();

				mc.codeAccessLabel(ifEnd, 54);
				mc.LOADConstByte(0);
				mc.RETURNTop();
			});
		}
	}

	private static void visitDefine_onCreated(ClassBody cw) {
		cw.privateMethod("onCreated")
			.parameter("axonBankAccountId", String.class)
			.parameter("overdraftLimit", long.class)
			.code(mc -> {
				mc.line(100).putVarToThisField("axonBankAccountId", "axonBankAccountId", Type.getType(String.class));
				mc.line(101).putVarToThisField("overdraftLimit", "overdraftLimit", Type.LONG_TYPE);
				mc.line(102).LOADThis();
				mc.LOADConst(0L);
				mc.PUTFIELD("balance", Type.LONG_TYPE);
				mc.line(103).RETURN();
			});
	}

	private static void visitDefine_onMoneyAdded(ClassBody cw) {
		cw.privateMethod("onMoneyAdded").parameter("amount", long.class).code(mc -> {
			mc.def("newbalance", long.class);
			mc.line(107).LOADThisField("balance", Type.LONG_TYPE);
			mc.LOAD("amount");
			mc.ADD();
			mc.STORE("newbalance");
			mc.line(108).LOADThis();
			mc.LOAD("newbalance");
			mc.PUTFIELD("balance", Type.LONG_TYPE);
			mc.line(109).RETURN();
		});
	}

	private static void visitDefine_onMoneySubtracted(ClassBody cw) {
		cw.privateMethod("onMoneySubtracted").parameter("amount", long.class).code(mc -> {
			mc.line(113).LOADThis();
			mc.DUP();
			mc.GETFIELD("balance", Type.LONG_TYPE);
			mc.LOAD("amount");
			mc.SUB();
			mc.PUTFIELD("balance", Type.LONG_TYPE);
			mc.line(114).RETURN();
		});
	}

	private static void visitDefine_init(ClassBody cw) {
		cw.privateMethod("<init>").code(mc -> {
			mc.line(34).INITObject();
			mc.line(35).RETURN();
		});
	}
}
