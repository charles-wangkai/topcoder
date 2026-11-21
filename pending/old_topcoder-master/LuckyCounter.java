public class LuckyCounter {
	public int countLuckyMoments(String[] moments) {
		int luckyNum = 0;
		for (String moment : moments) {
			if ((moment.charAt(0) == moment.charAt(3) && moment.charAt(1) == moment
					.charAt(4))
					|| (moment.charAt(0) == moment.charAt(1) && moment
							.charAt(3) == moment.charAt(4))
					|| (moment.charAt(0) == moment.charAt(4) && moment
							.charAt(1) == moment.charAt(3))) {
				luckyNum++;
			}
		}
		return luckyNum;
	}
}
