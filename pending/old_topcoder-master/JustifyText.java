public class JustifyText {
	public String[] format(String[] text) {
		int maxLength = -1;
		for (String line : text) {
			maxLength = Math.max(maxLength, line.length());
		}
		String justified[] = new String[text.length];
		for (int i = 0; i < justified.length; i++) {
			justified[i] = "";
			for (int j = 0; j < maxLength - text[i].length(); j++) {
				justified[i] += " ";
			}
			justified[i] += text[i];
		}
		return justified;
	}
}
