public class CarBuyer {
	public double lowestCost(String[] cars, int fuelPrice, int annualDistance,
			int years) {
		double lowest = Double.MAX_VALUE;
		for (String car : cars) {
			String fields[] = car.split(" ");
			int purchaseCost = Integer.parseInt(fields[0]);
			int tax = Integer.parseInt(fields[1]);
			int fuelEfficiency = Integer.parseInt(fields[2]);
			double cost = purchaseCost + tax * years + (double) fuelPrice
					* annualDistance * years / fuelEfficiency;
			lowest = Math.min(lowest, cost);
		}
		return lowest;
	}
}
