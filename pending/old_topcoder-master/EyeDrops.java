public class EyeDrops {
	public double closest(int sleepTime, int k) {
		if (sleepTime * k <= 24) {
			return 1440.0 / k;
		} else {
			return (1440.0 - sleepTime * 60) / (k - 1);
		}
	}
}
