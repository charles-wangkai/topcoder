public class OldestOne {
	public String oldest(String[] data) {
		String result = null;
		int maxAge = -1;
		for (String item : data) {
			int age = extractAge(item);
			if (age > maxAge) {
				maxAge = age;
				result = extractName(item);
			}
		}
		return result;
	}

	int extractAge(String str) {
		return Integer.parseInt(str.split("\\D+")[1]);
	}

	String extractName(String str) {
		return str.split("\\d")[0].trim();
	}
}
