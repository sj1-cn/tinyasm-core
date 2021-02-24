package cc1sj.tinyasm.hero;

import java.util.function.Consumer;

import cc1sj.tinyasm.MethodCode;

public class Context {

//	private Stack<Consumer<MethodCode>> __codes;
//	private Map<String, Consumer<MethodCode>> __codeBlocks;
//	private Stack<String> __stack;
	MethodCode code;

	public Context(MethodCode code) {
		super();
		this.code = code;
	}

	// public Stack<Consumer<MethodCode>> get__codes() {
//		return __codes;
//	}
//
//	public void set__codes(Stack<Consumer<MethodCode>> __codes) {
//		this.__codes = __codes;
//	}
//
//	public Map<String, Consumer<MethodCode>> get__codeBlocks() {
//		return __codeBlocks;
//	}
//
//	public void set__codeBlocks(Map<String, Consumer<MethodCode>> __codeBlocks) {
//		this.__codeBlocks = __codeBlocks;
//	}
//
//	public Stack<String> get__stack() {
//		return __stack;
//	}
//
//	public void set__stack(Stack<String> __stack) {
//		this.__stack = __stack;
//	}
//
//	public Context(Stack<Consumer<MethodCode>> __codes, Map<String, Consumer<MethodCode>> __codeBlocks, Stack<String> __stack) {
//		super();
//		this.__codes = __codes;
//		this.__codeBlocks = __codeBlocks;
//		this.__stack = __stack;
//	}
//
//	public void add(Consumer<MethodCode> code1) {
//		this.__codes.add(code1);
//	}
//
//	public void add(Consumer<MethodCode> code1, Consumer<MethodCode> code2) {
//
//		this.__codes.add(new CodeLine(new Consumer<?>[] { code1, code2 }));
//	}
//
//	public void add(Consumer<MethodCode> code1, Consumer<MethodCode> code2, Consumer<MethodCode> code3) {
//
//		this.__codes.add(new CodeLine(new Consumer<?>[] { code1, code2, code3 }));
//	}
//
//	public void add(Consumer<MethodCode> code1, Consumer<MethodCode> code2, Consumer<MethodCode> code3, Consumer<MethodCode> code4) {
//
//		this.__codes.add(new CodeLine(new Consumer<?>[] { code1, code2, code3, code4 }));
//	}
//
//	@SuppressWarnings("unchecked")
//	public void addAll(Consumer<MethodCode>... codes) {
//		this.__codes.add(new CodeLine(codes));
//
//	}
//
//	public <T> T add(Class<T> clazz, Consumer<MethodCode> code1) {
//		this.__codes.add(code1);
//		return refer(this.__codes,clazz);
//	}
//
//	@SafeVarargs
//	public final <T> T addAll(Class<T> clazz, Consumer<MethodCode>... codes) {
//		this.__codes.add(new CodeLine(codes));
//		T refer = refer(this.__codes,clazz);
//		return refer;
//	}
//	
	MethodCode code() {
		return this.code;
	}

//	@SuppressWarnings("unchecked")
//	public void add(Consumer<MethodCode>... codes) {
//		if (codes.length == 1) {
//			this.__codes.add(codes[0]);
//		} else {
//			this.__codes.add(HeroASMBuilder.wi(codes));
//		}
//	}
}

//class CodeLine implements Consumer<MethodCode> {
//	Consumer<?>[] codes;
//
//	public CodeLine(Consumer<?>[] codes) {
//		this.codes = codes;
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public void accept(MethodCode t) {
//		for (Consumer<?> consumer : codes) {
//			((Consumer<MethodCode>) consumer).accept(t);
//		}
//
//	}
//
//}
