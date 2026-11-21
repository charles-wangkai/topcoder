public class GogoXCake {
	int row;
	int col;
	int cutterRow;
	int cutterCol;

	public String solve(String[] cake, String[] cutter) {
		row = cake.length;
		col = cake[0].length();
		cutterRow = cutter.length;
		cutterCol = cutter[0].length();
		boolean[][] cells = convert(cake);
		int cutterFirstC = 0;
		while (cutter[0].charAt(cutterFirstC) != '.') {
			cutterFirstC++;
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (!cells[i][j]) {
					if (!fill(cells, cutter, i, j - cutterFirstC)) {
						return "NO";
					}
				}
			}
		}
		return "YES";
	}

	boolean[][] convert(String[] cake) {
		boolean[][] cells = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				cells[i][j] = cake[i].charAt(j) == 'X';
			}
		}
		return cells;
	}

	boolean fill(boolean[][] cells, String[] cutter, int minR, int minC) {
		if (minR < 0 || minR + cutterRow > row || minC < 0
				|| minC + cutterCol > col) {
			return false;
		}
		for (int i = minR; i < minR + cutterRow; i++) {
			for (int j = minC; j < minC + cutterCol; j++) {
				if (cutter[i - minR].charAt(j - minC) == '.') {
					if (cells[i][j]) {
						return false;
					}
					cells[i][j] = true;
				}
			}
		}
		return true;
	}
}
