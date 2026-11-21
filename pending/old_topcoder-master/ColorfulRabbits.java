import java.util.HashMap;
import java.util.Map.Entry;

public class ColorfulRabbits {
	public int getMinimum(int[] replies) {
		HashMap<Integer, Integer> reply2count = new HashMap<Integer, Integer>();
		for (int oneReplies : replies) {
			if (!reply2count.containsKey(oneReplies)) {
				reply2count.put(oneReplies, 0);
			}
			reply2count.put(oneReplies, reply2count.get(oneReplies) + 1);
		}
		int result = 0;
		for (Entry<Integer, Integer> entry : reply2count.entrySet()) {
			int reply = entry.getKey();
			int count = entry.getValue();
			result += (reply + 1) * divideToCeil(count, reply + 1);
		}
		return result;
	}

	int divideToCeil(int a, int b) {
		return a / b + ((a % b == 0) ? 0 : 1);
	}
}
