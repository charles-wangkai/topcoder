import java.util.Arrays;

public class LightsCube {
	public int[] count(int N, String[] lights) {
		int colors[][][] = new int[N][N][N];
		for (int i = 0; i < lights.length; i++) {
			String fields[] = lights[i].split(" ");
			int x = Integer.parseInt(fields[0]);
			int y = Integer.parseInt(fields[1]);
			int z = Integer.parseInt(fields[2]);
			colors[x][y][z] = i + 1;
		}
		int colorNums[] = new int[lights.length];
		Arrays.fill(colorNums, 1);
		while (true) {
			boolean changed = false;
			int nextColors[][][] = new int[N][N][N];
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					for (int z = 0; z < N; z++) {
						nextColors[x][y][z] = colors[x][y][z];
					}
				}
			}
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					for (int z = 0; z < N; z++) {
						if (colors[x][y][z] != 0) {
							continue;
						}
						int offsetX[] = { -1, 1, 0, 0, 0, 0 };
						int offsetY[] = { 0, 0, -1, 1, 0, 0 };
						int offsetZ[] = { 0, 0, 0, 0, -1, 1 };
						int minColor = 0;
						for (int i = 0; i < offsetX.length; i++) {
							int nextX = x + offsetX[i];
							int nextY = y + offsetY[i];
							int nextZ = z + offsetZ[i];
							if (nextX >= 0
									&& nextX < N
									&& nextY >= 0
									&& nextY < N
									&& nextZ >= 0
									&& nextZ < N
									&& colors[nextX][nextY][nextZ] != 0
									&& (minColor == 0 || colors[nextX][nextY][nextZ] < minColor)) {
								minColor = colors[nextX][nextY][nextZ];
							}
						}
						if (minColor != 0) {
							nextColors[x][y][z] = minColor;
							colorNums[minColor - 1]++;
							changed = true;
						}
					}
				}
			}
			if (!changed) {
				break;
			}
			colors = nextColors;
		}
		return colorNums;
	}
}
