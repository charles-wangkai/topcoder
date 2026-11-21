import java.util.ArrayList;

public class MatArith {
	public String[] calculate(String[] A, String[] B, String[] C,
			String equation) {
		Matrix a = new Matrix(A);
		Matrix b = new Matrix(B);
		Matrix c = new Matrix(C);
		ArrayList<Matrix> matrixs = new ArrayList<Matrix>();
		ArrayList<Character> operands = new ArrayList<Character>();
		int pos = 0;
		while (true) {
			char ch = equation.charAt(pos);
			if (ch == 'A') {
				matrixs.add(a);
			} else if (ch == 'B') {
				matrixs.add(b);
			} else {
				matrixs.add(c);
			}
			pos++;
			if (pos == equation.length()) {
				break;
			}
			operands.add(equation.charAt(pos));
			pos++;
		}
		for (int i = 0; i < operands.size(); i++) {
			if (operands.get(i) == '*') {
				operands.remove(i);
				Matrix m = matrixs.remove(i);
				Matrix n = matrixs.remove(i);
				Matrix p = Matrix.muliply(m, n);
				if (p == null) {
					return new String[] {};
				}
				matrixs.add(i, p);
				i--;
			}
		}
		while (matrixs.size() > 1) {
			Matrix m = matrixs.remove(0);
			Matrix n = matrixs.remove(0);
			Matrix p = Matrix.add(m, n);
			if (p == null) {
				return new String[] {};
			}
			matrixs.add(0, p);
		}
		return matrixs.get(0).getString();
	}

	static class Matrix {
		long values[][];

		Matrix(int row, int column) {
			values = new long[row][column];
		}

		Matrix(String str[]) {
			values = new long[str.length][str[0].split(" ").length];
			for (int i = 0; i < values.length; i++) {
				String temp[] = str[i].split(" ");
				for (int j = 0; j < values[0].length; j++) {
					values[i][j] = Long.parseLong(temp[j]);
				}
			}
		}

		int getRow() {
			return values.length;
		}

		int getColumn() {
			return values[0].length;
		}

		static Matrix muliply(Matrix m, Matrix n) {
			if (m.getColumn() != n.getRow()) {
				return null;
			}
			Matrix result = new Matrix(m.getRow(), n.getColumn());
			for (int i = 0; i < m.getRow(); i++) {
				for (int j = 0; j < n.getColumn(); j++) {
					for (int k = 0; k < m.getColumn(); k++) {
						result.values[i][j] += m.values[i][k] * n.values[k][j];
					}
					if (result.values[i][j] > 2147483647
							|| result.values[i][j] < -2147483648) {
						return null;
					}
				}
			}
			return result;
		}

		static Matrix add(Matrix m, Matrix n) {
			if (m.getRow() != n.getRow() || m.getColumn() != n.getColumn()) {
				return null;
			}
			Matrix result = new Matrix(m.getRow(), m.getColumn());
			for (int i = 0; i < m.getRow(); i++) {
				for (int j = 0; j < m.getColumn(); j++) {
					result.values[i][j] = m.values[i][j] + n.values[i][j];
					if (result.values[i][j] > 2147483647
							|| result.values[i][j] < -2147483648) {
						return null;
					}
				}
			}
			return result;
		}

		String[] getString() {
			String str[] = new String[values.length];
			for (int i = 0; i < values.length; i++) {
				str[i] = "";
				for (int j = 0; j < values[0].length; j++) {
					if (j != 0) {
						str[i] += " ";
					}
					str[i] += values[i][j];
				}
			}
			return str;
		}
	}
}
