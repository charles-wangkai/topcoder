public class TaxTable {
	public int income(int taxAmount) {
		int atLeasts[] = { 100000, 117250, 178650, 319100 };
		int lessThans[] = { 117250, 178650, 319100, Integer.MAX_VALUE };
		double multipliers[] = { 0.25, 0.28, 0.33, 0.35 };
		double subtractions[] = { 6525, 10042.5, 18975, 25357 };
		for (int i = 0;; i++) {
			double minTax = tax(atLeasts[i], multipliers[i], subtractions[i]);
			if (taxAmount < minTax) {
				return -1;
			}
			double maxTax = tax(lessThans[i], multipliers[i], subtractions[i]);
			if (taxAmount <= maxTax) {
				return (int) Math.round((taxAmount + subtractions[i])
						/ multipliers[i]);
			}
		}
	}

	double tax(int taxable, double multiplier, double subtraction) {
		return taxable * multiplier - subtraction;
	}
}
