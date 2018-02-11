package components;

public class Person {
	private String name;
	private String lastName;
	private boolean isNewPerson;
	private boolean isNewPerson2;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public boolean isNewPerson() {
		return isNewPerson;
	}
	public void setNewPerson(boolean isNewPerson) {
		this.isNewPerson = isNewPerson;
	}
	public boolean isNewPerson2() {
		return isNewPerson2;
	}
	public void setNewPerson2(boolean isNewPerson2) {
		this.isNewPerson2 = isNewPerson2;
	}
	
	public Person(String name, String lastName, boolean isNewPerson, boolean isNewPerson2) {
		this.name = name;
		this.lastName = lastName;
		this.isNewPerson = isNewPerson;
		this.isNewPerson2 = isNewPerson2;
	}
}
