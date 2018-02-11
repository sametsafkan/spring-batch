package components;

public class NewPerson {

	private String nameLastName;

	public String getNameLastName() {
		return nameLastName;
	}

	public void setNameLastName(String nameLastName) {
		this.nameLastName = nameLastName;
	}
	
	public NewPerson(String nameLastName) {
		this.nameLastName = nameLastName;
	}
}
