import java.util.HashSet;

public class ColorfulBricks {
	public int countLayouts(String bricks) {
		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < bricks.length(); i++) {
			set.add(bricks.charAt(i));
		}
		if (set.size() > 2) {
			return 0;
		} else {
			return set.size();
		}
	}
}
