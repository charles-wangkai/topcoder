public class RGBColor {
	public int[] getComplement(int[] rgb) {
		int complement[] = new int[3];
		boolean close = true;
		for (int i = 0; i < 3; i++) {
			complement[i] = 255 - rgb[i];
			if (Math.abs(complement[i] - rgb[i]) > 32) {
				close = false;
			}
		}
		if (close) {
			for (int i = 0; i < 3; i++) {
				if (rgb[i] >= 128) {
					complement[i] = rgb[i] - 128;
				} else {
					complement[i] = rgb[i] + 128;
				}
			}
		}
		return complement;
	}
}
