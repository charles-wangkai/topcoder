public class CoinsExchange {
	public int countExchanges(int G1, int S1, int B1, int G2, int S2, int B2) {
		int coins[] = new int[] { G1, S1, B1 };
		int targets[] = new int[] { G2, S2, B2 };
		int minExchange = min(new int[] {
				countExchangeNum(
						coins.clone(),
						targets.clone(),
						new Exchange[] { new Exchange(1, 2), new Exchange(0, 1) }),
				countExchangeNum(
						coins.clone(),
						targets.clone(),
						new Exchange[] { new Exchange(1, 0), new Exchange(2, 1) }),
				countExchangeNum(
						coins.clone(),
						targets.clone(),
						new Exchange[] { new Exchange(0, 1), new Exchange(2, 1) }),
				countExchangeNum(
						coins.clone(),
						targets.clone(),
						new Exchange[] { new Exchange(1, 0), new Exchange(1, 2) }) });
		return (minExchange == Integer.MAX_VALUE) ? -1 : minExchange;
	}

	int countExchangeNum(int coins[], int targets[], Exchange exchanges[]) {
		int exchangeNum = 0;
		boolean satisfyTo = (exchanges[0].from == exchanges[1].to);
		for (Exchange exchange : exchanges) {
			while (coins[exchange.to] < targets[exchange.to]
					&& (satisfyTo || coins[exchange.from] - exchange.getMinus() >= targets[exchange.from])) {
				coins[exchange.from] -= exchange.getMinus();
				coins[exchange.to] += exchange.getPlus();
				exchangeNum++;
			}
		}
		for (int i = 0; i < coins.length; i++) {
			if (coins[i] < targets[i]) {
				return Integer.MAX_VALUE;
			}
		}
		return exchangeNum;
	}

	int min(int numbers[]) {
		int result = Integer.MAX_VALUE;
		for (int number : numbers) {
			result = Math.min(result, number);
		}
		return result;
	}
}

class Exchange {
	int from;
	int to;

	Exchange(int from, int to) {
		this.from = from;
		this.to = to;
	}

	int getMinus() {
		return (from < to) ? 1 : 11;
	}

	int getPlus() {
		return (from < to) ? 9 : 1;
	}
}