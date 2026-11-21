public class FeudaliasBattle {
	public double getMinimumTime(int[] baseX, int[] baseY, int[] siloX,
			int[] siloY, int takeOffTime, int rechargeTime, int missileSpeed) {
		double takeOffMinute = takeOffTime / 60.0;
		return min(new double[] {
				takeOffMinute
						+ Math.max(
								calcTime(siloX[0], siloY[0], baseX[0],
										baseY[0], missileSpeed),
								rechargeTime
										+ takeOffMinute
										+ calcTime(siloX[0], siloY[0],
												baseX[1], baseY[1],
												missileSpeed)),
				takeOffMinute
						+ Math.max(
								rechargeTime
										+ takeOffMinute
										+ calcTime(siloX[0], siloY[0],
												baseX[0], baseY[0],
												missileSpeed),
								calcTime(siloX[0], siloY[0], baseX[1],
										baseY[1], missileSpeed)),
				takeOffMinute
						+ Math.max(
								calcTime(siloX[1], siloY[1], baseX[0],
										baseY[0], missileSpeed),
								rechargeTime
										+ takeOffMinute
										+ calcTime(siloX[1], siloY[1],
												baseX[1], baseY[1],
												missileSpeed)),
				takeOffMinute
						+ Math.max(
								rechargeTime
										+ takeOffMinute
										+ calcTime(siloX[1], siloY[1],
												baseX[0], baseY[0],
												missileSpeed),
								calcTime(siloX[1], siloY[1], baseX[1],
										baseY[1], missileSpeed)),
				takeOffMinute
						+ Math.max(
								calcTime(siloX[0], siloY[0], baseX[0],
										baseY[0], missileSpeed),
								calcTime(siloX[1], siloY[1], baseX[1],
										baseY[1], missileSpeed)),
				takeOffMinute
						+ Math.max(
								calcTime(siloX[1], siloY[1], baseX[0],
										baseY[0], missileSpeed),
								calcTime(siloX[0], siloY[0], baseX[1],
										baseY[1], missileSpeed)) }

		);
	}

	double min(double numbers[]) {
		double result = Double.MAX_VALUE;
		for (double number : numbers) {
			result = Math.min(result, number);
		}
		return result;
	}

	double calcTime(int siloX, int siloY, int baseX, int baseY, int missileSpeed) {
		return Math.sqrt(square(siloX - baseX) + square(siloY - baseY))
				/ missileSpeed;
	}

	long square(int number) {
		return (long) number * number;
	}
}
