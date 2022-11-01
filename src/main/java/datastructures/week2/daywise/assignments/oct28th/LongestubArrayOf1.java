package datastructures.week2.daywise.assignments.oct28th;

import org.junit.Assert;
import org.junit.Test;

public class LongestubArrayOf1 {

    /**
     *Given a binary array nums, you should delete one element from it.
     *
     * Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,1,0,1]
     * Output: 3
     * Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
     * Example 2:
     *
     * Input: nums = [0,1,1,1,0,1,1,0,1]
     * Output: 5
     * Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
     * Example 3:
     *
     * Input: nums = [1,1,1]
     * Output: 2
     * Explanation: You must delete one element.
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 105
     * nums[i] is either 0 or 1.
     *
     */

    @Test
    public void test1(){
        int[] nums = {1,1,1};
        int output = 2;
        Assert.assertEquals(output, longestSUbArrayLength(nums));
    }

    /***
     * - check nums.length == 1, if yes return 0.
     *
     * - loop over given array to check if 1's present.
     *
     * - if not present return 0
     *
     * - if only 1's present return 1
     *
     * - if both 1's and 0's present :
     *
     * - initialize maxLength = 0
     *
     * - iterate through binary array until you reach your 1st 1.
     *
     * - on reaching 1st 1, iterate again till you reach 0.
     *
     * - on reaching 0, check if next elt is 1
     *
     *   - if 1, continue to iterate till you reach next 0, and then return length from i to j -1
     *
     *   - if 0, return i to 0
     *
     *   - initialize startIndexOf1, maxLength
     *
     *   - reinitialize oCount = 0
     *
     *   - iterate through nums starting currentIndex = 0 to nums.length
     *
     *   - check if nums[i] == 0, if yes ==> calculate maxlength btw maxLength and sum of startIndex+currentIndex
     *                                       reinitialize startIndex with 0, as next index elt expecting to be 1.
     *                                       reinitialize oCount with 0, to start fresh count of 1s again
     *
     *   - else if nums[i] == 1, incremenet oCount
     *                          if currIndex reaches nums.length calculate maxlength btw maxLength and sum of startIndex+currentIndex
     *
     *
     *
     *
     *
     * @param nums
     * @return
     */
    private int longestSUbArrayLength(int[] nums) {
        if (nums.length == 1) return 0;

        int oCount = 0;
        int zCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zCount++;
            else oCount++;
        }

        if (oCount == nums.length) return nums.length-1;
        if (zCount == nums.length) return 0;

        int startIndex = 0;
        oCount = 0;
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                maxLength = Math.max(maxLength, startIndex + oCount);
                startIndex = oCount;
                oCount = 0;
            } else {
                oCount++;
                if (i == nums.length - 1) {
                    maxLength = Math.max(maxLength, startIndex + oCount);
                }


            }
        }

        return maxLength;
    }
}
