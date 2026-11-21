import java.util.ArrayList;
import java.util.Arrays;

public class Intervals {
	public String[] partition(String[] intervals) {
		int size = intervals.length;
		if (size == 0) {
			return new String[0];
		}
		ArrayList<String> result = new ArrayList<String>();
		int begin[] = new int[size];
		int end[] = new int[size];
		for (int i = 0; i < size; i++) {
			String str[] = intervals[i].split(":");
			begin[i] = Integer.parseInt(str[0]);
			end[i] = Integer.parseInt(str[1]);
		}
		Arrays.sort(begin);
		Arrays.sort(end);
		int start = begin[0];
		int posBegin = 1;
		int posEnd = 0;
		boolean lastIsEnd = false;
		while (posBegin < size || posEnd < size) {
			if (posBegin == size || end[posEnd] <= begin[posBegin] - 1) {
				if (start <= end[posEnd]) {
					result.add(start + ":" + end[posEnd]);
					start = end[posEnd] + 1;
				}
				posEnd++;
				lastIsEnd = true;
			} else {
				if (!(lastIsEnd && posBegin == posEnd)
						&& start <= begin[posBegin] - 1) {
					result.add(start + ":" + (begin[posBegin] - 1));
				}
				if (start < begin[posBegin]) {
					start = begin[posBegin];
				}
				posBegin++;
				lastIsEnd = false;
			}
		}
		return result.toArray(new String[] {});
	}
}
