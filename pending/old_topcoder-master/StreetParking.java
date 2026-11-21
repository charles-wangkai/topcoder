public class StreetParking {
	public int freeParks(String street) {
		int parkNum = 0;
		for (int i = 0; i < street.length(); i++) {
			char ch = street.charAt(i);
			if (ch != 'D'
					&& ch != 'B'
					&& ch != 'S'
					&& (i + 1 >= street.length() || (street.charAt(i + 1) != 'B' && street
							.charAt(i + 1) != 'S'))
					&& (i + 2 >= street.length() || street.charAt(i + 2) != 'B')
					&& (i == 0 || street.charAt(i - 1) != 'S')) {
				parkNum++;
			}
		}
		return parkNum;
	}
}
