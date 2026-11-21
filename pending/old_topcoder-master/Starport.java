public class Starport {
	public double getExpectedTime(int N, int M) {
		int common = gcd(N, M);
		int an = (N - 1) / common * common;
		return an / 2.0;
	}

	int gcd(int a, int b) {
		while (b != 0) {
			int c = a % b;
			a = b;
			b = c;
		}
		return a;
	}
}
