import java.util.Arrays;

public class WordCompositionGame {
	public String score(String[] listA, String[] listB, String[] listC) {
		Arrays.sort(listA);
		Arrays.sort(listB);
		Arrays.sort(listC);
		int scoreA = calcScore(listA, listB, listC);
		int scoreB = calcScore(listB, listC, listA);
		int scoreC = calcScore(listC, listA, listB);
		return scoreA + "/" + scoreB + "/" + scoreC;
	}

	int calcScore(String list[], String list1[], String list2[]) {
		int score = 0;
		for (String word : list) {
			score += 3;
			if (Arrays.binarySearch(list1, word) >= 0) {
				score--;
			}
			if (Arrays.binarySearch(list2, word) >= 0) {
				score--;
			}
		}
		return score;
	}
}
