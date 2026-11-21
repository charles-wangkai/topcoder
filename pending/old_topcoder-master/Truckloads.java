import java.util.Stack;

public class Truckloads {
	public int numTrucks(int numCrates, int loadSize) {
		int truckNum = 0;
		Stack<Integer> crates = new Stack<Integer>();
		crates.push(numCrates);
		while (!crates.empty()) {
			int top = crates.pop();
			if (top <= loadSize) {
				truckNum++;
			} else {
				crates.push(top / 2);
				crates.push(top - top / 2);
			}
		}
		return truckNum;
	}
}
