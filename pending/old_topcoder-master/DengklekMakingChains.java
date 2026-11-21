import java.util.ArrayList;

public class DengklekMakingChains {
	public int maxBeauty(String[] chains) {
		int single = 0;
		int onlyLeft = 0;
		int middle = 0;
		int onlyRight = 0;
		ArrayList<Twoway> twoways = new ArrayList<Twoway>();
		twoways.add(new Twoway(0, 0));
		twoways.add(new Twoway(0, 0));
		for (String chain : chains) {
			char ch0 = chain.charAt(0);
			char ch1 = chain.charAt(1);
			char ch2 = chain.charAt(2);
			if (ch0 == '.' && ch1 != '.' && ch2 == '.') {
				single = Math.max(single, convertToDigit(ch1));
			} else if (ch0 != '.' && ch1 == '.' && ch2 != '.') {
				twoways.add(new Twoway(convertToDigit(ch2), convertToDigit(ch0)));
			} else if (ch2 != '.' && (ch0 == '.' || ch1 == '.')) {
				onlyLeft = Math.max(onlyLeft, convertToDigit(ch2)
						+ (ch1 == '.' ? 0 : convertToDigit(ch1)));
			} else if (ch0 != '.' && ch1 != '.' && ch2 != '.') {
				middle += convertToDigit(ch0) + convertToDigit(ch1)
						+ convertToDigit(ch2);
			} else if (ch0 != '.' && (ch1 == '.' || ch2 == '.')) {
				onlyRight = Math.max(onlyRight, convertToDigit(ch0)
						+ (ch1 == '.' ? 0 : convertToDigit(ch1)));
			}
		}
		int maxLeftIndex = getMaxIndex(twoways, true, -1);
		int maxRightIndex = getMaxIndex(twoways, false, maxLeftIndex);
		int maxLeftIndex1 = getMaxIndex(twoways, true, maxLeftIndex);
		return Math.max(
				single,
				Math.max(
						Math.max(onlyLeft, twoways.get(maxLeftIndex).left)
								+ middle
								+ Math.max(onlyRight,
										twoways.get(maxRightIndex).right),
						Math.max(onlyLeft, twoways.get(maxLeftIndex1).left)
								+ middle
								+ Math.max(onlyRight,
										twoways.get(maxLeftIndex).right)));
	}

	int convertToDigit(char ch) {
		return ch - '0';
	}

	int getMaxIndex(ArrayList<Twoway> twoways, boolean leftOrRight,
			int exceptIndex) {
		int maxIndex = -1;
		for (int i = 0; i < twoways.size(); i++) {
			if (i == exceptIndex) {
				continue;
			}
			if (maxIndex < 0
					|| (leftOrRight && twoways.get(i).left > twoways
							.get(maxIndex).left)
					|| (!leftOrRight && twoways.get(i).right > twoways
							.get(maxIndex).right)) {
				maxIndex = i;
			}
		}
		return maxIndex;
	}
}

class Twoway {
	int left;
	int right;

	Twoway(int left, int right) {
		this.left = left;
		this.right = right;
	}
}