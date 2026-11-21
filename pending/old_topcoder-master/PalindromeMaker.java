public class PalindromeMaker {
	public String make(String baseString) {
		int counts[] = new int[26];
		for (int i = 0; i < baseString.length(); i++) {
			counts[baseString.charAt(i) - 'A']++;
		}
		Character middle = null;
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] % 2 != 0) {
				if (middle != null || baseString.length() % 2 == 0) {
					return "";
				}
				middle = (char) (i + 'A');
			}
			counts[i] /= 2;
		}
		String palindrome = middle == null ? "" : (middle + "");
		for (int i = counts.length - 1; i >= 0; i--) {
			char ch = (char) (i + 'A');
			for (int j = 0; j < counts[i]; j++) {
				palindrome = ch + palindrome + ch;
			}
		}
		return palindrome;
	}
}
