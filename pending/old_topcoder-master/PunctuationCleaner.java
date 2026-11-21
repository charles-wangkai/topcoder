public class PunctuationCleaner {
	public String clearExcess(String document) {
		return document.replaceAll("[?!]*\\?[?!]*", "?").replaceAll("!+", "!");
	}
}
