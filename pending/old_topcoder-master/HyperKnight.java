public class HyperKnight {
	public long countCells(int a, int b, int numRows, int numColumns, int k) {
		if (a < b) {
			return countCells(b, a, numRows, numColumns, k);
		}
		if (numRows < numColumns) {
			return countCells(a, b, numColumns, numRows, k);
		}
		long A = a;
		long B = b;
		long rows = numRows;
		long columns = numColumns;
		if (k == 0) {
			return 0;
		} else if (k == 1) {
			return 0;
		} else if (k == 2) {
			return 4 * B * B;
		} else if (k == 3) {
			return 8 * B * (A - B);
		} else if (k == 4) {
			return 2 * B * ((rows - 2 * A) + (columns - 2 * A)) + 4 * (A - B)
					* (A - B);
		} else if (k == 5) {
			return 0;
		} else if (k == 6) {
			return 2 * (A - B) * ((rows - 2 * A) + (columns - 2 * A));
		} else if (k == 7) {
			return 0;
		} else { // k == 8
			return (rows - 2 * A) * (columns - 2 * A);
		}
	}
}
