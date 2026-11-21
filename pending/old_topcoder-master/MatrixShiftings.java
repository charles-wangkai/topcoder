public class MatrixShiftings {
	public int minimumShifts(String[] matrix, int value) {
		int minShift = -1;
		int row = matrix.length;
		int column = matrix[0].length();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (matrix[i].charAt(j) - '0' == value) {
					int shift = Math.min(i, row - i) + Math.min(j, column - j);
					if (minShift < 0 || shift < minShift) {
						minShift = shift;
					}
				}
			}
		}
		return minShift;
	}
}
