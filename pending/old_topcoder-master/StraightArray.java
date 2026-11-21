import java.util.Arrays;

public class StraightArray {
	public int howManyMore(int[] nums) {
		Arrays.sort(nums);
		int result=4;
		for (int i=0;i<nums.length;i++) {
			for (int j=i+1;j<nums.length && nums[j]-nums[i]<=4;j++) {
				result=Math.min(result, 4-j+i);
			}
		}
		return result;
	}
}
