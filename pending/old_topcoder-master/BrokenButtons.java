import java.util.Arrays;

public class BrokenButtons {
	boolean digits[] = new boolean[10];

	public int minPresses(int page, int[] broken) {
		final int CURRENT_PAGE = 100;
		Arrays.fill(digits, true);
		for (int oneBroken : broken) {
			digits[oneBroken] = false;
		}
		int minPress = Math.abs(page - CURRENT_PAGE);
		int lower = Math.max(0, page - minPress);
		int upper = page + minPress;
		for (int i = lower; i <= upper; i++) {
			if (canReach(i)) {
				int press = (i + "").length() + Math.abs(i - page);
				minPress = Math.min(minPress, press);
			}
		}
		return minPress;
	}

	boolean canReach(int page) {
		String pageStr = page + "";
		for (int i = 0; i < pageStr.length(); i++) {
			if (!digits[pageStr.charAt(i) - '0']) {
				return false;
			}
		}
		return true;
	}
}
