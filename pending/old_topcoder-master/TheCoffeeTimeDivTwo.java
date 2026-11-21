import java.util.ArrayList;
import java.util.Arrays;

public class TheCoffeeTimeDivTwo {
	final int PASSENGER_PER_ROUND = 7;
	final int FILL_FLASK_TIME = 47;
	final int SERVE_ONE_TIME = 4;

	public int find(int n, int[] tea) {
		Arrays.sort(tea);
		ArrayList<Integer> coffeeList = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			coffeeList.add(i);
		}
		ArrayList<Integer> teaList = new ArrayList<Integer>();
		for (int oneTea : tea) {
			coffeeList.remove(new Integer(oneTea));
			teaList.add(oneTea);
		}
		return calcServeTime(coffeeList) + calcServeTime(teaList);
	}

	int calcServeTime(ArrayList<Integer> passengers) {
		int passengerNum = passengers.size();
		int round = passengerNum / PASSENGER_PER_ROUND
				+ (passengerNum % PASSENGER_PER_ROUND == 0 ? 0 : 1);
		int time = round * FILL_FLASK_TIME + passengerNum * SERVE_ONE_TIME;
		for (int i = passengerNum - 1; i >= 0; i -= PASSENGER_PER_ROUND) {
			time += 2 * passengers.get(i);
		}
		return time;
	}
}
