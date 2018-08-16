package nebula.module;

public class Pet {

	private Long id;

	private String name;

	private String desciption;

	public Pet(Long id, String name, String desciption) {
		this.id = id;
		this.name = name;
		this.desciption = desciption;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDesciption() {
		return desciption;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", desciption=" + desciption + "]";
	}
	
}
