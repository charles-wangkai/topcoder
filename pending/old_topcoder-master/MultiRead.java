public class MultiRead {
	public int minCycles(String trace, int procs) {
		int cycle = 0;
		int readNum = 0;
		for (int i = 0; i <= trace.length(); i++) {
			if (i < trace.length() && trace.charAt(i) == 'R') {
				readNum++;
			} else {
				if (i < trace.length()) {
					cycle++;
				}
				cycle += (int) Math.ceil((double) readNum / procs);
				readNum = 0;
			}
		}
		return cycle;
	}
}
