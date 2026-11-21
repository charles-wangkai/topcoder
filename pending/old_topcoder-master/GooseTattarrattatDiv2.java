import java.util.HashMap;
import java.util.Map;

public class GooseTattarrattatDiv2 {
	public int getmin(String S) {
		Map<Character, Integer> ch2count = new HashMap<Character, Integer>();
		for (char ch : S.toCharArray()) {
			if (!ch2count.containsKey(ch)) {
				ch2count.put(ch, 0);
			}
			ch2count.put(ch, ch2count.get(ch) + 1);
		}

		int maxCount = 0;
		for (int count : ch2count.values()) {
			maxCount = Math.max(maxCount, count);
		}
		return S.length() - maxCount;
	}
}
