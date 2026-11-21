public class TrueStatements {
	public int numberTrue(int[] statements) {
		int counts[] = new int[51];
		for (int statement : statements) {
			counts[statement]++;
		}
		for (int i = counts.length - 1; i >= 0; i--) {
			if (counts[i] == i) {
				return i;
			}
		}
		return -1;
	}
}
