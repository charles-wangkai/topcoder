import java.util.Arrays;
import java.util.HashSet;

public class SimpleWordGame {
	public int points(String[] player, String[] dictionary) {
		HashSet<String> dict = new HashSet<String>(Arrays.asList(dictionary));
		HashSet<String> words = new HashSet<String>(Arrays.asList(player));
		int point = 0;
		for (String word : words) {
			if (dict.contains(word)) {
				point += word.length() * word.length();
			}
		}
		return point;
	}
}
