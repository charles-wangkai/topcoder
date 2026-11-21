public class LinearPolyominoCovering {
	public String findCovering(String region) {
		String covering = region.replaceAll("XXXX", "AAAA").replaceAll("XX",
				"BB");
		if (covering.indexOf("X") >= 0) {
			return "impossible";
		} else {
			return covering;
		}
	}
}
