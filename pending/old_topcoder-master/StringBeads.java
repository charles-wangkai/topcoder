public class StringBeads {
	static long ways[][][][][][][];

	public long numWays(int[] beads) {
		int temp[] = new int[5];
		for (int i = 0; i < beads.length; i++) {
			temp[i] = beads[i];
		}
		ways = new long[temp[0] + 1][temp[1] + 1][temp[2] + 1][temp[3] + 1][temp[4] + 1][6][6];
		return search(temp[0], temp[1], temp[2], temp[3], temp[4], 0, 0);
	}

	long search(int bead1, int bead2, int bead3, int bead4, int bead5,
			int prev1, int prev2) {
		if (ways[bead1][bead2][bead3][bead4][bead5][prev1][prev2] > 0) {
			return ways[bead1][bead2][bead3][bead4][bead5][prev1][prev2] - 1;
		}
		if (bead1 == 0 && bead2 == 0 && bead3 == 0 && bead4 == 0 && bead5 == 0) {
			ways[bead1][bead2][bead3][bead4][bead5][prev1][prev2] = 2;
			return 1;
		}
		long total = 0;
		if (bead1 > 0 && prev1 != 1 && prev2 != 1) {
			total += search(bead1 - 1, bead2, bead3, bead4, bead5, prev2, 1);
		}
		if (bead2 > 0 && prev1 != 2 && prev2 != 2) {
			total += search(bead1, bead2 - 1, bead3, bead4, bead5, prev2, 2);
		}
		if (bead3 > 0 && prev1 != 3 && prev2 != 3) {
			total += search(bead1, bead2, bead3 - 1, bead4, bead5, prev2, 3);
		}
		if (bead4 > 0 && prev1 != 4 && prev2 != 4) {
			total += search(bead1, bead2, bead3, bead4 - 1, bead5, prev2, 4);
		}
		if (bead5 > 0 && prev1 != 5 && prev2 != 5) {
			total += search(bead1, bead2, bead3, bead4, bead5 - 1, prev2, 5);
		}
		ways[bead1][bead2][bead3][bead4][bead5][prev1][prev2] = total + 1;
		return total;
	}
}
