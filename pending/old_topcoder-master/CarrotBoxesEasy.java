public class CarrotBoxesEasy {
	public int theIndex(int[] carrots, int K) {
		for (int i = 1;; i++) {
			int index = 0;
			for (int j = 1; j < carrots.length; j++) {
				if (carrots[j] > carrots[index]) {
					index = j;
				}
			}
			carrots[index]--;
			if (i == K) {
				return index;
			}
		}
	}
}
