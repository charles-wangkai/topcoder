public class TextStatistics {
	public double averageLength(String text) {
		String fields[] = text.split("[^a-zA-Z]");
		int wordNum = 0;
		int totalLength = 0;
		for (String field : fields) {
			if (!field.equals("")) {
				wordNum++;
				totalLength += field.length();
			}
		}
		if (wordNum == 0) {
			return 0;
		} else {
			return (double) totalLength / wordNum;
		}
	}
}
