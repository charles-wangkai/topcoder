public class Embassy {
	int totalTime;
	int timeInDay;

	public int visaApplication(int[] forms, int dayLength, int openTime) {
		int minTotalTime = Integer.MAX_VALUE;
		for (int beginTimeInDay = 0; beginTimeInDay < dayLength; beginTimeInDay++) {
			totalTime = 0;
			timeInDay = beginTimeInDay;
			for (int form : forms) {
				elapse(form, dayLength);
				if (timeInDay > openTime) {
					elapse(dayLength - timeInDay, dayLength);
				}
			}
			minTotalTime = Math.min(minTotalTime, totalTime);
		}
		return minTotalTime;
	}

	void elapse(int time, int dayLength) {
		totalTime += time;
		timeInDay = (timeInDay + time) % dayLength;
	}
}
