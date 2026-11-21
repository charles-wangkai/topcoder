public class SpeedTyper {
	public String lettersToPractice(String letters, int[] times) {
		String result = "";
		int average = times[times.length - 1] / times.length;
		for (int i = 0; i < times.length; i++) {
			int keyTime = (i == 0) ? times[0] : (times[i] - times[i - 1]);
			if (keyTime > average) {
				result += letters.charAt(i);
			}
		}
		return result;
	}
}
