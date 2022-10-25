package week2.day2;

import org.junit.Assert;
import org.junit.Test;

public class ReverseArrayWithTwoPointer {
	
	//@Test
	public void test() {
		int[] nums = {5,4,1,2,3};
		int[] expected = {3,2,1,4,5};
		Assert.assertArrayEquals(expected, reverseArray(nums));
	}
	@Test
	public void test2() {
		int[] nums = {5,4,1,2,3,6};
		int[] expected = {6,3,2,1,4,5};
		Assert.assertArrayEquals(expected, reverseArray(nums));
	}
	
	/**
	 * 1.initialise 2 pointers -> start = 0; end = nums.length-1
	 * 2.traverse through array until start !=  end
	 * 3.swap the elts at start and end.
	 * increment start, dcrement end
	 */
	
	private int[] reverseArray(int[] nums) {
		
		int start = 0;
		int end = nums.length-1;
		
		while(start < end) {
			int temp = nums[start];
			nums[start++] = nums[end];
			nums[end--] = temp;
			
		}
		return nums;
	}

}
