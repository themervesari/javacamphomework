package oopWithNLayeredApp.entities;

public class Instructor {
	public Instructor() {

	}

	private int id;
	private String firstName;
	private String lasName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLasName() {
		return lasName;
	}

	public void setLasName(String lasName) {
		this.lasName = lasName;
	}

	public Instructor(int id, String firstName, String lasName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lasName = lasName;
	}
}
