public class ApocalypseSomeday {
	public int getNth(int n) {
		int number = 0;
		while (n > 0) {
			do {
				number++;
			} while (check(number) == false);
			n--;
		}
		return number;
	}

	boolean check(int number) {
		int count = 0;
		while (number > 0) {
			int digit = number % 10;
			if (digit == 6) {
				count++;
				if (count == 3) {
					return true;
				}
			} else {
				count = 0;
			}
			number /= 10;
		}
		return false;
	}
}
