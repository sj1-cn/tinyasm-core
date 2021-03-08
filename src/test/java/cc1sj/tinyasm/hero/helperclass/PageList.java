package cc1sj.tinyasm.hero.helperclass;

import java.util.List;

public interface PageList<E> extends List<E> {
	int getStart();

	int getMax();

	int getTotalSize();

	void start(int start);

	void max(int max);

	void totalSize(int totalSize);
}
