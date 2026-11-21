public class TransportCounting {
	public int countBuses(int speed, int[] positions, int[] velocities, int time) {
		int count = 0;
		for (int i = 0; i < positions.length; i++) {
			if (positions[i] == 0
					|| (speed - velocities[i]) * time >= positions[i]) {
				count++;
			}
		}
		return count;
	}
}
