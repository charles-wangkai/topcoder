public class Chocolate {
	public int minSplitNumber(int width, int height, int nTiles) {
		long area = (long) width * height;
		if (area == nTiles) {
			return 0;
		}
		if (area > nTiles && (nTiles % width == 0 || nTiles % height == 0)) {
			return 1;
		}
		for (int size1 = 1; size1 * size1 <= nTiles; size1++) {
			if (nTiles % size1 == 0) {
				int size2 = nTiles / size1;
				if ((size1 < width && size2 < height)
						|| (size1 < height && size2 < width)) {
					return 2;
				}
			}
		}
		return -1;
	}
}
