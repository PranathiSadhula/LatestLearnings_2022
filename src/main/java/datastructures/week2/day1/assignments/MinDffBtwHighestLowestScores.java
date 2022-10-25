package datastructures.week2.day1.assignments;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MinDffBtwHighestLowestScores {
    /**
     * You are given a 0-indexed integer array nums, where nums[i] represents the score of the ith student. You are also given an integer k.
     *
     * Pick the scores of any k students from the array so that the difference between the highest and the lowest of the k scores is minimized.
     *
     * Return the minimum possible difference.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [90], k = 1
     * Output: 0
     * Explanation: There is one way to pick score(s) of one student:
     * - [90]. The difference between the highest and lowest score is 90 - 90 = 0.
     * The minimum possible difference is 0.
     * Example 2:
     *
     * Input: nums = [9,4,1,7], k = 2
     * Output: 2
     * Explanation: There are six ways to pick score(s) of two students:
     * - [9,4,1,7]. The difference between the highest and lowest score is 9 - 4 = 5.
     * - [9,4,1,7]. The difference between the highest and lowest score is 9 - 1 = 8.
     * - [9,4,1,7]. The difference between the highest and lowest score is 9 - 7 = 2.
     * - [9,4,1,7]. The difference between the highest and lowest score is 4 - 1 = 3.
     * - [9,4,1,7]. The difference between the highest and lowest score is 7 - 4 = 3.
     * - [9,4,1,7]. The difference between the highest and lowest score is 7 - 1 = 6.
     * The minimum possible difference is 2.
     *
     *
     * Constraints:
     *
     * 1 <= k <= nums.length <= 1000
     * 0 <= nums[i] <= 105
     * 
     */
    
    
    @Test
    public void test(){
        int[] scores = {9,4,1,7};
        int noOfStudentsWithLeastScoreDiff /*= k*/ = 2;
        int expectedScoreDiff = 2;
        
        Assert.assertEquals(expectedScoreDiff, getLeastScoreDiffBtwkStudents(scores, noOfStudentsWithLeastScoreDiff));
        
        
    }

    /**
     *
     *  approach : sliding_window
     *
     *  - sort the given array.
     *
     *  - initialise 1 pointers : start = 0
     *
     *  - initialise finaliseDiff = integer.MinValue
     *
     *  - loop starts from start till k
     *
     *  - find diff btw nums[start]  and nums[start+k]
     *
     *  - finaldiff = math.min(diff, finaldiff)
     *
     *  - return finaldiff
     *
     */
    private int getLeastScoreDiffBtwkStudents(int[] scores, int noOfStudentsWithLeastScoreDiff) {
            Arrays.sort(scores);
            int start = 0;
            int minDiff = Integer.MAX_VALUE;

            for(; start < scores.length-noOfStudentsWithLeastScoreDiff+1 ;start++){
                int diff = Math.abs(scores[start] - scores[start+noOfStudentsWithLeastScoreDiff-1]);
                minDiff = Math.min(diff,minDiff);

            }

            return minDiff;


    }
}
