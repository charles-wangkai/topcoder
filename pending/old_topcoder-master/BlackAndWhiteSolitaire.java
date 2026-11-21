public class BlackAndWhiteSolitaire {
	public int minimumTurns(String cardFront) {
		return Math.min(countTurn(cardFront, 'B'), countTurn(cardFront, 'W'));
	}

	int countTurn(String cardFront, char firstCard) {
		int turnNum = 0;
		for (int i = 0; i < cardFront.length(); i++) {
			turnNum += ((i % 2 == 0) == (cardFront.charAt(i) == firstCard)) ? 1
					: 0;
		}
		return turnNum;
	}
}
