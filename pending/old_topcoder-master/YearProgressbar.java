public class YearProgressbar {
	int daysInMonth[] = { 0, 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public double percentage(String currentDate) {
		Time time = parseTime(currentDate);
		if (isLeapYear(time.year)) {
			daysInMonth[2] = 29;
		} else {
			daysInMonth[2] = 28;
		}
		int totalMinute = new Time(time.year, 12, 31, 23, 59).toMinute() + 1;
		int timeMinute = time.toMinute();
		return 100.0 * timeMinute / totalMinute;
	}

	boolean isLeapYear(int year) {
		return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
	}

	Time parseTime(String currentDate) {
		String fields[] = currentDate.split("[ ,:]+");
		int year = Integer.parseInt(fields[2]);
		int month = getMonthByName(fields[0]);
		int date = Integer.parseInt(fields[1]);
		int hour = Integer.parseInt(fields[3]);
		int minute = Integer.parseInt(fields[4]);
		return new Time(year, month, date, hour, minute);
	}

	int getMonthByName(String monthName) {
		final String MONTH_NAMES[] = { "January", "February", "March", "April",
				"May", "June", "July", "August", "September", "October",
				"November", "December" };
		for (int i = 0;; i++) {
			if (monthName.equals(MONTH_NAMES[i])) {
				return i + 1;
			}
		}
	}

	class Time {
		int year;
		int month;
		int date;
		int hour;
		int minute;

		public Time(int year, int month, int date, int hour, int minute) {
			this.year = year;
			this.month = month;
			this.date = date;
			this.hour = hour;
			this.minute = minute;
		}

		int toMinute() {
			int convertedMinute = 0;
			for (int i = 1; i < month; i++) {
				convertedMinute += daysInMonth[i] * 24 * 60;
			}
			convertedMinute += (date - 1) * 24 * 60;
			convertedMinute += hour * 60;
			convertedMinute += minute;
			return convertedMinute;
		}
	}
}
