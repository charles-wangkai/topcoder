public class ValueHistogram {
	public String[] build(int[] values) {
		int[] counts = new int[10];
		int maxCount = 0;
		for (int value : values) {
			counts[value]++;
			maxCount = Math.max(maxCount, counts[value]);
		}

		String[] histogram = new String[maxCount + 1];
		for (int i = 0; i < histogram.length; i++) {
			histogram[i] = "";
			for (int j = 0; j < 10; j++) {
				histogram[i] += (counts[j] + i >= histogram.length) ? 'X' : '.';
			}
		}
		return histogram;
	}
}
