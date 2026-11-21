public class DocumentSearch {
	public int nonIntersecting(String[] doc, String search) {
		String document = "";
		for (String d : doc) {
			document += d;
		}
		int matchNum = 0;
		int fromIndex = 0;
		int index;
		while ((index = document.indexOf(search, fromIndex)) >= 0) {
			matchNum++;
			fromIndex = index + search.length();
		}
		return matchNum;
	}
}
