public class WordAbbreviation {
	public String[] getAbbreviations(String[] words) {
		String abbreviations[] = new String[words.length];
		for (int i = 0; i < abbreviations.length; i++) {
			for (int j = 1;; j++) {
				abbreviations[i] = words[i].substring(0, j);
				boolean isOtherPrefix = false;
				for (int k = 0; k < words.length; k++) {
					if (k == i) {
						continue;
					}
					if (words[k].startsWith(abbreviations[i])) {
						isOtherPrefix = true;
						break;
					}
				}
				if (!isOtherPrefix) {
					break;
				}
			}
		}
		return abbreviations;
	}
}
