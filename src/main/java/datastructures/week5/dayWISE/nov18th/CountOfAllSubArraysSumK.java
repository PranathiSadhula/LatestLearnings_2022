package datastructures.week5.dayWISE.nov18th;

import org.junit.Assert;
import org.junit.Test;

public class CountOfAllSubArraysSumK {
    /**
     * {1,1,1} k = 2
     * output = 2 {1,1} and {1,1}
     *
     * {1,1,1,4,-1} k = 3
     * output = 2 {1,1,1} and {4,-1}
     */

    /**
     * - initialize 2 pointers start = 0 and end = start+1.
     * - initialize count = 0.
     * - initialize sum = input[0].
     * - iterate through given array until end < input.length
     * - add sum with input[end]
     * - check if sum matches with k, increment count.
     * - else if sum < k , remove
     * - else if sum > k
     */

    private int countOfSubArrays(int[] nums, int k){
        int start = 0;
        int end = 0;
        int sum = 0;
        int count = 0;
        while(end < nums.length){

            if(sum == k) count++;
           else if(nums[end] < k){
                sum += nums[end];
                if(sum == k) count++;
            }
           else{
               sum -= nums[start++];
                if(sum == k) count++;
            }
            sum += nums[end++];

        }
        return count;
    }

    @Test
    public void test(){
        int[] nums = {1,1,1};
        int k = 2;
        Assert.assertEquals(2, countOfSubArrays(nums, k));
    }

    @Test
    public void test1(){
        int[] nums = {1,1,1,4,-1};
        int k = 3;
        Assert.assertEquals(2, countOfSubArrays(nums, k));
    }
}
