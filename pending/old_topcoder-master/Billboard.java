public class Billboard {
	public String[] enlarge(String message, String[] letters) {
		String result[] = new String[5];
		for (int i = 0; i < 5; i++) {
			result[i] = "";
		}
		for (int i = 0; i < message.length(); i++) {
			if (i != 0) {
				for (int j = 0; j < 5; j++) {
					result[j] += ".";
				}
			}
			for (int j = 0; j < letters.length; j++) {
				if (message.charAt(i) == letters[j].charAt(0)) {
					for (int k = 0; k < 5; k++) {
						result[k] += letters[j].substring(k * 6 + 2, k * 6 + 7);
					}
				}
			}
		}
		return result;
	}
}
