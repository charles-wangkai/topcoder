import java.util.Arrays;

public class RollingDiceDivTwo {
	public int minimumFaces(String[] rolls) {
		for (int i = 0; i < rolls.length; i++) {
			rolls[i] = sortRoll(rolls[i]);
		}
		int result = 0;
		for (int i = 0; i < rolls[0].length(); i++) {
			int maxFace = Integer.MIN_VALUE;
			for (String roll : rolls) {
				maxFace = Math.max(maxFace, roll.charAt(i) - '0');
			}
			result += maxFace;
		}
		return result;
	}

	String sortRoll(String roll) {
		char[] faces = roll.toCharArray();
		Arrays.sort(faces);
		return new String(faces);
	}
}
