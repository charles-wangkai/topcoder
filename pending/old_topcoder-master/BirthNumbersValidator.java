public class BirthNumbersValidator {
	public String[] validate(String[] test) {
		String valids[] = new String[test.length];
		for (int i = 0; i < valids.length; i++) {
			String birthNumber = test[i];
			int year = Integer.parseInt(birthNumber.substring(0, 2)) + 1900;
			if (year < 1907) {
				year += 100;
			}
			int month = Integer.parseInt(birthNumber.substring(2, 4));
			if (!isValidMonth(month)) {
				month -= 50;
			}
			int day = Integer.parseInt(birthNumber.substring(4, 6));
			if (isValidMonth(month) && isValidDay(isLeapYear(year), month, day)
					&& Long.parseLong(birthNumber) % 11 == 0) {
				valids[i] = "YES";
			} else {
				valids[i] = "NO";
			}
		}
		return valids;
	}

	boolean isValidMonth(int month) {
		return month >= 1 && month <= 12;
	}

	boolean isLeapYear(int year) {
		return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
	}

	boolean isValidDay(boolean leapYear, int month, int day) {
		final int DAYS[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		return day >= 1
				&& day <= DAYS[month] + ((month == 2 && leapYear) ? 1 : 0);
	}
}
