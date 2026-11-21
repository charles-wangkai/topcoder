public class DivisorDigits {
	public int howMany(int number) {
		int count = 0;
		int remaining = number;
		while (remaining != 0) {
			int digit = remaining % 10;
			if (digit != 0 && number % digit == 0) {
				count++;
			}
			remaining /= 10;
		}
		return count;
	}
}
