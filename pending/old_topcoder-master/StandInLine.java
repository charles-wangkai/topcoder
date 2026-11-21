public class StandInLine {
	public int[] reconstruct(int[] left) {
		int heights[] = new int[left.length];
		for (int i = 0; i < left.length; i++) {
			int remain = left[i];
			int pos = 0;
			while (true) {
				if (heights[pos] == 0) {
					if (remain == 0) {
						heights[pos] = i + 1;
						break;
					}
					remain--;
				}
				pos++;
			}
		}
		return heights;
	}
}
