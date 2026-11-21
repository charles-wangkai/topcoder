public class CalendarRecycle {
	public int useAgain(int year) {
		boolean leapYear = isLeapYear(year);
		int dayDiff = 0;
		for (int i = year + 1;; i++) {
			boolean leap = isLeapYear(i);
			dayDiff += (leap ? 366 : 365);
			if (leap == leapYear && dayDiff % 7 == 0) {
				return i;
			}
		}
	}

	boolean isLeapYear(int year) {
		return year % 400 == 0 || (year % 100 != 0 && year % 4 == 0);
	}
}
