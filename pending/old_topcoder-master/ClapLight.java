public class ClapLight {
	public int threshold(int[] background) {
		for (int i = 1;; i++) {
			int lowNum = 0;
			for (int item : background) {
				if (item < i) {
					lowNum++;
				}
			}
			if (lowNum * 2 <= background.length) {
				continue;
			}
			boolean trigger = false;
			for (int j = 0; j + 4 <= background.length; j++) {
				if (background[j] < i && background[j + 1] >= i
						&& background[j + 2] >= i && background[j + 3] < i) {
					trigger = true;
					break;
				}
			}
			if (!trigger) {
				return i;
			}
		}
	}
}
