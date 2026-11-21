import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class DVDPlayer {
	public String[] findMovies(String[] moviesWatched) {
		HashMap<String, String> movie2case = new HashMap<String, String>();
		String player = null;
		for (String movie : moviesWatched) {
			if (!movie2case.containsKey(movie)) {
				movie2case.put(movie, movie);
			}
			String temp = player;
			player = movie;
			if (temp != null) {
				movie2case.put(temp, movie2case.get(movie));
			}
			movie2case.remove(movie);
		}
		ArrayList<String> result = new ArrayList<String>();
		for (Entry<String, String> entry : movie2case.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			if (!key.equals(value)) {
				result.add(key + " is inside " + value + "'s case");
			}
		}
		Collections.sort(result);
		return result.toArray(new String[0]);
	}
}
