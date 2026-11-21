public class MovieSeating {
	public long getSeatings(int numFriends, String[] hall) {
		int row = hall.length;
		int column = hall[0].length();
		int[] rowCounts = new int[row];
		int[] columnCounts = new int[column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (hall[i].charAt(j) == '.') {
					rowCounts[i]++;
					columnCounts[j]++;
				}
			}
		}
		long result = 0;
		for (int rowCount : rowCounts) {
			result += P(rowCount, numFriends);
		}
		if (numFriends > 1) {
			for (int columnCount : columnCounts) {
				result += P(columnCount, numFriends);
			}
		}
		return result;
	}

	long P(int n, int m) {
		if (n < m) {
			return 0;
		}
		long result = 1;
		for (int i = n; i > n - m; i--) {
			result *= i;
		}
		return result;
	}
}
