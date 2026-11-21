import java.util.Arrays;
import java.util.Comparator;

public class PrefixFreeSets {
	public int maxElements(String[] words) {
		Arrays.sort(words, new LengthComparator());
		int setSize = 0;
		for (int i = 0; i < words.length; i++) {
			boolean prefix = false;
			for (int j = i + 1; j < words.length; j++) {
				if (words[j].startsWith(words[i])) {
					prefix = true;
					break;
				}
			}
			if (!prefix) {
				setSize++;
			}
		}
		return setSize;
	}
}

class LengthComparator implements Comparator<String> {
	public int compare(String str1, String str2) {
		return str1.length() - str2.length();
	}
}