import java.util.ArrayList;
import java.util.HashMap;

public class Resort {
	HashMap<String, Run> map;

	public String classify(String[] runs, String classify) {
		map = new HashMap<String, Run>();
		for (int i = 0; i < runs.length; i++) {
			String str[] = runs[i].split(":");
			String name = str[0];
			str = str[1].split(",");
			Run run = new Run(str[0]);
			for (int j = 1; j < str.length; j++) {
				run.feeds.add(str[j]);
			}
			map.put(name, run);
		}
		int rate = search(classify);
		if (rate == 1) {
			return "GREEN CIRCLE";
		} else if (rate == 2) {
			return "BLUE SQUARE";
		} else {
			return "BLACK DIAMOND";
		}
	}

	int search(String name) {
		Run run = map.get(name);
		if (run.rate != -1) {
			return run.rate;
		}
		if (run.feeds.size() == 0) {
			return run.difficulty;
		}
		int temp = 3;
		for (int i = 0; i < run.feeds.size(); i++) {
			temp = Math.min(temp, search(run.feeds.get(i)));
		}
		return run.rate = Math.max(run.difficulty, temp);
	}

	class Run {
		int difficulty;
		ArrayList<String> feeds;
		int rate;

		Run(String letter) {
			if (letter.equals("E")) {
				this.difficulty = 1;
			} else if (letter.equals("M")) {
				this.difficulty = 2;
			} else {
				this.difficulty = 3;
			}
			this.feeds = new ArrayList<String>();
			rate = -1;
		}
	}
}
