public class ThreePhotos {
	int size;

	public int removeCubes(String[] A, String[] B, String[] C) {
		size = A.length;
		boolean cubes[][][] = new boolean[size][size][size];
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				for (int z = 0; z < size; z++) {
					cubes[x][y][z] = true;
				}
			}
		}
		LineGenerator lineGeneratorA = new XYLineGenerator();
		LineGenerator lineGeneratorB = new XZLineGenerator();
		LineGenerator lineGeneratorC = new YZLineGenerator();
		removeByPhoto(cubes, A, lineGeneratorA);
		removeByPhoto(cubes, B, lineGeneratorB);
		removeByPhoto(cubes, C, lineGeneratorC);
		if (!checkByPhoto(cubes, A, lineGeneratorA)
				|| !checkByPhoto(cubes, B, lineGeneratorB)
				|| !checkByPhoto(cubes, C, lineGeneratorC)) {
			return -1;
		}
		int removeNum = 0;
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				for (int z = 0; z < size; z++) {
					if (!cubes[x][y][z]) {
						removeNum++;
					}
				}
			}
		}
		return removeNum;
	}

	void removeByPhoto(boolean cubes[][][], String photo[],
			LineGenerator lineGenerator) {
		for (int coordinate1 = 0; coordinate1 < size; coordinate1++) {
			for (int coordinate2 = 0; coordinate2 < size; coordinate2++) {
				if (photo[coordinate1].charAt(coordinate2) == 'N') {
					for (Point point : lineGenerator.generateLine(coordinate1,
							coordinate2)) {
						cubes[point.x][point.y][point.z] = false;
					}
				}
			}
		}
	}

	boolean checkByPhoto(boolean cubes[][][], String photo[],
			LineGenerator lineGenerator) {
		for (int coordinate1 = 0; coordinate1 < size; coordinate1++) {
			for (int coordinate2 = 0; coordinate2 < size; coordinate2++) {
				if (photo[coordinate1].charAt(coordinate2) == 'Y') {
					boolean blocked = false;
					for (Point point : lineGenerator.generateLine(coordinate1,
							coordinate2)) {
						if (cubes[point.x][point.y][point.z]) {
							blocked = true;
							break;
						}
					}
					if (!blocked) {
						return false;
					}
				}
			}
		}
		return true;
	}

	class XYLineGenerator implements LineGenerator {
		public Point[] generateLine(int x, int y) {
			Point points[] = new Point[size];
			for (int z = 0; z < points.length; z++) {
				points[z] = new Point(x, y, z);
			}
			return points;
		}
	}

	class XZLineGenerator implements LineGenerator {
		public Point[] generateLine(int x, int z) {
			Point points[] = new Point[size];
			for (int y = 0; y < points.length; y++) {
				points[y] = new Point(x, y, z);
			}
			return points;
		}
	}

	class YZLineGenerator implements LineGenerator {
		public Point[] generateLine(int y, int z) {
			Point points[] = new Point[size];
			for (int x = 0; x < points.length; x++) {
				points[x] = new Point(x, y, z);
			}
			return points;
		}
	}
}

class Point {
	int x;
	int y;
	int z;

	public Point(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

interface LineGenerator {
	Point[] generateLine(int coordinate1, int coordinate2);
}
