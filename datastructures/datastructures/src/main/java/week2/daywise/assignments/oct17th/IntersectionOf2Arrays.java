package week2.daywise.assignments.oct17th;

import java.util.HashSet;

import org.junit.Test;

public class IntersectionOf2Arrays {
/**
 * https://leetcode.com/problems/intersection-of-two-arrays/
 * 
 * 
 * Given two integer arrays nums1 and nums2, return an array of their intersection. 
 * Each element in the result must be unique and you may return the result in any order.

 
Questns to Ask :
	1. if empty what to be returned?
	2. if both arrays are of same length?
	3. if input consists of -ve nums.
	4. if output can have duplicates?
	5. any specific order for output?
	
	
	

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 

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
	 * - initialse hashset.  //space -> o[n]
	 * 
	 * - sort the arrays. // o[nlogn]  
	 * 
	 * - iterate through arrays until first < array1.length &&  second < array2.length  //o[ n*m ]
	 * 
	 * - check if value at first of array 1 and second of array2 matches.
	 *    if yes, add to set.
	 * 
	 *   if no, check if value at first < value at second -> increment first.
	 *   
	 *   		 check if value at first > value at second -> increment second.
	 *   
	 * 
	 *  - finally return the set.
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
		HashSet<Integer> set = new HashSet<Integer>(nums1.length > nums2.length? nums1.length : nums2.length);
		
		nums1 = sortEltsBfByTemp(nums1);
		nums2 = sortEltsBfByTemp(nums2);
		
		while(first < nums1.length && second < nums2.length) {
			if(nums1[first] == nums2[second]) {
				set.add(nums1[first]);
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
		int[] output = new int[set.size()];
		int outIndex = 0;
		
		for (int i : set) {
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
