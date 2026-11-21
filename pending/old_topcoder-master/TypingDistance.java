import java.util.HashMap;

public class TypingDistance {
	public int minDistance(String keyboard, String word) {
		HashMap<Character, Integer> letter2pos = new HashMap<Character, Integer>();
		for (int i = 0; i < keyboard.length(); i++) {
			letter2pos.put(keyboard.charAt(i), i);
		}
		int distance = 0;
		for (int i = 0; i < word.length() - 1; i++) {
			distance += Math.abs(letter2pos.get(word.charAt(i + 1))
					- letter2pos.get(word.charAt(i)));
		}
		return distance;
	}
}
