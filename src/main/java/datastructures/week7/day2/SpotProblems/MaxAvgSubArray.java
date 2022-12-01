package datastructures.week7.day2.SpotProblems;

import org.junit.Test;

public class MaxAvgSubArray {
    /**
     * You are given an integer array nums consisting of n elements, and an integer k.
     *
     * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
     * Any answer with a calculation error less than 10-5 will be accepted.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,12,-5,-6,50,3], k = 4
     * Output: 12.75000
     * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
     * Example 2:
     *
     * Input: nums = [5], k = 1
     * Output: 5.00000
     *
     *
     * Constraints:
     *
     * n == nums.length
     * 1 <= k <= n <= 105
     * -104 <= nums[i] <= 104
     */

    /**
     * - accept given int[] and check if array length > 1, else return 0/ exception.
     * - initialize maxAvg = Integer.Min_Value;
     * - iterate through given array starting from 0 till K.
     * - calculate avg for elts btw 0 and K and assign this curAvg.
     * - Now, start iteration from i starting 1 till array.length.
     * - while iteration,
     * - remove elt at i-1 from curAvg and add elt
     */


    private double findMaxAverage(int[] nums, int k) {
        double maxAvg = 0.0;
        double curAvg = 0.0;

        for(int i = 0; i < k; i++){
            curAvg += nums[i];
        }
        maxAvg = curAvg/k;

        for(int i = k; i < nums.length; i++){
            curAvg -= nums[i-k];
            curAvg += nums[i];
            maxAvg = Math.max(curAvg/k, maxAvg);
        }

        return maxAvg;
    }

    @Test
    public void test(){
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(findMaxAverage(nums, k));
    }
}
