public class DigitsSum {
	public int lastDigit(int n) {
		while (n > 9) {
			int digitSum = 0;
			while (n != 0) {
				digitSum += n % 10;
				n /= 10;
			}
			n = digitSum;
		}
		return n;
	}
}
