public class AmoebaDivTwo {
	public int count(String[] table, int K) {
		int wayNum = 0;
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[0].length(); j++) {
				int offsetX[] = { 0, 1 };
				int offsetY[] = { 1, 0 };
				for (int d = 0; d < offsetX.length; d++) {
					if (i + offsetX[d] * (K - 1) >= table.length
							|| j + offsetY[d] * (K - 1) >= table[0].length()) {
						continue;
					}
					boolean valid = true;
					for (int p = 0; p < K; p++) {
						if (table[i + offsetX[d] * p]
								.charAt(j + offsetY[d] * p) != 'A') {
							valid = false;
							break;
						}
					}
					if (valid) {
						wayNum++;
					}
				}
			}
		}
		if (K == 1) {
			wayNum /= 2;
		}
		return wayNum;
	}
}
