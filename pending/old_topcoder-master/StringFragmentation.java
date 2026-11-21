public class StringFragmentation {
	public int largestFontSize(String text, int width, int height) {
		int maxFontSize = -1;
		for (int fontSize = 8; canContain(text, width, height, fontSize); fontSize++) {
			maxFontSize = fontSize;
		}
		return maxFontSize;
	}

	boolean canContain(String text, int width, int height, int fontSize) {
		int row = height / (2 * fontSize);
		int column = width / (fontSize + 2);
		String words[] = text.split(" ");
		int x = 0;
		int y = 0;
		for (String word : words) {
			int wordLength = word.length();
			if (wordLength > column) {
				return false;
			}
			if (y + wordLength <= column) {
				y += wordLength + 1;
			} else {
				x++;
				y = wordLength + 1;
			}
			if (x >= row) {
				return false;
			}
		}
		return true;
	}
}
