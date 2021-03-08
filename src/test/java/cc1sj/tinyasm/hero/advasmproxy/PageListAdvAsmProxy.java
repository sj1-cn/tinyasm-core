package cc1sj.tinyasm.hero.advasmproxy;

import static cc1sj.tinyasm.Adv.MAGIC_CODES_NUMBER;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
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
	public int getStart() {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(int.class, c -> {
			objEval.accept(c);
			c.VIRTUAL(PojoClassSample.class, "getStart").reTurn(int.class).INVOKE();
		});
		return MAGIC_CODES_NUMBER + codeIndex; // int.class);
	}

	@Override
	public int getMax() {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(int.class, c -> {
			objEval.accept(c);
			c.VIRTUAL(PojoClassSample.class, "getMax").reTurn(int.class).INVOKE();
		});
		return MAGIC_CODES_NUMBER + codeIndex; // int.class);
	}

	@Override
	public int getTotalSize() {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(int.class, c -> {
			objEval.accept(c);
			c.VIRTUAL(PojoClassSample.class, "getTotalSize").reTurn(int.class).INVOKE();
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
			c.VIRTUAL(PageList.class, "start").parameter(int.class).INVOKE();
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
			c.VIRTUAL(PageList.class, "max").parameter(int.class).INVOKE();
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
			c.VIRTUAL(PageList.class, "totalSize").parameter(int.class).INVOKE();
		});

	}
	
	@Override
	public int size() {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(int.class, c -> {
			objEval.accept(c);
			c.VIRTUAL(PageList.class, "size").reTurn(int.class).INVOKE();
		});

		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);

		return magicNumber;
	}

	@Override
	public boolean isEmpty() {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(boolean.class, c -> {
			objEval.accept(c);
			c.VIRTUAL(PageList.class, "isEmpty").reTurn(boolean.class).INVOKE();
		});

		return false;
	}

	@Override
	public boolean contains(Object param0) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(boolean.class, c -> {
			objEval.accept(c);
			eval_param0.accept(c);
			c.VIRTUAL(PageList.class, "contains").reTurn(boolean.class).INVOKE();
		});
		return false;
	}

	@Override
	public Iterator<PojoClassSample> iterator() {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(Iterator.class, c -> {
			objEval.accept(c);
			c.VIRTUAL(PageList.class, "iterator").reTurn(Iterator.class).INVOKE();
		});

		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);

		if (Adv.canProxy(Iterator.class)) {
			return Adv.buildProxyClass(Iterator.class, PojoClassSample.class, magicNumber);
		} else {
			return null;
		}
	}

	@Override
	public Object[] toArray() {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
//		byte codeIndex = context.push(Object[].class, c -> {
//			objEval.accept(c);
//			c.VIRTUAL(PageList.class, "toArray").reTurn(Object[].class).INVOKE();
//		});
//
//		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);
//
//		if (Adv.canProxy(Iterator.class)) {
//			return Adv.buildProxyClass(Iterator.class, PojoClassSample.class, magicNumber);
//		} else {
//			return null;
//		}
		return null;
	}

	@Override
	public <T> T[] toArray(T[] param0) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
//		byte codeIndex = context.push(Array.li.class, c -> {
////			objEval.accept(c);
////			eval_param0.accept(c);
////			c.VIRTUAL(PojoClassSample.class, "toArray").reTurn(int.class).INVOKE();
//		});
//		return MAGIC_CODES_NUMBER + codeIndex; // int.class);
		return null;
	}

	@Override
	public boolean add(PojoClassSample param0) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(boolean.class, c -> {
			objEval.accept(c);
			eval_param0.accept(c);
			c.VIRTUAL(PojoClassSample.class, "add").parameter(PojoClassSample.class).reTurn(boolean.class).INVOKE();
		});
//		return MAGIC_CODES_NUMBER + codeIndex; // int.class);
		return false;
	}

	@Override
	public boolean remove(Object param0) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(boolean.class, c -> {
			objEval.accept(c);
			eval_param0.accept(c);
			c.VIRTUAL(PojoClassSample.class, "remove").parameter(Object.class).reTurn(boolean.class).INVOKE();
		});
//		return MAGIC_CODES_NUMBER + codeIndex; // int.class);
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> param0) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(boolean.class, c -> {
			objEval.accept(c);
			eval_param0.accept(c);
			c.VIRTUAL(PojoClassSample.class, "containsAll").parameter(Collection.class).reTurn(boolean.class).INVOKE();
		});
//		return MAGIC_CODES_NUMBER + codeIndex; // int.class);
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends PojoClassSample> param0) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(boolean.class, c -> {
			objEval.accept(c);
			eval_param0.accept(c);
			c.VIRTUAL(PojoClassSample.class, "addAll").parameter(Collection.class).reTurn(boolean.class).INVOKE();
		});
