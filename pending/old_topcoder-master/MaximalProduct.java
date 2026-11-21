public class MaximalProduct {
	public long maximalProduct(int s, int k) {
		int numbers[] = new int[k];
		for (int i = 0; s != 0; i = (i + 1) % numbers.length, s--) {
			numbers[i]++;
		}
		long product = 1;
		for (int number : numbers) {
			product *= number;
		}
		return product;
	}
}
