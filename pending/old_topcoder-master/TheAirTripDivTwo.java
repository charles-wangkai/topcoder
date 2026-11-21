public class TheAirTripDivTwo {
	public int find(int[] flights, int fuel) {
		int sum = 0;
		for (int i = 0; i < flights.length; i++) {
			if (sum + flights[i] > fuel) {
				return i;
			}
			sum += flights[i];
		}
		return flights.length;
	}
}
