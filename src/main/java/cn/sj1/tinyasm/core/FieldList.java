package cn.sj1.tinyasm.core;

import cn.sj1.commons.list.StringListMap;

public class FieldList extends StringListMap<ClassField> {

	public FieldList() {
		super(f -> f.name);
	}

}