//		return MAGIC_CODES_NUMBER + codeIndex; // int.class);
		return false;
	}

	@Override
	public boolean addAll(int param0, Collection<? extends PojoClassSample> param1) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param1 = context.resolve(param1);
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(boolean.class, c -> {
			objEval.accept(c);
			eval_param0.accept(c);
			eval_param1.accept(c);
			c.VIRTUAL(PojoClassSample.class, "addAll").parameter(int.class).parameter(Collection.class).reTurn(boolean.class).INVOKE();
		});
//		return MAGIC_CODES_NUMBER + codeIndex; // int.class);
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> param0) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(boolean.class, c -> {
			objEval.accept(c);
			eval_param0.accept(c);
			c.VIRTUAL(PojoClassSample.class, "removeAll").parameter(Collection.class).reTurn(boolean.class).INVOKE();
		});
//		return MAGIC_CODES_NUMBER + codeIndex; // int.class);
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> param0) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(boolean.class, c -> {
			objEval.accept(c);
			eval_param0.accept(c);
			c.VIRTUAL(PojoClassSample.class, "retainAll").parameter(Collection.class).reTurn(boolean.class).INVOKE();
		});
//		return MAGIC_CODES_NUMBER + codeIndex; // int.class);
		return false;
	}

	@Override
	public void clear() {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		context.execLine(c -> {
			objEval.accept(c);
			c.VIRTUAL(PageList.class, "clear").INVOKE();
		});

	}

	@Override
	public PojoClassSample get(int param0) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(PojoClassSample.class, c -> {
			objEval.accept(c);
			eval_param0.accept(c);
			c.VIRTUAL(PageList.class, "isEmpty").parameter(int.class).reTurn(boolean.class).INVOKE();
		});

		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);

		if (Adv.canProxy(Iterator.class)) {
			return Adv.buildProxyClass(Iterator.class, PojoClassSample.class, magicNumber);
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
			c.VIRTUAL(PageList.class, "isEmpty").parameter(int.class).parameter(PojoClassSample.class).reTurn(boolean.class).INVOKE();
		});

		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);

		if (Adv.canProxy(Iterator.class)) {
			return Adv.buildProxyClass(Iterator.class, PojoClassSample.class, magicNumber);
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
		context.exec(c -> {
			objEval.accept(c);
			eval_param0.accept(c);
			eval_param1.accept(c);
			c.VIRTUAL(PageList.class, "add").parameter(int.class).parameter(int.class).INVOKE();
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
			c.VIRTUAL(PageList.class, "isEmpty").parameter(int.class).reTurn(PojoClassSample.class).INVOKE();
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
			c.VIRTUAL(PojoClassSample.class, "indexOf").parameter(Object.class).reTurn(int.class).INVOKE();
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
			c.VIRTUAL(PojoClassSample.class, "lastIndexOf").parameter(Object.class).reTurn(int.class).INVOKE();
		});
		return MAGIC_CODES_NUMBER + codeIndex; // int.class);
	}

	@Override
	public ListIterator<PojoClassSample> listIterator() {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(ListIterator.class, c -> {
			objEval.accept(c);
			c.VIRTUAL(PageList.class, "listIterator").reTurn(ListIterator.class).INVOKE();
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
			c.VIRTUAL(PageList.class, "listIterator").parameter(int.class).reTurn(ListIterator.class).INVOKE();
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
			c.VIRTUAL(PageList.class, "subList").parameter(int.class).parameter(int.class).reTurn(List.class).INVOKE();
		});

		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);

		if (Adv.canProxy(List.class)) {
			return Adv.buildProxyClass(List.class, PojoClassSample.class, magicNumber);
		} else {
			return null;
		}
	}

	@Override
	public <T> T[] toArray(IntFunction<T[]> param0) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(Array.class, c -> {
//			objEval.accept(c);
//			eval_param0.accept(c);
//			c.VIRTUAL(PageList.class, "toArray").parameter(IntFunction.class).reTurn(T[].class).INVOKE();
		});

		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);
//		context.push(Array.class,c->{});
		return null;

	}

	@Override
	public boolean removeIf(Predicate<? super PojoClassSample> param0) {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> eval_param0 = context.resolve(param0);
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(boolean.class, c -> {
			objEval.accept(c);
			eval_param0.accept(c);
			c.VIRTUAL(PageList.class, "removeIf").parameter(Predicate.class).INVOKE();
		});
		return false; // int.class);
	}

	@Override
	public Stream<PojoClassSample> stream() {
		AdvContext context = _contextThreadLocal.get();
		ConsumerWithException<MethodCode> objEval = context.resolve(this);
		byte codeIndex = context.push(Stream.class, c -> {
			objEval.accept(c);
			c.VIRTUAL(PageList.class, "stream").reTurn(Stream.class).INVOKE();
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
			c.VIRTUAL(PageList.class, "parallelStream").reTurn(Stream.class).INVOKE();
		});

		byte magicNumber = (byte) (MAGIC_CODES_NUMBER + codeIndex);

		if (Adv.canProxy(Stream.class)) {
			return Adv.buildProxyClass(Stream.class, PojoClassSample.class, magicNumber);
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
			c.VIRTUAL(PageList.class, "forEach").parameter(Consumer.class).INVOKE();
		});
	}


}
