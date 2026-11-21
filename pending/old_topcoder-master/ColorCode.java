import java.util.HashMap;

public class ColorCode {
	public long getOhms(String[] code) {
		HashMap<String, Integer> color2value = new HashMap<String, Integer>();
		color2value.put("black", 0);
		color2value.put("brown", 1);
		color2value.put("red", 2);
		color2value.put("orange", 3);
		color2value.put("yellow", 4);
		color2value.put("green", 5);
		color2value.put("blue", 6);
		color2value.put("violet", 7);
		color2value.put("grey", 8);
		color2value.put("white", 9);
		int value0 = color2value.get(code[0]);
		int value1 = color2value.get(code[1]);
		int value2 = color2value.get(code[2]);
		return (value0 * 10 + value1) * (long) Math.pow(10, value2);
	}
}
