public class CompositeSmash {
	public String thePossible(int N, int target) {
		final String YES = "Yes";
		final String NO = "No";
		if (N == target) {
			return YES;
		}
		if (N % target != 0) {
			return NO;
		}
		if (isPrime(target)) {
			return YES;
		}
		Integer root = sqrt(target);
		if (root < 0) {
			return NO;
		}
		if (isPrime(root) && isPower(N, root)) {
			return YES;
		}
		return NO;
	}

	boolean isPrime(int number) {
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	int sqrt(int number) {
		int root = (int) Math.sqrt(number);
		if (root * root == number) {
			return root;
		} else {
			return -1;
		}
	}

	boolean isPower(int number, int base) {
		while (number % base == 0) {
			number /= base;
		}
		return number == 1;
	}
}
