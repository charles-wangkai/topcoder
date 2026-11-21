public class CalcTest {
	public String[] uniform(String[] numbers) {
		String unified[] = new String[numbers.length];
		for (int i = 0; i < unified.length; i++) {
			unified[i] = numbers[i].replaceAll(" ", "").replaceAll("\\D", ".");
		}
		return unified;
	}
}
