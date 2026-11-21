public class BirthdayOdds {
	public int minPeople(int minOdds, int daysInYear) {
		double noShareProbability = 1;
		for (int i = 1;; i++) {
			noShareProbability *= (daysInYear - i + 1.0) / daysInYear;
			if (1 - noShareProbability >= minOdds / 100.0) {
				return i;
			}
		}
	}
}
