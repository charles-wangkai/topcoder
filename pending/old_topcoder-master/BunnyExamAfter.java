public class BunnyExamAfter {
	public int getMaximum(String black, String gray, String white) {
		int max = 0;
		for (int i = 0; i < black.length(); i++) {
			char blackAnswer = black.charAt(i);
			char grayAnswer = gray.charAt(i);
			char whiteAnswer = white.charAt(i);
			if (grayAnswer == whiteAnswer) {
				if (grayAnswer != blackAnswer) {
					max += 2;
				}
			} else {
				max++;
			}
		}
		return max;
	}
}
