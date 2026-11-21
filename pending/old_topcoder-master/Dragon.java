public class Dragon {
	double dragonProb;
	double knightProb;
	double dragonTurn[][];
	double knightTurn[][];

	public double winFight(int h, int k, int probDragon, int probKnight) {
		dragonProb = probDragon / 100.0;
		knightProb = probKnight / 100.0;

		dragonTurn = new double[h + 1][k + 1];
		knightTurn = new double[h + 1][k + 1];
		for (int i = 1; i <= h; i++) {
			dragonTurn[i][0] = 1;
			knightTurn[i][0] = 1;
		}
		for (int j = 1; j <= k; j++) {
			dragonTurn[0][j] = 0;
			knightTurn[0][j] = 0;
		}

		for (int i = 1; i <= h; i++) {
			for (int j = 1; j <= k; j++) {
				dragonTurn[i][j] = -1;
				knightTurn[i][j] = -1;
			}
		}

		return 1 - dragon(h, k);
	}

	double dragon(int h, int k) {
		if (dragonTurn[h][k] >= 0) {
			return dragonTurn[h][k];
		}
		return dragonTurn[h][k] = Math.max(dragonProb * dragon(h, k - 1)
				+ (1 - dragonProb) * dragon(h - 1, k), knight(h, k));
	}

	double knight(int h, int k) {
		if (knightTurn[h][k] >= 0) {
			return knightTurn[h][k];
		}
		return knightTurn[h][k] = (1 - knightProb) * knight(h, k - 1)
				+ knightProb * knight(h - 1, k - 1);
	}
}
