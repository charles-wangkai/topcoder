public class MagicCube {
	public int getScore(int[] nums) {
		int minScore = calcScore(nums);
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				swap(nums, i, j);
				minScore = Math.min(minScore, calcScore(nums));
				swap(nums, i, j);
			}
		}
		return minScore;
	}

	void swap(int a[], int index1, int index2) {
		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}

	int calcScore(int nums[]) {
		int cube[][][] = new int[3][3][3];
		int index = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					cube[i][j][k] = nums[index];
					index++;
				}
			}
		}
		int maxSum = findSum(cube, new Max());
		int minSum = findSum(cube, new Min());
		return maxSum - minSum;
	}

	int findSum(int cube[][][], Comparator comparator) {
		int result = 0;
		boolean first = true;
		int offsetX[] = { 1, 0, 0 };
		int offsetY[] = { 0, 1, 0 };
		int offsetZ[] = { 0, 0, 1 };
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					for (int offsetIndex = 0; offsetIndex < 3; offsetIndex++) {
						int sum = 0;
						int x = i;
						int y = j;
						int z = k;
						boolean valid = true;
						for (int step = 0; step < 3; step++) {
							if (x >= 3 || y >= 3 || z >= 3) {
								valid = false;
								break;
							}
							sum += cube[x][y][z];
							x += offsetX[offsetIndex];
							y += offsetY[offsetIndex];
							z += offsetZ[offsetIndex];
						}
						if (!valid) {
							continue;
						}
						if (first) {
							result = sum;
							first = false;
						} else {
							result = comparator.compare(result, sum);
						}
					}
				}
			}
		}
		return result;
	}
}

interface Comparator {
	int compare(int a, int b);
}

class Max implements Comparator {
	public int compare(int a, int b) {
		return Math.max(a, b);
	}
}

class Min implements Comparator {
	public int compare(int a, int b) {
		return Math.min(a, b);
	}
}