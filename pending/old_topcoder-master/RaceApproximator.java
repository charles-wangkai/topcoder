public class RaceApproximator {
	public String timeToBeat(int d1, int t1, int d2, int t2, int raceDistance) {
		int time = (int) Math.floor(t1
				* Math.exp(Math.log((double) t2 / t1)
						* Math.log((double) d1 / raceDistance)
						/ Math.log((double) d1 / d2)));
		int second = time % 60;
		int minute = time / 60 % 60;
		int hour = time / 3600;
		return String.format("%d:%02d:%02d", hour, minute, second);
	}
}
