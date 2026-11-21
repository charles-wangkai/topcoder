public class BigBurger {
	public int maxWait(int[] arrival, int[] service) {
		int length = arrival.length;
		int servTimes;
		int time = 0;
		int max = -1;
		for (int i = 0; i < length; i++) {
			servTimes = Math.max(time, arrival[i]);
			max = Math.max(max, servTimes - arrival[i]);
			time = servTimes + service[i];
		}
		return max;
	}
}
