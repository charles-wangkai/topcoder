public class HillHike {
	public long numPaths(int distance, int maxHeight, int[] landmarks) {
		long paths[][][] = new long[maxHeight + 1][landmarks.length + 1][2];
		paths[0][0][0] = 1;
		for (int i = 1; i <= distance; i++) {
			long temp[][][] = new long[paths.length][paths[0].length][2];
			for (int j = (i == distance ? 0 : 1); j < temp.length; j++) {
				for (int k = 0; k < temp[0].length; k++) {
					for (int m = 0; m < 2; m++) {
						int mark;
						if (k >= 1 && j == landmarks[k - 1]) {
							mark = k - 1;
						} else {
							mark = k;
						}
						int hasPeak;
						if (j == maxHeight || m == 0) {
							hasPeak = 0;
						} else {
							hasPeak = 1;
						}
						for (int p = -1; p <= 1; p++) {
							int height = j + p;
							if (height <= maxHeight && height >= 0) {
								temp[j][k][m] += paths[height][mark][hasPeak];
							}
						}
					}
				}
			}
			paths = temp;
		}
		return paths[0][landmarks.length][1];
	}
}
