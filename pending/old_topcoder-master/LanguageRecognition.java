public class LanguageRecognition {
	public int whichLanguage(String[] languages, String text) {
		Frequency textFrequency = new Frequency(text);
		Rational minDifference = new Rational(Integer.MAX_VALUE, 1);
		int result = -1;
		for (int i = 0; i < languages.length; i++) {
			Rational difference = Frequency.calcDifference(new Frequency(
					languages[i]), textFrequency);
			if (Rational.lessThan(difference, minDifference)) {
				minDifference = difference;
				result = i;
			}
		}
		return result;
	}
}

class Frequency {
	Rational letterFreqs[] = new Rational[26];

	Frequency(String str) {
		str = str.toLowerCase();
		str = str.replaceAll("[^a-z]", "");
		for (int i = 0; i < letterFreqs.length; i++) {
			char ch = (char) ('a' + i);
			int count = 0;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == ch) {
					count++;
				}
			}
			letterFreqs[i] = new Rational(count, str.length());
		}
	}

	static Rational calcDifference(Frequency f1, Frequency f2) {
		Rational difference = new Rational(0, 1);
		for (int i = 0; i < 26; i++) {
			difference = Rational.add(difference, Rational.square(Rational
					.subtract(f1.letterFreqs[i], f2.letterFreqs[i])));
		}
		return difference;
	}
}

class Rational {
	long numerator;
	long denominator;

	Rational(long numerator, long denominator) {
		long common = gcd(numerator, denominator);
		this.numerator = numerator / common;
		this.denominator = denominator / common;
	}

	private long gcd(long a, long b) {
		while (b != 0) {
			long c = a % b;
			a = b;
			b = c;
		}
		return a;
	}

	static Rational add(Rational r1, Rational r2) {
		return new Rational(r1.numerator * r2.denominator + r2.numerator
				* r1.denominator, r1.denominator * r2.denominator);
	}

	static Rational subtract(Rational r1, Rational r2) {
		return new Rational(r1.numerator * r2.denominator - r2.numerator
				* r1.denominator, r1.denominator * r2.denominator);
	}

	static Rational square(Rational r) {
		return new Rational(r.numerator * r.numerator, r.denominator
				* r.denominator);
	}

	static boolean lessThan(Rational r1, Rational r2) {
		return r1.numerator * r2.denominator < r2.numerator * r1.denominator;
	}
}
