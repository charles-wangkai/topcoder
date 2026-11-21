public class FussySleeper {
	public int[] nextTime(int[] currentTime, int elephants) {
		int hour = currentTime[0];
		int minute = currentTime[1];
		while (true) {
			minute = (minute + 1) % 60;
			if (minute == 0) {
				hour = (hour + 1) % 24;
			}
			if ((hour * 100 + minute) % elephants == 0) {
				return new int[] { hour, minute };
			}
		}
	}
}
