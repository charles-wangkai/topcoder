public class AutoLoan {
	public double interestRate(double price, double monthlyPayment, int loanTerm) {
		final double ERROR = 1e-12;
		double lower = 0;
		double upper = 100;
		double middle = 0;
		while (true) {
			middle = (lower + upper) / 2;
			if (upper - lower < ERROR) {
				break;
			}
			double balance = calcBalance(price, monthlyPayment, loanTerm,
					middle / 100);
			if (balance > 0) {
				upper = middle;
			} else {
				lower = middle;
			}
		}
		return middle * 12;
	}

	double calcBalance(double price, double monthlyPayment, int loanTerm,
			double monthlyRate) {
		double balance = price;
		for (int i = 0; i < loanTerm; i++) {
			balance += balance * monthlyRate - monthlyPayment;
		}
		return balance;
	}
}
