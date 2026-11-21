import java.util.Arrays;

public class RectangleGroups {
	public String maximalIndexed(String[] rectangles) {
		Arrays.sort(rectangles);
		String maxName = null;
		int maxIndex = -1;
		int index = -1;
		for (int i = 0; i <= rectangles.length; i++) {
			int area = -1;
			if (i < rectangles.length) {
				String fields[] = rectangles[i].split(" ");
				area = Integer.parseInt(fields[1])
						* Integer.parseInt(fields[2]);
			}
			if (i < rectangles.length && i > 0
					&& rectangles[i].charAt(0) == rectangles[i - 1].charAt(0)) {
				index += area;
			} else {
				if (i > 0 && index > maxIndex) {
					maxIndex = index;
					maxName = rectangles[i - 1].charAt(0) + "";
				}
				index = area;
			}
		}
		return maxName + " " + maxIndex;
	}
}
