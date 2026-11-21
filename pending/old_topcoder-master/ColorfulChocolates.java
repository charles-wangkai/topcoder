import java.util.ArrayList;
import java.util.HashMap;

public class ColorfulChocolates {
	public int maximumSpread(String chocolates, int maxSwaps) {
		HashMap<Character, ArrayList<Integer>> color2positions = new HashMap<Character, ArrayList<Integer>>();
		for (int i = 0; i < chocolates.length(); i++) {
			char ch = chocolates.charAt(i);
			ArrayList<Integer> positions;
			if (color2positions.containsKey(ch)) {
				positions = color2positions.get(ch);
			} else {
				positions = new ArrayList<Integer>();
				color2positions.put(ch, positions);
			}
			positions.add(i);
		}
		int maxSpread = -1;
		for (ArrayList<Integer> positions : color2positions.values()) {
			for (int spread = positions.size();; spread--) {
				boolean found = false;
				for (int center = 0; center < positions.size(); center++) {
					for (int left = 0; left <= center; left++) {
						int right = spread - 1 - left;
						if (right >= 0 && right < positions.size() - center) {
							int swap = 0;
							for (int i = 1; i <= left; i++) {
								swap += (positions.get(center) - i)
										- positions.get(center - i);
							}
							for (int i = 1; i <= right; i++) {
								swap += positions.get(center + i)
										- (positions.get(center) + i);
							}
							if (swap <= maxSwaps) {
								found = true;
								break;
							}
						}
					}
					if (found) {
						break;
					}
				}
				if (found) {
					maxSpread = Math.max(maxSpread, spread);
					break;
				}
			}
		}
		return maxSpread;
	}
}
