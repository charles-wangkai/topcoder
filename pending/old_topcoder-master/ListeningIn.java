public class ListeningIn {
	public String probableMatch(String typed, String phrase) {
		int indexTyped = 0;
		String removed = "";
		for (int indexPhrase = 0; indexPhrase < phrase.length(); indexPhrase++) {
			char chPhrase = phrase.charAt(indexPhrase);
			if (chPhrase == typed.charAt(indexTyped)) {
				indexTyped++;
				if (indexTyped == typed.length()) {
					removed += phrase.substring(indexPhrase + 1);
					return removed;
				}
			} else {
				removed += chPhrase;
			}
		}
		return "UNMATCHED";
	}
}
