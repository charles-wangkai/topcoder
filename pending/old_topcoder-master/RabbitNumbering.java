import java.util.Arrays;

public class RabbitNumbering {
	public int theCount(int[] maxNumber) {
		final int MODULO = 1000000007;
		Arrays.sort(maxNumber);
		for (int i = 0; i < maxNumber.length; i++) {
			if (maxNumber[i] <= i) {
				return 0;
			}
		}
		int result = 1;
		for (int i = 0; i < maxNumber.length; i++) {
			result = (int) ((long) result * (maxNumber[i] - i) % MODULO);
		}
		return result;
	}
}
