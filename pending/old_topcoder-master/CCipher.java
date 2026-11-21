public class CCipher {
	public String decode(String cipherText, int shift) {
		String result = "";
		for (int i = 0; i < cipherText.length(); i++) {
			result += (char) ((cipherText.charAt(i) - 'A' - shift + 26) % 26 + 'A');
		}
		return result;
	}
}
