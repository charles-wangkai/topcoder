public class BiggestRectangleEasy {
	public int findArea(int N) {
		int semiPerimeter = N / 2;
		int width = semiPerimeter / 2;
		int height = semiPerimeter - width;
		return height * width;
	}
}
