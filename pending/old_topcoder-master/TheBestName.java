import java.util.Arrays;
import java.util.Comparator;

public class TheBestName {
	public String[] sort(String[] names) {
		Arrays.sort(names, new NameComparator());
		return names;
	}
}

class NameComparator implements Comparator<String> {
	public int compare(String name1, String name2) {
		int weight1 = calcWeight(name1);
		int weight2 = calcWeight(name2);
		if (!name2.equals("JOHN")
				&& (name1.equals("JOHN") || weight1 > weight2 || (weight1 == weight2 && name1
						.compareTo(name2) <= 0))) {
			return -1;
		} else {
			return 1;
		}
	}

	int calcWeight(String name) {
		int weight = 0;
		for (int i = 0; i < name.length(); i++) {
			weight += name.charAt(i) - 'A' + 1;
		}
		return weight;
	}
}