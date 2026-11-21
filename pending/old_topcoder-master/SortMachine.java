import java.util.ArrayList;
import java.util.Collections;

public class SortMachine {
	public int countMoves(int[] a) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		ArrayList<Integer> sorted = new ArrayList<Integer>();
		for (int number : a) {
			numbers.add(number);
			sorted.add(number);
		}
		Collections.sort(sorted);
		int pos = -1;
		int moveNum = a.length;
		for (int i = 0; i < sorted.size(); i++) {
			int nextPos = numbers.indexOf(sorted.get(i));
			if (nextPos > pos) {
				moveNum--;
			} else {
				break;
			}
			pos = nextPos;
		}
		return moveNum;
	}
}
