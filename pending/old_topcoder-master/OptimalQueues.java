import java.util.Arrays;

public class OptimalQueues {
	public int minWaitingTime(int[] clientArrivals, int tellerCount,
			int serviceTime) {
		int maxTime = 0;
		Arrays.sort(clientArrivals);
		for (int i = 0; i < clientArrivals.length; i++) {
			maxTime = Math.max(maxTime, clientArrivals[i]
					+ ((clientArrivals.length - 1 - i) / tellerCount + 1)
					* serviceTime);
		}
		return maxTime;
	}
}
