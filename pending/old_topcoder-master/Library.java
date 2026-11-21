import java.util.HashSet;

public class Library {
	public int documentAccess(String[] records, String[] userGroups,
			String[] roomRights) {
		HashSet<String> accessableDocuments = new HashSet<String>();
		for (String record : records) {
			String fields[] = record.split(" ");
			String document = fields[0];
			String room = fields[1];
			String userGroup = fields[2];
			if (contains(roomRights, room) && contains(userGroups, userGroup)) {
				accessableDocuments.add(document);
			}
		}
		return accessableDocuments.size();
	}

	boolean contains(String list[], String target) {
		for (String element : list) {
			if (element.equals(target)) {
				return true;
			}
		}
		return false;
	}
}
