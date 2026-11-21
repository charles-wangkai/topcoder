public class RosePetals {
	public int getScore(int[] dice) {
		int petals[] = { -1, 0, 0, 2, 0, 4, 0 };
		int score = 0;
		for (int d : dice) {
			score += petals[d];
		}
		return score;
	}
}
