public class Cannons {
	public String getDirections(int[] x, int[] y) {
		String result = "";
		for (int i = 0; i < x.length; i++) {
			boolean impossibles[] = new boolean[4];
			for (int j = 0; j < x.length; j++) {
				if (j != i) {
					if (x[j] == x[i] && y[j] < y[i]) {
						impossibles[0] = true;
					}
					if (y[j] == y[i] && x[j] < x[i]) {
						impossibles[1] = true;
					}
					if (y[j] == y[i] && x[j] > x[i]) {
						impossibles[2] = true;
					}
					if (x[j] == x[i] && y[j] > y[i]) {
						impossibles[3] = true;
					}
				}
			}
			if (impossibles[0] && impossibles[1] && impossibles[2]
					&& impossibles[3]) {
				return "";
			}
			char directions[] = { 'D', 'L', 'R', 'U' };
			for (int j = 0; j < 4; j++) {
				if (!impossibles[j]) {
					result += directions[j];
					break;
				}
			}
		}
		return result;
	}
}
