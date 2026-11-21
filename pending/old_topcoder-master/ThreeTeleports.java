public class ThreeTeleports {
	int minTime = Integer.MAX_VALUE;

	public int shortestDistance(int xMe, int yMe, int xHome, int yHome,
			String[] teleports) {
		Teleport[] teleportArray = new Teleport[teleports.length];
		for (int i = 0; i < teleportArray.length; i++) {
			teleportArray[i] = new Teleport(teleports[i]);
		}
		search(new Point(xMe, yMe), new Point(xHome, yHome), teleportArray, 0,
				0);
		return minTime;
	}

	void search(Point me, Point home, Teleport[] teleportArray, int index,
			long time) {
		if (index == teleportArray.length) {
			minTime = (int) Math.min(minTime,
					time + Point.getDistance(me, home));
			return;
		}
		for (int i = index; i < teleportArray.length; i++) {
			swap(teleportArray, index, i);
			search(me, home, teleportArray, index + 1, time);
			search(teleportArray[index].to, home, teleportArray, index + 1,
					time + Point.getDistance(me, teleportArray[index].from)
							+ 10);
			search(teleportArray[index].from, home, teleportArray, index + 1,
					time + Point.getDistance(me, teleportArray[index].to) + 10);
			swap(teleportArray, index, i);
		}
	}

	void swap(Teleport[] teleportArray, int index1, int index2) {
		Teleport temp = teleportArray[index1];
		teleportArray[index1] = teleportArray[index2];
		teleportArray[index2] = temp;
	}
}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	static int getDistance(Point p1, Point p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}
}

class Teleport {
	Point from;
	Point to;

	Teleport(String teleport) {
		String[] fields = teleport.split(" ");
		from = new Point(Integer.parseInt(fields[0]),
				Integer.parseInt(fields[1]));
		to = new Point(Integer.parseInt(fields[2]), Integer.parseInt(fields[3]));
	}
}