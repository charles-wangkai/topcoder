public class BagOfHolding {
	public double oddsReachable(int[] sizes, int item) {
		int nonSmallerNum = 0;
		for (int size : sizes) {
			if (size >= sizes[item]) {
				nonSmallerNum++;
			}
		}
		return 1.0 / nonSmallerNum;
	}
}
