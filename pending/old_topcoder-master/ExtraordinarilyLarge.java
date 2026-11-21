import java.math.BigInteger;

public class ExtraordinarilyLarge {
	public String compare(String x, String y) {
		Number number1 = new Number(x);
		Number number2 = new Number(y);
		int commonFactorialNum = Math.min(number1.factorialNum,
				number2.factorialNum);
		number1.factorialNum -= commonFactorialNum;
		number2.factorialNum -= commonFactorialNum;
		if (number1.factorialNum > 0) {
			number1.expand(number2.operator);
		} else if (number2.factorialNum > 0) {
			number2.expand(number1.operator);
		}
		int compareResult = number1.operator.compareTo(number2.operator);
		if (compareResult < 0) {
			return "x<y";
		} else if (compareResult > 0) {
			return "x>y";
		} else {
			return "x=y";
		}
	}
}

class Number {
	BigInteger operator;
	int factorialNum;

	Number(String str) {
		int index = str.indexOf('!');
		if (index < 0) {
			operator = new BigInteger(str);
			factorialNum = 0;
		} else {
			operator = new BigInteger(str.substring(0, index));
			if (operator.equals(BigInteger.ZERO)) {
				operator = BigInteger.ONE;
			}
			factorialNum = str.length() - index;
		}
	}

	void expand(BigInteger limit) {
		while (factorialNum > 0) {
			BigInteger factor = new BigInteger(operator.toString())
					.subtract(BigInteger.ONE);
			while (factor.compareTo(BigInteger.ONE) > 0) {
				if (operator.compareTo(limit) > 0) {
					return;
				}
				operator = operator.multiply(factor);
				factor = factor.subtract(BigInteger.ONE);
			}
			factorialNum--;
		}
	}
}