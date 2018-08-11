package nebula.tinyasm;

//import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.DUP;
import static org.objectweb.asm.Opcodes.ICONST_0;
import static org.objectweb.asm.Opcodes.ICONST_1;
import static org.objectweb.asm.Opcodes.IFGT;
import static org.objectweb.asm.Opcodes.LADD;
import static org.objectweb.asm.Opcodes.LCMP;
import static org.objectweb.asm.Opcodes.LCONST_0;
import static org.objectweb.asm.Opcodes.LSUB;

import org.objectweb.asm.Label;

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
//		visitDefine_deposit(cw);
//		visitDefine_withdraw(cw);
//		visitDefine_onCreated(cw);
		visitDefine_onMoneyAdded(cw);
//		visitDefine_onMoneySubtracted(cw);

		cw.end();

		return cw.toByteArray();
	}

	private static void visitDefine_init_withfields(ClassBody cw) {
		cw.publicMethod("<init>")
			.parameter("axonBankAccountId", String.class)
			.parameter("overdraftLimit", long.class)
			.code(mc -> {
				mc.line(38).init();
				mc.line(39)
					.depetatedUse("this", "axonBankAccountId", "overdraftLimit")
					.invokeSpecial("onCreated", String.class, long.class);
				mc.line(40).returnvoid();
			});
	}

	private static void visitDefine_deposit(ClassBody cw) {
		cw.publicMethod(boolean.class, "deposit").parameter("amount", long.class).code(mv -> {
			mv.line(44).depetatedUse("this", "amount").invokeSpecial("onMoneyAdded", long.class);
			mv.line(45).deperatedInsn(ICONST_1).returnTop(boolean.class);
		});
	}

	private static void visitDefine_withdraw(ClassBody cw) {
		{
			cw.publicMethod(boolean.class, "withdraw").parameter("amount", long.class).code(mc -> {
				mc.line(50).load("amount");

				mc.deperatedLoadThis().get("balance");
				mc.deperatedLoadThis().get("overdraftLimit");
				mc.deperatedInsn(LADD);

				mc.deperatedInsn(LCMP);
				Label ifEnd = mc.newLabel();
				mc.jumpInsn(IFGT, ifEnd);

				mc.line(51).depetatedUse("this", "amount").invokeSpecial("onMoneySubtracted", long.class);
				mc.line(52).deperatedInsn(ICONST_1).returnTop(boolean.class);

				mc.accessLabel(ifEnd, 54);
				mc.deperatedInsn(ICONST_0).returnTop(boolean.class);
			});
		}
	}

	private static void visitDefine_onCreated(ClassBody cw) {
		cw.privateMethod("onCreated")
			.parameter("axonBankAccountId", String.class)
			.parameter("overdraftLimit", long.class)
			.code(mc -> {
				mc.line(100).deperatedLoadThis().put("axonBankAccountId", "axonBankAccountId");
				mc.line(101).deperatedLoadThis().put("overdraftLimit", "overdraftLimit");
				mc.line(102).depetatedUse("this").with(e -> e.deperatedInsn(LCONST_0)).putTo("balance");
				mc.line(103).returnvoid();
			});
	}

	private static void visitDefine_onMoneyAdded(ClassBody cw) {
		cw.privateMethod("onMoneyAdded").parameter("amount", long.class).code(mc -> {
			mc.def("newbalance", mc.fieldOfThis("balance").type);
			mc.line(107).load("this");
			mc.getfield_op("balance", mc.fieldOfThis("balance").type);
			mc.load("amount");
			mc.add_op();
			mc.storeStackTopTo("newbalance");
			mc.line(108).deperatedLoadThis().put("newbalance", "balance");
			mc.line(109).returnvoid();
		});
	}

	private static void visitDefine_onMoneySubtracted(ClassBody cw) {
		cw.privateMethod("onMoneySubtracted").parameter("amount", long.class).code(mc -> {
			mc.line(113).load("this");
			mc.dup();
			mc.useTopThis().get("balance");
			mc.load("amount");
			mc.dup();
			mc.useTopThis().putTo("balance");
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
