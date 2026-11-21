public class bloggoHyphenate {
	public String[] correct(String[] dictionary, String[] candidates) {
		String result[] = new String[candidates.length];
		for (int i = 0; i < result.length; i++) {
			String candidateNoHyphen = candidates[i].replace("-", "");
			for (String dictWord : dictionary) {
				String dictWordNoSpace = dictWord.replace(" ", "");
				if (dictWordNoSpace.equals(candidateNoHyphen)) {
					if (dictWord.indexOf(' ') < 0) {
						result[i] = dictWordNoSpace;
					} else {
						int leftNum = candidates[i].indexOf('-');
						int passNum = 0;
						int index = 0;
						while (passNum < leftNum) {
							if (dictWord.charAt(index) != ' ') {
								passNum++;
							}
							index++;
						}
						if (index < dictWord.length()
								&& dictWord.charAt(index) == ' ') {
							result[i] = "correct";
						} else {
							int leftHyphenIndex = index;
							int rightHyphenIndex = index - 1;
							int hyphenIndex;
							while (true) {
								if (leftHyphenIndex >= 0
										&& leftHyphenIndex < dictWord.length()
										&& dictWord.charAt(leftHyphenIndex) == ' ') {
									hyphenIndex = leftHyphenIndex;
									break;
								}
								leftHyphenIndex--;
								if (rightHyphenIndex >= 0
										&& rightHyphenIndex < dictWord.length()
										&& dictWord.charAt(rightHyphenIndex) == ' ') {
									hyphenIndex = rightHyphenIndex;
									break;
								}
								rightHyphenIndex++;
							}
							result[i] = (dictWord.substring(0, hyphenIndex)
									+ "-" + dictWord.substring(hyphenIndex + 1))
									.replace(" ", "");
						}
					}
					break;
				}
			}
		}
		return result;
	}
}
