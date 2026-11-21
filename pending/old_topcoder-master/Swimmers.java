public class Swimmers {
	public int[] getSwimTimes(int[] distances, int[] speeds, int current) {
		int times[] = new int[distances.length];
		for (int i = 0; i < times.length; i++) {
			if (distances[i] == 0) {
				times[i] = 0;
			} else if (speeds[i] <= current || speeds[i] + current == 0) {
				times[i] = -1;
			} else {
				times[i] = 2 * distances[i] * speeds[i]
						/ ((speeds[i] + current) * (speeds[i] - current));
			}
		}
		return times;
	}
}
