public class UnderscoreJustification {
	public String justifyLine(String[] words, int width) {
		int totalSpace = width;
		for (String word : words) {
			totalSpace -= word.length();
		}
		int averageSpace = totalSpace / (words.length - 1);
		int extraSpace = totalSpace - averageSpace * (words.length - 1);
		String result = "";
		for (int i = 0; i < words.length; i++) {
			if (i > 0) {
				for (int j = 0; j < averageSpace; j++) {
					result += "_";
				}
				if (extraSpace == words.length - i
						|| (extraSpace > 0 && '_' < words[i].charAt(0))) {
					result += "_";
					extraSpace--;
				}
			}
			result += words[i];
		}
		return result;
	}
}
