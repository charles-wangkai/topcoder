import java.util.LinkedList;
import java.util.Queue;

public class RoadConstruction {
	int beforeDiplomat;

	public int getExitTime(String[] currentLanes) {
		int laneNum = currentLanes.length;
		@SuppressWarnings("unchecked")
		Queue<Car> lanes[] = new Queue[laneNum];
		for (int i = 0; i < laneNum; i++) {
			lanes[i] = new LinkedList<Car>();
			for (int j = 0; j < currentLanes[i].length(); j++) {
				lanes[i].offer(new Car(currentLanes[i].charAt(j) == 'D'));
			}
		}
		beforeDiplomat = 0;
		boolean diplomatExit = false;
		while (true) {
			int minYieldedLane = -1;
			for (int i = 0; i < laneNum; i++) {
				if (!lanes[i].isEmpty() && lanes[i].peek().yield) {
					minYieldedLane = i;
					break;
				}
			}
			if (minYieldedLane >= 0) {
				diplomatExit = exitLane(lanes, minYieldedLane);
			} else {
				for (int i = laneNum - 1; i >= 0; i--) {
					if (!lanes[i].isEmpty()) {
						diplomatExit = exitLane(lanes, i);
						break;
					}
				}
			}
			if (diplomatExit) {
				break;
			}
		}
		return beforeDiplomat;
	}

	boolean exitLane(Queue<Car> lanes[], int laneIndex) {
		for (int i = 0; i < laneIndex; i++) {
			if (!lanes[i].isEmpty()) {
				lanes[i].peek().yield = true;
			}
		}
		boolean diplomatExit = lanes[laneIndex].poll().diplomat;
		if (!diplomatExit) {
			beforeDiplomat++;
		}
		return diplomatExit;
	}
}

class Car {
	boolean diplomat;
	boolean yield;

	public Car(boolean diplomat) {
		this.diplomat = diplomat;
	}
}