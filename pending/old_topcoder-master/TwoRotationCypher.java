public class TwoRotationCypher {
	public String encrypt(int firstSize, int firstRotate, int secondRotate,
			String message) {
		String result = "";
		for (int i = 0; i < message.length(); i++) {
			char ch = message.charAt(i);
			if (ch == ' ') {
				result += ch;
			} else if (ch < 'a' + firstSize) {
				result += (char) ((ch - 'a' + firstRotate) % firstSize + 'a');
			} else {
				result += (char) ((ch - 'a' - firstSize + secondRotate)
						% (26 - firstSize) + 'a' + firstSize);
			}
		}
		return result;
	}
}
