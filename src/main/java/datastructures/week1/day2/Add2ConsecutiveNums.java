package datastructures.week1.day2;

import org.junit.Assert;
import org.junit.Test;

public class Add2ConsecutiveNums {

	@Test
	public void test() {
		int[] nums = { 1, 2, 3, 4, 5 };
		int[] expected = { 3, 5, 7, 9 };
	Assert.assertArrayEquals(expected, addConsecutiveNums(nums));
	}
	
	@Test
	public void test2() {
		int[] nums = { 1, 2, 3, 4, 5,9 };
		int[] expected = { 3, 5, 7, 9 , 14};
	Assert.assertArrayEquals(expected, addConsecutiveNums(nums));
	}

	private int[] addConsecutiveNums(int[] nums) {
		int[] output = new int[nums.length-1];
		int outIndex = 0;
		for (int i = 0; i < nums.length-1; i++) { // n
			int sum = 0;
			for (int j = i; j <= i + 1; j++) { // 2
				sum += nums[j];
			}
			output[outIndex++] = sum;
		}

		return output;
	}

}
