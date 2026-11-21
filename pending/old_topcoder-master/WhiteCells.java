public class WhiteCells {
	public int countOccupied(String[] board) {
		int whiteOccupied = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length(); j++) {
				if (board[i].charAt(j) == 'F' && (i + j) % 2 == 0) {
					whiteOccupied++;
				}
			}
		}
		return whiteOccupied;
	}
}
