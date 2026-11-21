public class ChocolateBar {
	public int maxLength(String letters) {
		int maxLen = 1;
		for (int i = 0; i < letters.length(); i++) {
			for (int j = i + 1; j < letters.length(); j++) {
				if (containRepeated(letters.substring(i, j + 1))) {
					break;
				}
				maxLen = Math.max(maxLen, j - i + 1);
			}
		}
		return maxLen;
	}

	boolean containRepeated(String str) {
		boolean used[] = new boolean[26];
		for (int i = 0; i < str.length(); i++) {
			int index = str.charAt(i) - 'a';
			if (used[index]) {
				return true;
			}
			used[index] = true;
		}
		return false;
	}
}
