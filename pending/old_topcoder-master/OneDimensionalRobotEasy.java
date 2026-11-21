public class OneDimensionalRobotEasy {
	public int finalPosition(String commands, int A, int B) {
		return commands.chars().reduce(0,
				(result, element) -> element == 'L' ? Math.max(result - 1, -A) : Math.min(result + 1, B));
	}
}
