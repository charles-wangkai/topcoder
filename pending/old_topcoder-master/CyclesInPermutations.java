public class CyclesInPermutations {
	public int maxCycle(int[] board) {
		int maxStep = -1;
		for (int i = 0; i < board.length; i++) {
			int step = 0;
			int pos = i;
			while (true) {
				pos = board[pos] - 1;
				step++;
				if (pos == i) {
					break;
				}
			}
			maxStep = Math.max(maxStep, step);
		}
		return maxStep;
	}
}
