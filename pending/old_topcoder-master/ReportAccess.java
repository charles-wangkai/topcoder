import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ReportAccess {
	public String[] whoCanSee(String[] userNames, String[] allowedData,
			String[] reportData) {
		ArrayList<String> users = new ArrayList<String>();
		for (int i = 0; i < userNames.length; i++) {
			String accesses[] = allowedData[i].split(" ");
			Arrays.sort(accesses);
			boolean allowed = true;
			for (String oneReportData : reportData) {
				int index = Arrays.binarySearch(accesses, oneReportData);
				if (index < 0) {
					allowed = false;
					break;
				}
			}
			if (allowed) {
				users.add(userNames[i]);
			}
		}
		Collections.sort(users);
		return users.toArray(new String[0]);
	}
}
