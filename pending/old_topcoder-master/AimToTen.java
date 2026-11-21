public class AimToTen {
	public int need(int[] marks) {
		int sum = 0;
		for (int mark : marks) {
			sum += mark;
		}
		return Math.max(0, 19 * marks.length - 2 * sum);
	}
}
