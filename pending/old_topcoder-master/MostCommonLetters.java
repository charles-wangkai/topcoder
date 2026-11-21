public class MostCommonLetters {
	public String listMostCommon(String[] text) {
		int counts[] = new int[26];
		for (String t : text) {
			for (int i = 0; i < t.length(); i++) {
				char ch = t.charAt(i);
				if (ch != ' ') {
					counts[ch - 'a']++;
				}
			}
		}
		int maxCount = -1;
		String result = "";
		for (int i = 0; i < counts.length; i++) {
			char ch = (char) (i + 'a');
			if (counts[i] > maxCount) {
				result = ch + "";
				maxCount = counts[i];
			} else if (counts[i] == maxCount) {
				result += ch;
			}
		}
		return result;
	}
}
