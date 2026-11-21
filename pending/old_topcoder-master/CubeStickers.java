import java.util.HashMap;

public class CubeStickers {
	public String isPossible(String[] sticker) {
		HashMap<String, Integer> color2count = new HashMap<String, Integer>();
		for (String color : sticker) {
			if (!color2count.containsKey(color)) {
				color2count.put(color, 0);
			}
			color2count.put(color, color2count.get(color) + 1);
		}
		int possibleNum = 0;
		for (int count : color2count.values()) {
			possibleNum += Math.min(count, 2);
		}
		if (possibleNum >= 6) {
			return "YES";
		} else {
			return "NO";
		}
	}
}
