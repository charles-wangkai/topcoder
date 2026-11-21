public class TxMsg {
	public String getMessage(String original) {
		final String VOWEL_REGEX = "[aeiou]";
		String words[] = original.split(" ");
		String result = "";
		for (int i = 0; i < words.length; i++) {
			if (i != 0) {
				result += " ";
			}
			if (words[i].replaceAll(VOWEL_REGEX, "").equals("")) {
				result += words[i];
			} else {
				String fields[] = words[i].split(VOWEL_REGEX);
				for (String field : fields) {
					if (!field.equals("")) {
						result += field.charAt(0);
					}
				}
			}
		}
		return result;
	}
}
