public class Trainyard {
	int row;
	int column;
	boolean visited[][];
	int reachableNum = 0;

	public int reachableSquares(String[] layout, int fuel) {
		row = layout.length;
		column = layout[0].length();
		visited = new boolean[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (layout[i].charAt(j) == 'S') {
					search(layout, i, j, 0, 0, fuel);
				}
			}
		}
		return reachableNum;
	}

	void search(String layout[], int x, int y, int prevOffsetX,
			int prevOffsetY, int restFuel) {
		if (!visited[x][y]) {
			visited[x][y] = true;
			reachableNum++;
		}
		if (restFuel == 0) {
			return;
		}
		char cell = layout[x].charAt(y);
		int offsetX[] = {};
		int offsetY[] = {};
		if (cell == 'S' || cell == '+') {
			offsetX = new int[] { -1, 0, 1, 0 };
			offsetY = new int[] { 0, 1, 0, -1 };
		} else if ((prevOffsetX == 0 && cell == '-')
				|| (prevOffsetY == 0 && cell == '|')) {
			offsetX = new int[] { prevOffsetX };
			offsetY = new int[] { prevOffsetY };
		}
		for (int i = 0; i < offsetX.length; i++) {
			int nextX = x + offsetX[i];
			int nextY = y + offsetY[i];
			if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < column) {
				char nextCell = layout[nextX].charAt(nextY);
				if (nextCell == '+' || (offsetX[i] == 0 && nextCell == '-')
						|| (offsetY[i] == 0 && nextCell == '|')) {
					search(layout, nextX, nextY, offsetX[i], offsetY[i],
							restFuel - 1);
				}
			}
		}
	}
}
