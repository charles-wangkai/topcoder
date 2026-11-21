public class BusTrip {
	public int returnTime(int N, String[] buses) {
		final int LIMIT = 1000;
		Bus busArray[] = new Bus[buses.length];
		for (int i = 0; i < busArray.length; i++) {
			busArray[i] = new Bus(buses[i]);
		}
		int station = 0;
		int onBus = -1;
		for (int time = 0; time <= LIMIT; time++) {
			if (onBus < 0) {
				onBus = getOn(station, busArray);
			} else if (busArray[onBus].isOnStation()) {
				station = busArray[onBus].getStation();
				onBus = -1;
				if (station == 0) {
					return time;
				}
			}
			for (Bus bus : busArray) {
				bus.move();
			}
		}
		return -1;
	}

	int getOn(int station, Bus busArray[]) {
		for (int i = 0; i < busArray.length; i++) {
			if (busArray[i].isOnStation()
					&& busArray[i].getStation() == station) {
				return i;
			}
		}
		return -1;
	}
}

class Bus {
	int stations[];
	int fromIndex;
	int timeFrom;
	int timeTo;

	Bus(String str) {
		String fields[] = str.split(" ");
		stations = new int[fields.length];
		for (int i = 0; i < stations.length; i++) {
			stations[i] = Integer.parseInt(fields[i]);
		}
		fromIndex = -1;
		timeFrom = -1;
		timeTo = -1;
		move();
	}

	boolean isOnStation() {
		return timeFrom == 0;
	}

	int getStation() {
		return stations[fromIndex];
	}

	void move() {
		if (timeTo > 1) {
			timeFrom++;
			timeTo--;
		} else {
			fromIndex = getNextStationIndex();
			timeFrom = 0;
			timeTo = Math.abs(stations[getNextStationIndex()]
					- stations[fromIndex]);
		}
	}

	private int getNextStationIndex() {
		return (fromIndex + 1) % stations.length;
	}
}