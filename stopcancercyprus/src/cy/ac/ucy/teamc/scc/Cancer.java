package cy.ac.ucy.teamc.scc;

public class Cancer {

	int id;
	String name;
	String description;

	public Cancer(int i, String n, String d) {
		id = i;
		name = n;
		description = d;
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

	public int getId() {
		return id;
	}

}
