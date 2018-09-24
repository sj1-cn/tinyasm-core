package nebula.tinyasm;

import nebula.commons.list.StringListMap;

public class FieldList extends StringListMap<ClassField> {

	public FieldList() {
		super(f -> f.name);
	}

}
