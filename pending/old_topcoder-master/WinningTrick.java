public class WinningTrick {
	public double minimumSpeed(int[] speed, int yourSpeed) {
		int max = -1;
		for (int i = 0; i < speed.length; i++) {
			if (speed[i] > max) {
				max = speed[i];
			}
		}
		if (yourSpeed >= max) {
			return 0;
		} else {
			return (max - yourSpeed) / 2.0;
		}
	}
}
