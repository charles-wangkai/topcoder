import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class XBallGame {
	String name;
	String position;

	public String[] newStatistics(String[] placeboard) {
		HashMap<String, ArrayList<String>> name2positions = new HashMap<String, ArrayList<String>>();
		for (String element : placeboard) {
			parse(element);
			ArrayList<String> positions;
			if (name2positions.containsKey(name)) {
				positions = name2positions.get(name);
			} else {
				positions = new ArrayList<String>();
				name2positions.put(name, positions);
			}
			positions.add(position);
		}
		String newFormats[] = new String[placeboard.length];
		for (int i = 0; i < newFormats.length; i++) {
			parse(placeboard[i]);
			@SuppressWarnings("unchecked")
			ArrayList<String> otherPositions = (ArrayList<String>) name2positions
					.get(name).clone();
			otherPositions.remove(position);
			Collections.sort(otherPositions);
			newFormats[i] = placeboard[i];
			for (String otherPosition : otherPositions) {
				newFormats[i] += "," + otherPosition;
			}
		}
		return newFormats;
	}

	void parse(String element) {
		String fields[] = element.split("-");
		name = fields[0];
		position = fields[1];
	}
}
