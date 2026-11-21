public class XorBoardDivTwo {
	public int theMax(String[] board) {
		int row = board.length;
		int column = board[0].length();
		int deltaRows[] = new int[row];
		int deltaColumns[] = new int[column];
		int numOne = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (board[i].charAt(j) == '0') {
					deltaRows[i]++;
					deltaColumns[j]++;
				} else {
					deltaRows[i]--;
					deltaColumns[j]--;
					numOne++;
				}
			}
		}
		int maxDelta = Integer.MIN_VALUE;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				int delta = deltaRows[i] + deltaColumns[j];
				if (board[i].charAt(j) == '0') {
					delta -= 2;
				} else {
					delta += 2;
				}
				maxDelta = Math.max(maxDelta, delta);
			}
		}
		return numOne + maxDelta;
	}
}
