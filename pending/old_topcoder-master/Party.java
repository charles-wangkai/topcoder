import java.util.HashSet;

public class Party {
	public double averageNames(int n, int[] personA, int[] personB) {
		@SuppressWarnings("unchecked")
		HashSet<Integer> learned[] = new HashSet[n];
		for (int i = 0; i < learned.length; i++) {
			learned[i] = new HashSet<Integer>();
			learned[i].add(i);
		}
		for (int i = 0; i < personA.length; i++) {
			learned[personA[i]].addAll(learned[personB[i]]);
			learned[personB[i]].addAll(learned[personA[i]]);
		}
		int total = 0;
		for (HashSet<Integer> learn : learned) {
			total += learn.size() - 1;
		}
		return (double) total / n;
	}
}
