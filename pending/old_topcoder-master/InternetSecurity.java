import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class InternetSecurity {
	public String[] determineWebsite(String[] address, String[] keyword,
			String[] dangerous, int threshold) {
		Website[] websites = new Website[address.length];
		for (int i = 0; i < websites.length; i++) {
			websites[i] = new Website(address[i], keyword[i].split(" "), false);
		}
		HashSet<String> dangerousKeywords = new HashSet<String>(
				Arrays.asList(dangerous));
		boolean found;
		do {
			found = false;
			for (Website website : websites) {
				if (!website.dangerous) {
					int dangerousNum = 0;
					for (String oneKeyword : website.keywords) {
						if (dangerousKeywords.contains(oneKeyword)) {
							dangerousNum++;
						}
					}
					if (dangerousNum >= threshold) {
						for (String oneKeyword : website.keywords) {
							dangerousKeywords.add(oneKeyword);
						}
						website.dangerous = true;
						found = true;
					}
				}
			}
		} while (found);
		ArrayList<String> result = new ArrayList<String>();
		for (Website website : websites) {
			if (website.dangerous) {
				result.add(website.address);
			}
		}
		return result.toArray(new String[0]);
	}
}

class Website {
	String address;
	String[] keywords;
	boolean dangerous;

	public Website(String address, String[] keywords, boolean dangerous) {
		this.address = address;
		this.keywords = keywords;
		this.dangerous = dangerous;
	}
}