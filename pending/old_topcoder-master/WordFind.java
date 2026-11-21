public class WordFind {
	int offsetX[] = { 0, 1, 1 };
	int offsetY[] = { 1, 1, 0 };

	public String[] findWords(String[] grid, String[] wordList) {
		String result[] = new String[wordList.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = "";
			boolean matched = false;
			for (int row = 0; row < grid.length; row++) {
				for (int col = 0; col < grid[0].length(); col++) {
					for (int direction = 0; direction < 3; direction++) {
						if (isMatch(wordList[i], grid, row, col, direction)) {
							result[i] = row + " " + col;
							matched = true;
							break;
						}
					}
					if (matched) {
						break;
					}
				}
				if (matched) {
					break;
				}
			}
		}
		return result;
	}

	boolean isMatch(String word, String grid[], int row, int col, int direction) {
		int length = word.length();
		int lastX = row + offsetX[direction] * (length - 1);
		int lastY = col + offsetY[direction] * (length - 1);
		if (lastX >= grid.length || lastY >= grid[0].length()) {
			return false;
		}
		for (int i = 0; i < length; i++) {
			int x = row + offsetX[direction] * i;
			int y = col + offsetY[direction] * i;
			if (grid[x].charAt(y) != word.charAt(i)) {
				return false;
			}
		}
		return true;
	}
}
