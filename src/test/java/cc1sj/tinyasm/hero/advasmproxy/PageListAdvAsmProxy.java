package cc1sj.tinyasm.hero.advasmproxy;

import static cc1sj.tinyasm.Adv.MAGIC_CODES_NUMBER;

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

import cc1sj.tinyasm.Adv;
import cc1sj.tinyasm.AdvContext;
import cc1sj.tinyasm.AdvRuntimeReferNameObject;
import cc1sj.tinyasm.ConsumerWithException;
import cc1sj.tinyasm.MethodCode;
import cc1sj.tinyasm.hero.helperclass.PageList;
import cc1sj.tinyasm.hero.helperclass.PojoClassSample;

public class PageListAdvAsmProxy implements PageList<PojoClassSample>, AdvRuntimeReferNameObject {
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
	public Iterator<PojoClassSample> iterator() {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(Iterator.class, c -> {
			objEval.accept(c);
			c.INTERFACE(PageList.class, "iterator").return_(Iterator.class).INVOKE();
		});
	
		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);
	
		if (Adv.canProxy(Iterator.class)) {
			return Adv.buildProxyClass(Iterator.class, PojoClassSample.class, magicNumber);
		} else {
			return null;
		}
	}

	@Override
	public void forEach(Consumer<? super PojoClassSample> param0) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.execLine(c -> {
			objEval.accept(c);
			eval_param0.accept(c);
			c.INTERFACE(PageList.class, "forEach").parameter(Consumer.class).INVOKE();
		});
	}

	@Override
	public Spliterator<PojoClassSample> spliterator() {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(Spliterator.class, c -> {
			objEval.accept(c);
			c.INTERFACE(PageList.class, "spliterator").return_(Spliterator.class).INVOKE();
		});
	
		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);
	
		if (Adv.canProxy(Spliterator.class)) {
			return Adv.buildProxyClass(Spliterator.class, PojoClassSample.class, magicNumber);
		} else {
			return null;
		}
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
	public boolean add(PojoClassSample param0) {
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
	public boolean addAll(Collection<? extends PojoClassSample> param0) {
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
		public boolean removeIf(Predicate<? super PojoClassSample> param0) {
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

	@Override
				public Stream<PojoClassSample> stream() {
					AdvContext context = _contextThreadLocal.get();
					ConsumerWithException<MethodCode> objEval = context.resolve(this);
					byte codeIndex = context.push(Stream.class, c -> {
						objEval.accept(c);
						c.INTERFACE(PageList.class, "stream").return_(Stream.class).INVOKE();
					});
				
					byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);
				
					if (Adv.canProxy(Stream.class)) {
						return Adv.buildProxyClass(Stream.class, PojoClassSample.class, magicNumber);
					} else {
						return null;
					}
				}

	@Override
	public Stream<PojoClassSample> parallelStream() {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(Stream.class, c -> {
			objEval.accept(c);
			c.INTERFACE(PageList.class, "parallelStream").return_(Stream.class).INVOKE();
		});
	
		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);
	
		if (Adv.canProxy(Stream.class)) {
			return Adv.buildProxyClass(Stream.class, PojoClassSample.class, magicNumber);
		} else {
			return null;
		}
	}

	@Override
	public boolean addAll(int param0, Collection<? extends PojoClassSample> param1) {
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
	public void replaceAll(UnaryOperator<PojoClassSample> param0) {
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
	public void sort(Comparator<? super PojoClassSample> param0) {
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
	public PojoClassSample get(int param0) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(PojoClassSample.class, c -> {
			objEval.accept(c);
			eval_param0.accept(c);
			c.INTERFACE(PageList.class, "get").parameter(int.class).return_(Object.class).INVOKE();
			c.CHECKCAST(PojoClassSample.class);
		});

		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);

		if (Adv.canProxy(PojoClassSample.class)) {
			return Adv.buildProxyClass(PojoClassSample.class, magicNumber);
		} else {
			return null;
		}
	}

	@Override
	public PojoClassSample set(int param0, PojoClassSample param1) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param1 = context.resolve(param1);
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(PojoClassSample.class, c -> {
			objEval.accept(c);
			eval_param0.accept(c);
			eval_param1.accept(c);
			c.INTERFACE(PageList.class, "set").parameter(int.class).parameter(Object.class).return_(Object.class).INVOKE();
			c.CHECKCAST(PojoClassSample.class);
		});

		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);

		if (Adv.canProxy(PojoClassSample.class)) {
			return Adv.buildProxyClass(PojoClassSample.class, magicNumber);
		} else {
			return null;
		}
	}

	@Override
	public void add(int param0, PojoClassSample param1) {
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
	public PojoClassSample remove(int param0) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(PojoClassSample.class, c -> {
			objEval.accept(c);
			eval_param0.accept(c);
			c.INTERFACE(PageList.class, "remove").parameter(int.class).return_(Object.class).INVOKE();
			c.CHECKCAST(PojoClassSample.class);
		});

		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);

		if (Adv.canProxy(PojoClassSample.class)) {
			return Adv.buildProxyClass(PojoClassSample.class, magicNumber);
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
	public ListIterator<PojoClassSample> listIterator() {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(ListIterator.class, c -> {
			objEval.accept(c);
			c.INTERFACE(PageList.class, "listIterator").return_(ListIterator.class).INVOKE();
		});

		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);

		if (Adv.canProxy(ListIterator.class)) {
			return Adv.buildProxyClass(ListIterator.class, PojoClassSample.class, magicNumber);
		} else {
			return null;
		}
	}

	@Override
	public ListIterator<PojoClassSample> listIterator(int param0) {
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
			return Adv.buildProxyClass(ListIterator.class, PojoClassSample.class, magicNumber);
		} else {
			return null;
		}
	}

	@Override
	public List<PojoClassSample> subList(int param0, int param1) {
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
			return Adv.buildProxyClass(List.class, PojoClassSample.class, magicNumber);
		} else {
			return null;
		}
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

	

}
