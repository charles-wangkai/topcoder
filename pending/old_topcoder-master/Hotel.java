import java.util.Arrays;

public class Hotel {
	public int marketCost(int minCustomers, int[] customers, int[] cost) {
		int minCosts[] = new int[minCustomers + max(customers)];
		Arrays.fill(minCosts, Integer.MAX_VALUE);
		minCosts[0] = 0;
		for (int i = 0; i < minCustomers; i++) {
			if (minCosts[i] == Integer.MAX_VALUE) {
				continue;
			}
			for (int j = 0; j < customers.length; j++) {
				minCosts[i + customers[j]] = (int) Math.min(minCosts[i
						+ customers[j]], (long) (minCosts[i] + cost[j]));
			}
		}
		int result = Integer.MAX_VALUE;
		for (int i = minCustomers; i < minCosts.length; i++) {
			result = Math.min(result, minCosts[i]);
		}
		return result;
	}

	int max(int numbers[]) {
		int result = Integer.MIN_VALUE;
		for (int number : numbers) {
			result = Math.max(result, number);
		}
		return result;
	}
}
