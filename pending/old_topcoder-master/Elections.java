public class Elections {
	public int visit(String[] likelihoods) {
		int vote1 = 2;
		int voteTotal = 1;
		int voteIndex = -1;
		for (int i = 0; i < likelihoods.length; i++) {
			int v1 = 0;
			for (int j = 0; j < likelihoods[i].length(); j++) {
				if (likelihoods[i].charAt(j) == '1') {
					v1++;
				}
			}
			if (v1 * voteTotal < vote1 * likelihoods[i].length()) {
				vote1 = v1;
				voteTotal = likelihoods[i].length();
				voteIndex = i;
			}
		}
		return voteIndex;
	}
}
