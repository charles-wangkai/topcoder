public class Thimbles {
	public int thimbleWithBall(String[] swaps) {
		int ball = 1;
		for (String swap : swaps) {
			int pos1 = swap.charAt(0) - '0';
			int pos2 = swap.charAt(2) - '0';
			if (pos1 == ball) {
				ball = pos2;
			} else if (pos2 == ball) {
				ball = pos1;
			}
		}
		return ball;
	}
}
