public class BrokenClock {
	public int fewestClicks(String clockTime, String currentTime) {
		Time clock = new Time(clockTime);
		Time current = new Time(currentTime);
		int clickNum = 0;
		while (clock.hour != current.hour) {
			clock.increaseHourAndMinute();
			clickNum++;
		}
		while (clock.minute != current.minute) {
			clock.increaseMinute();
			clickNum++;
		}
		return clickNum;
	}
}

class Time {
	int hour;
	int minute;

	Time(String str) {
		String fields[] = str.split(":");
		hour = Integer.parseInt(fields[0]);
		minute = Integer.parseInt(fields[1]);
	}

	void increaseHour() {
		hour = (hour + 1) % 24;
	}

	void increaseMinute() {
		minute = (minute + 1) % 60;
	}

	void increaseHourAndMinute() {
		increaseHour();
		increaseMinute();
	}
}