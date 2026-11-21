public class StreetWalking {
	public long minTime(int X, int Y, int walkTime, int sneakTime) {
		long time;
		if (sneakTime < walkTime * 2) {
			time = (long) Math.min(X, Y) * sneakTime;
			long rest = Math.abs(X - Y);
			if (sneakTime < walkTime) {
				time += rest / 2 * (sneakTime * 2) + rest % 2 * walkTime;
			} else {
				time += rest * walkTime;
			}
		} else {
			time = (long) (X + Y) * walkTime;
		}
		return time;
	}
}
