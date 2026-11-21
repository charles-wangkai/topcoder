public class ColoredStrokes {
	public int getLeast(String[] picture) {
		return countStroke(picture, 1, 0, 0, 1, "RG")
				+ countStroke(picture, 0, 1, 1, 0, "BG");
	}

	int countStroke(String[] picture, int outerOffsetX, int outerOffsetY,
			int innerOffsetX, int innerOffsetY, String target) {
		int strokeNum = 0;
		int row = picture.length;
		int column = picture[0].length();
		int outerX = 0;
		int outerY = 0;
		while (isValid(row, column, outerX, outerY)) {
			int x = outerX;
			int y = outerY;
			boolean previous = false;
			while (isValid(row, column, x, y)) {
				boolean current = target.contains(picture[x].charAt(y) + "");
				if (current && !previous) {
					strokeNum++;
				}
				previous = current;
				x += innerOffsetX;
				y += innerOffsetY;
			}
			outerX += outerOffsetX;
			outerY += outerOffsetY;
		}
		return strokeNum;
	}

	boolean isValid(int row, int column, int x, int y) {
		return x >= 0 && x < row && y >= 0 && y < column;
	}
}
