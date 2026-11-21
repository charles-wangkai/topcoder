public class MountainRoad {
	public double findDistance(int[] start, int[] finish) {
		int minStart = Integer.MAX_VALUE;
		for (int s : start) {
			minStart = Math.min(minStart, s);
		}
		int maxFinish = Integer.MIN_VALUE;
		for (int f : finish) {
			maxFinish = Math.max(maxFinish, f);
		}
		return Math.sqrt(2) * (maxFinish - minStart);
	}
}
