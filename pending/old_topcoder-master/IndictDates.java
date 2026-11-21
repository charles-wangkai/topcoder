public class IndictDates {
	public int getYear(int indict, int circleSun, int circleMoon) {
		int year = circleSun;
		while (true) {
			if ((year - 1) % 15 + 1 == indict
					&& (year - 1) % 19 + 1 == circleMoon) {
				return year;
			}
			year += 28;
		}
	}
}
