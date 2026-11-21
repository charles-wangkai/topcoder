public class Inventory {
	public int monthlyOrder(int[] sales, int[] daysAvailable) {
		double total = 0;
		int n = 0;
		for (int i = 0; i < sales.length; i++) {
			if (daysAvailable[i] == 0) {
				continue;
			}
			total += sales[i] * 30.0 / daysAvailable[i];
			n++;
		}
		return (int) Math.ceil(total / n - (1E-9));
	}
}
