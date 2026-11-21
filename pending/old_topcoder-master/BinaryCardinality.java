import java.util.Arrays;
import java.util.Comparator;

public class BinaryCardinality {
	public int[] arrange(int[] numbers) {
		Integer nums[] = new Integer[numbers.length];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = numbers[i];
		}
		Arrays.sort(nums, new CardinalityComparator());
		int result[] = new int[nums.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = nums[i];
		}
		return result;
	}
}

class CardinalityComparator implements Comparator<Integer> {
	public int compare(Integer number1, Integer number2) {
		int cardinality1 = calcCardinality(number1);
		int cardinality2 = calcCardinality(number2);
		if (cardinality1 != cardinality2) {
			return cardinality1 - cardinality2;
		} else {
			return number1 - number2;
		}
	}

	int calcCardinality(int number) {
		return Integer.toBinaryString(number).replace("0", "").length();
	}
}