package datastructures.week1.day1;

import java.util.Arrays;

import org.junit.Test;



public class IndicesOfEltsToSumUpTarget {
	
	/*
	 * Given input array, find out sum of 2 elts summing up to match given target and return the indices of those elts
	 *
	 *
	 *Questns to ask :
	 * - what if I find more 1 occurances of indices pair summing up to given target? what needs to be returned?
	 * -what if I find non occurances > what should be returned ? empty array or any assert message?
	 * - is the array consists of +ve or -ve elts?
	 * - any duplicates?
	 * - is the sum of same indices considered?
	 * - any length constraints? 
	 *
	 *Examples to try out :
	 * int[] input = {1,3,2,5, 4, 0}; 
	 * 
	 * int target = 4   // 2 pairs I found : {0,1}, {4,5}
	 *
	 * int[] expectedIndices = {}; // return first found indices. here {0,1}
	 * 
	 * 
	 * 
	 * 
	 * int[] input = {1,3,2,5, 4, 0}; 
	 * 
	 * int target = 10   // 2 pairs I found : none
	 *
	 * int[] expectedIndices = {}; // return first found indices. here {}
	 * 
	 * 
	 * int[] input = {1,1,1}; 
	 * 
	 * int target = 1   // 2 pairs I found : none
	 *
	 * int[] expectedIndices = {}; // return first found indices. here {}
	 * 
	 * 
	 * int[] input = {1,1,1}; 
	 * 
	 * int target = 1   // 2 pairs I found : none
	 *
	 * int[] expectedIndices = {}; // return first found indices. here {}
	 * 
	 */

	
	
	
	
	

	

	
	
	public static int[] returnIndicesOfEltsToSumUpTarget(int[] nums, int target) {
		
		if(nums.length == 1) return new int[]{};
		
		if(nums.length == 2 && nums[0]+nums[1] == target ) return new int[] {0,1};
		else if(nums[0]+nums[1] != target)  return new int[] {} ;
		
		int[] output = {0,0};
		boolean matchesFound = false;
		for(int i = 0; i < nums.length -1; i++) {
			for(int j = i+1; j < nums.length; j++) {
				if(nums[i] + nums[j] == target) {
					output[0] = i;
					output[1] = j;
					matchesFound = true;
				}
			}
			
		}
		
		if(!matchesFound) return new int[]{};
		
		return output;
	}
	
	
	
	
	@Test
	public void test() {
		
		/*
		  int[] nums = {2,4,5,8,3,6,7}; int target = 12;
		  System.out.println(Arrays.toString(returnIndicesOfEltsToSumUpTarget(nums,
		  target)));
		 */
		
		/*
		  int[] nums = {2}; int target = 15;
		  System.out.println(Arrays.toString(returnIndicesOfEltsToSumUpTarget(nums,
		  target)));
		 */
		
		
		int[] nums = {3,2,4};
		int target = 6;
		System.out.println(Arrays.toString(returnIndicesOfEltsSummingUpTarget(nums,target)));
		
	}
	
	
	/*
	 * Examples to try out :
	 * int[] input = {1,3,2,5, 4, 0}; 
	 * 
	 * int target = 4   // 2 pairs I found : {0,1}, {4,5}
	 *
	 * int[] expectedIndices = {}; // return first found indices. here {0,1}
	
	 * 
	 * 
	 * Two-Pointer Approach
	 * - create an output array with size 2.
	 * 
	 * - initialise 2 pointers : start = 0, end = array.length.
	 * 
	 * - sum up the elts at both pointers and check if sum matches with target.
	 * 
	 * - if matches, add start and end to output array.
	 * 
	 * -if doesnt matches, 
	 *    
	 *    - check if sum < target, move start
	 * 
	 *    - check if sum > target, move end
	 * 
	 */
	
	
	private int[] returnIndicesOfEltsSummingUpTarget(int[] nums, int target) {
		
			
		int[] output = new int[2];
		int start = 0 ;
		int end = nums.length-1;
		
		while(start < end) {
			int sum = nums[start] + nums[end];
			if(sum == target) {
				output[0] = start++;
				output[1] = end--;
			}
			else if(sum < target) start++;
			else end--;
		}
		
		
		return output;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
