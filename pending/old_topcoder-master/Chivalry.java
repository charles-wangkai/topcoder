public class Chivalry {
	public String getOrder(String first, String second) {
		String result = "";
		int index1 = 0;
		int index2 = 0;
		while (index1 < first.length() || index2 < second.length()) {
			if (index1 < first.length()
					&& (index2 == second.length()
							|| first.charAt(index1) == second.charAt(index2) || first
							.charAt(index1) == 'W')) {
				result += first.charAt(index1);
				index1++;
			} else {
				result += second.charAt(index2);
				index2++;
			}
		}
		return result;
	}
}
