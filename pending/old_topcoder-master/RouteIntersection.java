import java.util.HashSet;
import java.util.TreeMap;

public class RouteIntersection {
	@SuppressWarnings("unchecked")
	public String isValid(int N, int[] coords, String moves) {
		TreeMap<Integer, Integer> current = new TreeMap<Integer, Integer>();
		HashSet<TreeMap<Integer, Integer>> history = new HashSet<TreeMap<Integer, Integer>>();
		history.add((TreeMap<Integer, Integer>) current.clone());
		for (int i = 0; i < coords.length; i++) {
			move(current, coords[i], (moves.charAt(i) == '+') ? 1 : -1);
			if (history.contains(current)) {
				return "NOT VALID";
			}
			history.add((TreeMap<Integer, Integer>) current.clone());
		}
		return "VALID";
	}

	void move(TreeMap<Integer, Integer> current, int coord, int offset) {
		if (current.containsKey(coord)) {
			int value = current.get(coord) + offset;
			if (value == 0) {
				current.remove(coord);
			} else {
				current.put(coord, value);
			}
		} else {
			current.put(coord, offset);
		}
	}
}
