import java.util.Arrays;
import java.util.HashSet;

public class TheQuestionsAndAnswersDivTwo {
	public int find(String[] questions) {
		HashSet<String> questionSet = new HashSet<String>(
				Arrays.asList(questions));
		return 1 << questionSet.size();
	}
}
