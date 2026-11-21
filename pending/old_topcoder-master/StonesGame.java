public class StonesGame {
	public String winner(int N, int M, int K, int L) {
		if (inOneStep(N, K, M, L)) {
			return "Romeo";
		}
		boolean firstPlayerLost = true;
		for (int i = 1; i <= N; i++) {
			if (inOneStep(N, K, M, i) && !inOneStep(N, K, i, L)) {
				firstPlayerLost = false;
				break;
			}
		}
		if (firstPlayerLost) {
			return "Strangelet";
		} else {
			return "Draw";
		}
	}

	boolean inOneStep(int size, int stone, int pos1, int pos2) {
		int left = Math.min(pos1, pos2);
		int right = Math.max(pos1, pos2);
		int interval = right - left + 1;
		if (stone >= interval && (stone - interval) % 2 == 0) {
			int side = (stone - interval) / 2;
			if (side <= left - 1 && side <= size - right) {
				return true;
			}
		}
		return false;
	}
}
