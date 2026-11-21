import java.util.Collection;
import java.util.HashMap;

public class RoughStrings {
	public int minRoughness(String s, int n) {
		HashMap<Character, Integer> letter2count = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char letter = s.charAt(i);
			if (!letter2count.containsKey(letter)) {
				letter2count.put(letter, 0);
			}
			letter2count.put(letter, letter2count.get(letter) + 1);
		}
		int minRough = Integer.MAX_VALUE;
		Collection<Integer> counts = letter2count.values();
		for (int maxOccur = 1; maxOccur <= s.length(); maxOccur++) {
			for (int minOccur = 1; minOccur <= maxOccur; minOccur++) {
				int erase = 0;
				for (int count : counts) {
					if (count < minOccur) {
						erase += count;
					} else if (count > maxOccur) {
						erase += count - maxOccur;
					}
				}
				if (erase <= n) {
					minRough = Math.min(minRough, maxOccur - minOccur);
				}
			}
		}
		return minRough;
	}
}
