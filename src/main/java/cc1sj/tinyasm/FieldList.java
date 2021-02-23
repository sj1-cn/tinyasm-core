package cc1sj.tinyasm;

import cc1sj.commons.list.StringListMap;

public class FieldList extends StringListMap<ClassField> {

	public FieldList() {
		super(f -> f.name);
	}

}
