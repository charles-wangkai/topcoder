import java.util.ArrayList;

public class UGroupOrder {
	public int[] findOrders(int N) {
		ArrayList<Integer> orders = new ArrayList<Integer>();
		for (int i = 1; i < N; i++) {
			if (gcd(i, N) == 1) {
				int order = 1;
				int number = i;
				while (number != 1) {
					number = (number * i) % N;
					order++;
				}
				orders.add(order);
			}
		}
		int result[] = new int[orders.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = orders.get(i);
		}
		return result;
	}

	int gcd(int a, int b) {
		while (b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}
}
