import java.util.ArrayList;

public class InterestingDigits {
	public int[] digits(int base) {
		ArrayList<Integer> interesting = new ArrayList<Integer>();
		for (int i = 2; i <= base - 1; i++) {
			if ((base - 1) % i == 0) {
				interesting.add(i);
			}
		}
		int result[] = new int[interesting.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = interesting.get(i);
		}
		return result;
	}
}
