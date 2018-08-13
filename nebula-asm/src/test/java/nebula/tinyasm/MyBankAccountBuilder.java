package nebula.tinyasm;

import org.objectweb.asm.Label;

public class MyBankAccountBuilder {

	public static byte[] dump() throws Exception {

		ClassBody cb = ClassBuilder.make("com.nebula.cqrs.core.asm.MyBankAccount")
			.annotation("com/nebula/cqrs/core/CqrsEntity")
			.annotation("org/axonframework/spring/stereotype/Aggregate")
			.body();

		cb.fieldWithAnnotation("org/axonframework/commandhandling/model/AggregateIdentifier", "axonBankAccountId",
				String.class);
		cb.field("overdraftLimit", long.class);
		cb.field("balance", long.class);

		visitDefine_init(cb);
		visitDefine_init_withfields(cb);
		visitDefine_deposit(cb);
		visitDefine_withdraw(cb);
		visitDefine_onCreated(cb);
		visitDefine_onMoneyAdded(cb);
		visitDefine_onMoneySubtracted(cb);

		return cb.end().toByteArray();
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
				mc.INVOKESPECIAL("com.nebula.cqrs.core.asm.MyBankAccount", null, "onCreated", String.class, long.class);
				mc.line(40).RETURN();
			});
	}

	private static void visitDefine_deposit(ClassBody cw) {
		cw.publicMethod(boolean.class, "deposit").parameter("amount", long.class).code(mc -> {
			mc.line(44).LOADThis();
			mc.LOAD("amount");
			mc.INVOKESPECIAL("com.nebula.cqrs.core.asm.MyBankAccount", null, "onMoneyAdded", long.class);
			mc.line(45).LOADConstByte(1);
			mc.RETURNTop();
		});
	}

	private static void visitDefine_withdraw(ClassBody cw) {
		{
			cw.publicMethod(boolean.class, "withdraw").parameter("amount", long.class).code(mc -> {
				mc.line(50).LOAD("amount");

				mc.LOADThisField("balance");
				mc.LOADThisField("overdraftLimit");
				mc.ADD();

				mc.CMP();
				Label ifEnd = mc.codeNewLabel();
				mc.IFGT(ifEnd);

				mc.line(51).LOADThis();
				mc.LOAD("amount");
				mc.INVOKESPECIAL("com.nebula.cqrs.core.asm.MyBankAccount", null, "onMoneySubtracted", long.class);
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
				mc.line(100).putVarToThisField("axonBankAccountId", "axonBankAccountId");
				mc.line(101).putVarToThisField("overdraftLimit", "overdraftLimit");
				mc.line(102).LOADThis();
				mc.LOADConst(0L);
				mc.PUT_THIS_FIELD("balance");
				mc.line(103).RETURN();
			});
	}

	private static void visitDefine_onMoneyAdded(ClassBody cw) {
		cw.privateMethod("onMoneyAdded").parameter("amount", long.class).code(mc -> {
			mc.var("newbalance", long.class);
			mc.line(107).LOADThisField("balance");
			mc.LOAD("amount");
			mc.ADD();
			mc.STORE("newbalance");
			mc.line(108).LOADThis();
			mc.LOAD("newbalance");
			mc.PUT_THIS_FIELD("balance");
			mc.line(109).RETURN();
		});
	}

	private static void visitDefine_onMoneySubtracted(ClassBody cw) {
		cw.privateMethod("onMoneySubtracted").parameter("amount", long.class).code(mc -> {
			mc.line(113).LOADThis();
			mc.DUP();
			mc.GET_THIS_FIELD("balance");
			mc.LOAD("amount");
			mc.SUB();
			mc.PUT_THIS_FIELD("balance");
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
