package nebula.module.definedTables;

public class DefinedTableThin {

	private String id;

	private String name;

	public DefinedTableThin(String name) {
		this.id = name;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
