public class CheatingQuiz {
	public int[] howMany(String answers) {
		int optionNum = 0;
		int rests[] = new int[3];
		for (int i = 0; i < answers.length(); i++) {
			int index = answers.charAt(i) - 'A';
			if (rests[index] == 0) {
				optionNum++;
			}
			rests[index]++;
		}
		int options[] = new int[answers.length()];
		for (int i = 0; i < options.length; i++) {
			options[i] = optionNum;
			int index = answers.charAt(i) - 'A';
			rests[index]--;
			if (rests[index] == 0) {
				optionNum--;
			}
		}
		return options;
	}
}
