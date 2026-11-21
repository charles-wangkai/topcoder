public class SMSLanguage {
	public String translate(String text) {
		text = text.toLowerCase();
		String regex[] = { "[.,?!]", "and", "ate", "at", "you" };
		String replacements[] = { "", "&", "8", "@", "U" };
		for (int i = 0; i < regex.length; i++) {
			text = text.replaceAll(regex[i], replacements[i]);
		}
		return text;
	}
}
