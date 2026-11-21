import java.util.ArrayList;
import java.util.Arrays;

public class BusinessTasks {
	public String getTask(String[] list, int n) {
		ArrayList<String> tasks = new ArrayList<String>(Arrays.asList(list));
		int index = 0;
		while (tasks.size() != 1) {
			index = (index + n - 1) % tasks.size();
			tasks.remove(index);
		}
		return tasks.get(0);
	}
}
