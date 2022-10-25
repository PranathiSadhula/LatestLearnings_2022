package datastructures.week1.daywise.assignments.oct19th;

import java.util.ArrayList;

import org.junit.Test;

public class IntersectionOf2ArraysWithDups {
/**
 * https://leetcode.com/problems/intersection-of-two-arrays/
 * 
 Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
 
Questns to Ask :
	1. if empty what to be returned?
	2. if both arrays are of same length?
	3. if input consists of -ve nums.
	4. if output can have duplicates?
	5. any specific order for output?
	
	
	



Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 */
	
	
	/**
	 * int[] nums1 = {0, 2,3};
	 *int[] nums2 = {1};
	 * 
	 * int[] output = {}; 
	 */
	
	

	/**
	 * nums1 = {0, 2,3};
	 * nums2 = {1};
	 * 
	 * output = {}; 
	 */
	
	
	/**
	 * nums1 = {1,2,3,4};
	 * nums2 = {1,2,2,3,3,4};
	 * 
	 * output = {1,2,3,4}; 
	 */
	
	
	/**
	 * pseudo code
	 * 
	 * 1. 
	 * 
	 * 
	 */
	
	/**
	 * pseudo code - 2Pointer
	 * 
	 * - first = 0 second = 0  
	 * 
	 * - initialse list.  //space -> o[n]
	 * 
	 * - sort the arrays. // o[nlogn]  
	 * 
	 * - iterate through arrays until first < array1.length &&  second < array2.length  //o[ n*m ]
	 * 
	 * - check if value at first of array 1 and second of array2 matches.
	 *    if yes, add to list.
	 * 
	 *   if no, check if value at first < value at second -> increment first.
	 *   
	 *   		 check if value at first > value at second -> increment second.
	 *   
	 * 
	 *  - finally return the list.
	 *  
	 *  time-->  o[nlogn] + o[ n*m ] => o[ n*m ]
	 *  
	 *  space --> o[n]
	 * 
	 */
	
	@Test
	public void test() {
		int[] nums1 = {4,9,5};
		int[] nums2 = {9,4,9,8,4};
		getIntersectionOfArrays(nums1, nums2);
	}
	private int[] getIntersectionOfArrays(int[] nums1, int[] nums2) {
		int first = 0;
		int second = 0;
		ArrayList<Integer> list = new ArrayList<Integer>(nums1.length > nums2.length? nums1.length : nums2.length);
		
		nums1 = sortEltsBfByTemp(nums1); //o[n2]
		nums2 = sortEltsBfByTemp(nums2); //o[n2]
		
		while(first < nums1.length && second < nums2.length) { //o[n*m]
			if(nums1[first] == nums2[second]) {
				list.add(nums1[first]);
				first++;
				second++;
			}
			else {
				if(nums1[first] < nums2[second]) {
					first++;
				}
				else {
					second++;
				}
			}
		}
		int[] output = new int[list.size()];
		int outIndex = 0;
		
		for (int i : list) {
			output[outIndex++] = i;
		}
		
		return output;
	}
	
	
	
private int[] sortEltsBfByTemp(int[] nums) {
		
		for(int i = 0; i < nums.length; i++) {
		for(int j = i + 1; j < nums.length; j++) {
			if(nums[i] > nums[j]) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}
	}
	
	return nums;
	
}
	
	
	
	
}
