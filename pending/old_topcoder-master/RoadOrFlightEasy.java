import java.util.Arrays;

public class RoadOrFlightEasy {
	public int minTime(int N, int[] roadTime, int[] flightTime, int K) {
		int time = 0;
		int saved[] = new int[N];
		for (int i = 0; i < N; i++) {
			time += roadTime[i];
			saved[i] = flightTime[i] - roadTime[i];
		}
		Arrays.sort(saved);
		for (int i = 0; i < K && saved[i] < 0; i++) {
			time += saved[i];
		}
		return time;
	}
}
