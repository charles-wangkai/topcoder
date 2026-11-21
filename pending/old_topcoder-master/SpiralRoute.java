public class SpiralRoute {
	public int[] thronePosition(int width, int length) {
		int offsetX[] = { 1, 0, -1, 0 };
		int offsetY[] = { 0, 1, 0, -1 };
		int x = -1;
		int y = 0;
		int direction = 0;
		boolean palace[][] = new boolean[width][length];
		for (int step = 0; step < width * length; step++) {
			while (true) {
				int nextX = x + offsetX[direction];
				int nextY = y + offsetY[direction];
				if (nextX >= 0 && nextX < width && nextY >= 0 && nextY < length
						&& !palace[nextX][nextY]) {
					x = nextX;
					y = nextY;
					break;
				}
				direction = (direction + 1) % 4;
			}
			palace[x][y] = true;
		}
		return new int[] { x, y };
	}
}
