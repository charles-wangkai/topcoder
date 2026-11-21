import java.util.HashMap;

public class GroceryBagger {
	public int minimumBags(int strength, String[] itemType) {
		HashMap<String, Integer> type2count = new HashMap<String, Integer>();
		for (String type : itemType) {
			if (type2count.containsKey(type)) {
				type2count.put(type, type2count.get(type) + 1);
			} else {
				type2count.put(type, 1);
			}
		}
		int bagNum = 0;
		for (int count : type2count.values()) {
			bagNum += count / strength + (count % strength == 0 ? 0 : 1);
		}
		return bagNum;
	}
}
