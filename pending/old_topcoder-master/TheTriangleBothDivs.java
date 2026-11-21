public class TheTriangleBothDivs {
	public String fix(String time) {
		String result = null;
		for (int hour = 0; hour <= 23; hour++) {
			for (int minute = 0; minute <= 59; minute++) {
				for (int gmt = -9; gmt <= 9; gmt++) {
					String produced = produceTime(hour, minute, gmt);
					if (isMatched(produced, time)) {
						String normalized = produceTime((hour - gmt + 24) % 24,
								minute, 0).substring(0, 5);
						if (result == null || normalized.compareTo(result) < 0) {
							result = normalized;
						}
					}
				}
			}
		}
		return result;
	}

	String produceTime(int hour, int minute, int gmt) {
		return String.format("%02d:%02d GMT%+d", hour, minute, gmt);
	}

	boolean isMatched(String filled, String pattern) {
		for (int i = 0; i < pattern.length(); i++) {
			char ch = pattern.charAt(i);
			if (ch != '?' && ch != filled.charAt(i)) {
				return false;
			}
		}
		return true;
	}
}
