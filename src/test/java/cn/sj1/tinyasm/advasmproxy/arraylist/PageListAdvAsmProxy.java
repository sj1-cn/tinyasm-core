package cn.sj1.tinyasm.advasmproxy.arraylist;

import static cn.sj1.tinyasm.Adv.MAGIC_CODES_NUMBER;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import cn.sj1.tinyasm.Adv;
import cn.sj1.tinyasm.AdvContext;
import cn.sj1.tinyasm.AdvRuntimeReferNameObject;
import cn.sj1.tinyasm.Clazz;
import cn.sj1.tinyasm.ConsumerWithException;
import cn.sj1.tinyasm.MethodCode;
import cn.sj1.tinyasm.advasmproxy.simple.PojoClass;

public class PageListAdvAsmProxy implements PageList<PojoClass>, AdvRuntimeReferNameObject {
	private byte _magicNumber;
	private ThreadLocal<AdvContext> _contextThreadLocal;

	@Override
	public byte get__MagicNumber() {
		return this._magicNumber;
	}

	@Override
	public void set__MagicNumber(byte _magicNumber) {
		this._magicNumber = _magicNumber;
	}

	@Override
	public void set__Context(ThreadLocal<AdvContext> _contextThreadLocal, byte _magicNumber) {
		this._contextThreadLocal = _contextThreadLocal;
		this._magicNumber = _magicNumber;
	}

	@Override
	public Clazz get__TargetClazz() {
		return Clazz.of(PageList.class);
	}

	@Override
	public int getStart() {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(int.class, c -> {
			objEval.accept(c);
			c.INTERFACE(PageList.class, "getStart").return_(int.class).INVOKE();
		});
		return MAGIC_CODES_NUMBER + codeIndex; // int.class);
	}

	@Override
	public int getMax() {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(int.class, c -> {
			objEval.accept(c);
			c.INTERFACE(PageList.class, "getMax").return_(int.class).INVOKE();
		});
		return MAGIC_CODES_NUMBER + codeIndex; // int.class);
	}

	@Override
	public int getTotalSize() {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(int.class, c -> {
			objEval.accept(c);
			c.INTERFACE(PageList.class, "getTotalSize").return_(int.class).INVOKE();
		});
		return MAGIC_CODES_NUMBER + codeIndex; // int.class);
	}

