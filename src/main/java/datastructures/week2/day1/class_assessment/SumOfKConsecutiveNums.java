package datastructures.week2.day1.class_assessment;

import org.junit.Assert;
import org.junit.Test;

public class SumOfKConsecutiveNums {
    /**
     * Given
     */

    /**
     * int[] nums = {1,5,2,3,7,1};
     * k = 3
     * output is 12 ==>2,3,7
     */

    /**
     * int[] nums ={4,5,3, 2,7,1}
     * k = 3
     * output is 12 => {4,5,3} and {3,2,7}
     */


    /**
     * approach
     *
     * - create 1 pointers start = 0 and end = k(3)
     *
     * - initialise maxSum with 0.
     *
     * - iterate through the array until start < end
     *
     * - add up elts starting start to end and assign this this maxSum.
     *
     * - in next loop, start iterating from start+1 till end+1
     *
     * - add up the elts and check which is max btw localSum and maxSum to retain the maxSum.
     *
     * -
     */

    private int maxSum(int[] nums, int k){
        int start = 0;
        int end = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(start = 0; start < k; start++){
            sum += nums[start];
        }
        if(k == end) return sum;
        for(start = k; start < end; start++){

            maxSum = Math.max(sum, maxSum);
            sum += nums[start] - nums[start-k];
        }

        return maxSum;
    }

  //  @Test
    public void test(){
        int[] nums = {1,5,2,3,7,1};
        int k = 3;
        Assert.assertEquals(12, maxSum(nums,k));
    }


    @Test
    public void test1(){
        int[] nums = {1,1,1};
        int k = 3;
        Assert.assertEquals(3, maxSum(nums,k));
    }
}
