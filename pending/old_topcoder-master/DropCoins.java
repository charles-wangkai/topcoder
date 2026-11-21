public class DropCoins {
	public int getMinimum(String[] board, int K) {
		int minOperNum = -1;
		int row = board.length;
		int col = board[0].length();
		for (int rowBegin = 0; rowBegin < row; rowBegin++) {
			for (int rowEnd = rowBegin; rowEnd < row; rowEnd++) {
				for (int colBegin = 0; colBegin < col; colBegin++) {
					for (int colEnd = colBegin; colEnd < col; colEnd++) {
						int coinNum = 0;
						for (int i = rowBegin; i <= rowEnd; i++) {
							for (int j = colBegin; j <= colEnd; j++) {
								if (board[i].charAt(j) == 'o') {
									coinNum++;
								}
							}
						}
						if (coinNum == K) {
							int operNum = getOperNumInDirection(rowBegin, row
									- 1 - rowEnd)
									+ getOperNumInDirection(colBegin, col - 1
											- colEnd);
							if (minOperNum < 0 || operNum < minOperNum) {
								minOperNum = operNum;
							}
						}
					}
				}
			}
		}
		return minOperNum;
	}

	int getOperNumInDirection(int side1, int side2) {
		return side1 + side2 + Math.min(side1, side2);
	}
}
