import java.util.HashSet;

public class TheSwap {
	int result = -1;
	HashSet<String>[] history;

	@SuppressWarnings("unchecked")
	public int findMax(int n, int k) {
		history = new HashSet[k + 1];
		for (int i = 0; i < history.length; i++) {
			history[i] = new HashSet<String>();
		}
		search(n + "", k);
		return result;
	}

	void search(String str, int swapRest) {
		if (history[swapRest].contains(str)) {
			return;
		}
		history[swapRest].add(str);
		if (swapRest == 0) {
			result = Math.max(result, Integer.parseInt(str));
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				String next = str.substring(0, i) + str.charAt(j)
						+ str.substring(i + 1, j) + str.charAt(i)
						+ str.substring(j + 1);
				if (!next.startsWith("0")) {
					search(next, swapRest - 1);
				}
			}
		}
	}
}
