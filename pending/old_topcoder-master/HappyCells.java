public class HappyCells {
	public int[] getHappy(String[] grid) {
		int happy[] = new int[3];
		int row = grid.length;
		int column = grid[0].length();
		int orthogonalX[] = { -1, 0, 1, 0 };
		int orthogonalY[] = { 0, 1, 0, -1 };
		int diagonalX[] = { -1, 1, 1, -1 };
		int diagonalY[] = { 1, 1, -1, -1 };
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (grid[i].charAt(j) != '.') {
					continue;
				}
				boolean orthogonalEmpty = checkEmpty(grid, row, column, i, j,
						orthogonalX, orthogonalY);
				boolean diagonalEmpty = checkEmpty(grid, row, column, i, j,
						diagonalX, diagonalY);
				if (!orthogonalEmpty && !diagonalEmpty) {
					happy[0]++;
				} else if (!orthogonalEmpty) {
					happy[1]++;
				} else if (!diagonalEmpty) {
					happy[2]++;
				}
			}
		}
		return happy;
	}

	boolean checkEmpty(String grid[], int row, int column, int x, int y,
			int offsetX[], int offsetY[]) {
		for (int i = 0; i < offsetX.length; i++) {
			int adjX = x + offsetX[i];
			int adjY = y + offsetY[i];
			if (adjX >= 0 && adjX < row && adjY >= 0 && adjY < column
					&& grid[adjX].charAt(adjY) == '.') {
				return true;
			}
		}
		return false;
	}
}
