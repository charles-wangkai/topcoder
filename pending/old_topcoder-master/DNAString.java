import java.util.HashMap;

public class DNAString {
	public int minChanges(int maxPeriod, String[] dna) {
		String whole = "";
		for (String oneDna : dna) {
			whole += oneDna;
		}
		int minChange = Integer.MAX_VALUE;
		for (int period = 1; period <= maxPeriod; period++) {
			int change = 0;
			for (int start = 0; start < period; start++) {
				HashMap<Character, Integer> letter2count = new HashMap<Character, Integer>();
				for (int i = start; i < whole.length(); i += period) {
					char letter = whole.charAt(i);
					if (!letter2count.containsKey(letter)) {
						letter2count.put(letter, 0);
					}
					letter2count.put(letter, letter2count.get(letter) + 1);
				}
				int totalCount = 0;
				int maxCount = 0;
				for (int count : letter2count.values()) {
					totalCount += count;
					maxCount = Math.max(maxCount, count);
				}
				change += totalCount - maxCount;
			}
			minChange = Math.min(minChange, change);
		}
		return minChange;
	}
}
