import java.util.ArrayList;

public class Decimal {
	public int[] find(int lower, int upper, int lowerLength, int upperLength) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = lower; i <= upper; i++) {
			int length = repeat(i);
			if (length >= lowerLength && length <= upperLength) {
				result.add(i);
			}
		}
		int array[] = new int[result.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = result.get(i);
		}
		return array;
	}

	int repeat(int number) {
		int remainders[] = new int[number];
		int rest = 1 % number;
		int count = 1;
		while (remainders[rest] == 0) {
			remainders[rest] = count;
			count++;
			rest = (rest * 10) % number;
		}
		return count - remainders[rest];
	}
}
