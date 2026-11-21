public class SimpleRotationDecoder {
	public String decode(String cipherText) {
		for (char ch1 = 'a';; ch1++) {
			for (char ch2 = 'a'; ch2 <= 'z'; ch2++) {
				for (char ch3 = 'a'; ch3 <= 'z'; ch3++) {
					String password = "" + ch1 + ch2 + ch3;
					String original = decipher(cipherText, password);
					if (isValid(original)) {
						return original;
					}
				}
			}
		}
	}

	String decipher(String cipherText, String password) {
		String original = "";
		for (int i = 0; i < cipherText.length(); i++) {
			int number = (letter2number(cipherText.charAt(i))
					- letter2number(password.charAt(i % 3)) + 27) % 27;
			original += number2letter(number);
		}
		return original;
	}

	char number2letter(int number) {
		if (number == 0) {
			return ' ';
		} else {
			return (char) (number - 1 + 'a');
		}
	}

	int letter2number(char letter) {
		if (letter == ' ') {
			return 0;
		} else {
			return letter - 'a' + 1;
		}
	}

	boolean isValid(String original) {
		if (original.startsWith(" ") || original.endsWith(" ")
				|| original.contains("  ")) {
			return false;
		}
		String words[] = original.split(" ");
		for (String word : words) {
			int length = word.length();
			if (!(length >= 2 && length <= 8 && (word.contains("a")
					|| word.contains("e") || word.contains("i")
					|| word.contains("o") || word.contains("u")))) {
				return false;
			}
		}
		return true;
	}
}
