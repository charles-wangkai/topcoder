public class EqualSubstrings {
	public String[] getSubstrings(String str) {
		int countA = 0;
		int countB = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a') {
				countA++;
			}
		}
		for (int i = str.length();; i--) {
			if (countA == countB) {
				return new String[] { str.substring(0, i), str.substring(i) };
			}
			char nextCh = str.charAt(i - 1);
			if (nextCh == 'a') {
				countA--;
			} else if (nextCh == 'b') {
				countB++;
			}
		}
	}
}
