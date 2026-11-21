public class FoxAndGomoku {
	static final int[] R_OFFSETS = { 0, 1, 1, 1 };
	static final int[] C_OFFSETS = { 1, 0, 1, -1 };

	public String win(String[] board) {
		int n = board.length;
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				for (int i = 0; i < R_OFFSETS.length; i++) {
					if (isWin(board, r, c, R_OFFSETS[i], C_OFFSETS[i])) {
						return "found";
					}
				}
			}
		}
		return "not found";
	}

	boolean isWin(String[] board, int startR, int startC, int offsetR, int offsetC) {
		int n = board.length;
		for (int i = 0; i < 5; i++) {
			int r = startR + offsetR * i;
			int c = startC + offsetC * i;
			if (!(r >= 0 && r < n && c >= 0 && c < n && board[r].charAt(c) == 'o')) {
				return false;
			}
		}
		return true;
	}
}
