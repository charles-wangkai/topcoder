public class BadVocabulary {
	public int count(String badPrefix, String badSuffix, String badSubstring,
			String[] vocabulary) {
		int badNum = 0;
		for (String word : vocabulary) {
			if (word.startsWith(badPrefix)
					|| word.endsWith(badSuffix)
					|| (word.length() > 2 && word.substring(1,
							word.length() - 1).contains(badSubstring))) {
				badNum++;
			}
		}
		return badNum;
	}
}
