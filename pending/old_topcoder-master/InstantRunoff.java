import java.util.HashMap;
import java.util.Map.Entry;

public class InstantRunoff {
	public String outcome(String candidates, String[] ballots) {
		while (!candidates.equals("")) {
			HashMap<Character, Integer> candidate2count = new HashMap<Character, Integer>();
			for (int i = 0; i < candidates.length(); i++) {
				candidate2count.put(candidates.charAt(i), 0);
			}
			for (String ballot : ballots) {
				char first = ballot.charAt(0);
				candidate2count.put(first, candidate2count.get(first) + 1);
			}
			int minCount = Integer.MAX_VALUE;
			int maxCount = Integer.MIN_VALUE;
			for (int count : candidate2count.values()) {
				minCount = Math.min(minCount, count);
				maxCount = Math.max(maxCount, count);
			}
			if (maxCount * 2 > ballots.length) {
				for (Entry<Character, Integer> entry : candidate2count
						.entrySet()) {
					if (entry.getValue() == maxCount) {
						return entry.getKey().toString();
					}
				}
			}
			for (Entry<Character, Integer> entry : candidate2count.entrySet()) {
				if (entry.getValue() == minCount) {
					char candidate = entry.getKey();
					candidates = candidates.replace(candidate + "", "");
					for (int i = 0; i < ballots.length; i++) {
						ballots[i] = ballots[i].replace(candidate + "", "");
					}
				}
			}
		}
		return "";
	}
}
