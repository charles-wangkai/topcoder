public class RandomColoringDiv2 {
	public int getCount(int maxR, int maxG, int maxB, int startR, int startG,
			int startB, int d1, int d2) {
		int count = 0;
		for (int r = 0; r < maxR; r++) {
			for (int g = 0; g < maxG; g++) {
				for (int b = 0; b < maxB; b++) {
					if (isGoodTransition(Math.abs(r - startR),
							Math.abs(g - startG), Math.abs(b - startB), d1, d2)) {
						count++;
					}
				}
			}
		}
		return count;
	}

	boolean isGoodTransition(int diffR, int diffG, int diffB, int d1, int d2) {
		return diffR <= d2 && diffG <= d2 && diffB <= d2
				&& (diffR >= d1 || diffG >= d1 || diffB >= d1);
	}
}
