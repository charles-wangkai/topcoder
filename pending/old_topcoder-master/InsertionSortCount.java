public class InsertionSortCount {
	public int countMoves(int[] A) {
		int moveNum = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = i + 1; j < A.length; j++) {
				if (A[i] > A[j]) {
					moveNum++;
				}
			}
		}
		return moveNum;
	}
}
