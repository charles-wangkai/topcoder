public class LampsGrid {
	public int mostLit(String[] initial, int K) {
		int rowNum = initial.length;
		int columnNum = initial[0].length();
		int maxLitNum = 0;
		for (String row : initial) {
			int offCount = countOff(row);
			if (K >= offCount && (K - offCount) % 2 == 0) {
				boolean grid[][] = new boolean[rowNum][columnNum];
				for (int i = 0; i < rowNum; i++) {
					for (int j = 0; j < columnNum; j++) {
						grid[i][j] = initial[i].charAt(j) == '1';
					}
				}
				for (int j = 0; j < columnNum; j++) {
					if (row.charAt(j) == '0') {
						for (int i = 0; i < rowNum; i++) {
							grid[i][j] = !grid[i][j];
						}
					}
				}
				int litNum = 0;
				for (int i = 0; i < rowNum; i++) {
					boolean lit = true;
					for (int j = 0; j < columnNum; j++) {
						if (!grid[i][j]) {
							lit = false;
							break;
						}
					}
					if (lit) {
						litNum++;
					}
				}
				maxLitNum = Math.max(maxLitNum, litNum);
			}
		}
		return maxLitNum;
	}

	int countOff(String row) {
		int offCount = 0;
		for (int i = 0; i < row.length(); i++) {
			if (row.charAt(i) == '0') {
				offCount++;
			}
		}
		return offCount;
	}
}
