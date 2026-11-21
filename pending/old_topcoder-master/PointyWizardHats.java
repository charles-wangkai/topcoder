import java.util.Arrays;
import java.util.Comparator;

public class PointyWizardHats {
	public int getNumHats(int[] topHeight, int[] topRadius, int[] bottomHeight,
			int[] bottomRadius) {
		Hat[] tops = buildHats(topHeight, topRadius);
		Hat[] bottoms = buildHats(bottomHeight, bottomRadius);

		Arrays.sort(bottoms, new RadiusComparator());
		Arrays.sort(tops, new RatioComparator());

		int pairNum = 0;
		boolean[] used = new boolean[tops.length];
		for (Hat bottom : bottoms) {
			for (int i = 0; i < tops.length; i++) {
				if (!used[i] && bottom.radius > tops[i].radius
						&& Hat.computeRatioDelta(bottom, tops[i]) < 0) {
					used[i] = true;
					pairNum++;
					break;
				}
			}
		}
		return pairNum;
	}

	Hat[] buildHats(int[] height, int[] radius) {
		Hat[] hats = new Hat[height.length];
		for (int i = 0; i < hats.length; i++) {
			hats[i] = new Hat(height[i], radius[i]);
		}
		return hats;
	}
}

class RatioComparator implements Comparator<Hat> {
	public int compare(Hat hat1, Hat hat2) {
		return Hat.computeRatioDelta(hat1, hat2);
	}
}

class RadiusComparator implements Comparator<Hat> {
	public int compare(Hat hat1, Hat hat2) {
		return hat1.radius - hat2.radius;
	}
}

class Hat {
	int height;
	int radius;

	public Hat(int height, int radius) {
		this.height = height;
		this.radius = radius;
	}

	static int computeRatioDelta(Hat hat1, Hat hat2) {
		return hat1.height * hat2.radius - hat1.radius * hat2.height;
	}
}