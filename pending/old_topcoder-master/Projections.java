public class Projections {
	public int[] count(String front, String right) {
		int frontX = countX(front);
		int rightX = countX(right);
		return new int[] { Math.max(frontX, rightX), frontX * rightX };
	}

	int countX(String line) {
		int count = 0;
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == 'x') {
				count++;
			}
		}
		return count;
	}
}
