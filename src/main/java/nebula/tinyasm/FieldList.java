package nebula.tinyasm;

import nebula.tinyasm.data.ArrayListMap;

public class FieldList extends ArrayListMap<ClassField> {

	public FieldList() {
		super(f -> f.name);
	}

}
