public class BettingStrategy {
	public int finalSum(int initSum, String outcome) {
		int sum = initSum;
		int bet = 1;
		for (int i = 0; i < outcome.length(); i++) {
			if (outcome.charAt(i) == 'W') {
				sum += bet;
				bet = 1;
			} else {
				sum -= bet;
				bet *= 2;
				if (sum < bet) {
					break;
				}
			}
		}
		return sum;
	}
}
