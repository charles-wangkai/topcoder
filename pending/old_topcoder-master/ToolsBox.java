import java.util.HashSet;

public class ToolsBox {
	public int countTools(String[] need) {
		HashSet<String> tools = new HashSet<String>();
		for (String oneNeed : need) {
			String fields[] = oneNeed.split(" ");
			for (String field : fields) {
				tools.add(field);
			}
		}
		return tools.size();
	}
}
