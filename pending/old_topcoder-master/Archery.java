public class Archery {
	public double expectedPoints(int N, int[] ringPoints) {
		int totalPoint = 0;
		for (int i = 0; i < ringPoints.length; i++) {
			totalPoint += (i * 2 + 1) * ringPoints[i];
		}
		return (double) totalPoint / (ringPoints.length * ringPoints.length);
	}
}
