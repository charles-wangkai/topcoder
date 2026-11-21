public class TurningLightOn {
	public int minFlips(String[] board) {
		int row = board.length;
		int column = board[0].length();
		boolean states[][] = new boolean[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				states[i][j] = board[i].charAt(j) == '1';
			}
		}
		int flipNum = 0;
		for (int i = row - 1; i >= 0; i--) {
			for (int j = column - 1; j >= 0; j--) {
				if (!states[i][j]) {
					for (int p = 0; p <= i; p++) {
						for (int q = 0; q <= j; q++) {
							states[p][q] = !states[p][q];
						}
					}
					flipNum++;
				}
			}
		}
		return flipNum;
	}
}
