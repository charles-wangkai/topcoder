public class TravellingByTrain {
	public String earliestArrival(String[] timeTable) {
		int day = 1;
		Time time = new Time("09:00");
		for (String oneTimeTable : timeTable) {
			int minMinute = Integer.MAX_VALUE;
			String trains[] = oneTimeTable.split(" ");
			for (String train : trains) {
				String times[] = train.split("-");
				Time leave = new Time(times[0]);
				Time arrive = new Time(times[1]);
				minMinute = Math.min(
						minMinute,
						Time.interval(time, leave, false)
								+ Time.interval(leave, arrive, true));
			}
			day += time.addMinute(minMinute);
		}
		return time + ", day " + day;
	}
}

class Time {
	static final int MINUTES_IN_DAY = 24 * 60;
	int hour;
	int minute;

	public Time(String timeStr) {
		this.hour = Integer.parseInt(timeStr.substring(0, 2));
		this.minute = Integer.parseInt(timeStr.substring(3));
	}

	@Override
	public String toString() {
		return String.format("%02d:%02d", hour, minute);
	}

	static int interval(Time t1, Time t2, boolean mustPositive) {
		int result = (t2.toMinute() - t1.toMinute() + MINUTES_IN_DAY)
				% MINUTES_IN_DAY;
		if (mustPositive && result == 0) {
			result = MINUTES_IN_DAY;
		}
		return result;
	}

	int toMinute() {
		return hour * 60 + minute;
	}

	int addMinute(int addedMinute) {
		int newMinute = toMinute() + addedMinute;
		int addedDay = newMinute / MINUTES_IN_DAY;
		newMinute %= MINUTES_IN_DAY;
		hour = newMinute / 60;
		minute = newMinute % 60;
		return addedDay;
	}
}