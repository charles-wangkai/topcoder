public class TireRotation {
	public int getCycle(String initial, String current) {
		String tires = initial;
		for (int i = 1; i <= 4; i++) {
			if (tires.equals(current)) {
				return i;
			}
			tires = "" + tires.charAt(3) + tires.charAt(2) + tires.charAt(0)
					+ tires.charAt(1);
		}
		return -1;
	}
}
