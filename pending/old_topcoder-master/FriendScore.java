public class FriendScore {
	public int highestScore(String[] friends) {
		int N = friends.length;
		int twoFriendNums[] = new int[N];
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (friends[i].charAt(j) == 'Y') {
					twoFriendNums[i]++;
					twoFriendNums[j]++;
				} else {
					for (int k = 0; k < N; k++) {
						if (friends[i].charAt(k) == 'Y'
								&& friends[j].charAt(k) == 'Y') {
							twoFriendNums[i]++;
							twoFriendNums[j]++;
							break;
						}
					}
				}
			}
		}
		int maxTwoFriendNum = -1;
		for (int twoFriendNum : twoFriendNums) {
			maxTwoFriendNum = Math.max(maxTwoFriendNum, twoFriendNum);
		}
		return maxTwoFriendNum;
	}
}
