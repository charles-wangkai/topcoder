public class Segments {
	public String intersection(int[] s1, int[] s2) {
		if (s1[0] != s1[2]) {
			mirrorXY(s1);
			mirrorXY(s2);
		}
		if (s2[0] == s2[2]) {
			if (s1[0] != s2[0]) {
				return "NO";
			}
			int min1 = Math.min(s1[1], s1[3]);
			int max1 = Math.max(s1[1], s1[3]);
			int min2 = Math.min(s2[1], s2[3]);
			int max2 = Math.max(s2[1], s2[3]);
			if (max1 < min2 || max2 < min1) {
				return "NO";
			} else if (max1 == min2 || max2 == min1
					|| (min1 == max1 && min1 >= min2 && min1 <= max2)
					|| (min2 == max2 && min2 >= min1 && min2 <= max1)) {
				return "POINT";
			} else {
				return "SEGMENT";
			}
		} else if (sameSide(s1[1], s1[3], s2[1])
				|| sameSide(s2[0], s2[2], s1[0])) {
			return "NO";
		} else {
			return "POINT";
		}
	}

	boolean sameSide(int a, int b, int s) {
		return (a - s) * (b - s) > 0;
	}

	void mirrorXY(int s[]) {
		int temp = s[0];
		s[0] = s[1];
		s[1] = temp;
		temp = s[2];
		s[2] = s[3];
		s[3] = temp;
	}
}
