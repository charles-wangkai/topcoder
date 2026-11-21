public class FontSize {
	public int getPixelWidth(String sentence, int[] uppercase, int[] lowercase) {
		int totalWidth = sentence.length() - 1;
		for (int i = 0; i < sentence.length(); i++) {
			char ch = sentence.charAt(i);
			if (Character.isUpperCase(ch)) {
				totalWidth += uppercase[ch - 'A'];
			} else if (Character.isLowerCase(ch)) {
				totalWidth += lowercase[ch - 'a'];
			} else {
				totalWidth += 3;
			}
		}
		return totalWidth;
	}
}
