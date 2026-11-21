import java.util.Arrays;

public class SentenceDecomposition {
	public int decompose(String sentence, String[] validWords) {
		final int INFINITE = Integer.MAX_VALUE;
		int costs[] = new int[sentence.length() + 1];
		Arrays.fill(costs, INFINITE);
		costs[0] = 0;
		for (int i = 0; i < costs.length; i++) {
			if (costs[i] != INFINITE) {
				for (String validWord : validWords) {
					int next = i + validWord.length();
					if (next <= sentence.length()) {
						int currentCost = calcCost(sentence.substring(i, next),
								validWord);
						if (currentCost >= 0) {
							costs[next] = Math.min(costs[next], costs[i]
									+ currentCost);
						}
					}
				}
			}
		}
		return (costs[costs.length - 1] == INFINITE) ? -1
				: costs[costs.length - 1];
	}

	int calcCost(String str1, String str2) {
		if (!getKey(str1).equals(getKey(str2))) {
			return -1;
		}
		int cost = 0;
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				cost++;
			}
		}
		return cost;
	}

	String getKey(String str) {
		int counts[] = new int[26];
		for (int i = 0; i < str.length(); i++) {
			counts[str.charAt(i) - 'a']++;
		}
		String key = "";
		for (int i = 0; i < counts.length; i++) {
			key += (char) ('a' + i) + "" + counts[i];
		}
		return key;
	}
}
