public class BombSweeper {
	public double winPercentage(String[] board) {
		int offsetX[] = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
		int offsetY[] = { 0, 0, 1, 1, 1, 0, -1, -1, -1 };
		int row = board.length;
		int column = board[0].length();
		int loss = 0;
		boolean bombImpacts[][] = new boolean[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (board[i].charAt(j) == 'B') {
					loss++;
					for (int k = 0; k < offsetX.length; k++) {
						int nextX = i + offsetX[k];
						int nextY = j + offsetY[k];
						if (nextX >= 0 && nextX < row && nextY >= 0
								&& nextY < column) {
							bombImpacts[nextX][nextY] = true;
						}
					}
				}
			}
		}
		int win = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (!bombImpacts[i][j]) {
					win++;
				}
			}
		}
		return win * 100.0 / (win + loss);
	}
}
