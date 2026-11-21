import java.util.Arrays;

public class ConsecutiveNumbers {
	public int[] missingNumber(int[] numbers) {
		Arrays.sort(numbers);
		int missingMiddle = -1;
		for (int i = 0; i < numbers.length - 1; i++) {
			int diff = numbers[i + 1] - numbers[i];
			if (diff == 1) {
				continue;
			}
			if (diff != 2 || missingMiddle > 0) {
				return new int[0];
			}
			if (diff == 2) {
				missingMiddle = numbers[i] + 1;
			}
		}
		if (missingMiddle > 0) {
			return new int[] { missingMiddle };
		}
		int first = numbers[0];
		int last = numbers[numbers.length - 1];
		if (first == 1) {
			return new int[] { last + 1 };
		} else {
			return new int[] { first - 1, last + 1 };
		}
	}
}
