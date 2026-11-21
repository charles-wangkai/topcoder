public class PairingPawns {
	public int savedPawnCount(int[] start) {
		for (int i = start.length - 1; i > 0; i--) {
			start[i - 1] += start[i] / 2;
		}
		return start[0];
	}
}
