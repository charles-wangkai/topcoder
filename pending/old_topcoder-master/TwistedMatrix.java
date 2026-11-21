public class TwistedMatrix {
	public String[] solve(String[] A, String[] B) {
		int row = A.length;
		int column = A[0].length();
		int matrixA[][] = convert(A, row, column);
		int matrixB[][] = convert(B, row, column);
		String result[] = {};
		int offsetX[][] = { { 0, 1, 0 }, { 1, 0, -1 } };
		int offsetY[][] = { { 1, 0, -1 }, { 0, 1, 0 } };
		for (int i = 0; i < row - 1; i++) {
			for (int j = 0; j < column - 1; j++) {
				for (int d = 0; d < offsetX.length; d++) {
					rotate(matrixA, i, j, offsetX[d], offsetY[d]);
					String solution[] = match(matrixA, matrixB, row, column);
					if (solution != null
							&& (result.length == 0 || compare(solution, result,
									row) < 0)) {
						result = solution;
					}
					rotate(matrixA, i, j, offsetX[1 - d], offsetY[1 - d]);
				}
			}
		}
		return result;
	}

	int compare(String a[], String b[], int row) {
		for (int i = 0; i < row; i++) {
			int result = a[i].compareTo(b[i]);
			if (result != 0) {
				return result;
			}
		}
		return 0;
	}

	String[] match(int matrixA[][], int matrixB[][], int row, int column) {
		String solution[] = new String[row];
		for (int i = 0; i < row; i++) {
			solution[i] = "";
			for (int j = 0; j < column; j++) {
				if (matrixA[i][j] != -1 && matrixB[i][j] != -1
						&& matrixA[i][j] != matrixB[i][j]) {
					return null;
				}
				if (matrixA[i][j] == 0 || matrixB[i][j] == 0
						|| (matrixA[i][j] == -1 && matrixB[i][j] == -1)) {
					solution[i] += "0";
				} else {
					solution[i] += "1";
				}
			}
		}
		return solution;
	}

	void rotate(int matrix[][], int x, int y, int offsetX[], int offsetY[]) {
		int temp = matrix[x][y];
		for (int i = 0; i < offsetX.length; i++) {
			matrix[x][y] = matrix[x + offsetX[i]][y + offsetY[i]];
			x += offsetX[i];
			y += offsetY[i];
		}
		matrix[x][y] = temp;
	}

	int[][] convert(String A[], int row, int column) {
		int matrix[][] = new int[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				char ch = A[i].charAt(j);
				if (ch == '?') {
					matrix[i][j] = -1;
				} else {
					matrix[i][j] = ch - '0';
				}
			}
		}
		return matrix;
	}
}
