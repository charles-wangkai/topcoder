public class SquareDigitNumbers {
	public int getNumber(int n) {
		int digits[] = { 0, 1, 4, 9 };
		int number = 0;
		int base = 1;
		while (n != 0) {
			number += digits[n % 4] * base;
			n /= 4;
			base *= 10;
		}
		return number;
	}
}
