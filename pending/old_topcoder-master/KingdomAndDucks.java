import java.util.HashMap;

public class KingdomAndDucks {
	public int minDucks(int[] duckTypes) {
		int maxCount = -1;
		HashMap<Integer, Integer> type2count = new HashMap<Integer, Integer>();
		for (int duckType : duckTypes) {
			if (type2count.containsKey(duckType)) {
				type2count.put(duckType, type2count.get(duckType) + 1);
			} else {
				type2count.put(duckType, 1);
			}
			maxCount = Math.max(maxCount, type2count.get(duckType));
		}
		return type2count.size() * maxCount;
	}
}
