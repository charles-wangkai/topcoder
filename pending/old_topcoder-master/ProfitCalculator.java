public class ProfitCalculator {
	public int percent(String[] items) {
		double totalPrice = 0;
		double totalCost = 0;
		for (String item : items) {
			double price = Double.parseDouble(item.substring(0, 6));
			double cost = Double.parseDouble(item.substring(7));
			totalPrice += price;
			totalCost += cost;
		}
		return (int) Math.floor((totalPrice - totalCost) * 100 / totalPrice);
	}
}
