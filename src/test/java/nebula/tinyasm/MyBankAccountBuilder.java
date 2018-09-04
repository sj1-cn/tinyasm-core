package nebula.tinyasm;

import org.objectweb.asm.Label;

import nebula.tinyasm.data.Annotation;
import nebula.tinyasm.data.ClassBody;

public class MyBankAccountBuilder {

	public static byte[] dump() throws Exception {

		ClassBody cb = ClassBuilder.make("com.nebula.cqrs.core.asm.MyBankAccount")
			.annotation("com/nebula/cqrs/core/CqrsEntity")
			.annotation("org/axonframework/spring/stereotype/Aggregate")
			.body();

		cb.field(Annotation.annotation("org/axonframework/commandhandling/model/AggregateIdentifier"), "axonBankAccountId", String.class);
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
		cw.publicMethod("<init>").parameter("axonBankAccountId", String.class).parameter("overdraftLimit", long.class).code(mc -> {
			mc.line(38);
			mc.initObject();
			mc.line(39);
			mc.loadThis();
			mc.LOAD("axonBankAccountId");
			mc.LOAD("overdraftLimit");
			mc.INVOKESPECIAL("com.nebula.cqrs.core.asm.MyBankAccount", null, "onCreated", String.class, long.class);
			mc.line(40);
			mc.RETURN();
		});
	}

	private static void visitDefine_deposit(ClassBody cw) {
		cw.publicMethod(boolean.class, "deposit").parameter("amount", long.class).code(mc -> {
			mc.line(44).loadThis();
			mc.LOAD("amount");
			mc.INVOKESPECIAL("com.nebula.cqrs.core.asm.MyBankAccount", null, "onMoneyAdded", long.class);
			mc.line(45);
			mc.LOADConstByte(1);
			mc.RETURNTop();
		});
	}

	private static void visitDefine_withdraw(ClassBody cw) {
		{
			cw.publicMethod(boolean.class, "withdraw").parameter("amount", long.class).code(mc -> {
				mc.line(50);
				mc.LOAD("amount");

				mc.loadThisField("balance");
				mc.loadThisField("overdraftLimit");
				mc.ADD();

				mc.LCMP();
				Label ifEnd = mc.codeNewLabel();
				mc.IFGT(ifEnd);

				mc.line(51).loadThis();
				mc.LOAD("amount");
				mc.INVOKESPECIAL("com.nebula.cqrs.core.asm.MyBankAccount", null, "onMoneySubtracted", long.class);
				mc.line(52);
				mc.LOADConstByte(1);
				mc.RETURNTop();

				mc.visitLabel(ifEnd, 54);
				mc.LOADConstByte(0);
				mc.RETURNTop();
			});
		}
	}

	private static void visitDefine_onCreated(ClassBody cw) {
		cw.privateMethod("onCreated").parameter("axonBankAccountId", String.class).parameter("overdraftLimit", long.class).code(mc -> {
			mc.line(100).putThisFieldWithVar("axonBankAccountId", "axonBankAccountId");
			mc.line(101).putThisFieldWithVar("overdraftLimit", "overdraftLimit");
			mc.line(102).loadThis();
			mc.LOADConst(0L);
			mc.PUTFIELD_OF_THIS("balance");
			mc.line(103);
			mc.RETURN();
		});
	}

	private static void visitDefine_onMoneyAdded(ClassBody cw) {
		cw.privateMethod("onMoneyAdded").parameter("amount", long.class).code(mc -> {
			mc.define("newbalance", long.class);
			mc.line(107).loadThisField("balance");
			mc.LOAD("amount");
			mc.ADD();
			mc.STORE("newbalance");
			mc.line(108).loadThis();
			mc.LOAD("newbalance");
			mc.PUTFIELD_OF_THIS("balance");
			mc.line(109);
			mc.RETURN();
		});
	}

	private static void visitDefine_onMoneySubtracted(ClassBody cw) {
		cw.privateMethod("onMoneySubtracted").parameter("amount", long.class).code(mc -> {
			mc.line(113).loadThis();
			mc.DUP();
			mc.GET_THIS_FIELD("balance");
			mc.LOAD("amount");
			mc.SUB();
			mc.PUTFIELD_OF_THIS("balance");
			mc.line(114);
			mc.RETURN();
		});
	}

	private static void visitDefine_init(ClassBody cw) {
		cw.privateMethod("<init>").code(mc -> {
			mc.line(34).initObject();
			mc.line(35);
			mc.RETURN();
		});
	}
}
