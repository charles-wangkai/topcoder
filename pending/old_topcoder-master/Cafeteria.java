public class Cafeteria {
	public String latestTime(int[] offset, int[] walkingTime, int[] drivingTime) {
		int maxTime = -1;
		for (int i = 0; i < offset.length; i++) {
			maxTime = Math.max(maxTime,
					calcTime(offset[i], walkingTime[i], drivingTime[i]));
		}
		int hour = maxTime / 60;
		if (hour > 12) {
			hour -= 12;
		}
		int minute = maxTime % 60;
		return String.format("%02d:%02d", hour, minute);
	}

	int calcTime(int offset, int walkingTime, int drivingTime) {
		int time = 14 * 60 + 30;
		time -= drivingTime;
		while (time % 10 != offset) {
			time--;
		}
		return time - walkingTime;
	}
}
