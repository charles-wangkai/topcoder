public class ToastXToast {
	public int bake(int[] undertoasted, int[] overtoasted) {
		int groups[] = new int[1000001];
		for (int under : undertoasted) {
			groups[under] = -1;
		}
		for (int over : overtoasted) {
			groups[over] = 1;
		}
		int sorted[] = new int[undertoasted.length + overtoasted.length];
		int sortedIndex = 0;
		for (int group : groups) {
			if (group != 0) {
				sorted[sortedIndex] = group;
				sortedIndex++;
			}
		}
		if (sorted[0] != -1 || sorted[sorted.length - 1] != 1) {
			return -1;
		}
		for (int i = 0; i < sorted.length - 1; i++) {
			if (sorted[i] == 1 && sorted[i + 1] == -1) {
				return 2;
			}
		}
		return 1;
	}
}
