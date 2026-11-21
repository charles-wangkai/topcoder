import java.util.Arrays;

public class ShufflingMachine {
	public double stackDeck(int[] shuffle, int maxShuffles,
			int[] cardsReceived, int K) {
		int cardNum = shuffle.length;
		int counts[] = new int[cardNum];
		int cards[] = new int[cardNum];
		for (int i = 0; i < cards.length; i++) {
			cards[i] = i;
		}
		for (int i = 0; i < maxShuffles; i++) {
			cards = performShuffle(cards, shuffle);
			for (int cardReceived : cardsReceived) {
				counts[cards[cardReceived]]++;
			}
		}
		Arrays.sort(counts);
		int total = 0;
		for (int i = cardNum - 1; i >= cardNum - K; i--) {
			total += counts[i];
		}
		return (double) total / maxShuffles;
	}

	int[] performShuffle(int cards[], int shuffle[]) {
		int nextCards[] = new int[cards.length];
		for (int i = 0; i < nextCards.length; i++) {
			nextCards[i] = cards[shuffle[i]];
		}
		return nextCards;
	}
}
