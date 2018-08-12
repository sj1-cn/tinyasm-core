package nebula.tinyasm;

//import org.objectweb.asm.Type;
import static nebula.tinyasm.api.TypeUtils.*;
import static org.objectweb.asm.Opcodes.DUP;
import static org.objectweb.asm.Opcodes.ICONST_0;
import static org.objectweb.asm.Opcodes.ICONST_1;
import static org.objectweb.asm.Opcodes.IFGT;
import static org.objectweb.asm.Opcodes.LADD;
import static org.objectweb.asm.Opcodes.LCMP;
import static org.objectweb.asm.Opcodes.LCONST_0;
import static org.objectweb.asm.Opcodes.LSUB;

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
				mc.line(38).init();
				mc.line(39).loadThis();
				mc.load("axonBankAccountId");
				mc.load("overdraftLimit");
				mc.INVOKESPECIAL(typeOf("com.nebula.cqrs.core.asm.MyBankAccount"), null, "onCreated",
						typeOf(String.class), typeOf(long.class));
				mc.line(40).returnvoid();
			});
	}

	private static void visitDefine_deposit(ClassBody cw) {
		cw.publicMethod(boolean.class, "deposit").parameter("amount", long.class).code(mc -> {
			mc.line(44).loadThis();
			mc.load("amount");
			mc.INVOKESPECIAL(typeOf("com.nebula.cqrs.core.asm.MyBankAccount"), null, "onMoneyAdded", Type.LONG_TYPE);
			mc.line(45).loadConstByte(1);
			mc.returnTopValue();
		});
	}

	private static void visitDefine_withdraw(ClassBody cw) {
		{
			cw.publicMethod(boolean.class, "withdraw").parameter("amount", long.class).code(mc -> {
				mc.line(50).load("amount");

				mc.loadThisField("balance", Type.LONG_TYPE);
				mc.loadThisField("overdraftLimit", Type.LONG_TYPE);
				mc.ADD();

				mc.deperatedInsn(LCMP);
				Label ifEnd = mc.newLabel();
				mc.jumpInsn(IFGT, ifEnd);

				mc.line(51).loadThis();
				mc.load("amount");
				mc.INVOKESPECIAL(typeOf("com.nebula.cqrs.core.asm.MyBankAccount"), null, "onMoneySubtracted",
						Type.LONG_TYPE);
				mc.line(52).loadConstByte(1);
				mc.returnTopValue();

				mc.accessLabel(ifEnd, 54);
				mc.loadConstByte(0);
				mc.returnTopValue();
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
				mc.line(102).loadThis();
				mc.loadConst(0L);
				mc.PUTFIELD("balance", Type.LONG_TYPE);
				mc.line(103).returnvoid();
			});
	}

	private static void visitDefine_onMoneyAdded(ClassBody cw) {
		cw.privateMethod("onMoneyAdded").parameter("amount", long.class).code(mc -> {
			mc.def("newbalance", long.class);
			mc.line(107).loadThisField("balance", Type.LONG_TYPE);
			mc.load("amount");
			mc.ADD();
			mc.store("newbalance");
			mc.line(108).loadThis();
			mc.load("newbalance");
			mc.PUTFIELD("balance", Type.LONG_TYPE);
			mc.line(109).returnvoid();
		});
	}

	private static void visitDefine_onMoneySubtracted(ClassBody cw) {
		cw.privateMethod("onMoneySubtracted").parameter("amount", long.class).code(mc -> {
			mc.line(113).loadThis();
			mc.DUP();
			mc.GETFIELD("balance", Type.LONG_TYPE);
			mc.load("amount");
			mc.SUB();
			mc.PUTFIELD("balance", Type.LONG_TYPE);
			mc.line(114).returnvoid();
		});
	}

	private static void visitDefine_init(ClassBody cw) {
		cw.privateMethod("<init>").code(mc -> {
			mc.line(34).init();
			mc.line(35).returnvoid();
		});
	}
}
