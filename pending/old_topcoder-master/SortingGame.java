import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class SortingGame {
	public int fewestMoves(int[] board, int k) {
		int n = board.length;
		String target = "";
		for (int i = 1; i <= n; i++) {
			target += i;
		}
		String start = "";
		for (int number : board) {
			start += number;
		}
		HashSet<String> history = new HashSet<String>();
		history.add(start);
		Queue<Element> queue = new LinkedList<Element>();
		queue.offer(new Element(start, 0));
		while (!queue.isEmpty()) {
			Element head = queue.poll();
			if (head.sequence.equals(target)) {
				return head.step;
			}
			for (int i = 0; i + k <= n; i++) {
				String nextSequence = reverse(head.sequence, i, i + k);
				if (!history.contains(nextSequence)) {
					history.add(nextSequence);
					queue.offer(new Element(nextSequence, head.step + 1));
				}
			}
		}
		return -1;
	}

	String reverse(String str, int begin, int end) {
		return str.substring(0, begin)
				+ new StringBuffer(str.substring(begin, end)).reverse()
						.toString() + str.substring(end);
	}
}

class Element {
	String sequence;
	int step;

	public Element(String sequence, int step) {
		this.sequence = sequence;
		this.step = step;
	}
}