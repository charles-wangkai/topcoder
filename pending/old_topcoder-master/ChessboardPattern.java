public class ChessboardPattern {
	public String[] makeChessboard(int rows, int columns) {
		String result[] = new String[rows];
		for (int i = 0; i < result.length; i++) {
			result[i] = "";
			for (int j = 0; j < columns; j++) {
				if ((Math.abs(i - rows + 1) + j) % 2 == 0) {
					result[i] += '.';
				} else {
					result[i] += 'X';
				}
			}
		}
		return result;
	}
}
