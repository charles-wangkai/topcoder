import java.util.Arrays;
import java.util.Comparator;

public class SequenceOfNumbers {
	public String[] rearrange(String[] sequence) {
		Arrays.sort(sequence, new NumericalComparator());
		return sequence;
	}
}

class NumericalComparator implements Comparator<String> {
	public int compare(String s1, String s2) {
		return Integer.parseInt(s1) - Integer.parseInt(s2);
	}
}