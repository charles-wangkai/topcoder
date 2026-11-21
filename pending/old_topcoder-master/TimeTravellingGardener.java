public class TimeTravellingGardener {
	public int determineUsage(int[] distance, int[] height) {
		int treeNum = height.length;
		Tree[] trees = new Tree[treeNum];
		int x = 0;
		for (int i = 0; i < trees.length; i++) {
			trees[i] = new Tree(x, height[i]);
			if (i < distance.length) {
				x += distance[i];
			}
		}
		int result = treeNum - 1;
		for (int i = 0; i < treeNum; i++) {
			for (int j = i + 1; j < treeNum; j++) {
				result = Math.min(result, countChosen(trees, i, j));
			}
		}
		return result;
	}

	int countChosen(Tree[] trees, int index1, int index2) {
		int diffX = trees[index2].x - trees[index1].x;
		if ((trees[index1].y < trees[index2].y && isTooFar(trees[index1].y,
				trees[index2].y, diffX, trees[index1].x))
				|| (trees[index1].y > trees[index2].y && isTooFar(
						trees[index2].y, trees[index1].y, diffX,
						trees[trees.length - 1].x - trees[index2].x))) {
			return Integer.MAX_VALUE;
		}
		int chosenNum = 0;
		for (int i = 0; i < trees.length; i++) {
			if (i == index1 || i == index2) {
				continue;
			}
			int delta = trees[i].y
					* (trees[index2].x - trees[index1].x)
					- (trees[index1].y * (trees[index2].x - trees[index1].x) + (trees[index2].y - trees[index1].y)
							* (trees[i].x - trees[index1].x));
			if (delta < 0) {
				return Integer.MAX_VALUE;
			} else if (delta > 0) {
				chosenNum++;
			}
		}
		return chosenNum;
	}

	boolean isTooFar(int yMin, int yMax, int xBetween, int xMin) {
		return xMin * (yMax - yMin) > xBetween * yMin;
	}
}

class Tree {
	int x;
	int y;

	Tree(int x, int y) {
		this.x = x;
		this.y = y;
	}
}