public class NoEights {
	public int smallestAmount(int low, int high) {
		int eightNum = 0;
		while (high != 0) {
			if (low == high && high % 10 == 8) {
				eightNum++;
			}
			low /= 10;
			high /= 10;
		}
		return eightNum;
	}
}
