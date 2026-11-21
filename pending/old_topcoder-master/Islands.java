public class Islands {
	public int beachLength(String[] kingdom) {
		int row = kingdom.length;
		int column = kingdom[0].length();
		int[] OFFSET_X = { -1, -1, 0, 0, 1, 1 };
		int[] OFFSET_Y_EVEN = { -1, 0, -1, 1, -1, 0 };
		int[] OFFSET_Y_ODD = { 0, 1, -1, 1, 0, 1 };
		int beach = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (kingdom[i].charAt(j) == '#') {
					for (int k = 0; k < OFFSET_X.length; k++) {
						int adjacentX = i + OFFSET_X[k];
						int adjacentY = j
								+ (i % 2 == 0 ? OFFSET_Y_EVEN[k]
										: OFFSET_Y_ODD[k]);
						if (adjacentX >= 0 && adjacentX < row && adjacentY >= 0
								&& adjacentY < column
								&& kingdom[adjacentX].charAt(adjacentY) == '.') {
							beach++;
						}
					}
				}
			}
		}
		return beach;
	}
}
