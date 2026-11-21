import java.util.Arrays;

public class MedianOfNumbers {
	public int findMedian(int[] numbers) {
		if (numbers.length % 2 == 0) {
			return -1;
		}
		Arrays.sort(numbers);
		return numbers[numbers.length / 2];
	}
}
