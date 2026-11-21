public class VowelEncryptor {
	public String[] encrypt(String[] text) {
		String encrypted[] = new String[text.length];
		for (int i = 0; i < encrypted.length; i++) {
			encrypted[i] = text[i].replaceAll("[aeiou]", "");
			if (encrypted[i].equals("")) {
				encrypted[i] = text[i];
			}
		}
		return encrypted;
	}
}
