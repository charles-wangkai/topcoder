public class BreakingTheCode {
	public String decodingEncoding(String code, String message) {
		int numbers[] = new int[26];
		for (int i = 0; i < code.length(); i++) {
			numbers[code.charAt(i) - 'a'] = i + 1;
		}
		String result = "";
		if (Character.isDigit(message.charAt(0))) {
			for (int i = 0; i < message.length(); i += 2) {
				result += code.charAt(Integer.parseInt(message.substring(i,
						i + 2)) - 1);
			}
		} else {
			for (int i = 0; i < message.length(); i++) {
				result += String.format("%02d",
						numbers[message.charAt(i) - 'a']);
			}
		}
		return result;
	}
}
