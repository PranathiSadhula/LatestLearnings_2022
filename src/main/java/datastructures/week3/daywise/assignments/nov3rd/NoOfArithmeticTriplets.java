package datastructures.week3.daywise.assignments.nov3rd;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class NoOfArithmeticTriplets {
    /**
     *  You are given a 0-indexed, strictly increasing integer array nums and a positive integer diff. A triplet (i, j, k) is an arithmetic triplet if the following conditions are met:
     *
     * i < j < k,
     * nums[j] - nums[i] == diff, and
     * nums[k] - nums[j] == diff.
     * Return the number of unique arithmetic triplets.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [0,1,4,6,7,10], diff = 3
     * Output: 2
     * Explanation:
     * (1, 2, 4) is an arithmetic triplet because both 7 - 4 == 3 and 4 - 1 == 3.
     * (2, 4, 5) is an arithmetic triplet because both 10 - 7 == 3 and 7 - 4 == 3.
     * Example 2:
     *
     * Input: nums = [4,5,6,7,8,9], diff = 2
     * Output: 2
     * Explanation:
     * (0, 2, 4) is an arithmetic triplet because both 8 - 6 == 2 and 6 - 4 == 2.
     * (1, 3, 5) is an arithmetic triplet because both 9 - 7 == 2 and 7 - 5 == 2.
     *
     *
     * Constraints:
     *
     * 3 <= nums.length <= 200
     * 0 <= nums[i] <= 200
     * 1 <= diff <= 50
     * nums is strictly increasing.
     *
     */

    /**
     *
     * - CHECK IF NUMS.LENGTH < 3, IF YES return 0.
     *
     * - initialize hashSet to hold elt.
     *
     * - while adding an elt into check if set already has 2 matching elts : diff -elt && diff - 2*elt
     *
     * - if yes , count ++
     *
     * - finally return count.
     *
     */
        private int getArithmeticTripletsHS(int[] nums, int diff){
            int count = 0;

            if(nums.length < 3) return 0;
            HashSet<Integer> set = new HashSet<>();
            for(int i = 0; i < nums.length; i++){
                if(set.contains(nums[i] - diff) && set.contains(nums[i]- (2*diff))) count++;

                set.add(nums[i]);
            }


            return count;
        }
    /**
     *
     * - check if nums.length < 3, if yes return 0.
     *
     * - start 3 pointers : i = 0, j = i+1; k = j+1
     *
     * - iterate through nums starting from i = 0 to nums.length
     *
     * - check if nums[j] - nums[i] == diff then start k = j+1 to  check there is another numss[k] - nums[j] == diff
     *
     * -if yes, count increment
     *
     * finally return count.
     *
     */


    private int arithmeticTripletsCount(int[] nums, int diff){
        if(nums.length < 3) return 0;

        int count = 0;




        for( int i = 0; i < nums.length-2; i++){
            for(int j =i+1; j < nums.length - 1; j++){
                for(int k = j+1;k < nums.length; k++){
                        if(nums[j] - nums[i] == diff && nums[k] - nums[j] == diff) count++;
                }
            }
        }

        return count;
    }


    @Test
    public void test(){
        int[] nums = {0,1,4,6,7,10};
        int diff = 3;
        Assert.assertEquals(2,getArithmeticTripletsHS(nums,diff));

    }
}
