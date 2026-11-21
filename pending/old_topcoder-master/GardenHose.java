public class GardenHose {
	public int countDead(int n, int rowDist, int colDist, int hoseDist) {
		int rowSide = hoseDist / rowDist;
		int deathRow = Math.max(n - rowSide * 2, 0);
		int columnSide = hoseDist / colDist;
		int deathColumn = Math.max(n - columnSide * 2, 0);
		return deathRow * deathColumn;
	}
}
