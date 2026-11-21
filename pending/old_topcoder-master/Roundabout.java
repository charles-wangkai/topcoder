import java.util.LinkedList;

public class Roundabout {
	@SuppressWarnings("unchecked")
	public int clearUpTime(String north, String east, String south, String west) {
		char directions[] = { 'N', 'E', 'S', 'W' };
		char roundabouts[] = new char[4];
		LinkedList<Character> entries[] = new LinkedList[4];
		for (int i = 0; i < 4; i++) {
			entries[i] = new LinkedList<Character>();
		}
		String comes[] = { north, east, south, west };
		int total = 0;
		int time = 0;
		while (true) {
			boolean hasCome = false;
			for (int i = 0; i < 4; i++) {
				if (comes[i].length() > time) {
					hasCome = true;
					char ch = comes[i].charAt(time);
					if (ch != '-') {
						entries[i].offer(ch);
					}
				}
			}
			int entryCount = 0;
			boolean hasInside = false;
			for (int i = 0; i < 4; i++) {
				if (!entries[i].isEmpty()) {
					entryCount++;
				}
				if (roundabouts[i] != 0) {
					hasInside = true;
				}
			}
			if (!hasCome && entryCount == 0 && !hasInside) {
				break;
			}
			char nextRoundabouts[] = new char[4];
			if (entryCount == 4) {
				if (roundabouts[1] == 0) {
					nextRoundabouts[0] = entries[0].poll();
				}
			} else {
				for (int i = 0; i < 4; i++) {
					if (!entries[i].isEmpty() && entries[(i + 1) % 4].isEmpty()
							&& roundabouts[(i + 1) % 4] == 0
							&& nextRoundabouts[(i + 1) % 4] == 0) {
						nextRoundabouts[i] = entries[i].poll();
					}
				}
			}
			for (int i = 0; i < 4; i++) {
				if (roundabouts[i] != 0 && roundabouts[i] != directions[i]) {
					nextRoundabouts[(i + 3) % 4] = roundabouts[i];
				} else {
					if (roundabouts[i] == directions[i]) {
						total = time + 1;
					}
				}
			}
			roundabouts = nextRoundabouts;
			time++;
		}
		return total;
	}
}
