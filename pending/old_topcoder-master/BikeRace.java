import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class BikeRace {
	public String[] eliminated(int track, String[] name, int[] start,
			int[] speed) {
		double minCircleTime = Double.MAX_VALUE;
		ArrayList<Racer> racers = new ArrayList<Racer>();
		for (int i = 0; i < name.length; i++) {
			racers.add(new Racer(name[i], start[i], speed[i]));
			double circleTime = start[i] + (double) track / speed[i];
			minCircleTime = Math.min(minCircleTime, circleTime);
		}
		HashMap<String, Eliminator> name2eliminator = new HashMap<String, Eliminator>();
		for (int i = 0; i < racers.size(); i++) {
			Racer racer = racers.get(i);
			if (racer.start >= minCircleTime) {
				name2eliminator.put(racer.name, new Eliminator(racer.name,
						minCircleTime));
				racers.remove(i);
				i--;
			}
		}
		Collections.sort(racers);
		for (int i = 0; i < racers.size(); i++) {
			Racer racer1 = racers.get(i);
			for (int j = i + 1; j < racers.size(); j++) {
				Racer racer2 = racers.get(j);
				if (racer2.speed == racer1.speed) {
					continue;
				}
				int distance;
				if (racer1.start > racer2.start) {
					distance = (racer1.start - racer2.start) * racer2.speed
							% track;
					if (distance == 0) {
						distance = track;
					}

				} else {
					distance = track
							- ((racer2.start - racer1.start) * racer1.speed % track);
				}
				updateName2Time(racer2.name,
						Math.max(racer1.start, racer2.start)
								+ (double) distance
								/ (racer1.speed - racer2.speed),
						name2eliminator);
			}
		}
		Eliminator eliminators[] = name2eliminator.values().toArray(
				new Eliminator[0]);
		Arrays.sort(eliminators);
		String result[] = new String[eliminators.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = eliminators[i].name;
		}
		return result;
	}

	void updateName2Time(String name, double time,
			HashMap<String, Eliminator> name2eliminator) {
		if (name2eliminator.containsKey(name)) {
			Eliminator eliminator = name2eliminator.get(name);
			if (eliminator.time > time) {
				eliminator.time = time;
			}
		} else {
			name2eliminator.put(name, new Eliminator(name, time));
		}
	}
}

class Racer implements Comparable<Racer> {
	String name;
	int start;
	int speed;

	public Racer(String name, int start, int speed) {
		this.name = name;
		this.start = start;
		this.speed = speed;
	}

	public int compareTo(Racer other) {
		return other.speed - speed;
	}
}

class Eliminator implements Comparable<Eliminator> {
	String name;
	double time;

	public Eliminator(String name, double time) {
		this.name = name;
		this.time = time;
	}

	public int compareTo(Eliminator other) {
		if (time != other.time) {
			return (int) Math.signum(time - other.time);
		} else {
			return name.compareTo(other.name);
		}
	}
}