public class LCMRange {
	public int lcm(int first, int last) {
		int result = 1;
		for (int i = first; i <= last; i++) {
			result = LCM(result, i);
		}
		return result;
	}

	int LCM(int a, int b) {
		int common = GCD(a, b);
		return a / common * b;
	}

	int GCD(int a, int b) {
		if (a < b) {
			return GCD(b, a);
		}
		while (b != 0) {
			int c = a % b;
			a = b;
			b = c;
		}
		return a;
	}
}
