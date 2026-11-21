import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.Map.Entry;

public class Solver {
	HashMap<String, Person> people;
	int max;

	public int largest(String[] lovers) {
		people = new HashMap<String, Person>();
		String left[] = new String[lovers.length];
		String right[] = new String[lovers.length];
		for (int i = 0; i < lovers.length; i++) {
			String str[] = lovers[i].split(" ");
			left[i] = str[0];
			right[i] = str[2];
			if (!people.containsKey(left[i])) {
				people.put(left[i], new Person());
			}
			if (!people.containsKey(right[i])) {
				people.put(right[i], new Person());
			}
		}
		for (int i = 0; i < lovers.length; i++) {
			people.get(left[i]).targets.add(right[i]);
		}
		max = 2;
		Iterator<Entry<String, Person>> iterator = people.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, Person> one = iterator.next();
			one.getValue().visited = true;
			DFS(one.getKey(), one.getKey(), 0);
			one.getValue().visited = false;
		}
		return max;
	}

	void DFS(String start, String name, int count) {
		if (start.equals(name) && count > 0) {
			if (count > max) {
				max = count;
			}
		} else {
			Iterator<String> iterator = people.get(name).targets.iterator();
			while (iterator.hasNext()) {
				String target = iterator.next();
				Person person = people.get(target);
				if (!person.visited || target.equals(start)) {
					person.visited = true;
					DFS(start, target, count + 1);
					person.visited = false;
				}
			}
		}
	}
}

class Person {
	TreeSet<String> targets = new TreeSet<String>();
	boolean visited;
}
