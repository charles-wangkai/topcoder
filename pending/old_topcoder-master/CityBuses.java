import java.util.ArrayList;

public class CityBuses {
	public int maximumFare(String[] blocks) {
		ArrayList<Station> stations = new ArrayList<Station>();
		int row = blocks.length;
		int column = blocks[0].length();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (blocks[i].charAt(j) == 'B') {
					stations.add(new Station(i, j));
				}
			}
		}
		int max = -1;
		for (int i = 0; i < stations.size(); i++) {
			for (int j = i + 1; j < stations.size(); j++) {
				max = Math.max(max, Station.distance(stations.get(i), stations
						.get(j)));
			}
		}
		return max;
	}

	static class Station {
		int x;
		int y;

		Station(int X, int Y) {
			this.x = X;
			this.y = Y;
		}

		static int distance(Station a, Station b) {
			return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
		}
	}
}
