public class BigCube {
	public String largestCube(String[] range) {
		long intervals[][] = new long[range.length][2];
		long limit = -1;
		for (int i = 0; i < intervals.length; i++) {
			String fields[] = range[i].split("-");
			for (int j = 0; j < fields.length; j++) {
				intervals[i][j] = Long.parseLong(fields[j]);
			}
			limit = Math.max(limit, intervals[i][1]);
		}
		for (int i = (int) Math.ceil(Math.pow(limit, 1.0 / 3)); i >= 0; i--) {
			long cube = (long) i * i * i;
			for (long interval[] : intervals) {
				if (cube >= interval[0] && cube <= interval[1]) {
					return cube + "";
				}
			}
		}
		return "";
	}
}
