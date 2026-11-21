public class MysteriousRestaurant {
	public int maxDays(String[] prices, int budget) {
		int dayNum = 0;
		Day[] days = new Day[7];
		for (int i = 0; i < days.length; i++) {
			days[i] = new Day(prices[0].length());
		}
		while (dayNum < prices.length) {
			Day day = new Day(prices[dayNum]);
			days[dayNum % 7].add(day);
			budget -= days[dayNum % 7].delta;
			if (budget < 0) {
				break;
			}
			dayNum++;
		}
		return dayNum;
	}
}

class Day {
	int[] dollars;
	int minPrice;
	int minIndex;
	int delta;

	Day(int length) {
		dollars = new int[length];
	}

	Day(String price) {
		dollars = new int[price.length()];
		for (int i = 0; i < dollars.length; i++) {
			dollars[i] = decode(price.charAt(i));
		}

		updateMin();
	}

	void updateMin() {
		minPrice = Integer.MAX_VALUE;
		minIndex = -1;
		for (int i = 0; i < dollars.length; i++) {
			if (dollars[i] < minPrice) {
				minPrice = dollars[i];
				minIndex = i;
			}
		}
	}

	int decode(char ch) {
		if (Character.isDigit(ch)) {
			return ch - '0';
		}
		if (Character.isUpperCase(ch)) {
			return ch - 'A' + 10;
		}
		return ch - 'a' + 36;
	}

	void add(Day day) {
		int prevMinPrice = minPrice;
		for (int i = 0; i < dollars.length; i++) {
			dollars[i] += day.dollars[i];
		}

		updateMin();
		delta = minPrice - prevMinPrice;
	}
}