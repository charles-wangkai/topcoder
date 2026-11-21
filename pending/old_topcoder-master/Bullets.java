public class Bullets {
	public int match(String[] guns, String bullet) {
		int result = -1;
		for (int i = 0; i < guns.length; i++) {
			String temp = guns[i] + guns[i];
			if (temp.indexOf(bullet) != -1) {
				result = i;
			}
		}
		return result;
	}
}
