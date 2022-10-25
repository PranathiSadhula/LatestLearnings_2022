package datastructures.week1.day1.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class SortArrayByParity2 {
/**
 * Given an array of integers nums, half of the integers in nums are odd, and the other half are even.

Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.

Return any answer array that satisfies this condition.

 

Example 1:

Input: nums = [4,2,5,7]
Output: [4,5,2,7]
Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
Example 2:

Input: nums = [2,3]
Output: [2,3]
 

Constraints:

2 <= nums.length <= 2 * 104
nums.length is even.
Half of the integers in nums are even.
0 <= nums[i] <= 1000
 */
	
	
	@Test
	public void test1() {
		int[] nums = {4,2,5,7};
		int[] output = {4,5,2,7};
		Assert.assertArrayEquals(output, sortArrayByPariti2(nums));
	}
	
	
	/**
	 * psuedo code
	 * 
	 * 1.check if array length < 2, if yes - return invalid error
	 * 2.check if array.length is even , if no return error.
	 * 3. create output array wi array.length
	 * 4.initialise outputIndex with 0;
	 * 5.traverse output array for even indices and check if elt at even indix is even -> if yes, fill in output.
	 * 6.initilise outputIndex with 1;
	 * 7.traverse output array for odd indices and check if elt at odd indix is odd -> if yes, fill in output.
	 */
	
	
	private int[] sortArrayByPariti2(int[] input) {
		if(input.length < 2 || input.length % 2 != 0) {
			return new int[] {};
		}
		else {
			int[] output = new int[input.length];
			int outIndex = 0;
			for(int i = 0; i < input.length; i++) {
				if(input[i] % 2 == 0) {
					output[outIndex] = input[i];
					outIndex = outIndex+2;
				}
			}
			outIndex = 1;
			for(int i = 0; i < input.length; i++) {
				if(input[i] % 2 != 0) {
					output[outIndex] = input[i];
					outIndex = outIndex+2;
				}
			}
			
			return output;
		}
		
		
		  
	}
	
	 public int[] sortArrayByParityIIKrisha(int[] nums) {
	        
	        int even=0;
	        int odd=1;
	                int arr[]= new int[nums.length];
	                for (int i = 0; i < nums.length; i++) {
	                    if(nums[i]%2==0) {
	              arr[even++]=nums[i];
	                        even=even+1;
	                    }
	                }
	                for (int i = 0; i < nums.length; i++) {
	                    if(nums[i]%2!=0) {
	                          arr[odd++]=nums[i];
	                         odd=odd+1;
	                                
	                                }
	                }
	                return arr;
	            }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
