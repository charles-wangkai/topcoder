import java.util.Arrays;

public class CuttingPoles {
	public int countCuts(int[] poles) {
		int sum = 0;
		for (int pole : poles) {
			sum += pole;
		}
		int average = sum / poles.length;
		for (int cutNum = 0;; cutNum++) {
			Arrays.sort(poles);
			if (poles[poles.length - 1] == average) {
				return cutNum;
			}
			poles[0] += poles[poles.length - 1] - average;
			poles[poles.length - 1] = average;
		}
	}
}
