public class FuelConsumption {
	public double maximalDistance(int[] velocities, int[] consumptions, int fuel) {
		double maxDistance = -1;
		for (int i = 0; i < velocities.length; i++) {
			maxDistance = Math.max(maxDistance, (double) velocities[i] * fuel
					/ consumptions[i]);
		}
		return maxDistance;
	}
}
