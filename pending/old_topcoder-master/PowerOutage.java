import java.util.ArrayList;

public class PowerOutage {
	int maxLength;
	ArrayList<Integer> adjacents[];
	ArrayList<Integer> lengths[];
	boolean visited[];

	@SuppressWarnings("unchecked")
	public int estimateTimeOut(int[] fromJunction, int[] toJunction,
			int[] ductLength) {
		adjacents = new ArrayList[50];
		lengths = new ArrayList[50];
		visited = new boolean[50];
		for (int i = 0; i < adjacents.length; i++) {
			adjacents[i] = new ArrayList<Integer>();
			lengths[i] = new ArrayList<Integer>();
		}
		int total = 0;
		maxLength = -1;
		for (int i = 0; i < fromJunction.length; i++) {
			adjacents[fromJunction[i]].add(toJunction[i]);
			lengths[fromJunction[i]].add(ductLength[i]);
			adjacents[toJunction[i]].add(fromJunction[i]);
			lengths[toJunction[i]].add(ductLength[i]);
			total += ductLength[i] * 2;
		}
		visited[0] = true;
		DFS(0, 0);
		return total-maxLength;
	}

	void DFS(int index,int currentLength) {
		if (currentLength>maxLength) {
			maxLength=currentLength;
		}
		for (int i=0;i<adjacents[index].size();i++) {
			int next=adjacents[index].get(i);
			if (visited[next]==false) {
				visited[next]=true;
				DFS(next,currentLength+lengths[index].get(i));
			}
		}
	}
}
