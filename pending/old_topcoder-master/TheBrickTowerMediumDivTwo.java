public class TheBrickTowerMediumDivTwo {
	int minDistance = Integer.MAX_VALUE;
	int result[] = null;

	public int[] find(int[] heights) {
		int indices[] = new int[heights.length];
		for (int i = 0; i < indices.length; i++) {
			indices[i] = i;
		}
		search(heights, indices, 0);
		return result;
	}

	int compare(int a[], int b[]) {
		for (int i = 0;; i++) {
			if (a[i] != b[i]) {
				return a[i] - b[i];
			}
		}
	}

	void search(int heights[], int indices[], int depth) {
		if (depth == indices.length) {
			int distance = 0;
			for (int i = 1; i < indices.length; i++) {
				distance += Math.max(heights[indices[i - 1]],
						heights[indices[i]]);
			}
			if (distance < minDistance
					|| (distance == minDistance && compare(indices, result) < 0)) {
				minDistance = distance;
				result = indices.clone();
			}
		} else {
			for (int i = depth; i < indices.length; i++) {
				swap(indices, depth, i);
				search(heights, indices, depth + 1);
				swap(indices, depth, i);
			}
		}
	}

	void swap(int a[], int index1, int index2) {
		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}
}
