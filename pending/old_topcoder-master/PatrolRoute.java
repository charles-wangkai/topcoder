public class PatrolRoute {
	final int MODULO = 1000000007;

	public int countRoutes(int X, int Y, int minT, int maxT) {
		int result = 0;
		for (int time = minT; time <= maxT; time++) {
			if (time % 2 != 0) {
				continue;
			}
			for (int timeX = 4; timeX <= 2 * X - 2 && timeX + 4 <= time; timeX += 2) {
				int timeY = time - timeX;
				if (timeY > 2 * Y - 2) {
					continue;
				}
				result = addMod(
						result,
						multiplyMod(
								multiplyMod(computeWayNum(X, timeX / 2),
										computeWayNum(Y, timeY / 2)), 6));
			}
		}
		return result;
	}

	int computeWayNum(int size, int interval) {
		return multiplyMod(size - interval, interval - 1);
	}

	int addMod(int a, int b) {
		return (a + b) % MODULO;
	}

	int multiplyMod(int a, int b) {
		return (int) ((long) a * b % MODULO);
	}
}
