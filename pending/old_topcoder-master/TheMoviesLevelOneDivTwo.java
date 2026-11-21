public class TheMoviesLevelOneDivTwo {
	public int find(int n, int m, int[] row, int[] seat) {
		boolean reserved[][] = new boolean[n][m];
		for (int i = 0; i < row.length; i++) {
			reserved[row[i] - 1][seat[i] - 1] = true;
		}
		int wayNum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m - 1; j++) {
				if (!reserved[i][j] && !reserved[i][j + 1]) {
					wayNum++;
				}
			}
		}
		return wayNum;
	}
}
