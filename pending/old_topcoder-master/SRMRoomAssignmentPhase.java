import java.util.Arrays;

public class SRMRoomAssignmentPhase {
	public int countCompetitors(int[] ratings, int K) {
		int myRating = ratings[0];
		Arrays.sort(ratings);
		int first = Arrays.binarySearch(ratings, myRating) % K;
		int higherNum = 0;
		for (int i = first; i < ratings.length; i += K) {
			if (ratings[i] > myRating) {
				higherNum++;
			}
		}
		return higherNum;
	}
}
