public class Subway2 {
	public double minTime(int length, int maxAcceleration, int maxVelocity) {
		double timeToMaxV = (double) maxVelocity / maxAcceleration;
		double time;
		if (maxAcceleration * timeToMaxV * timeToMaxV <= length) {
			time = timeToMaxV * 2
					+ (length - maxAcceleration * timeToMaxV * timeToMaxV)
					/ maxVelocity;
		} else {
			time = 2 * Math.sqrt((double) length / maxAcceleration);
		}
		return time;
	}
}
