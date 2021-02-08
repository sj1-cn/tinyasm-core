package nebula.tinyasm;

import org.objectweb.asm.Label;
import static org.objectweb.asm.Opcodes.*;

public class MyBankAccountBuilder {

	public static byte[] dump() throws Exception {

		ClassBody cb = ClassBuilder.make("com.nebula.cqrs.core.asm.MyBankAccount").annotation("com/nebula/cqrs/core/CqrsEntity")
				.annotation("org/axonframework/spring/stereotype/Aggregate").body();

		cb.field(ACC_PRIVATE,Annotation.annotation("org/axonframework/commandhandling/model/AggregateIdentifier"), "axonBankAccountId", Clazz.of(String.class));
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
		cw.publicMethod(boolean.class, "deposit").parameter("amount", long.class).code(mc -> {
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
			cw.publicMethod(boolean.class, "withdraw").parameter("amount", long.class).code(mc -> {
				mc.LINE(50);
				mc.LOAD("amount");

				mc.LOAD("this");
				mc.GET_THIS_FIELD("balance");
				mc.LOAD("this");
				mc.GET_THIS_FIELD("overdraftLimit");
				mc.ADD();

				mc.LCMP();
				Label ifEnd = mc.codeNewLabel();
				mc.IFGT(ifEnd);

				mc.LINE(51);
				mc.LOAD_THIS();
				mc.LOAD("amount");
				mc.INVOKESPECIAL("com.nebula.cqrs.core.asm.MyBankAccount", null, "onMoneySubtracted", long.class);
				mc.LINE(52);
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
		cw.privateMethod("onMoneyAdded").parameter("amount", long.class).code(mc -> {
			mc.define("newbalance", long.class);
			mc.LINE(107);
			mc.LOAD("this");
			mc.GET_THIS_FIELD("balance");
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
		cw.privateMethod("onMoneySubtracted").parameter("amount", long.class).code(mc -> {
			mc.LINE(113);
			mc.LOAD_THIS();
			mc.DUP();
			mc.GET_THIS_FIELD("balance");
			mc.LOAD("amount");
			mc.SUB();
			mc.PUTFIELD_OF_THIS("balance");
			mc.LINE(114);
			mc.RETURN();
		});
	}

	private static void visitDefine_init(ClassBody cw) {
		cw.privateMethod("<init>").code(mc -> {
			mc.LINE(34);
			mc.INIT_OBJECT();
			mc.LINE(35);
			mc.RETURN();
		});
	}
}
