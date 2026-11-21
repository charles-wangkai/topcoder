public class TurretPlacement {
	public long count(int[] x, int[] y) {
		long wayNum = 0;
		for (int i = 0; i < x.length; i++) {
			for (int j = i + 1; j < x.length; j++) {
				int wholeDist = (int) Math.floor(Math.sqrt((x[i] - x[j])
						* (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j])) * 2);
				wayNum += wholeDist * (wholeDist - 1L) / 2;
			}
		}
		return wayNum;
	}
}
