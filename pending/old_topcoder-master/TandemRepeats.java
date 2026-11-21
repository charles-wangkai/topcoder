public class TandemRepeats {
	public int maxLength(String dna, int k) {
		int maxLen = 0;
		for (int i = 2; i <= dna.length(); i += 2) {
			for (int j = 0; j + i <= dna.length(); j++) {
				if (isApproximateRepeat(dna.substring(j, j + i), k)) {
					maxLen = i / 2;
				}
			}
		}
		return maxLen;
	}

	boolean isApproximateRepeat(String str, int k) {
		int halfLength = str.length() / 2;
		for (int i = 0; i < halfLength; i++) {
			if (str.charAt(i) != str.charAt(i + halfLength)) {
				if (k == 0) {
					return false;
				}
				k--;
			}
		}
		return true;
	}
}
