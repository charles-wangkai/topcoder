public class BettingMoney {
	public int moneyMade(int[] amounts, int[] centsPerDollar, int finalResult) {
		int netGain = 0;
		for (int i = 0; i < amounts.length; i++) {
			if (i == finalResult) {
				netGain -= amounts[i] * centsPerDollar[i];
			} else {
				netGain += amounts[i] * 100;
			}
		}
		return netGain;
	}
}
