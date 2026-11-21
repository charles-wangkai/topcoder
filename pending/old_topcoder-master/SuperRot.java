public class SuperRot {
	public String decoder(String message) {
		String result = "";
		for (int i = 0; i < message.length(); i++) {
			char ch = message.charAt(i);
			if (Character.isUpperCase(ch)) {
				result += (char) ((ch - 'A' + 13) % 26 + 'A');
			} else if (Character.isLowerCase(ch)) {
				result += (char) ((ch - 'a' + 13) % 26 + 'a');
			} else if (Character.isDigit(ch)) {
				result += (char) ((ch - '0' + 5) % 10 + '0');
			} else {
				result += ch;
			}
		}
		return result;
	}
}
