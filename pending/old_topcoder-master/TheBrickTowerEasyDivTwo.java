public class TheBrickTowerEasyDivTwo {
	public int find(int redCount, int redHeight, int blueCount, int blueHeight) {
		int pairCount = Math.min(redCount, blueCount);
		int result = (redCount == blueCount ? 0 : 1);
		if (redHeight == blueHeight) {
			result += pairCount * 2;
		} else {
			result += pairCount * 3;
		}
		return result;
	}
}
