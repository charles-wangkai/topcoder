public class RPG {
	public int[] dieRolls(String[] dice) {
		int min = 0;
		int max = 0;
		for (String d : dice) {
			String fields[] = d.split("d");
			int roll = Integer.parseInt(fields[0]);
			int size = Integer.parseInt(fields[1]);
			min += roll;
			max += roll * size;
		}
		return new int[] { min, max, (min + max) / 2 };
	}
}