	@Override
	public void start(int param0) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.execLine(c -> {
			objEval.accept(c);
			eval_param0.accept(c);
			c.INTERFACE(PageList.class, "start").parameter(int.class).INVOKE();
		});
	
	}

	@Override
	public void max(int param0) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.execLine(c -> {
			objEval.accept(c);
			eval_param0.accept(c);
			c.INTERFACE(PageList.class, "max").parameter(int.class).INVOKE();
		});
	
	}

	@Override
	public void totalSize(int param0) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.execLine(c -> {
			objEval.accept(c);
			eval_param0.accept(c);
			c.INTERFACE(PageList.class, "totalSize").parameter(int.class).INVOKE();
		});
	
	}

	@Override
	public int size() {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(int.class, c -> {
			objEval.accept(c);
			c.INTERFACE(PageList.class, "size").return_(int.class).INVOKE();
		});
	
		return MAGIC_CODES_NUMBER + codeIndex;
	}

	@Override
	public boolean isEmpty() {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.push(boolean.class, c -> {
			objEval.accept(c);
			c.INTERFACE(PageList.class, "isEmpty").return_(boolean.class).INVOKE();
		});
	
		return false;
	}

	@Override
	public boolean contains(Object param0) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.push(boolean.class, c -> {
			objEval.accept(c);
			eval_param0.accept(c);
			c.INTERFACE(PageList.class, "contains").parameter(Object.class).return_(boolean.class).INVOKE();
		});
		return false;
	}

	@Override
	public Iterator<PojoClass> iterator() {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(Iterator.class, c -> {
			objEval.accept(c);
			c.INTERFACE(PageList.class, "iterator").return_(Iterator.class).INVOKE();
		});
	
		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);
	
		if (Adv.canProxy(Iterator.class)) {
			return Adv.buildProxyClass(Iterator.class, PojoClass.class, magicNumber);
		} else {
			return null;
		}
	}

	@Override
	public Object[] toArray() {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(Object[].class, c -> {
			objEval.accept(c);
			c.INTERFACE(PageList.class, "toArray").return_(Object[].class).INVOKE();
		});
	
		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);
		Object simplePojoClassSample = null;
		Object[] tarray = new Object[1];
	
		if (Adv.canProxy(Object.class)) {
			simplePojoClassSample = Adv.buildProxyClass(Object.class, magicNumber);
			tarray[0] = simplePojoClassSample;
			return tarray; // int.class);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] param0) {
	
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(Object[].class, c -> {
			objEval.accept(c);
			eval_param0.accept(c);
	
			c.INTERFACE(PageList.class, "toArray").parameter(Object[].class).return_(Object[].class).INVOKE();
		});
	
		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);
	
		Class<?> targetClassT = param0.getClass().getComponentType();
	
		T[] targetArray = (T[]) Array.newInstance(targetClassT, 1);
	
		T targetElement = null;
		if (Adv.canProxy(targetClassT)) {
			targetElement = Adv.buildProxyClass((Class<T>) targetClassT, magicNumber);
			targetArray[0] = targetElement;
			return targetArray; // int.class);
		} else {
			return null;
		}
	}

	@Override
		public boolean add(PojoClass param0) {
			AdvContext context = _contextThreadLocal.get();
			ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
			ConsumerWithException<MethodCode> objEval = context.resolve(this);
			context.push(boolean.class, c -> {
				objEval.accept(c);
				eval_param0.accept(c);
				c.INTERFACE(PageList.class, "add").parameter(Object.class).return_(boolean.class).INVOKE();
			});
	//		return MAGIC_CODES_NUMBER + codeIndex; // int.class);
			return false;
		}

	@Override
		public boolean remove(Object param0) {
			AdvContext context = _contextThreadLocal.get();
			ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
			ConsumerWithException<MethodCode> objEval = context.resolve(this);
			context.push(boolean.class, c -> {
				objEval.accept(c);
				eval_param0.accept(c);
				c.INTERFACE(PageList.class, "remove").parameter(Object.class).return_(boolean.class).INVOKE();
			});
	//		super.remove(param0);
	//		return MAGIC_CODES_NUMBER + codeIndex; // int.class);
			return false;
		}

	@Override
		public boolean containsAll(Collection<?> param0) {
			AdvContext context = _contextThreadLocal.get();
			ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
			ConsumerWithException<MethodCode> objEval = context.resolve(this);
			context.push(boolean.class, c -> {
				objEval.accept(c);
				eval_param0.accept(c);
				c.INTERFACE(PageList.class, "containsAll").parameter(Collection.class).return_(boolean.class).INVOKE();
			});
	//		return MAGIC_CODES_NUMBER + codeIndex; // int.class);
			return false;
		}

	@Override
		public boolean addAll(Collection<? extends PojoClass> param0) {
			AdvContext context = _contextThreadLocal.get();
			ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
			ConsumerWithException<MethodCode> objEval = context.resolve(this);
			context.push(boolean.class, c -> {
				objEval.accept(c);
				eval_param0.accept(c);
				c.INTERFACE(PageList.class, "addAll").parameter(Collection.class).return_(boolean.class).INVOKE();
			});
	//		return MAGIC_CODES_NUMBER + codeIndex; // int.class);
			return false;
		}

	@Override
		public boolean addAll(int param0, Collection<? extends PojoClass> param1) {
			AdvContext context = _contextThreadLocal.get();
			ConsumerWithException<MethodCode> eval_param1 = context.resolve(param1);
			ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
			ConsumerWithException<MethodCode> objEval = context.resolve(this);
			context.push(boolean.class, c -> {
				objEval.accept(c);
				eval_param0.accept(c);
				eval_param1.accept(c);
				c.INTERFACE(PageList.class, "addAll").parameter(int.class).parameter(Collection.class).return_(boolean.class).INVOKE();
			});
	//		return MAGIC_CODES_NUMBER + codeIndex; // int.class);
			return false;
		}

	@Override
		public boolean removeAll(Collection<?> param0) {
			AdvContext context = _contextThreadLocal.get();
			ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
			ConsumerWithException<MethodCode> objEval = context.resolve(this);
			context.push(boolean.class, c -> {
				objEval.accept(c);
				eval_param0.accept(c);
				c.INTERFACE(PageList.class, "removeAll").parameter(Collection.class).return_(boolean.class).INVOKE();
			});
	//		return MAGIC_CODES_NUMBER + codeIndex; // int.class);
			return false;
		}

	@Override
		public boolean retainAll(Collection<?> param0) {
			AdvContext context = _contextThreadLocal.get();
			ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
			ConsumerWithException<MethodCode> objEval = context.resolve(this);
			context.push(boolean.class, c -> {
				objEval.accept(c);
				eval_param0.accept(c);
				c.INTERFACE(PageList.class, "retainAll").parameter(Collection.class).return_(boolean.class).INVOKE();
			});
	//		return MAGIC_CODES_NUMBER + codeIndex; // int.class);
			return false;
		}

	@Override
	public void replaceAll(UnaryOperator<PojoClass> param0) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.execLine(c -> {
			objEval.accept(c);
			eval_param0.accept(c);
			c.INTERFACE(PageList.class, "replaceAll").parameter(UnaryOperator.class).INVOKE();
		});
	}

	@Override
	public void sort(Comparator<? super PojoClass> param0) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.execLine(c -> {
			objEval.accept(c);
			eval_param0.accept(c);
			c.INTERFACE(PageList.class, "sort").parameter(Comparator.class).INVOKE();
		});
	}

	//
	//	@Override
	//	public Spliterator<PojoClassSample> spliterator() {
	//		AdvContext context = _contextThreadLocal.get();
	//		ConsumerWithException<MethodCode> objEval = context.resolve(this);
	//		byte codeIndex = context.push(Iterator.class, c -> {
	//			objEval.accept(c);
	//			c.INTERFACE(PageList.class, "spliterator").reTurn(Spliterator.class).INVOKE();
	//		});
	//
	//		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);
	//
	//		if (Adv.canProxy(Spliterator.class)) {
	//			return Adv.buildProxyClass(Spliterator.class, PojoClassSample.class, magicNumber);
	//		} else {
	//			return null;
	//		}
	//	}
	
		@Override
		public void clear() {
			AdvContext context = _contextThreadLocal.get();
			ConsumerWithException<MethodCode> objEval = context.resolve(this);
			context.execLine(c -> {
				objEval.accept(c);
				c.INTERFACE(PageList.class, "clear").INVOKE();
			});
	
		}

	

	

	//
	//	@Override
	//	public Spliterator<PojoClassSample> spliterator() {
	//		AdvContext context = _contextThreadLocal.get();
	//		ConsumerWithException<MethodCode> objEval = context.resolve(this);
	//		byte codeIndex = context.push(Iterator.class, c -> {
	//			objEval.accept(c);
	//			c.INTERFACE(PageList.class, "spliterator").reTurn(Spliterator.class).INVOKE();
	//		});
	//
	//		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);
	//
	//		if (Adv.canProxy(Spliterator.class)) {
	//			return Adv.buildProxyClass(Spliterator.class, PojoClassSample.class, magicNumber);
	//		} else {
	//			return null;
	//		}
	//	}
	
		

	//
	//	@Override
	//	public Spliterator<PojoClassSample> spliterator() {
	//		AdvContext context = _contextThreadLocal.get();
	//		ConsumerWithException<MethodCode> objEval = context.resolve(this);
	//		byte codeIndex = context.push(Iterator.class, c -> {
	//			objEval.accept(c);
	//			c.INTERFACE(PageList.class, "spliterator").reTurn(Spliterator.class).INVOKE();
	//		});
	//
	//		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);
	//
	//		if (Adv.canProxy(Spliterator.class)) {
	//			return Adv.buildProxyClass(Spliterator.class, PojoClassSample.class, magicNumber);
	//		} else {
	//			return null;
	//		}
	//	}
	
		@Override
		public boolean equals(Object param0) {
			AdvContext context = _contextThreadLocal.get();
			ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
			ConsumerWithException<MethodCode> objEval = context.resolve(this);
			context.push(boolean.class, c -> {
				objEval.accept(c);
				eval_param0.accept(c);
				c.INTERFACE(PageList.class, "equals").parameter(Object.class).return_(boolean.class).INVOKE();
			});
	//		return MAGIC_CODES_NUMBER + codeIndex; // int.class);
			return false;
		}

	//
	//	@Override
	//	public Spliterator<PojoClassSample> spliterator() {
	//		AdvContext context = _contextThreadLocal.get();
	//		ConsumerWithException<MethodCode> objEval = context.resolve(this);
	//		byte codeIndex = context.push(Iterator.class, c -> {
	//			objEval.accept(c);
	//			c.INTERFACE(PageList.class, "spliterator").reTurn(Spliterator.class).INVOKE();
	//		});
	//
	//		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);
	//
	//		if (Adv.canProxy(Spliterator.class)) {
	//			return Adv.buildProxyClass(Spliterator.class, PojoClassSample.class, magicNumber);
	//		} else {
	//			return null;
	//		}
	//	}
	
		@Override
		public int hashCode() {
			AdvContext context = _contextThreadLocal.get();
			ConsumerWithException<MethodCode> objEval = context.resolve(this);
			byte codeIndex = context.push(int.class, c -> {
				objEval.accept(c);
				c.INTERFACE(PageList.class, "hashCode").return_(int.class).INVOKE();
			});
			return MAGIC_CODES_NUMBER + codeIndex; // int.class);
		}

	

	

	//
	//	@Override
	//	public Spliterator<PojoClassSample> spliterator() {
	//		AdvContext context = _contextThreadLocal.get();
	//		ConsumerWithException<MethodCode> objEval = context.resolve(this);
	//		byte codeIndex = context.push(Iterator.class, c -> {
	//			objEval.accept(c);
	//			c.INTERFACE(PageList.class, "spliterator").reTurn(Spliterator.class).INVOKE();
	//		});
	//
	//		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);
	//
	//		if (Adv.canProxy(Spliterator.class)) {
	//			return Adv.buildProxyClass(Spliterator.class, PojoClassSample.class, magicNumber);
	//		} else {
	//			return null;
	//		}
	//	}
	
		@Override
		public PojoClass get(int param0) {
			AdvContext context = _contextThreadLocal.get();
			ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
			ConsumerWithException<MethodCode> objEval = context.resolve(this);
			byte codeIndex = context.push(PojoClass.class, c -> {
				objEval.accept(c);
				eval_param0.accept(c);
				c.INTERFACE(PageList.class, "get").parameter(int.class).return_(Object.class).INVOKE();
				c.CHECKCAST(PojoClass.class);
			});
	
			byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);
	
			if (Adv.canProxy(PojoClass.class)) {
				return Adv.buildProxyClass(PojoClass.class, magicNumber);
			} else {
				return null;
			}
		}

	@Override
	public PojoClass set(int param0, PojoClass param1) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param1 = context.resolve(param1);
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(PojoClass.class, c -> {
			objEval.accept(c);
			eval_param0.accept(c);
			eval_param1.accept(c);
			c.INTERFACE(PageList.class, "set").parameter(int.class).parameter(Object.class).return_(Object.class).INVOKE();
			c.CHECKCAST(PojoClass.class);
		});
	
		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);
	
		if (Adv.canProxy(PojoClass.class)) {
			return Adv.buildProxyClass(PojoClass.class, magicNumber);
		} else {
			return null;
		}
	}

	@Override
	public void add(int param0, PojoClass param1) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param1 = context.resolve(param1);
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.execLine(c -> {
			objEval.accept(c);
			eval_param0.accept(c);
			eval_param1.accept(c);
			c.INTERFACE(PageList.class, "add").parameter(int.class).parameter(Object.class).INVOKE();
		});
	
	}

	@Override
	public PojoClass remove(int param0) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(PojoClass.class, c -> {
			objEval.accept(c);
			eval_param0.accept(c);
			c.INTERFACE(PageList.class, "remove").parameter(int.class).return_(Object.class).INVOKE();
			c.CHECKCAST(PojoClass.class);
		});
	
		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);
	
		if (Adv.canProxy(PojoClass.class)) {
			return Adv.buildProxyClass(PojoClass.class, magicNumber);
		} else {
			return null;
		}
	}

	@Override
	public int indexOf(Object param0) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(int.class, c -> {
			objEval.accept(c);
			eval_param0.accept(c);
			c.INTERFACE(PageList.class, "indexOf").parameter(Object.class).return_(int.class).INVOKE();
		});
		return MAGIC_CODES_NUMBER + codeIndex; // int.class);
	}

	@Override
	public int lastIndexOf(Object param0) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(int.class, c -> {
			objEval.accept(c);
			eval_param0.accept(c);
			c.INTERFACE(PageList.class, "lastIndexOf").parameter(Object.class).return_(int.class).INVOKE();
		});
		return MAGIC_CODES_NUMBER + codeIndex; // int.class);
	}

	@Override
	public ListIterator<PojoClass> listIterator() {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(ListIterator.class, c -> {
			objEval.accept(c);
			c.INTERFACE(PageList.class, "listIterator").return_(ListIterator.class).INVOKE();
		});
	
		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);
	
		if (Adv.canProxy(ListIterator.class)) {
			return Adv.buildProxyClass(ListIterator.class, PojoClass.class, magicNumber);
		} else {
			return null;
		}
	}

	@Override
	public ListIterator<PojoClass> listIterator(int param0) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(ListIterator.class, c -> {
			objEval.accept(c);
			eval_param0.accept(c);
			c.INTERFACE(PageList.class, "listIterator").parameter(int.class).return_(ListIterator.class).INVOKE();
		});
	
		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);
	
		if (Adv.canProxy(ListIterator.class)) {
			return Adv.buildProxyClass(ListIterator.class, PojoClass.class, magicNumber);
		} else {
			return null;
		}
	}

	@Override
	public List<PojoClass> subList(int param0, int param1) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param1 = context.resolve(param1);
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(List.class, c -> {
			objEval.accept(c);
			eval_param0.accept(c);
			eval_param1.accept(c);
			c.INTERFACE(PageList.class, "subList").parameter(int.class).parameter(int.class).return_(List.class).INVOKE();
		});
	
		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);
	
		if (Adv.canProxy(List.class)) {
			return Adv.buildProxyClass(List.class, PojoClass.class, magicNumber);
		} else {
			return null;
		}
	}

	@Override
	public Spliterator<PojoClass> spliterator() {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(Spliterator.class, c -> {
			objEval.accept(c);
			c.INTERFACE(PageList.class, "spliterator").return_(Spliterator.class).INVOKE();
		});
	
		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);
	
		if (Adv.canProxy(Spliterator.class)) {
			return Adv.buildProxyClass(Spliterator.class, PojoClass.class, magicNumber);
		} else {
			return null;
		}
	}

	// TODO
	@SuppressWarnings("unused")
	@Override
	public <T> T[] toArray(IntFunction<T[]> param0) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(Object[].class, c -> {
			objEval.accept(c);
			eval_param0.accept(c);
	
			c.INTERFACE(PageList.class, "toArray").parameter(IntFunction.class).return_(Object[].class).INVOKE();
		});
	
		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);
	
		return null;
	}

	@Override
		public boolean removeIf(Predicate<? super PojoClass> param0) {
			AdvContext context = _contextThreadLocal.get();
			ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
			ConsumerWithException<MethodCode> objEval = context.resolve(this);
			context.push(boolean.class, c -> {
				objEval.accept(c);
				eval_param0.accept(c);
				c.INTERFACE(PageList.class, "removeIf").parameter(Predicate.class).return_(boolean.class).INVOKE();
			});
	//		return MAGIC_CODES_NUMBER + codeIndex; // int.class);
			return false;
		}

	@Override
	public Stream<PojoClass> stream() {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(Stream.class, c -> {
			objEval.accept(c);
			c.INTERFACE(PageList.class, "stream").return_(Stream.class).INVOKE();
		});
	
		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);
	
		if (Adv.canProxy(Stream.class)) {
			return Adv.buildProxyClass(Stream.class, PojoClass.class, magicNumber);
		} else {
			return null;
		}
	}

	@Override
	public Stream<PojoClass> parallelStream() {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(Stream.class, c -> {
			objEval.accept(c);
			c.INTERFACE(PageList.class, "parallelStream").return_(Stream.class).INVOKE();
		});
	
		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);
	
		if (Adv.canProxy(Stream.class)) {
			return Adv.buildProxyClass(Stream.class, PojoClass.class, magicNumber);
		} else {
			return null;
		}
	}

	@Override
	public void forEach(Consumer<? super PojoClass> param0) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.execLine(c -> {
			objEval.accept(c);
			eval_param0.accept(c);
			c.INTERFACE(PageList.class, "forEach").parameter(Consumer.class).INVOKE();
		});
	}

	//
	//	@Override
	//	public Spliterator<PojoClassSample> spliterator() {
	//		AdvContext context = _contextThreadLocal.get();
	//		ConsumerWithException<MethodCode> objEval = context.resolve(this);
	//		byte codeIndex = context.push(Iterator.class, c -> {
	//			objEval.accept(c);
	//			c.INTERFACE(PageList.class, "spliterator").reTurn(Spliterator.class).INVOKE();
	//		});
	//
	//		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);
	//
	//		if (Adv.canProxy(Spliterator.class)) {
	//			return Adv.buildProxyClass(Spliterator.class, PojoClassSample.class, magicNumber);
	//		} else {
	//			return null;
	//		}
	//	}


	//
		//	@Override
		//	public Spliterator<PojoClassSample> spliterator() {
		//		AdvContext context = _contextThreadLocal.get();
		//		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		//		byte codeIndex = context.push(Iterator.class, c -> {
		//			objEval.accept(c);
		//			c.INTERFACE(PageList.class, "spliterator").reTurn(Spliterator.class).INVOKE();
		//		});
		//
		//		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);
		//
		//		if (Adv.canProxy(Spliterator.class)) {
		//			return Adv.buildProxyClass(Spliterator.class, PojoClassSample.class, magicNumber);
		//		} else {
		//			return null;
		//		}
		//	}


	//
			//	@Override
			//	public Spliterator<PojoClassSample> spliterator() {
			//		AdvContext context = _contextThreadLocal.get();
			//		ConsumerWithException<MethodCode> objEval = context.resolve(this);
			//		byte codeIndex = context.push(Iterator.class, c -> {
			//			objEval.accept(c);
			//			c.INTERFACE(PageList.class, "spliterator").reTurn(Spliterator.class).INVOKE();
			//		});
			//
			//		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);
			//
			//		if (Adv.canProxy(Spliterator.class)) {
			//			return Adv.buildProxyClass(Spliterator.class, PojoClassSample.class, magicNumber);
			//		} else {
			//			return null;
			//		}
			//	}


	

}
