public class HuffmanDecoding {
	public String decode(String archive, String[] dictionary) {
		String result = "";
		while (!archive.equals("")) {
			for (int i = 1;; i++) {
				Character letter = decode(dictionary, archive.substring(0, i));
				if (letter != null) {
					result += letter;
					archive = archive.substring(i);
					break;
				}
			}
		}
		return result;
	}

	Character decode(String dictionary[], String code) {
		for (int i = 0; i < dictionary.length; i++) {
			if (code.equals(dictionary[i])) {
				return (char) ('A' + i);
			}
		}
		return null;
	}
}
