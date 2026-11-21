public class LeastMajorityMultiple {
	public int leastMajorityMultiple(int a, int b, int c, int d, int e) {
		int numbers[] = { a, b, c, d, e };
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				for (int k = j + 1; k < numbers.length; k++) {
					result = Math.min(result,
							lcm(lcm(numbers[i], numbers[j]), numbers[k]));
				}
			}
		}
		return result;
	}

	int lcm(int a, int b) {
		int common = gcd(a, b);
		return a / common * b;
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
