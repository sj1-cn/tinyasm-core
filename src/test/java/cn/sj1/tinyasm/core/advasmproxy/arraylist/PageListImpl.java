package cn.sj1.tinyasm.core.advasmproxy.arraylist;

import java.util.ArrayList;

public class PageListImpl<E> extends ArrayList<E> implements PageList<E> {
	private static final long serialVersionUID = 6276525867983275677L;

	int start;
	int max;
	int totalSize;

	public PageListImpl() {
	}
	
	public PageListImpl(int start, int max) {
		this.start = start;
		this.max = max;
	}

	@Override
	public int getStart() {
		return this.start;
	}

	public void start(int start) {
		this.start = start;
	}

	public void max(int max) {
		this.max = max;
	}

	public void totalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	@Override
	public int getMax() {
		return this.max;
	}

	@Override
	public int getTotalSize() {
		return this.totalSize;
	}

}
