import java.util.Arrays;

public class Cryptography {
	public long encrypt(int[] numbers) {
		Arrays.sort(numbers);
		numbers[0]++;
		long product = 1;
		for (int number : numbers) {
			product *= number;
		}
		return product;
	}
}
