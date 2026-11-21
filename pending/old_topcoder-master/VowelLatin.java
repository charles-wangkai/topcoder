public class VowelLatin {
	public String translate(String word) {
		return word.replaceAll("[aeiouAEIOU]", "")
				+ word.replaceAll("[^aeiouAEIOU]", "");
	}
}
