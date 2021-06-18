# tinyasm

ASM是非常好用高效的JAVA字节码维护库。本项目并不是为了替代ASM，而是在ASM基础上，为了进一步提高开发效率，降低学习成本，扩展ASM提供更便利的方法。

### 当前使用ASM几个不便的地方：

* 代码中用到的class是以字符串的方式引用的，在Class名，package名变更时，需要手工维护。
* 工具生成的代码太繁琐，更多是基于快速运行，比较难以理解，基本上无法直接使用。
* 堆栈的维护基于locals，导致在编写代码的时候需要花费大量的时间维护locals的正确，也需要知道每个类型的长度细节等。

### 针对上述几个问题，我们进行了一下改进：

#### 堆栈，TinyASM可以直接使用变量名称，locals完全由TinyASM开维护。再也不用计算locals了。

```java
// ASM 写法
methodVisitor.visitVarInsn(ALOAD, 2);
methodVisitor.visitVarInsn(ALOAD, 1);

// TinyASM 写法
code.LOAD("mapper");
code.LOAD("resultSet");
```

#### 引用class基本使用Class，而不是字符串名称。可以任意改名，任意变更package

```java
// ASM 写法
methodVisitor.visitMethodInsn(INVOKESPECIAL, "nebula/data/jdbc/UserExtendJdbcRowMapper", "<init>", "()V", false);

// TinyASM 写法
code.SPECIAL(UserExtendJdbcRowMapper.class, "<init>").INVOKE();
```

#### 对指令进行大幅度的简化，直接使用字节码的名称

```java
// ASM 写法
methodVisitor.visitVarInsn(ALOAD, 2);
methodVisitor.visitVarInsn(ALOAD, 1);

// TinyASM 写法
code.LOAD("mapper");
code.LOAD("resultSet");
```

#### 生成代码大幅度简化

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

基于生成代码直接可用，所以不需要“写”代码，只需要“改”代码。可以把希望实现的代码直接写在模版类中，然后生成模版代码，再在模版代码基础上修改成期待的样子即可。

详细的列子请参照[tinyasm-sample](https://github.com/sj1-cn/tinyasm-sample)
