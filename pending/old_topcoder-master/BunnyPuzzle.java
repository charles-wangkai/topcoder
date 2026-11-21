public class BunnyPuzzle {
	public int theCount(int[] bunnies) {
		int pairNum = 2;
		for (int i = 1; i < bunnies.length - 1; i++) {
			if (bunnies[i] - bunnies[i - 1] != bunnies[i + 1] - bunnies[i]) {
				pairNum++;
			}
		}
		return pairNum;
	}
}
