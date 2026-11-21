public class LineOfSight {
	public int bestPosition(String[] board) {
		int row = board.length;
		int column = board[0].length();
		char grid[][] = new char[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				grid[i][j] = board[i].charAt(j);
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (grid[i][j] == 'X') {
					for (int k = 0; k < column; k++) {
						if (grid[i][k] == '.') {
							grid[i][k] = 'o';
						}
					}
					for (int k = 0; k < row; k++) {
						if (grid[k][j] == '.') {
							grid[k][j] = 'o';
						}
					}
				}
			}
		}
		int safeCount = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (grid[i][j] == '.') {
					safeCount++;
				}
			}
		}
		if (safeCount == 0) {
			return -1;
		}
		int max = -1;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (grid[i][j] == '.') {
					int count = -1;
					for (int k = 0; k < column; k++) {
						if (grid[i][k] == '.') {
							count++;
						}
					}
					for (int k = 0; k < row; k++) {
						if (grid[k][j] == '.') {
							count++;
						}
					}
					max = Math.max(max, count);
				}
			}
		}
		return safeCount - max;
	}
}
