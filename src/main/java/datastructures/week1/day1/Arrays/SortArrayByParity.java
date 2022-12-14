package datastructures.week1.day1.Arrays;

import org.junit.Assert;

public class SortArrayByParity {
	/**
	 * Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

	Return any array that satisfies this condition.

 

Example 1:

Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

Example 2:

Input: nums = [0]
Output: [0]
 

Constraints:

1 <= nums.length <= 5000
0 <= nums[i] <= 5000
	 */

	
	
//	@Test
	public void test1() {
		int[] nums = {2,3,1,4};
		int[] output = {2,4,3,1};
		Assert.assertArrayEquals(output, sortArrayByParity(nums));
		Assert.assertArrayEquals(output, sortArrayByParityBySwap(nums));
	}
	
//	@Test
	public void test2() {
		int[] nums = {2,4};
		int[] output = {2,4};
		Assert.assertArrayEquals(output, sortArrayByParity(nums));
	}
	
//	@Test
	public void test3() {
		
		int[] nums = {3};
		int[] output = {3};
		Assert.assertArrayEquals(output, sortArrayByParity(nums));
	}
	
	
	/**
	 * psuedo code
	 * 
	 *1.check if array length is equal to 1, if yes return array.
	 *2. create output array with array.length.
	 *3. traverse the array from index 0 to length
	 *4. check if elt is even 
	 *5.if yes -> fill from start index on output
	 *6.else -> fill from last index on output
	 */
	
	
	private static int[] sortArrayByParity(int[] nums) {
		if(nums.length == 1) return nums; //o[1]
		else {
			int[] output = new int[nums.length];
			int start = 0;
			int last = output.length-1;
			for(int i = 0; i <= nums.length-1; i++) { //o[n]
				if(nums[i] % 2 == 0) { 
					output[start++] = nums[i]; 
				}
				else {
					output[last--] = nums[i];
				}
			}
			return output;
		}
	}
	
	public static void xyz(String[] args) {
		int[] nums = {2,3,1,4};
		int[] output = {2,4,3,1};
	//	Assert.assertArrayEquals(output, sortArrayByParity(nums));
		Assert.assertArrayEquals(output, sortArrayByParityBySwap(nums));
	}
	
	public static void main(String[] args) {
		int[] nums = {1,0,3};
		int[] output = {0,1,3};
	//	Assert.assertArrayEquals(output, sortArrayByParity(nums));
		Assert.assertArrayEquals(output, sortArrayByParityBySwap(nums));
	}
	
	
	/**
	 * psuedo code by swapping
	 * 
	 *1.check if array length is equal to 1, if yes return array.
	 *2.traverse thorugh array from start and end
	 *3.check if elt at start is even 
	 *4.if yes -> do nothing 
	 *5.else -> swap
	 *
	 *
	 *
	 */
	
	
	private static int[] sortArrayByParityBySwap(int[] nums) {
		if(nums.length == 1) return nums; //o[1]
		else {
			int start = 0;
			int last = nums.length-1;
			while(start < last) {
				 if(nums[start++] % 2 != 0) {
					nums[start-1] = nums[last]+nums[start-1];
					nums[last] = nums[start-1] - nums[last];
					nums[start-1] = nums[start-1] - nums[last--];
				}
				
				
			}
			
			return nums;
		}
	}
	
	
	
}
