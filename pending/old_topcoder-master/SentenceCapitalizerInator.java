public class SentenceCapitalizerInator {
	public String fixCaps(String paragraph) {
		String sentences[] = paragraph.split("\\. ");
		String result = "";
		for (int i = 0; i < sentences.length; i++) {
			if (i != 0) {
				result += ". ";
			}
			result += "" + Character.toUpperCase(sentences[i].charAt(0))
					+ sentences[i].substring(1);
		}
		return result;
	}
}
