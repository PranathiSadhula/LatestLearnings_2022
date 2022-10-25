package week2.day1.assignments.templateimpl;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class MissingNumber {
/**
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

 

Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
Example 2:

Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
Example 3:

Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 

Constraints:

n == nums.length
1 <= n <= 104
0 <= nums[i] <= n
All the numbers of nums are unique.
 */
	
	@Test
	public void test1() {
		int[] nums = {0};
		int expectedMissingNum = 1 ;
		Assert.assertEquals(expectedMissingNum, returnMissedNum(nums));
	}
	
	public void test2() {
		int[] nums = {2,1,0,4};
		int expectedMissingNum =3 ;
		Assert.assertEquals(expectedMissingNum, returnMissedNum(nums));
	}
	
	public void test3() {
		int[] nums = {};
		int expectedMissingNum = 0 ;
		Assert.assertEquals(expectedMissingNum, returnMissedNum(nums));
	}
	
	
	/*
	 * pseudo code
	 * 
	 * 1. initilise missedNum = 0 and n = nums.length
	 * 
	 * 2.sort nums using Arrays.sort.
	 * 
	 * 3.  traverse through nums from i =  0 to n.
	 * 
	 * 4. check if nums[i] doesnt matches with i. if yes -> return i.
	 * 
	 * 
	 * 
	 * 
	 */

	private int returnMissedNum(int[] nums) {
		int missedNum = 0;
		int n = nums.length;
		Arrays.sort(nums);

		for (int i = 0; i < n; i++) {
				if(nums[i] != i)
					missedNum = i;
		}

		return missedNum;
	}
}
