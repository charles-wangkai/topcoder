public class GridPointsOnCircle {
	public int countPoints(int rSquare) {
		int count = 0;
		for (int i = 0; i * i * 2 <= rSquare; i++) {
			int j = (int) Math.round(Math.sqrt(rSquare - i * i));
			if (i * i + j * j != rSquare) {
				continue;
			}
			if (i == 0 || i == j) {
				count += 4;
			} else {
				count += 8;
			}
		}
		return count;
	}
}
