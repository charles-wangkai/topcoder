public class GameOfLife {
	int row;
	int column;
	boolean grid[][];

	public int alive(String[] start, String rules, int generations) {
		row = start.length;
		column = start[0].length();
		grid = new boolean[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (start[i].charAt(j) == 'X') {
					grid[i][j] = true;
				}
			}
		}
		for (int i = 0; i < generations; i++) {
			boolean nextGrid[][] = new boolean[row][column];
			for (int j = 0; j < row; j++) {
				for (int k = 0; k < column; k++) {
					int adjacent = countAdjacent(j, k);
					char ch = rules.charAt(adjacent);
					if (ch == 'D') {
						nextGrid[j][k] = false;
					} else if (ch == 'S') {
						nextGrid[j][k] = grid[j][k];
					} else if (ch == 'B') {
						nextGrid[j][k] = true;
					}
				}
			}
			grid = nextGrid;
		}
		int aliveCount = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (grid[i][j]) {
					aliveCount++;
				}
			}
		}
		return aliveCount;
	}

	int countAdjacent(int x, int y) {
		int offsetX[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
		int offsetY[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
		int count = 0;
		for (int i = 0; i < 8; i++) {
			if (grid[(x + offsetX[i] + row) % row][(y + offsetY[i] + column)
					% column]) {
				count++;
			}
		}
		return count;
	}
}
