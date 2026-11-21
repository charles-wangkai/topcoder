import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MedalTable {
	public String[] generate(String[] results) {
		HashMap<String, Country> code2country = new HashMap<String, Country>();
		for (String result : results) {
			String fields[] = result.split(" ");
			for (int i = 0; i < fields.length; i++) {
				Country country;
				if (code2country.containsKey(fields[i])) {
					country = code2country.get(fields[i]);
				} else {
					country = new Country(fields[i]);
					code2country.put(fields[i], country);
				}
				country.medals[i]++;
			}
		}
		ArrayList<Country> countries = new ArrayList<Country>(
				code2country.values());
		Collections.sort(countries);
		String result[] = new String[countries.size()];
		for (int i = 0; i < result.length; i++) {
			Country country = countries.get(i);
			result[i] = country.code;
			for (int j = 0; j < country.medals.length; j++) {
				result[i] += " " + country.medals[j];
			}
		}
		return result;
	}
}

class Country implements Comparable<Country> {
	String code;
	int medals[] = new int[3];

	public Country(String code) {
		super();
		this.code = code;
	}

	public int compareTo(Country another) {
		for (int i = 0; i < medals.length; i++) {
			if (medals[i] != another.medals[i]) {
				return another.medals[i] - medals[i];
			}
		}
		return code.compareTo(another.code);
	}
}