import java.util.ArrayList;

public class LetterRange {
	public String[] ranges(String text) {
		boolean used[] = new boolean[26];
		for (int i = 0; i < text.length(); i++) {
			char ch = text.charAt(i);
			if (ch != ' ') {
				used[ch - 'a'] = true;
			}
		}
		ArrayList<String> result = new ArrayList<String>();
		boolean power = false;
		int start = -1;
		for (int i = 0; i < 26; i++) {
			if (!power && used[i]) {
				start = i;
				power = true;
			} else if (power && !used[i]) {
				result.add((char) ('a' + start) + ":" + (char) ('a' + i - 1));
				power = false;
			}
		}
		if (power) {
			result.add((char) ('a' + start) + ":z");
		}
		return result.toArray(new String[] {});
	}
}
