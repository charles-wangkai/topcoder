public class Shuffling {
	public int position(int cards, int[] shuffles) {
		boolean aces[] = new boolean[cards];
		aces[0] = true;
		for (int shuffle : shuffles) {
			if (shuffle > 0) {
				aces = drop(aces, new int[] { cards / 2, 0 }, new int[] {
						cards / 2, cards / 2 }, 1, shuffle);
			} else {
				aces = drop(aces, new int[] { cards / 2, 0 }, new int[] {
						cards / 2, cards / 2 }, 0, -shuffle);
			}
		}
		for (int i = 0;; i++) {
			if (aces[i]) {
				return i;
			}
		}
	}

	boolean[] drop(boolean aces[], int cardIndices[], int remainingCards[],
			int index, int remaining) {
		boolean nextAces[] = new boolean[aces.length];
		for (int i = 0; i < nextAces.length; i++) {
			nextAces[i] = aces[cardIndices[index]];
			cardIndices[index]++;
			remainingCards[index]--;
			remaining--;
			if (remaining == 0 && remainingCards[1 - index] > 0) {
				index = 1 - index;
				remaining = 1;
			}
		}
		return nextAces;
	}
}
