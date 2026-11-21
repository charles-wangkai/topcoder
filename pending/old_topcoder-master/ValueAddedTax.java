public class ValueAddedTax {
	public double calculateFinalPrice(String product, int price, String[] food) {
		for (String f : food) {
			if (product.equals(f)) {
				return price * 1.1;
			}
		}
		return price * 1.18;
	}
}
