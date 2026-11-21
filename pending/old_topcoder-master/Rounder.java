public class Rounder {
	public int round(int n, int b) {
		int remainder = n % b;
		if (remainder * 2 >= b) {
			return (n / b + 1) * b;
		} else {
			return n / b * b;
		}
	}
}
