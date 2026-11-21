public class CubeAnts {
	public int getMinimumSteps(int[] pos) {
		int turns[] = new int[] { 0, 1, 2, 1, 1, 2, 3, 2 };
		int maxTurn = -1;
		for (int p : pos) {
			maxTurn = Math.max(maxTurn, turns[p]);
		}
		return maxTurn;
	}
}
