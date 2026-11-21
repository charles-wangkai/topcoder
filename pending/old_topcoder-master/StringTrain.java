public class StringTrain {
	public String buildTrain(String[] cars) {
		String train = cars[0];
		for (int i = 1; i < cars.length; i++) {
			for (int j = cars[i].length() - 1; j > 0; j--) {
				if (train.length() > j
						&& train.endsWith(cars[i].substring(0, j))) {
					train += cars[i].substring(j);
					break;
				}
			}
		}
		String removed = "";
		for (int i = train.length() - 1; i >= 0; i--) {
			char ch = train.charAt(i);
			if (removed.indexOf(ch) < 0) {
				removed = ch + removed;
			}
		}
		return train.length() + " " + removed;
	}
}
