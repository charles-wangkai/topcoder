public class TippingWaiters {
	public int possiblePayments(int bill, int cash) {
		int minPay = (int) (bill * 20L / 19) + ((bill * 20L % 19 == 0) ? 0 : 1);
		while (minPay % 5 != 0) {
			minPay++;
		}
		int maxPay = (int) Math.min(bill * 10L / 9, cash);
		while (maxPay % 5 != 0) {
			maxPay--;
		}
		if (minPay > maxPay) {
			return 0;
		} else {
			return (maxPay - minPay) / 5 + 1;
		}
	}
}
