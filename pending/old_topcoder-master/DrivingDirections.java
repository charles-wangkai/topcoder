public class DrivingDirections {
	public String[] reverse(String[] directions) {
		String turns[] = { "LEFT", "RIGHT" };
		String suffices[] = new String[directions.length];
		int turnIndices[] = new int[directions.length - 1];
		for (int i = 0; i < directions.length; i++) {
			int onPos = directions[i].indexOf("on");
			suffices[i] = directions[i].substring(onPos);
			if (i > 0) {
				turnIndices[i - 1] = (directions[i].substring(0, onPos)
						.indexOf(turns[0]) >= 0) ? 0 : 1;
			}
		}
		String result[] = new String[directions.length];
		for (int i = 0; i < result.length; i++) {
			if (i == 0) {
				result[i] = "Start";
			} else {
				result[i] = "Turn "
						+ turns[1 - turnIndices[directions.length - 1 - i]];
			}
			result[i] += " " + suffices[directions.length - 1 - i];
		}
		return result;
	}
}
