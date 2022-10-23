package week3.day1.class_assessment;

import org.junit.Assert;
import org.junit.Test;

public class AvgOfKConsecutiveNums {

    /**
     * You are given an integer array nums consisting of n elements, and an integer k.
     *
     * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
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
     * approach
     *
     * - create 2 pointers start = 0 and end = size - k+1
     *
     * - initialise double value for min.
     *
     * - in loop starting from start till k - 1 sum up values to get avg = sum.
     *
     * - in another loop start from start+1 till size of array
     *
     * - add sum with value at end[size-k+1] pointer
     *
     * - and then divide value by k and hold the max btw maxAvg and localAvg
     *
     * - keep removing value at start from maxAvg
     *
     * -
     */

    private double maxAvg(int[] nums, int k) {
        int start = 0;
        int next = nums.length ;
        double maxAvg = Double.MIN_VALUE;
        double sum = 0;
        for (start = 0; start < k; start++) {
            sum += nums[start];
        }
        maxAvg = sum / k;

        for (start = k; start < next; start++) {
            sum += nums[start] - nums[start-k];
            maxAvg = Math.max(maxAvg,sum/k);
        }
        return maxAvg;
    }

    @Test
    public void test(){
        int[] nums =  {1,12,-5,-6,50,3};
        int k = 4;
        double expected = 12.75000;
        System.out.println(maxAvg(nums,k));
    }
}
