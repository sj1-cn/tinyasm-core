# tinyasm
底层使用asm的动态生成辅助代码库

简化ASM的使用，更倾向于在样例代码上简单修改，而不是完全重新生成。

通过此工具可以自动维护local，stack，以便简化代码编写。

同时大量地方使用class，而不是class的字符串名字，以减少类型名细微的不同可能带来的问题。以及适应快速演化的代码。

为什么需要这样一个工具，下边是一个非常简单的例子：

```java
package nebula.data.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsingUserExtendJdbcRowMapper {
	public String test(ResultSet resultSet) throws SQLException {

		UserExtendJdbcRowMapper mapper = new UserExtendJdbcRowMapper();
		UserExtend userExtend = mapper.map(resultSet);
		return userExtend.getName();
	}
}
```

生成这样一个简单的class需要的ASM的代码如下：

```java
public class UsingUserExtendJdbcRowMapperDump implements Opcodes {

public static byte[] dump () throws Exception {

ClassWriter classWriter = new ClassWriter(0);
FieldVisitor fieldVisitor;
RecordComponentVisitor recordComponentVisitor;
MethodVisitor methodVisitor;
AnnotationVisitor annotationVisitor0;

classWriter.visit(V9, ACC_PUBLIC | ACC_SUPER, "nebula/data/jdbc/UsingUserExtendJdbcRowMapper", null, "java/lang/Object", null);

classWriter.visitSource("UsingUserExtendJdbcRowMapper.java", null);

{
methodVisitor = classWriter.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
methodVisitor.visitCode();
Label label0 = new Label();
methodVisitor.visitLabel(label0);
methodVisitor.visitLineNumber(6, label0);
methodVisitor.visitVarInsn(ALOAD, 0);
methodVisitor.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
methodVisitor.visitInsn(RETURN);
Label label1 = new Label();
methodVisitor.visitLabel(label1);
methodVisitor.visitLocalVariable("this", "Lnebula/data/jdbc/UsingUserExtendJdbcRowMapper;", null, label0, label1, 0);
methodVisitor.visitMaxs(1, 1);
methodVisitor.visitEnd();
}
{
methodVisitor = classWriter.visitMethod(ACC_PUBLIC, "test", "(Ljava/sql/ResultSet;)Ljava/lang/String;", null, new String[] { "java/sql/SQLException" });
methodVisitor.visitParameter("resultSet", 0);
methodVisitor.visitCode();
Label label0 = new Label();
methodVisitor.visitLabel(label0);
methodVisitor.visitLineNumber(9, label0);
methodVisitor.visitTypeInsn(NEW, "nebula/data/jdbc/UserExtendJdbcRowMapper");
methodVisitor.visitInsn(DUP);
methodVisitor.visitMethodInsn(INVOKESPECIAL, "nebula/data/jdbc/UserExtendJdbcRowMapper", "<init>", "()V", false);
methodVisitor.visitVarInsn(ASTORE, 2);
Label label1 = new Label();
methodVisitor.visitLabel(label1);
methodVisitor.visitLineNumber(10, label1);
methodVisitor.visitVarInsn(ALOAD, 2);
methodVisitor.visitVarInsn(ALOAD, 1);
methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "nebula/data/jdbc/UserExtendJdbcRowMapper", "map", "(Ljava/sql/ResultSet;)Lnebula/data/jdbc/UserExtend;", false);
methodVisitor.visitVarInsn(ASTORE, 3);
Label label2 = new Label();
methodVisitor.visitLabel(label2);
methodVisitor.visitLineNumber(11, label2);
methodVisitor.visitVarInsn(ALOAD, 3);
methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "nebula/data/jdbc/UserExtend", "getName", "()Ljava/lang/String;", false);
methodVisitor.visitInsn(ARETURN);
Label label3 = new Label();
methodVisitor.visitLabel(label3);
methodVisitor.visitLocalVariable("this", "Lnebula/data/jdbc/UsingUserExtendJdbcRowMapper;", null, label0, label3, 0);
methodVisitor.visitLocalVariable("resultSet", "Ljava/sql/ResultSet;", null, label0, label3, 1);
methodVisitor.visitLocalVariable("mapper", "Lnebula/data/jdbc/UserExtendJdbcRowMapper;", null, label1, label3, 2);
methodVisitor.visitLocalVariable("userExtend", "Lnebula/data/jdbc/UserExtend;", null, label2, label3, 3);
methodVisitor.visitMaxs(2, 4);
methodVisitor.visitEnd();
}
classWriter.visitEnd();

return classWriter.toByteArray();
}
}
```

当前我做的这个工具基础版本的代码是这样的：

```java
public class UsingUserExtendJdbcRowMapperTinyAsmDump {

	public static byte[] dump() throws Exception {
		return new UsingUserExtendJdbcRowMapperTinyAsmDump().dump("nebula.data.jdbc.UsingUserExtendJdbcRowMapper");
	}

	public byte[] dump(String className) throws Exception {
		ClassBody classBody = ClassBuilder.class_(className).access(ACC_PUBLIC | ACC_SUPER).body();

		__init_(classBody);
		_test(classBody);

		return classBody.end().toByteArray();
	}

	protected void __init_(ClassBody classBody) {
		MethodCode code = classBody.public_().method("<init>").begin();

		code.LINE();
		code.LOAD("this");
		code.SPECIAL(Object.class, "<init>").INVOKE();
		code.RETURN();

		code.END();
	}

	protected void _test(ClassBody classBody) {
		MethodCode code = classBody.public_().method("test").return_(String.class).throws_(SQLException.class).parameter("resultSet", ResultSet.class).begin();

		code.LINE();
		code.NEW(UserExtendJdbcRowMapper.class);
		code.DUP();
		code.SPECIAL(UserExtendJdbcRowMapper.class, "<init>").INVOKE();
		code.STORE("mapper", UserExtendJdbcRowMapper.class);

		code.LINE();
		code.LOAD("mapper");
		code.LOAD("resultSet");
		code.VIRTUAL(UserExtendJdbcRowMapper.class, "map").return_(UserExtend.class).parameter(ResultSet.class).INVOKE();
		code.STORE("userExtend", UserExtend.class);

		code.LINE();
		code.LOAD("userExtend");
		code.VIRTUAL(UserExtend.class, "getName").return_(String.class).INVOKE();
		code.RETURNTop();

		code.END();
	}

}

```

高级版本的代码是这样的

```java
public class UsingUserExtendJdbcRowMapperMagicBuilder {

	public String test(ResultSet resultSet) throws SQLException {
		UserExtendJdbcRowMapper mapper = __("mapper", new_(UserExtendJdbcRowMapper.class));
		UserExtend userExtend = __("userExtend", mapper.map(resultSet));
		return _return(userExtend.getName());
	}

	public static byte[] dump() {
		return AdvMagic.dump("nebula.data.jdbc.UsingUserExtendJdbcRowMapper", UsingUserExtendJdbcRowMapperMagicBuilder.class);
	}
}
```

你喜欢哪一种？

另外基础版本和高级版本的代码都是可以直接从UsingUserExtendJdbcRowMapper代码生成出来的。

