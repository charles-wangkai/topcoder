public class Painting {
	public int largestBrush(String[] picture) {
		int row = picture.length;
		int column = picture[0].length();
		for (int i = Math.min(row, column);; i--) {
			if (canPaint(picture, row, column, i)) {
				return i;
			}
		}
	}

	boolean canPaint(String picture[], int row, int column, int size) {
		boolean painted[][] = new boolean[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (picture[i].charAt(j) == 'B'
						&& allBlack(picture, row, column, i, j, size)) {
					for (int p = i; p < i + size; p++) {
						for (int q = j; q < j + size; q++) {
							painted[p][q] = true;
						}
					}
				}
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (picture[i].charAt(j) == 'B' && !painted[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	boolean allBlack(String picture[], int row, int column, int startX,
			int startY, int size) {
		if (startX + size > row || startY + size > column) {
			return false;
		}
		for (int i = startX; i < startX + size; i++) {
			for (int j = startY; j < startY + size; j++) {
				if (picture[i].charAt(j) == 'W') {
					return false;
				}
			}
		}
		return true;
	}
}
