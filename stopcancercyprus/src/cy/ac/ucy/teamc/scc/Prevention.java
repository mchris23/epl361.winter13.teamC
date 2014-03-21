package cy.ac.ucy.teamc.scc;

public class Prevention {
	int id;
	String name;
	String description;

	public Prevention(int i, String n, String d) {
		id = i;
		name = n;
		description = d;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
