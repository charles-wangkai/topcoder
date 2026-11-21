public class WhiteHats {
	public int whiteNumber(int[] count) {
		int peopleNum = count.length;
		int whiteCounts[] = new int[peopleNum];
		for (int oneCount : count) {
			if (oneCount >= peopleNum) {
				return -1;
			}
			whiteCounts[oneCount]++;
		}
		for (int white = 0; white <= peopleNum; white++) {
			if ((white == 0 || whiteCounts[white - 1] == white)
					&& (white == peopleNum || whiteCounts[white] == peopleNum
							- white)) {
				return white;
			}
		}
		return -1;
	}
}
