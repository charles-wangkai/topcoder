public class Packhorses {
	public int horses(int p, int x, int y) {
		int minHorse = Integer.MAX_VALUE;
		for (int i = 0; i <= p; i++) {
			int smallLeft = x - i * 2;
			int horseForSmall = (smallLeft <= 0) ? 0 : ((smallLeft + 2) / 3);
			int largeLeft = y - (p - i);
			int horseForLarge = (largeLeft <= 0) ? 0 : ((largeLeft + 1) / 2);
			minHorse = Math.min(minHorse, p + horseForSmall + horseForLarge);
		}
		return minHorse;
	}
}
