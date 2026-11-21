public class ParallelepipedUnion {
	public int getVolume(String[] parallelepipeds) {
		Cube cube1 = new Cube(parallelepipeds[0]);
		Cube cube2 = new Cube(parallelepipeds[1]);
		return cube1.size() + cube2.size()
				- intersect(cube1.x1, cube1.x2, cube2.x1, cube2.x2)
				* intersect(cube1.y1, cube1.y2, cube2.y1, cube2.y2)
				* intersect(cube1.z1, cube1.z2, cube2.z1, cube2.z2);
	}

	int intersect(int min1, int max1, int min2, int max2) {
		int min = Math.max(min1, min2);
		int max = Math.min(max1, max2);
		return Math.max(max - min, 0);
	}
}

class Cube {
	int x1;
	int y1;
	int z1;
	int x2;
	int y2;
	int z2;

	Cube(String parallelepiped) {
		String fields[] = parallelepiped.split(" ");
		x1 = Integer.parseInt(fields[0]);
		y1 = Integer.parseInt(fields[1]);
		z1 = Integer.parseInt(fields[2]);
		x2 = Integer.parseInt(fields[3]);
		y2 = Integer.parseInt(fields[4]);
		z2 = Integer.parseInt(fields[5]);
	}

	int size() {
		return (x2 - x1) * (y2 - y1) * (z2 - z1);
	}
}