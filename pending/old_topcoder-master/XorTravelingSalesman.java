import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class XorTravelingSalesman {
	public int maxProfit(int[] cityValues, String[] roads) {
		int result = cityValues[0];
		HashSet<City_Value> history = new HashSet<City_Value>();
		City_Value start = new City_Value(0, cityValues[0]);
		history.add(start);
		Queue<City_Value> queue = new LinkedList<City_Value>();
		queue.offer(start);
		while (!queue.isEmpty()) {
			City_Value head = queue.poll();
			for (int i = 0; i < roads.length; i++) {
				if (roads[head.city].charAt(i) == 'Y') {
					int nextValue = head.value ^ cityValues[i];
					City_Value cv = new City_Value(i, nextValue);
					if (!history.contains(cv)) {
						history.add(cv);
						result = Math.max(result, nextValue);
						queue.offer(cv);
					}
				}
			}
		}
		return result;
	}
}

class City_Value {
	int city;
	int value;

	City_Value(int city, int value) {
		this.city = city;
		this.value = value;
	}

	@Override
	public int hashCode() {
		return city * value;
	}

	@Override
	public boolean equals(Object obj) {
		City_Value other = (City_Value) obj;
		return city == other.city && value == other.value;
	}
}