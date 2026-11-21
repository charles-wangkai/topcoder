public class PenguinTiles {
	public int minMoves(String[] tiles) {
		int row = tiles.length;
		int col = tiles[0].length();
		for (int i = 0;; i++) {
			for (int j = 0; j < col; j++) {
				if (tiles[i].charAt(j) == '.') {
					if (i == row - 1 || j == col - 1) {
						if (i == row - 1 && j == col - 1) {
							return 0;
						} else {
							return 1;
						}
					} else {
						return 2;
					}
				}
			}
		}
	}
}
