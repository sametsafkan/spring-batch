package components;

public class CompositeData {

	private NewPerson newPerson;
	private NewPerson2 newPerson2;
	
	public NewPerson getNewPerson() {
		return newPerson;
	}
	public void setNewPerson(NewPerson newPerson) {
		this.newPerson = newPerson;
	}
	public NewPerson2 getNewPerson2() {
		return newPerson2;
	}
	public void setNewPerson2(NewPerson2 newPerson2) {
		this.newPerson2 = newPerson2;
	}
	
	public CompositeData(NewPerson newPerson, NewPerson2 newPerson2) {
		this.newPerson = newPerson;
		this.newPerson2 = newPerson2;
	}
}
