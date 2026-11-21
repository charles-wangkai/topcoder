import java.util.ArrayList;

public class Over9000Rocks {
	public int countPossibilities(int[] lowerBound, int[] upperBound) {
		final int ROCK_MIN_NUM = 9001;

		ArrayList<Range> ranges = new ArrayList<Range>();
		ranges.add(new Range(0, 0));
		for (int i = 0; i < lowerBound.length; i++) {
			ArrayList<Range> rangesAfterChosen = choose(ranges, lowerBound[i],
					upperBound[i]);
			ranges = merge(ranges, rangesAfterChosen);
		}
		int xNum = 0;
		for (Range range : ranges) {
			if (range.upper >= ROCK_MIN_NUM) {
				xNum += range.upper - Math.max(ROCK_MIN_NUM, range.lower) + 1;
			}
		}
		return xNum;
	}

	ArrayList<Range> choose(ArrayList<Range> ranges, int lowerB, int upperB) {
		ArrayList<Range> rangesAfterChosen = new ArrayList<Range>();
		for (Range range : ranges) {
			rangesAfterChosen.add(new Range(range.lower + lowerB, range.upper
					+ upperB));
		}
		return rangesAfterChosen;
	}

	ArrayList<Range> merge(ArrayList<Range> ranges1, ArrayList<Range> ranges2) {
		ArrayList<Range> merged = new ArrayList<Range>();
		int index1 = 0;
		int index2 = 0;
		while (index1 < ranges1.size() || index2 < ranges2.size()) {
			Range range;
			if (index2 == ranges2.size()
					|| (index1 < ranges1.size() && ranges1.get(index1).lower <= ranges2
							.get(index2).lower)) {
				range = ranges1.get(index1);
				index1++;
			} else {
				range = ranges2.get(index2);
				index2++;
			}
			if (merged.isEmpty()
					|| merged.get(merged.size() - 1).upper < range.lower) {
				merged.add(range);
			} else {
				merged.get(merged.size() - 1).upper = Math.max(
						merged.get(merged.size() - 1).upper, range.upper);
			}
		}
		return merged;
	}
}

class Range {
	int lower;
	int upper;

	Range(int lower, int upper) {
		this.lower = lower;
		this.upper = upper;
	}
}