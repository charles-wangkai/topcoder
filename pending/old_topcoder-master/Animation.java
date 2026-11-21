import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Animation {
	public String[] animate(int speed, String init) {
		int length = init.length();
		Queue<Integer> lefts = new LinkedList<Integer>();
		Queue<Integer> rights = new LinkedList<Integer>();
		for (int i = 0; i < length; i++) {
			char ch = init.charAt(i);
			if (ch == 'L') {
				lefts.offer(i);
			} else if (ch == 'R') {
				rights.offer(i);
			}
		}
		ArrayList<String> animation = new ArrayList<String>();
		animation.add(init.replaceAll("[LR]", "X"));
		while (!lefts.isEmpty() || !rights.isEmpty()) {
			boolean occupied[] = new boolean[length];
			int leftSize = lefts.size();
			for (int i = 0; i < leftSize; i++) {
				int pos = lefts.poll();
				if (pos >= speed) {
					occupied[pos - speed] = true;
					lefts.offer(pos - speed);
				}
			}
			int rightSize = rights.size();
			for (int i = 0; i < rightSize; i++) {
				int pos = rights.poll();
				if (pos + speed < length) {
					occupied[pos + speed] = true;
					rights.offer(pos + speed);
				}
			}
			String chamber = "";
			for (int i = 0; i < occupied.length; i++) {
				chamber += (occupied[i] ? "X" : ".");
			}
			animation.add(chamber);
		}
		String result[] = new String[animation.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = animation.get(i);
		}
		return result;
	}
}
