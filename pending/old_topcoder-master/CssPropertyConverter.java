public class CssPropertyConverter {
	public String getCamelized(String cssPropertyName) {
		String words[] = cssPropertyName.split("-");
		String camelized = words[0];
		for (int i = 1; i < words.length; i++) {
			camelized += Character.toUpperCase(words[i].charAt(0))
					+ words[i].substring(1);
		}
		return camelized;
	}
}
