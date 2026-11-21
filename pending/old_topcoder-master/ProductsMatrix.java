public class ProductsMatrix {
	int row;

	public long nthElement(int n, int k) {
		row = n;
		long bottom = 1;
		long top = 10000000000L;
		while (bottom < top) {
			long middle = (bottom + top) / 2;
			if (count(middle) < k) {
				bottom = middle + 1;
			} else {
				top = middle;
			}
		}
		return bottom;
	}

	long count(long number) {
		long total = 0;
		for (int i = 1; i <= row; i++) {
			total += Math.min(number / i, row);
		}
		return total;
	}
}
