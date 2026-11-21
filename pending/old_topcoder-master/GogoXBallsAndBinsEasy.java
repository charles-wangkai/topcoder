public class GogoXBallsAndBinsEasy {
	public int solve(int[] T) {
		int move = 0;
		for (int i = 0, j = T.length - 1; i < j; i++, j--) {
			move += T[j] - T[i];
		}
		return move;
	}
}
