public class Justifier {
	public String[] justify(String[] textIn) {
		int maxLength = -1;
		for (String text : textIn) {
			maxLength = Math.max(maxLength, text.length());
		}
		String justified[] = new String[textIn.length];
		for (int i = 0; i < justified.length; i++) {
			justified[i] = "";
			for (int j = 0; j < maxLength - textIn[i].length(); j++) {
				justified[i] += " ";
			}
			justified[i] += textIn[i];
		}
		return justified;
	}
}
