public class ClockWalk {
	public int finalPosition(String flips) {
		int position = 11;
		for (int i = 0; i < flips.length(); i++) {
			if (flips.charAt(i) == 'h') {
				position = (position + i + 1) % 12;
			} else {
				position = ((position - i - 1) % 12 + 12) % 12;
			}
		}
		return position + 1;
	}
}
