public class FoxAndFlowerShopDivTwo {
	public int theMaxFlowers(String[] flowers, int r, int c) {
		int R = flowers.length;
		int C = flowers[0].length();
		return Math.max(Math.max(countFlowers(flowers, 0, 0, r - 1, C - 1),
				countFlowers(flowers, r + 1, 0, R - 1, C - 1)), Math.max(
				countFlowers(flowers, 0, 0, R - 1, c - 1),
				countFlowers(flowers, 0, c + 1, R - 1, C - 1)));
	}

	int countFlowers(String[] flowers, int r1, int c1, int r2, int c2) {
		int flowerNum = 0;
		for (int i = r1; i <= r2; i++) {
			for (int j = c1; j <= c2; j++) {
				if (flowers[i].charAt(j) == 'F') {
					flowerNum++;
				}
			}
		}
		return flowerNum;
	}
}
