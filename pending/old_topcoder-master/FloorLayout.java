public class FloorLayout {
	public int countBoards(String[] layout) {
		int row = layout.length;
		int column = layout[0].length();
		boolean used[][] = new boolean[row][column];
		int boardNum = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (used[i][j]) {
					continue;
				}
				used[i][j] = true;
				boardNum++;
				char direction = layout[i].charAt(j);
				int offsetX;
				int offsetY;
				if (direction == '-') {
					offsetX = 0;
					offsetY = 1;
				} else {
					offsetX = 1;
					offsetY = 0;
				}
				for (int x = i, y = j; x < row && y < column
						&& layout[x].charAt(y) == direction; x += offsetX, y += offsetY) {
					used[x][y] = true;
				}
			}
		}
		return boardNum;
	}
}
