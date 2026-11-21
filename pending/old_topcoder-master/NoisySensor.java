import java.util.Arrays;

public class NoisySensor {
	public int[] medianFilter(int[] data) {
		int filtered[] = new int[data.length];
		filtered[0] = data[0];
		filtered[filtered.length - 1] = data[data.length - 1];
		for (int i = 1; i < filtered.length - 1; i++) {
			int numbers[] = { data[i - 1], data[i], data[i + 1] };
			Arrays.sort(numbers);
			filtered[i] = numbers[1];
		}
		return filtered;
	}
}
