public class HockeyFault {
	public int numPlayers(int width, int height, int x, int y, int[] px,
			int[] py) {
		int playerNum = 0;
		for (int i = 0; i < px.length; i++) {
			if (px[i] >= x && px[i] <= x + width) {
				if (py[i] >= y && py[i] <= y + height) {
					playerNum++;
				}
			} else if (px[i] < x) {
				if (distSquare(px[i], py[i], x, y + height / 2) <= height
						* height / 4) {
					playerNum++;
				}
			} else {
				if (distSquare(px[i], py[i], x + width, y + height / 2) <= height
						* height / 4) {
					playerNum++;
				}
			}
		}
		return playerNum;
	}

	int distSquare(int x1, int y1, int x2, int y2) {
		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
	}
}
