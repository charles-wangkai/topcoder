public class OrderedSuperString {
	public int getLength(String[] words) {
		String orderedSuper = "";
		int fromIndex = 0;
		for (String word : words) {
			int index = orderedSuper.indexOf(word, fromIndex);
			if (index >= 0) {
				fromIndex = index;
			} else {
				for (int begin = word.length() - 1;; begin--) {
					if (fromIndex + begin <= orderedSuper.length()
							&& orderedSuper.endsWith(word.substring(0, begin))) {
						orderedSuper += word.substring(begin);
						fromIndex = orderedSuper.length() - word.length();
						break;
					}
				}
			}
		}
		return orderedSuper.length();
	}
}
