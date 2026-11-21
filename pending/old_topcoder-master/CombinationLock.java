public class CombinationLock {
	public double degreesTurned(int[] combo, int size, int start) {
		double total = 0;
		int pointTo = start;
		boolean increase = true;
		int n = combo.length;
		for (int target : combo) {
			total += n * 360;
			int diff;
			if (increase) {
				diff = target - pointTo;
			} else {
				diff = pointTo - target;
			}
			total += (diff + size) % size * 360.0 / size;
			n--;
			increase = !increase;
			pointTo = target;
		}
		return total;
	}
}
