public class RedSquare {
	public int countTheEmptyReds(int maxRank, int maxFile, int[] rank,
			int[] file) {
		int emptyRedNum = maxRank * maxFile / 2;
		for (int i = 0; i < rank.length; i++) {
			if ((rank[i] + file[i]) % 2 != (1 + maxFile) % 2) {
				emptyRedNum--;
			}
		}
		return emptyRedNum;
	}
}
