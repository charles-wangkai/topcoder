public class Containers {
	public int wastedSpace(int[] containers, int[] packages) {
		int containerSum = 0;
		for (int container : containers) {
			containerSum += container;
		}
		int packageSum = 0;
		for (int pack : packages) {
			packageSum += pack;
		}
		return containerSum - packageSum;
	}
}
