import java.util.ArrayList;

public class AttendanceShort {
	public String[] shortList(String[] names, String[] attendance) {
		ArrayList<String> shorts = new ArrayList<String>();
		for (int i = 0; i < names.length; i++) {
			int countA = 0;
			int countP = 0;
			for (int j = 0; j < attendance[i].length(); j++) {
				char record = attendance[i].charAt(j);
				if (record == 'A') {
					countA++;
				} else if (record == 'P') {
					countP++;
				}
			}
			if (4 * countP < 3 * (countA + countP)) {
				shorts.add(names[i]);
			}
		}
		return shorts.toArray(new String[] {});
	}
}
