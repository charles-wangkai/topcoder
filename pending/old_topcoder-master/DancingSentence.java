public class DancingSentence {
	public String makeDancing(String sentence) {
		String dancing = "";
		boolean uppercase = true;
		for (int i = 0; i < sentence.length(); i++) {
			char ch = sentence.charAt(i);
			if (ch == ' ') {
				dancing += ch;
			} else {
				if (uppercase) {
					dancing += Character.toUpperCase(ch);
				} else {
					dancing += Character.toLowerCase(ch);
				}
				uppercase = !uppercase;
			}
		}
		return dancing;
	}
}
