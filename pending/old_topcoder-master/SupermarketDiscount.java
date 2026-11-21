public class SupermarketDiscount {
	public int minAmount(int[] goods) {
		int amounts[] = {
				transaction(goods[0]) + transaction(goods[1])
						+ transaction(goods[2]),
				transaction(goods[0] + goods[1]) + transaction(goods[2]),
				transaction(goods[1] + goods[2]) + transaction(goods[0]),
				transaction(goods[2] + goods[0]) + transaction(goods[1]),
				transaction(goods[0] + goods[1] + goods[2]) };
		int min = Integer.MAX_VALUE;
		for (int amount : amounts) {
			min = Math.min(min, amount);
		}
		return min;
	}

	int transaction(int cost) {
		return (cost >= 50) ? (cost - 10) : cost;
	}
}
