public class ReturnToHome {
	public double goHome(int X, int Y, int D, int T) {
		double distance = Math.sqrt(X * X + Y * Y);
		double minTime = distance;
		if (D > T) {
			double time = 0;
			while (distance >= D) {
				time += T;
				distance -= D;
			}
			minTime = Math.min(minTime, time + distance);
			if (time > 0) {
				minTime = Math.min(minTime, time + T);
			} else {
				minTime = Math.min(minTime, T + D - distance);
				minTime = Math.min(minTime, T + T);
			}
		}
		return minTime;
	}
}
