public class PrefixCode {
	public String isOne(String[] words) {
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words.length; j++) {
				if (j == i) {
					continue;
				}
				if (words[j].startsWith(words[i])) {
					return "No, " + i;
				}
			}
		}
		return "Yes";
	}
}
