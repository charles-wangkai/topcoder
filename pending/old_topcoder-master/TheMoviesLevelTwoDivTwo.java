import java.util.ArrayList;

public class TheMoviesLevelTwoDivTwo {
	ArrayList<int[]> orders = new ArrayList<int[]>();

	public int[] find(int[] length, int[] scary) {
		int[] initOrder = new int[length.length];
		for (int i = 0; i < initOrder.length; i++) {
			initOrder[i] = i;
		}
		searchOrders(initOrder, 0);
		int maxMovieNum = -1;
		int[] bestOrder = null;
		for (int[] order : orders) {
			int movieNum = calcMovieNum(order, length, scary);
			if (movieNum > maxMovieNum
					|| (movieNum == maxMovieNum && isBefore(order, bestOrder))) {
				maxMovieNum = movieNum;
				bestOrder = order;
			}
		}
		return bestOrder;
	}

	int calcMovieNum(int[] order, int[] length, int[] scary) {
		int level = 74;
		for (int i = 0;; i++) {
			if (i == order.length || level < scary[order[i]]
					|| level + 47 < length[order[i]]) {
				return i;
			}
			level += 47 - length[order[i]];
		}
	}

	boolean isBefore(int[] order1, int[] order2) {
		for (int i = 0;; i++) {
			if (order1[i] != order2[i]) {
				return order1[i] < order2[i];
			}
		}
	}

	void searchOrders(int[] order, int index) {
		if (index == order.length) {
			orders.add(order.clone());
			return;
		}
		for (int i = index; i < order.length; i++) {
			swap(order, index, i);
			searchOrders(order, index + 1);
			swap(order, index, i);
		}
	}

	void swap(int[] order, int index1, int index2) {
		int temp = order[index1];
		order[index1] = order[index2];
		order[index2] = temp;
	}
}
