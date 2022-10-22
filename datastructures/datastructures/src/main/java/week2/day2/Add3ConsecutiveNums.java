package week2.day2;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class Add3ConsecutiveNums {

	@Test
	public void test() {
		int[] nums = { 1, 2, 3, 4, 5 };
		int[] expected = {6,9,12 };
	Assert.assertArrayEquals(expected, addConsecutiveNums(nums, 3));
	}
	
	@Test
	public void test2() {
		int[] nums = { 1, 2, 3, 4, 5,9 };
		int[] expected = { 6,9,12,18};
	Assert.assertArrayEquals(expected, addConsecutiveNums(nums,3));
	//Assert.assertEquals(expected, addConsecutiveNums(nums));
	}
	@Test
	public void test4() {
		int[] nums = { 1, 2, 3, 4, 5 };
		int[] expected = { 3, 5, 7, 9 };
	Assert.assertArrayEquals(expected, addConsecutiveNums(nums,2));
	}
	
	@Test
	public void test5() {
		int[] nums = { 1, 2, 3, 4, 5,9 };
		int[] expected = { 3, 5, 7, 9 , 14};
	Assert.assertArrayEquals(expected, addConsecutiveNums(nums,2));
	}
	/**
	 * 1.create an output array with length as input.length - no.OfConsecutiveNumsToAdd.
	 * 2.traverse through input array from i = 0 to input.length - no.OfConsecutiveNumsToAdd.
	 * 3.initialise a sum variable with value 0 in this loop. so that it gets refrshed for every i iteration.
	 * 4.traverse again through input from j = i till j input.length - no.OfConsecutiveNumsToAdd.
	 * 5.now add each elt in this 2nd loop to sum varaible. 
	 * 6. at the end of 2nd loop assign sum to output array and increament outIndex.
	 * 
	 * finally return output
	 * 
	 */
	
	
	
	
	
	
	
	

	private int[] addConsecutiveNums(int[] nums, int consecutiveNumsToAdd) {
	
		int[] output = new int[nums.length-consecutiveNumsToAdd+1];
		int outIndex = 0;
		for (int i = 0; i < output.length; i++) { //n-consecutiveNumsToAdd+1
			int sum = 0;
			for (int j = i; j < i + consecutiveNumsToAdd; j++) { // consecutiveNumsToAdd
				sum += nums[j];
			}
			output[outIndex++] = sum;
		}
		//time = n-consecutiveNumsToAdd+1 * consecutiveNumsToAdd
		return output;
	}

}
