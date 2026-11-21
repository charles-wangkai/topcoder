public class Hyphenated {
	public double avgLength(String[] lines) {
		String text = "";
		for (String line : lines) {
			if (!line.equals("") && Character.isLetter(line.charAt(0))
					&& text.length() >= 2
					&& text.charAt(text.length() - 1) == '-'
					&& Character.isLetter(text.charAt(text.length() - 2))) {
				text = text.substring(0, text.length() - 1) + line;
			} else {
				text += " " + line;
			}
		}
		String words[] = text.replace('-', ' ').replace('.', ' ').split(" ");
		int totalLength = 0;
		int wordNum = 0;
		for (String word : words) {
			totalLength += word.length();
			if (!word.equals("")) {
				wordNum++;
			}
		}
		return (double) totalLength / wordNum;
	}
}
