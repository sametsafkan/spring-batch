package components;

import java.util.ArrayList;
import java.util.List;

public class PersonGenerator {

	public List<Person> generatePerson() {
		List<Person> personList = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			Person p1 = new Person("Samet" + i, "Safkan" + i, true, false);
			Person p2 = new Person("Semih" + i, "Safkan" + i, false, true);
			Person p3 = new Person("Erdem" + i, "Safkan" + i, true, true);
			Person p4 = new Person("Aysel" + i, "Safkan" + i, false, false);
			personList.add(p1);
			personList.add(p2);
			personList.add(p3);
			personList.add(p4);
		}
		return personList;
	}

}
