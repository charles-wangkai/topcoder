public class FoxPaintingBalls {
	public long theMax(long R, long G, long B, int N) {
		if (N == 1) {
			return R + G + B;
		}
		long triangleBall = (long) N * (N + 1) / 2;
		long avgBall = triangleBall / 3;
		long minColor = Math.min(Math.min(R, G), B);
		return Math.min(minColor / avgBall, (R + G + B) / triangleBall);
	}
}
