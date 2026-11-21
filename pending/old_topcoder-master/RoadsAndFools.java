import java.util.HashMap;
import java.util.Map.Entry;

public class RoadsAndFools {
	public String determineOrientation(int length, int[] frontSides) {
		HashMap<Integer, String> milestone2solution = new HashMap<Integer, String>();
		milestone2solution.put(-1, "");
		for (int frontSide : frontSides) {
			HashMap<Integer, String> nextMilestone2solution = new HashMap<Integer, String>();
			int sides[];
			if (frontSide * 2 == length) {
				sides = new int[] { frontSide };
			} else {
				sides = new int[] { frontSide, length - frontSide };
			}
			for (int side : sides) {
				for (Entry<Integer, String> entry : milestone2solution
						.entrySet()) {
					if (entry.getKey() < side) {
						if (nextMilestone2solution.containsKey(side)) {
							nextMilestone2solution.put(side, null);
						} else {
							String prevSolution = entry.getValue();
							String solution;
							if (prevSolution == null) {
								solution = null;
							} else {
								solution = prevSolution
										+ (prevSolution.equals("") ? "" : " ")
										+ side;
							}
							nextMilestone2solution.put(side, solution);
						}
					}
				}
			}
			milestone2solution = nextMilestone2solution;
		}
		if (milestone2solution.isEmpty()) {
			return "NO SOLUTION";
		} else {
			String solution = milestone2solution.values().iterator().next();
			if (solution == null || milestone2solution.size() > 1) {
				return "MULTIPLE SOLUTIONS";
			} else {
				return solution;
			}
		}
	}
}
