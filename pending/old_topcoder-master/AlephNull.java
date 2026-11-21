public class AlephNull {
	public int[] rational(int generation, int item) {
		int begin = 0;
		int end = 1 << generation - 1;
		if (item > end) {
			return new int[] { 0, 0 };
		}
		int numeratorBegin = 0;
		int denominatorBegin = 1;
		int numeratorEnd = 1;
		int denominatorEnd = 0;
		while (begin + 1 < end) {
			int middle = begin + (end - begin) / 2;
			int numeratorMiddle = numeratorBegin + numeratorEnd;
			int denominatorMiddle = denominatorBegin + denominatorEnd;
			if (item == middle) {
				return new int[] { numeratorMiddle, denominatorMiddle };
			} else if (item < middle) {
				end = middle;
				numeratorEnd = numeratorMiddle;
				denominatorEnd = denominatorMiddle;
			} else {
				begin = middle;
				numeratorBegin = numeratorMiddle;
				denominatorBegin = denominatorMiddle;
			}
		}
		if (item == begin) {
			return new int[] { numeratorBegin, denominatorBegin };
		} else {
			return new int[] { numeratorEnd, denominatorEnd };
		}
	}
}
