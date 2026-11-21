public class Soccer {
	public int maxPoints(int[] wins, int[] ties) {
		int maxPoint = -1;
		for (int i = 0; i < wins.length; i++) {
			maxPoint = Math.max(maxPoint, wins[i] * 3 + ties[i]);
		}
		return maxPoint;
	}
}
