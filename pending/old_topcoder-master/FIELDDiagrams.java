public class FIELDDiagrams {
	public long countDiagrams(int fieldOrder) {
		long ways[][] = new long[fieldOrder][];
		for (int i = 0; i < ways.length; i++) {
			ways[i] = new long[fieldOrder - i];
		}
		for (int j = 0; j < ways[0].length; j++) {
			ways[0][j] = 1;
		}
		for (int i = 1; i < ways.length; i++) {
			long aboveSum = 0;
			for (int j = 0; j < ways[i - 1].length; j++) {
				aboveSum += ways[i - 1][j];
			}
			for (int j = 0; j < ways[i].length; j++) {
				ways[i][j] = aboveSum;
				aboveSum -= ways[i - 1][j];
			}
		}
		long result = 0;
		for (long row[] : ways) {
			for (long way : row) {
				result += way;
			}
		}
		return result;
	}
}
