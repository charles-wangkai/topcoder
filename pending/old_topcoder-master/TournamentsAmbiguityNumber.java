public class TournamentsAmbiguityNumber {
	public int scrutinizeTable(String[] table) {
		int ambiguityNum = 0;
		int n = table.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (table[i].charAt(j) == '1' && table[j].charAt(k) == '1'
							&& table[k].charAt(i) == '1') {
						ambiguityNum++;
					}
				}
			}
		}
		return ambiguityNum;
	}
}
