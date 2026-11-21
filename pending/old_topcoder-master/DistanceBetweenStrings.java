public class DistanceBetweenStrings {
	public int getDistance(String a, String b, String letterSet) {
		a = a.toLowerCase();
		b = b.toLowerCase();
		int distance = 0;
		for (int i = 0; i < letterSet.length(); i++) {
			char letter = letterSet.charAt(i);
			int na = findOccurrenceNum(a, letter);
			int nb = findOccurrenceNum(b, letter);
			distance += (na - nb) * (na - nb);
		}
		return distance;
	}

	int findOccurrenceNum(String str, char ch) {
		int occurrenceNum = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ch) {
				occurrenceNum++;
			}
		}
		return occurrenceNum;
	}
}
