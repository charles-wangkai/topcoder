import java.util.Arrays;

public class AddElectricalWires {
	boolean connected[];

	public int maxNewWires(String[] wires, int[] gridConnections) {
		connected = new boolean[wires.length];
		int connectNums[] = new int[gridConnections.length];
		for (int i = 0; i < connectNums.length; i++) {
			connectNums[i] = search(wires, gridConnections[i]);
		}
		Arrays.sort(connectNums);
		int notConnectedNum = 0;
		for (boolean oneConnected : connected) {
			if (!oneConnected) {
				notConnectedNum++;
			}
		}
		connectNums[connectNums.length - 1] += notConnectedNum;
		int possibleConnectTotal = 0;
		for (int connectNum : connectNums) {
			possibleConnectTotal += connectNum * (connectNum - 1) / 2;
		}
		int actualConnectTotal = 0;
		for (int i = 0; i < wires.length; i++) {
			for (int j = 0; j < i; j++) {
				if (wires[i].charAt(j) == '1') {
					actualConnectTotal++;
				}
			}
		}
		return possibleConnectTotal - actualConnectTotal;
	}

	int search(String wires[], int index) {
		int result = 0;
		if (!connected[index]) {
			connected[index] = true;
			result++;
			for (int i = 0; i < wires[index].length(); i++) {
				if (wires[index].charAt(i) == '1') {
					result += search(wires, i);
				}
			}
		}
		return result;
	}
}
