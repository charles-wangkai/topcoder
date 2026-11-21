import java.util.HashSet;

public class CardStraights {
	public int longestStraight(int[] cards) {
		HashSet<Integer> positives = new HashSet<Integer>();
		int jokerNum = 0;
		for (int card : cards) {
			if (card == 0) {
				jokerNum++;
			} else {
				positives.add(card);
			}
		}
		int maxStraight = jokerNum;
		for (int positive : positives) {
			maxStraight = Math.max(maxStraight,
					getStraight(positives, positive, jokerNum));
		}
		return maxStraight;
	}

	int getStraight(HashSet<Integer> positives, int from, int jokerNum) {
		int straight = 0;
		for (int i = from;; i++) {
			if (!positives.contains(i)) {
				if (jokerNum == 0) {
					return straight;
				}
				jokerNum--;
			}
			straight++;
		}
	}
}
