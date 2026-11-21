public class Desertification {
	public int desertArea(String[] island, int T) {
		int row = island.length;
		int column = island[0].length();
		char grid[][] = new char[row][column];
		int desertNum = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				grid[i][j] = island[i].charAt(j);
				if (grid[i][j] == 'D') {
					desertNum++;
				}
			}
		}

		int offsetX[] = new int[] { 0, -1, 0, 1, 0 };
		int offsetY[] = new int[] { 0, 0, 1, 0, -1 };
		for (int year = 0; year < T && desertNum > 0
				&& desertNum < row * column; year++) {
			char nextGrid[][] = new char[row][column];
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < column; j++) {
					boolean desert = false;
					for (int k = 0; k < offsetX.length; k++) {
						int adjX = i + offsetX[k];
						int adjY = j + offsetY[k];
						if (adjX >= 0 && adjX < row && adjY >= 0
								&& adjY < column && grid[adjX][adjY] == 'D') {
							desert = true;
							break;
						}
					}
					nextGrid[i][j] = desert ? 'D' : 'F';
					if (grid[i][j] != nextGrid[i][j]) {
						desertNum++;
					}
				}
			}
			grid = nextGrid;
		}
		return desertNum;
	}
}
