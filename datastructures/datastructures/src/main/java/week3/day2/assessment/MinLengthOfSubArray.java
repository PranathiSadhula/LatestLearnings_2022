package week3.day2.assessment;

import org.junit.Assert;
import org.junit.Test;

public class MinLengthOfSubArray {

    /**
     * Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
     *
     *
     *
     * Example 1:
     *
     * Input: target = 7, nums = [2,3,1,2,4,3]
     * Output: 2
     * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
     * Example 2:
     *
     * Input: target = 4, nums = [1,4,4]
     * Output: 1
     * Example 3:
     *
     * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
     * Output: 0
     *
     *
     * Constraints:
     *
     * 1 <= target <= 109
     * 1 <= nums.length <= 105
     * 1 <= nums[i] <= 104
     */

    /**
     *
     * - initialise pointer start = 0;
     *
     * - initialize minlenth = interger.MaxValue
     *
     * - initialise length = interger.MaxValue
     *
     * - int sum = 0;
     *
     * - in a loop starting start to nums.length
     *
     * - keep adding nums[start] to sum.
     *
     * - check if sum >= target
     *
     * - if yes, remove nums[start-index + 1] from sum hold onto minLength btw length and minLength
     *
     * - else, if sum < target ==> keep adding nums[start]
     */


    private int minLengthOfSubArraySum(int[] nums, int target){ //[2,3,1,2,4,3] 7

        int start = 0;
        int minlenth = Integer.MAX_VALUE;
        int sum = 0;
        int index = 0;
       int curLength = Integer.MAX_VALUE;
        for( ; start < nums.length ; start++){ //start 4 index = 1
            sum += nums[start];

            while(sum >= target) {
                curLength =  start-index + 1;  //4-0 4
                sum -= nums[index++];
            }
            minlenth = Math.min(curLength,minlenth);

        }
        return minlenth == Integer.MAX_VALUE ? 0: minlenth;


    }

    @Test
    public void test(){
      int   target = 7;
      int[] nums = {2,3,1,2,4,3};
        Assert.assertEquals(2, minLengthOfSubArraySum(nums,target));

    }
}
