import java.util.Arrays;

public class MnemonicMemory {
	public String getPhrase(String number, String[] dictionary) {
		String phrase = "";
		Arrays.sort(dictionary);
		boolean used[] = new boolean[dictionary.length];
		for (int i = 0; i < number.length(); i++) {
			if (!phrase.equals("")) {
				phrase += " ";
			}
			for (int j = 0; j < dictionary.length; j++) {
				if (!used[j]
						&& dictionary[j].length() == number.charAt(i) - '0') {
					phrase += dictionary[j];
					used[j] = true;
					break;
				}
			}
		}
		return phrase;
	}
}
