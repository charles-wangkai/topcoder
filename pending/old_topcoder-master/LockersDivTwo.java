import java.util.ArrayList;

public class LockersDivTwo {
	public int lastOpened(int N) {
		ArrayList<Integer> lockers = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++) {
			lockers.add(i);
		}
		for (int i = 2; lockers.size() > 1; i++) {
			for (int j = (lockers.size() - 1) / i * i; j >= 0; j -= i) {
				lockers.remove(j);
			}
		}
		return lockers.get(0);
	}
}
