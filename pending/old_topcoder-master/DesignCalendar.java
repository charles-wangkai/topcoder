public class DesignCalendar {
	public int shortestPeriod(int dayLength, int yearLength) {
		int common = gcd(dayLength, yearLength);
		return dayLength / common;
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
