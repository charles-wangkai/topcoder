import java.util.PriorityQueue;

public class TheTower {
	public int[] count(int[] x, int[] y) {
		int pointNum = x.length;
		int moves[] = new int[pointNum];
		for (int i = 0; i < pointNum; i++) {
			moves[i] = Integer.MAX_VALUE;
			for (int j = 0; j < pointNum; j++) {
				for (int k = 0; k < pointNum; k++) {
					int currentMove = 0;
					PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
					for (int p = 0; p < pointNum; p++) {
						pq.offer(Math.abs(x[p] - x[j]) + Math.abs(y[p] - y[k]));
					}
					for (int p = 0; p < i + 1; p++) {
						currentMove += pq.poll();
					}
					moves[i] = Math.min(moves[i], currentMove);
				}
			}
		}
		return moves;
	}
}
