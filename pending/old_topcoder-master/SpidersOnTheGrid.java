public class SpidersOnTheGrid {
	public int find(String[] A) {
		int freeNum = 0;
		int row = A.length;
		int column = A[0].length();
		int offsetX[] = { -1, 0, 1, 0 };
		int offsetY[] = { 0, 1, 0, -1 };
		char directions[] = { 'S', 'W', 'N', 'E' };
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				boolean free = true;
				for (int k = 0; k < 4; k++) {
					int adjX = i + offsetX[k];
					int adjY = j + offsetY[k];
					if (adjX >= 0 && adjX < row && adjY >= 0 && adjY < column
							&& A[adjX].charAt(adjY) == directions[k]) {
						free = false;
						break;
					}
				}
				if (free) {
					freeNum++;
				}
			}
		}
		return freeNum;
	}
}
