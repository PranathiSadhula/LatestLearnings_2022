package week2.day2;

import org.junit.Assert;
import org.junit.Test;

public class SortElements {

	@Test
	public void test1()
	{
		int[] nums={3,2,1,6,5,4,0};
		int[] expected = {0,1,2,3,4,5,6};
		Assert.assertArrayEquals(expected, sortEltsBfByTemp(nums));
	}
	
	@Test
	public void test2()
	{
		int[] nums={1,2,3,4};
		int[] expected = {1,2,3,4};
		Assert.assertArrayEquals(expected, sortEltsBfByTemp(nums));
	}
	
	@Test
	public void test3()
	{
		int[] nums={1};
		int[] expected = {1};
		Assert.assertArrayEquals(expected, sortEltsBfByTemp(nums));
	}
	
	@Test
	public void test4()
	{
		int[] nums={-1,1,-2};
		int[] expected = {-2,-1,1};
		Assert.assertArrayEquals(expected, sortEltsBfByTemp(nums));
	}
	
	
	/**
	 * 1.  use 2 loops 
	 * 2- 1st loop to travesre each elt i starts from 0 to nums.length
	 * 
	 * 	- 2nd loop to compare with each elt to sort with index j starts from i+1 to nums.length
	 *  	 -> compare if elt at index i is greater than elt at index j
	 *  
	 *  	 -> if yes, add it to new output array.
	 *  		else, nothing.
	 *  
	 *  3.finally return output.
	 * 					
	 * 
	 * */
	
	
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

	private int[] sortEltsBf(int[] nums) {
			for(int i = 0; i < nums.length; i++) {
			for(int j = i + 1; j < nums.length; j++) {
				if(nums[i] > nums[j]) {
					nums[i] = nums[i] + nums[j];
					nums[j] = nums[i] - nums[j];
					nums[i] = nums[i] - nums[j];
				}
			}
		}
		
		return nums;
		
	}
}
