public class DateFormat {
	public String fromEuropeanToUs(String[] dateList) {
		String list = "";
		for (String oneDateList : dateList) {
			list += oneDateList;
		}
		String dateStrs[] = list.split(" ");
		Date previous = null;
		for (int i = 0; i < dateStrs.length; i++) {
			int number1 = Integer.parseInt(dateStrs[i].substring(0, 2));
			int number2 = Integer.parseInt(dateStrs[i].substring(3, 5));
			int min = Math.min(number1, number2);
			int max = Math.max(number1, number2);
			Date dates[] = { new Date(min, max), new Date(max, min) };
			boolean found = false;
			for (Date date : dates) {
				if (date.isValid() && date.isAfter(previous)) {
					dateStrs[i] = date.toString();
					previous = date;
					found = true;
					break;
				}
			}
			if (!found) {
				return "";
			}
		}
		String result = "";
		for (String dateStr : dateStrs) {
			result += (result.equals("") ? "" : " ") + dateStr;
		}
		return result;
	}
}

class Date {
	int month;
	int day;
	private static final int DAY_IN_MONTHS[] = { 0, 31, 29, 31, 30, 31, 30, 31,
			31, 30, 31, 30, 31 };

	public Date(int month, int day) {
		this.month = month;
		this.day = day;
	}

	boolean isValid() {
		return month >= 1 && month <= 12 && day >= 1
				&& day <= DAY_IN_MONTHS[month];
	}

	boolean isAfter(Date another) {
		return another == null || month > another.month
				|| (month == another.month && day > another.day);
	}

	@Override
	public String toString() {
		return String.format("%02d/%02d", month, day);
	}
}