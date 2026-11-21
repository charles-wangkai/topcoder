import java.util.HashMap;

public class InterestingParty {
	public int bestInvitation(String[] first, String[] second) {
		HashMap<String, Integer> topic2count = new HashMap<String, Integer>();
		for (int i = 0; i < first.length; i++) {
			increaseCount(topic2count, first[i]);
			increaseCount(topic2count, second[i]);
		}
		int maxCount = 0;
		for (int count : topic2count.values()) {
			maxCount = Math.max(maxCount, count);
		}
		return maxCount;
	}

	void increaseCount(HashMap<String, Integer> topic2count, String topic) {
		if (topic2count.containsKey(topic)) {
			topic2count.put(topic, topic2count.get(topic) + 1);
		} else {
			topic2count.put(topic, 1);
		}
	}
}
