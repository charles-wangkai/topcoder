public class PlatypusPaternity {
	public int maxFamily(String[] femaleCompatibility,
			String[] maleCompatibility, String[] siblingGroups) {
		int result = 0;
		for (String siblingGroup : siblingGroups) {
			boolean found = false;
			for (String female : femaleCompatibility) {
				for (String male : maleCompatibility) {
					if (isFamily(siblingGroup, female, male)) {
						found = true;
						break;
					}
				}
				if (found) {
					break;
				}
			}
			if (found) {
				result = Math.max(result, getChildrenNumber(siblingGroup) + 2);
			}
		}
		return result;
	}

	boolean isFamily(String siblingGroup, String female, String male) {
		for (int i = 0; i < siblingGroup.length(); i++) {
			if (siblingGroup.charAt(i) == 'Y'
					&& (female.charAt(i) != 'Y' || male.charAt(i) != 'Y')) {
				return false;
			}
		}
		return true;
	}

	int getChildrenNumber(String siblingGroup) {
		int childrenNum = 0;
		for (int i = 0; i < siblingGroup.length(); i++) {
			if (siblingGroup.charAt(i) == 'Y') {
				childrenNum++;
			}
		}
		return childrenNum;
	}
}
