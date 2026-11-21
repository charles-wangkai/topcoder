import java.util.Arrays;

public class PipeCuts {
	public double probability(int[] weldLocations, int L) {
		Arrays.sort(weldLocations);
		int length = weldLocations.length;
		int total = length * (length - 1) / 2;
		int count = 0;
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				if (weldLocations[i] > L
						|| weldLocations[j] - weldLocations[i] > L
						|| 100 - weldLocations[j] > L) {
					count++;
				}
			}
		}
		return (double) count / total;
	}
}
