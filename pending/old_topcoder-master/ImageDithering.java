public class ImageDithering {
	public int count(String dithered, String[] screen) {
		int ditherNum = 0;
		for (String row : screen) {
			for (int i = 0; i < row.length(); i++) {
				if (dithered.indexOf(row.charAt(i)) >= 0) {
					ditherNum++;
				}
			}
		}
		return ditherNum;
	}
}
