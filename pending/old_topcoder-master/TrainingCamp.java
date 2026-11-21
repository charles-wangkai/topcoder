public class TrainingCamp {
	public String[] determineSolvers(String[] attendance, String[] problemTopics) {
		String result[] = new String[attendance.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = "";
			for (int j = 0; j < problemTopics.length; j++) {
				boolean should = true;
				for (int k = 0; k < problemTopics[0].length(); k++) {
					if (problemTopics[j].charAt(k) == 'X'
							&& attendance[i].charAt(k) == '-') {
						should = false;
						break;
					}
				}
				result[i] += (should ? "X" : "-");
			}
		}
		return result;
	}
}
