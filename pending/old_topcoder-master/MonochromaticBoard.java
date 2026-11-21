public class MonochromaticBoard {
	public int theMin(String[] board) {
		int row = board.length;
		int column = board[0].length();
		boolean rowWhites[] = new boolean[row];
		boolean columnWhites[] = new boolean[column];
		int blackNum = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (board[i].charAt(j) == 'W') {
					rowWhites[i] = true;
					columnWhites[j] = true;
				} else {
					blackNum++;
				}
			}
		}
		int rowBlackNum = row;
		for (boolean rowWhite : rowWhites) {
			if (rowWhite) {
				rowBlackNum--;
			}
		}
		int columnBlackNum = column;
		for (boolean columnWhite : columnWhites) {
			if (columnWhite) {
				columnBlackNum--;
			}
		}
		if (row < column) {
			return rowBlackNum + (blackNum - rowBlackNum * column)
					/ Math.max(row - rowBlackNum, 1);
		} else {
			return columnBlackNum + (blackNum - columnBlackNum * row)
					/ Math.max(column - columnBlackNum, 1);
		}
	}
}
