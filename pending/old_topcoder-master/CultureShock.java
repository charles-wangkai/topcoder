public class CultureShock {
	public String translate(String text) {
		return text.replaceAll("(?<=^| )ZEE(?=$| )", "ZED");
	}
}
