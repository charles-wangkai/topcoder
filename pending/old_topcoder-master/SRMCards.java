import java.util.Arrays;

public class SRMCards {
	public int maxTurns(int[] cards) {
		Arrays.sort(cards);
		int turn = 0;
		int length = 1;
		for (int i = 1; i <= cards.length; i++) {
			if (i < cards.length && cards[i] == cards[i - 1] + 1) {
				length++;
			} else {
				turn += (length + 1) / 2;
				length = 1;
			}
		}
		return turn;
	}
}
