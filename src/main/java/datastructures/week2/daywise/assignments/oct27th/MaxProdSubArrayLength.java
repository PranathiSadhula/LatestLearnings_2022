package datastructures.week2.daywise.assignments.oct27th;

import org.junit.Assert;
import org.junit.Test;

public class MAxProbSubArrayLength{

 /**
Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.

 

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 

Constraints:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

 */


// @test
 public void test1(){
    int[] nums = {2,4,1,6};
    int expected = 48 ;
    Assert.assertEquals(expected, maxProdSubArrLength(nums));
 }

@Test
 public void test2(){
    int[] nums = {-2,4,2,-1};
    int expected = 16;
    Assert.assertEquals(expected, maxProdSubArrLength(nums));
 }

 public void test3(){
    int[] nums = {-1,3,0};
    int expected = 3;
    Assert.assertEquals(expected, maxProdSubArrLength(nums));
 }

  public void test4(){
    int[] nums = {-1,3,0,-2};
    int expected = 3;
    Assert.assertEquals(expected, maxProdSubArrLength(nums));
 }

@test
  public void test1(){
    int[] nums = {2,4,1,6};
    int expected = 48 ;
    Assert.assertEquals(expected, maxProdSubArrLength(nums));
 }

 /*
    - check if nums.length is == 1, if yes return nums[0]
    
  * - initialize zeroCount, negCount, prod
  * 
  * - iterate through nums to check if elt at ith index is 0 or < 0

    - if nums[i] == 0, increment zeroCount

    - if nums[i] < 0, increment negCount

    - keep multiplying nums[i] with prod to get final prod

    - after above iteration, check if zeroCount == 0 and negCount is even 

      ==> if yes return prod

    - initialize maxProd, minProd and result with nums[0] 

    - iterate through nums  
  */


  private int maxProdSubArrLength(int[] nums){
       if(nums.length == 1) return nums[0];

        int zeroCount = 0;
        int negCount = 0;
        int maxProd = 1;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) zeroCount++;
            if(nums[i] < 0) negCount++;
            maxProd *= nums[i];
        }

        if(zeroCount == 0 && negCount % 2 == 0) return maxProd;

        maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];

        for(int i = 1; i < nums.length; i++){

            int temp = maxProd;
            maxProd = Math.max(Math.max(maxProd*nums[i], minProd*nums[i]), nums[i]);
            minProd = Math.min(Math.min(temp*nums[i], minProd*nums[i]), nums[i]);
            result = Math.max(maxProd, result);
        }
        return result;



        
  }

}