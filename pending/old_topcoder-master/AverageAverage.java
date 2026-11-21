public class AverageAverage {
	public double average(int[] numList) {
		int sum = 0;
		for (int num : numList) {
			sum += num;
		}
		double total = 0;
		for (int i = 1; i <= numList.length; i++) {
			total += (double) sum * C(numList.length - 1, i - 1) / i;
		}
		return total / (Math.pow(2, numList.length) - 1);
	}

	int C(int n, int m) {
		int result = 1;
		for (int i = n; i > n - m; i--) {
			result *= i;
		}
		for (int i = 1; i <= m; i++) {
			result /= i;
		}
		return result;
	}
}
