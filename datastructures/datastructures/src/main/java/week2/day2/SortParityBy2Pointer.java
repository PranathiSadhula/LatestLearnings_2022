package week2.day2;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class SortParityBy2Pointer {
	
	@Test
	public void test1() {
		int[] nums = {2,3,1,4};
		int[] output = {2,4,3,1};
		Assert.assertArrayEquals(output, sortArrayByParity(nums));
		
	}
	
	@Test
	public void test2() {
		int[] nums = {2,3,1,4,0};
		int[] output = {2,4,0,3,1};
		Assert.assertArrayEquals(output, sortArrayByParity(nums));
		
	}
	
	/**
	 * 1. initialise 2 pointers start = 0, end = nums.length-1
	 * 2. traverse through nums until start < end
	 * 3. check if elt at start is not even and elt at end is even
	 * 		-if yes -> swap and increment start, decrement even.
	 * 4. check if elt at start is not even and elt at end is not even
	 * 		- if yes ->do nothing to start, decrement end.
	 * 5.  check if elt at start is even and elt at end is not even
	 *      - if yes ->do nothing to start, decrement end.
	 *  
	 * 6.  check if elt at start is even and elt at end is even  
	 * 		if yes -> do nothing to end, increment start.  
	 *      
	 */
	
	
	private int[] sortArrayByParity(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		System.out.println(Arrays.toString(nums));
		while(start < end) {
			int temp = 0;
			if(nums[start] % 2 != 0 && nums[end] % 2 == 0) {
				temp = nums[start];
				nums[start++] = nums[end];
				nums[end--] = temp;
				
			}
			else if(nums[start] % 2 != 0 && nums[end] % 2 != 0) {
				end--;
			}
			else if(nums[start] % 2 == 0 && nums[end] % 2 != 0) {
				start++;
				end--;
			}
			else if(nums[start] % 2 == 0 && nums[end] % 2 == 0) {
				start++;
			}
		}
		System.out.println(Arrays.toString(nums));
		return nums;
	}
}
