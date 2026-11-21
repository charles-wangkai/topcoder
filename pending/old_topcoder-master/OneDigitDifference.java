public class OneDigitDifference {
	public int getSmallest(int N) {
		if (N == 0) {
			return 1;
		} else if (N < 10) {
			return 0;
		} else {
			return Integer.parseInt((N + "").substring(1));
		}
	}
}
