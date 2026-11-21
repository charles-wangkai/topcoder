public class BlackjackWinner {
	public int winnings(int bet, int dealer, int dealerBlackjack, int player,
			int blackjack) {
		if (blackjack > dealerBlackjack
				|| (player <= 21 && (dealer > 21 || player > dealer))) {
			if (blackjack == 1) {
				return bet / 2 * 3;
			} else {
				return bet;
			}
		} else if (player <= 21 && player == dealer
				&& dealerBlackjack == blackjack) {
			return 0;
		} else {
			return -bet;
		}
	}
}
