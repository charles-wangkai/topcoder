public class SkewSymmetric {
	public int minChanges(String[] M) {
		int n = M.length;
		int matrix[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			String fields[] = M[i].split(" ");
			for (int j = 0; j < n; j++) {
				matrix[i][j] = Integer.parseInt(fields[j]);
			}
		}
		int changeNum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (matrix[i][j] != -matrix[j][i]) {
					changeNum++;
				}
			}
		}
		return changeNum;
	}
}
