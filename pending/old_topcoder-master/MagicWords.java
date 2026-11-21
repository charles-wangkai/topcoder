import java.util.HashMap;

public class MagicWords {
	int result = 0;
	HashMap<String, Integer> str2count = new HashMap<String, Integer>();

	public int count(String[] S, int K) {
		int[] permutation = new int[S.length];
		for (int i = 0; i < permutation.length; i++) {
			permutation[i] = i;
		}
		permutate(permutation, 0, S, K);
		return result;
	}

	void permutate(int[] permutation, int index, String[] S, int K) {
		if (index == permutation.length) {
			String str = "";
			for (int elem : permutation) {
				str += S[elem];
			}
			if (getEqualShiftCount(str) == K) {
				result++;
			}
			return;
		}
		for (int i = index; i < permutation.length; i++) {
			swap(permutation, i, index);
			permutate(permutation, index + 1, S, K);
			swap(permutation, i, index);
		}
	}

	int getEqualShiftCount(String str) {
		if (str2count.containsKey(str)) {
			return str2count.get(str);
		}
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (equalShift(str, i)) {
				count++;
			}
		}
		str2count.put(str, count);
		return count;
	}

	boolean equalShift(String str, int offset) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != str.charAt((i + offset) % str.length())) {
				return false;
			}
		}
		return true;
	}

	void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}
