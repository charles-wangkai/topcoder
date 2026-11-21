import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

public class ServiceNames {
	public String[] makeList(String[] services) {
		TreeMap<String, TreeSet<String>> input2services = new TreeMap<String, TreeSet<String>>();
		for (String service : services) {
			String fields[] = service.split(" ");
			for (int i = 1; i < fields.length; i++) {
				addToMap(input2services, fields[i], fields[0]);
			}
		}
		String result[] = new String[input2services.size()];
		int index = 0;
		for (Entry<String, TreeSet<String>> entry : input2services.entrySet()) {
			String list = "";
			for (String service : entry.getValue()) {
				if (!list.equals("")) {
					list += ", ";
				}
				list += service;
			}
			result[index] = entry.getKey() + " ==> " + list;
			index++;
		}
		return result;
	}

	void addToMap(TreeMap<String, TreeSet<String>> input2services,
			String input, String service) {
		if (!input2services.containsKey(input)) {
			input2services.put(input, new TreeSet<String>());
		}
		input2services.get(input).add(service);
	}
}
