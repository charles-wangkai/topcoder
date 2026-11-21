public class TheEncryptionDivTwo {
	public String encrypt(String message) {
		char cipher[] = new char[26];
		char sub = 'a';
		String encoded = "";
		for (int i = 0; i < message.length(); i++) {
			int index = message.charAt(i) - 'a';
			if (cipher[index] == 0) {
				cipher[index] = sub;
				sub++;
			}
			encoded += cipher[index];
		}
		return encoded;
	}
}
