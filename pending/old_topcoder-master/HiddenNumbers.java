import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HiddenNumbers {
	public String[] findAll(String[] text) {
		String whole = "";
		for (String t : text) {
			whole += t;
		}
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(whole);
		ArrayList<String> numbers = new ArrayList<String>();
		while (m.find()) {
			numbers.add(m.group());
		}
		Collections.sort(numbers, new NumberComparator());
		int fromIndex = numbers.size() / 2;
		return numbers.subList(fromIndex, numbers.size())
				.toArray(new String[0]);
	}
}

class NumberComparator implements Comparator<String> {
	public int compare(String number1, String number2) {
		long value1 = Long.parseLong(number1);
		long value2 = Long.parseLong(number2);
		if (value1 != value2) {
			return (int) Math.signum(value1 - value2);
		} else {
			return number1.length() - number2.length();
		}
	}
}