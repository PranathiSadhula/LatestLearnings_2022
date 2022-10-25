package datastructures.week1.daywise.assignments.oct18th;

import org.junit.Test;

import junit.framework.Assert;

public class NandItsDouble {
	/**
	 * 
	 * Given an array arr of integers, 
	 * check if there exist two indices i and j such that :

i != j
0 <= i, j < arr.length
arr[i] == 2 * arr[j]
 

Example 1:

Input: arr = [10,2,5,3]
Output: true
Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]
Example 2:

Input: arr = [3,1,7,11]
Output: false
Explanation: There is no i and j that satisfy the conditions.
 

Constraints:

2 <= arr.length <= 500
-103 <= arr[i] <= 103
	 */

	/**
	 *  - initiate 2 pointers : i = 0; j = nums.length - 1.
	 *  
	 *  - traverse through nums until i < j
	 *  
	 *  - check if nums[i] == 2 * nums[j] or nums[j] == 2 * nums[i]
	 *  
	 *    -- if yes, return true.
	 *    
	 *    finally make return false.
	 *
	 */
	
	private boolean isDoublePresent(int[] nums) {

		for (int i = 0; i < nums.length; i++) {

			for (int j = i+1; j < nums.length; j++) {
				int divisor = nums[i] < nums[j] ? nums[i] : nums[j];
				int divedend = nums[i] + nums[j] - divisor;
				if(divedend != 0 && divisor != 0) {
					if (divedend / divisor == 2 && divedend % divisor == 0)
						return true;
				}
				
			}
		}

		return false;
	}
	
	@Test
	public void test() {
		int[] nums = {-20,8,-6,-14,0,-19,14,4};
		Assert.assertTrue(isDoublePresent(nums));
	}
}
