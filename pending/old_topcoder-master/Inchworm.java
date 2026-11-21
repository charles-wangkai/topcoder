public class Inchworm {
	public int lunchtime(int branch, int rest, int leaf) {
		return branch / lcm(rest, leaf) + 1;
	}

	int lcm(int a, int b) {
		return a / gcd(a, b) * b;
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
