public class RiverHill {
	int initPower;
	int row;
	int column;
	int levels[][];
	int flow;
	int powers[][];

	public int largest(String[] map, int maxDist) {
		initPower = maxDist;
		row = map.length;
		column = map[0].length();
		levels = new int[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				levels[i][j] = map[i].charAt(j) - '0';
			}
		}
		int max = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				powers = new int[row][column];
				for (int p = 0; p < row; p++) {
					for (int q = 0; q < column; q++) {
						powers[p][q] = -1;
					}
				}
				flow = 1;
				powers[i][j] = maxDist;
				search(i, j);
				max = Math.max(max, flow);
			}
		}
		return max;
	}

	void search(int x, int y) {
		int offsetX[] = { -1, 0, 1, 0 };
		int offsetY[] = { 0, 1, 0, -1 };
		for (int i = 0; i < 4; i++) {
			int newX = x + offsetX[i];
			int newY = y + offsetY[i];
			if (newX >= 0 && newX < row && newY >= 0 && newY < column
					&& levels[newX][newY] <= levels[x][y]) {
				if (levels[newX][newY] == levels[x][y] && powers[x][y] > 0
						&& powers[x][y] - 1 > powers[newX][newY]) {
					if (powers[newX][newY] == -1) {
						flow++;
					}
					powers[newX][newY] = powers[x][y] - 1;
					search(newX, newY);
				} else if (levels[newX][newY] < levels[x][y]
						&& initPower > powers[newX][newY]) {
					if (powers[newX][newY] == -1) {
						flow++;
					}
					powers[newX][newY] = initPower;
					search(newX, newY);
				}
			}
		}
	}
}
