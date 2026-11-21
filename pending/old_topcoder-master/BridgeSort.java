import java.util.Arrays;
import java.util.Comparator;

public class BridgeSort {
	public String sortedHand(String hand) {
		String cards[] = new String[hand.length() / 2];
		for (int i = 0; i < cards.length; i++) {
			cards[i] = hand.substring(i * 2, i * 2 + 2);
		}
		Arrays.sort(cards, new CardComparator());
		String result = "";
		for (String card : cards) {
			result += card;
		}
		return result;
	}
}

class CardComparator implements Comparator<String> {
	public int compare(String card1, String card2) {
		char suit1 = card1.charAt(0);
		char suit2 = card2.charAt(0);
		if (suit1 != suit2) {
			return suit1 - suit2;
		}
		int value1 = convertToValue(card1.charAt(1));
		int value2 = convertToValue(card2.charAt(1));
		return value1 - value2;
	}

	int convertToValue(char ch) {
		if (ch >= '2' && ch <= '9') {
			return ch - '0';
		} else if (ch == 'T') {
			return 10;
		} else if (ch == 'J') {
			return 11;
		} else if (ch == 'Q') {
			return 12;
		} else if (ch == 'K') {
			return 13;
		} else {
			return 14;
		}
	}
}