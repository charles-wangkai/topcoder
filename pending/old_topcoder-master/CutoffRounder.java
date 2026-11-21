public class CutoffRounder {
	public int round(String num, String cutoff) {
		return (int) (Double.parseDouble(num) + 1 - Double.parseDouble(cutoff));
	}
}
