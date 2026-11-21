import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TwoEquations {
	public String solve(String first, String second) {
		int coeffs1[] = parseCoeffs(first);
		int coeffs2[] = parseCoeffs(second);
		int delta = coeffs1[0] * coeffs2[1] - coeffs1[1] * coeffs2[0];
		if (delta == 0) {
			if (coeffs1[0] * coeffs2[2] != coeffs1[2] * coeffs2[0]
					|| coeffs1[1] * coeffs2[2] != coeffs1[2] * coeffs2[1]
					|| (coeffs1[0] == 0 && coeffs1[1] == 0 && coeffs1[2] != 0)
					|| (coeffs2[0] == 0 && coeffs2[1] == 0 && coeffs2[2] != 0)) {
				return "NO SOLUTIONS";
			} else {
				return "MULTIPLE SOLUTIONS";
			}
		} else {
			Rational x = new Rational(coeffs1[2] * coeffs2[1] - coeffs1[1]
					* coeffs2[2], delta);
			Rational y = new Rational(coeffs1[0] * coeffs2[2] - coeffs1[2]
					* coeffs2[0], delta);
			return "X=" + x + " Y=" + y;
		}
	}

	int[] parseCoeffs(String equation) {
		Pattern pattern = Pattern.compile("-\\p{Digit}+|\\p{Digit}+");
		Matcher matcher = pattern.matcher(equation);
		int begin = 0;
		int coeffs[] = new int[3];
		for (int i = 0; i < coeffs.length; i++) {
			matcher.find(begin);
			int start = matcher.start();
			int end = matcher.end();
			coeffs[i] = Integer.parseInt(equation.substring(start, end));
			begin = end;
		}
		return coeffs;
	}
}

class Rational {
	int numerator;
	int denominator;

	public Rational(int numerator, int denominator) {
		int common = gcd(numerator, denominator);
		if (common * denominator < 0) {
			common = -common;
		}
		this.numerator = numerator / common;
		this.denominator = denominator / common;
	}

	int gcd(int a, int b) {
		while (b != 0) {
			int c = a % b;
			a = b;
			b = c;
		}
		return a;
	}

	@Override
	public String toString() {
		if (numerator < 0) {
			return "(" + numerator + ")/" + denominator;
		} else {
			return numerator + "/" + denominator;
		}
	}
}