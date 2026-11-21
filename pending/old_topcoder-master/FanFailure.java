import java.util.Arrays;

public class FanFailure {
	public int[] getRange(int[] capacities, int minCooling) {
		Arrays.sort(capacities);
		int mfs = capacities.length;
		for (int i = capacities.length - 1, sum = 0; sum < minCooling; i--) {
			sum += capacities[i];
			mfs--;
		}
		int mfc = capacities.length;
		for (int i = 0, sum = 0; sum < minCooling; i++) {
			sum += capacities[i];
			mfc--;
		}
		return new int[] { mfs, mfc };
	}
}
