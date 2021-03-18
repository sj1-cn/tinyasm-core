package cn.sj1.tinyasm.ana.generatedsources.BankAccount.api;

import static org.objectweb.asm.Opcodes.ACC_PRIVATE;

import org.objectweb.asm.Label;

import cn.sj1.tinyasm.Annotation;
import cn.sj1.tinyasm.ClassBody;
import cn.sj1.tinyasm.ClassBuilder;
import cn.sj1.tinyasm.Clazz;

public class MyBankAccountBuilder {

	public static byte[] dump() throws Exception {

		ClassBody cb = ClassBuilder.class_("com.nebula.cqrs.core.asm.MyBankAccount").annotation("com/nebula/cqrs/core/CqrsEntity")
				.annotation("org/axonframework/spring/stereotype/Aggregate").body();

		cb.field(ACC_PRIVATE, Annotation.of("org/axonframework/commandhandling/model/AggregateIdentifier"), "axonBankAccountId",
				Clazz.of(String.class));
		cb.private_().field("overdraftLimit", long.class);
		cb.private_().field("balance", long.class);

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
		cw.public_().method("<init>").parameter("axonBankAccountId", String.class).parameter("overdraftLimit", long.class).code(mc -> {
			mc.LINE(38);
			mc.INIT_OBJECT();
			mc.LINE(39);
			mc.LOAD_THIS();
			mc.LOAD("axonBankAccountId");
			mc.LOAD("overdraftLimit");
			mc.INVOKESPECIAL("com.nebula.cqrs.core.asm.MyBankAccount", null, "onCreated", String.class, long.class);
			mc.LINE(40);
			mc.RETURN();
		});
	}

	private static void visitDefine_deposit(ClassBody cw) {
		cw.public_().method("deposit").return_(boolean.class).parameter("amount", long.class).code(mc -> {
			mc.LINE(44);
			mc.LOAD_THIS();
			mc.LOAD("amount");
			mc.INVOKESPECIAL("com.nebula.cqrs.core.asm.MyBankAccount", null, "onMoneyAdded", long.class);
			mc.LINE(45);
			mc.LOADConstByte(1);
			mc.RETURNTop();
		});
	}

	private static void visitDefine_withdraw(ClassBody cw) {
		{
			cw.public_().method("withdraw").return_(boolean.class).parameter("amount", long.class).code(mc -> {
				mc.LINE(50);
				mc.LOAD("amount");

				mc.LOAD("this");
				mc.GETFIELD_OF_THIS("balance");
				mc.LOAD("this");
				mc.GETFIELD_OF_THIS("overdraftLimit");
				mc.ADD();

				mc.LCMP();
				Label ifEnd = new Label();
				mc.IFGT(ifEnd);

				mc.LINE(51);
				mc.LOAD_THIS();
				mc.LOAD("amount");
				mc.INVOKESPECIAL("com.nebula.cqrs.core.asm.MyBankAccount", null, "onMoneySubtracted", long.class);
				mc.LINE(52);
				mc.LOADConstByte(1);
				mc.RETURNTop();

				mc.LINE();
				mc.visitLabel(ifEnd);
				mc.LOADConstByte(0);
				mc.RETURNTop();
			});
		}
	}

	private static void visitDefine_onCreated(ClassBody cw) {
		cw.private_().method("onCreated").parameter("axonBankAccountId", String.class).parameter("overdraftLimit", long.class).code(mc -> {
			mc.LINE(100);
			mc.LOAD_THIS();
			mc.LOAD("axonBankAccountId");
			mc.PUTFIELD_OF_THIS("axonBankAccountId");

			mc.LINE(102);
			mc.LOAD_THIS();
			mc.LOAD("overdraftLimit");
			mc.PUTFIELD_OF_THIS("overdraftLimit");

			mc.LINE(102);
			mc.LOAD_THIS();
			mc.LOADConst(0L);
			mc.PUTFIELD_OF_THIS("balance");
			mc.LINE(103);
			mc.RETURN();
		});
	}

	private static void visitDefine_onMoneyAdded(ClassBody cw) {
		cw.private_().method("onMoneyAdded").parameter("amount", long.class).code(mc -> {
			mc.define("newbalance", long.class);
			mc.LINE(107);
			mc.LOAD("this");
			mc.GETFIELD_OF_THIS("balance");
			mc.LOAD("amount");
			mc.ADD();
			mc.STORE("newbalance");
			mc.LINE(108);
			mc.LOAD_THIS();
			mc.LOAD("newbalance");
			mc.PUTFIELD_OF_THIS("balance");
			mc.LINE(109);
			mc.RETURN();
		});
	}

	private static void visitDefine_onMoneySubtracted(ClassBody cw) {
		cw.private_().method("onMoneySubtracted").parameter("amount", long.class).code(mc -> {
			mc.LINE(113);
			mc.LOAD_THIS();
			mc.DUP();
			mc.GETFIELD_OF_THIS("balance");
			mc.LOAD("amount");
			mc.SUB();
			mc.PUTFIELD_OF_THIS("balance");
			mc.LINE(114);
			mc.RETURN();
		});
	}

	private static void visitDefine_init(ClassBody cw) {
		cw.private_().method("<init>").code(mc -> {
			mc.LINE(34);
			mc.INIT_OBJECT();
			mc.LINE(35);
			mc.RETURN();
		});
	}
}
