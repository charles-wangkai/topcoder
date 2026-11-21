import java.util.ArrayList;
import java.util.Collections;

public class SuperSort {
	public String wordSort(String sentence) {
		ArrayList<String> intervals = new ArrayList<String>();
		ArrayList<String> words = new ArrayList<String>();
		String interval = "";
		String word = null;
		boolean readInterval = true;
		for (int i = 0; i < sentence.length(); i++) {
			char ch = sentence.charAt(i);
			if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
				if (readInterval) {
					intervals.add(interval);
					word = ch + "";
					readInterval = false;
				} else {
					word += ch;
				}
			} else {
				if (readInterval) {
					interval += ch;
				} else {
					words.add(word);
					interval = ch + "";
					readInterval = true;
				}
			}
		}
		if (readInterval) {
			intervals.add(interval);
		} else {
			words.add(word);
			intervals.add("");
		}
		Collections.sort(words);
		String result = "";
		for (int i = 0; i < words.size(); i++) {
			result += intervals.get(i) + words.get(i);
		}
		result += intervals.get(intervals.size() - 1);
		return result;
	}
}
