public class BestView {
	public int numberOfBuildings(int[] heights) {
		Vector[] roofs = new Vector[heights.length];
		for (int i = 0; i < roofs.length; i++) {
			roofs[i] = new Vector(i, heights[i]);
		}
		int maxSee = 0;
		for (int i = 0; i < roofs.length; i++) {
			int see = 0;
			if (i > 0) {
				see++;
				Vector prev = new Vector(roofs[i], roofs[i - 1]);
				for (int j = i - 2; j >= 0; j--) {
					Vector cur = new Vector(roofs[i], roofs[j]);
					if ((long) cur.y * prev.x < (long) prev.y * cur.x) {
						see++;
						prev = cur;
					}
				}
			}
			if (i + 1 < roofs.length) {
				see++;
				Vector prev = new Vector(roofs[i], roofs[i + 1]);
				for (int j = i + 2; j < roofs.length; j++) {
					Vector cur = new Vector(roofs[i], roofs[j]);
					if ((long) cur.y * prev.x > (long) prev.y * cur.x) {
						see++;
						prev = cur;
					}
				}
			}
			maxSee = Math.max(maxSee, see);
		}
		return maxSee;
	}
}

class Vector {
	int x;
	int y;

	Vector(int x, int y) {
		this.x = x;
		this.y = y;
	}

	Vector(Vector from, Vector to) {
		this.x = to.x - from.x;
		this.y = to.y - from.y;
	}
}