import java.util.ArrayList;
import java.util.List;

public class TeamsSelection {
	public String simulate(int[] preference1, int[] preference2) {
		char[] teams = new char[preference1.length];
		@SuppressWarnings("unchecked")
		List<Integer>[] prefs = new List[] { toList(preference1),
				toList(preference2) };
		int index = 0;
		while (!prefs[index].isEmpty()) {
			int chosen = prefs[index].get(0);
			teams[chosen - 1] = (char) ('1' + index);

			prefs[index].remove(0);
			index = 1 - index;
			prefs[index].remove(new Integer(chosen));
		}
		return new String(teams);
	}

	List<Integer> toList(int[] a) {
		List<Integer> result = new ArrayList<Integer>();
		for (int elem : a) {
			result.add(elem);
		}
		return result;
	}
}
