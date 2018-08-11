package nebula.module.definedTables;

import java.util.List;

public class DefinedTable extends DefinedTableThin {

	private List<DefinedColumn> columns;

	public List<DefinedColumn> getColumns() {
		return columns;
	}

	public DefinedTable(String name, List<DefinedColumn> columns) {
		super(name);
		this.columns = columns;
	}

}
