public class TheSimpleGame {
	public int count(int n, int[] x, int[] y) {
		int cornerX[] = { 1, 1, n, n };
		int cornerY[] = { 1, n, 1, n };
		int moveTotal = 0;
		for (int i = 0; i < x.length; i++) {
			int move = Integer.MAX_VALUE;
			for (int j = 0; j < cornerX.length; j++) {
				move = Math.min(
						move,
						Math.abs(x[i] - cornerX[j])
								+ Math.abs(y[i] - cornerY[j]));
			}
			moveTotal += move;
		}
		return moveTotal;
	}
}
