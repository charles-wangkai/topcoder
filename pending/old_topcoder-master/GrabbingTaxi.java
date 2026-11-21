public class GrabbingTaxi {
	public int minTime(int[] tXs, int[] tYs, int gX, int gY, int walkTime,
			int taxiTime) {
		int minT = (Math.abs(gX) + Math.abs(gY)) * walkTime;
		for (int i = 0; i < tXs.length; i++) {
			int time = (Math.abs(tXs[i]) + Math.abs(tYs[i])) * walkTime
					+ (Math.abs(gX - tXs[i]) + Math.abs(gY - tYs[i]))
					* taxiTime;
			minT = Math.min(minT, time);
		}
		return minT;
	}
}
