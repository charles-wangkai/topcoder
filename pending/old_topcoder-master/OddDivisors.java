public class OddDivisors {
	public long findSum(int N) {
		long sum = 0;
		while (N >= 1) {
			sum += calcArithmeticProgressionSum(1, N % 2 == 0 ? (N - 1) : N, 2);
			N /= 2;
		}
		return sum;
	}

	long calcArithmeticProgressionSum(int a0, int an, int d) {
		int n = (an - a0) / d + 1;
		return (long) (a0 + an) * n / 2;
	}
}
