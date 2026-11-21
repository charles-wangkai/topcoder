import java.util.Arrays;

public class MatchMaking {
	public String makeMatch(String[] namesWomen, String[] answersWomen,
			String[] namesMen, String[] answersMen, String queryWoman) {
		Person women[] = buildPersons(namesWomen, answersWomen);
		Person men[] = buildPersons(namesMen, answersMen);
		Arrays.sort(women);
		Arrays.sort(men);
		for (int i = 0;; i++) {
			int maxMatchNum = -1;
			Person matchedMan = null;
			for (Person man : men) {
				if (man.answer == null) {
					continue;
				}
				int matchNum = 0;
				for (int j = 0; j < man.answer.length(); j++) {
					if (man.answer.charAt(j) == women[i].answer.charAt(j)) {
						matchNum++;
					}
				}
				if (matchNum > maxMatchNum) {
					maxMatchNum = matchNum;
					matchedMan = man;
				}
			}
			matchedMan.answer = null;
			if (women[i].name.equals(queryWoman)) {
				return matchedMan.name;
			}
		}
	}

	Person[] buildPersons(String names[], String answers[]) {
		Person persons[] = new Person[names.length];
		for (int i = 0; i < persons.length; i++) {
			persons[i] = new Person(names[i], answers[i]);
		}
		return persons;
	}
}

class Person implements Comparable<Person> {
	String name;
	String answer;

	Person(String name, String answer) {
		this.name = name;
		this.answer = answer;
	}

	public int compareTo(Person other) {
		return name.compareTo(other.name);
	}
}