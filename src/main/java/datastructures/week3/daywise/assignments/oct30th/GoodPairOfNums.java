package datastructures.week3.daywise.assignments.oct30th;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class GoodPairOfNums {
    /**
     *
     * https://leetcode.com/problems/number-of-good-pairs/description/
     *
     * Given an array of integers nums, return the number of good pairs.
     *
     * A pair (i, j) is called good if nums[i] == nums[j] and i < j.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,3,1,1,3]
     * Output: 4
     * Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
     * Example 2:
     *
     * Input: nums = [1,1,1,1]
     * Output: 6
     * Explanation: Each pair in the array are good.
     * Example 3:
     *
     * Input: nums = [1,2,3]
     * Output: 0
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 100
     * 1 <= nums[i] <= 100
     */

    /**
     * approach : HashMap
     *
     * - check if nums.length == 1. if yes return 0
     *
     * - Initalize hashMap to hold elts at index.
     *
     * - iterate through nums starting from i = 0 to nums.length
     *
     * - before adding elt into set, check if elt already exists, if yes, cont++
     *
     * finally return count
     *
     *
     */

    private int goodPairNumsHashMap(int[] nums) {
        if(nums.length == 1) return 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
         if(map.containsKey(nums[i])) count += map.get(nums[i]);
         map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        return count;
    }
/**
 * approach : HashSet
 *
 * - check if nums.length == 1. if yes return 0
 *
 * - Initalize hashset to hold elts at index.
 *
 * - iterate through nums starting from i = 0 to nums.length
 *
 * - before adding elt into set, check if elt already exists, if yes, cont++
 *
 * finally return count
 *
 *
 */

        private int goodPairNumsHashSet(int[] nums) {
            if(nums.length == 1) return 0;
            int count = 0;
            HashSet<Integer> set = new HashSet<>();
            for(int i = 0; i < nums.length; i++){

                if(set.contains(nums[i]) ) count++;
                set.add(nums[i]);
            }
            return count;
        }
    /**
     *  - check if nums.length == 1, if yes, return 0.
     *
     *  - initialize a counter = 0.
     *
     *  - iterate trhough nums starting i = 0 till nums.length-1
     *
     *  - in inner loop start iteration from j = i+1 to nums.length
     *
     *  - check if nums[i] == nums[j] and i < j then increment counter++
     *
     *  finally return counter.
     */
    private int containsGoodPair(int[] nums) {
        if(nums.length == 1) return 0;

        int count = 0;

        for(int i = 0; i < nums.length-1; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] == nums[j] && i < j) count++;
            }

        }

        return count;
    }



    @Test
    public void test1(){
        int[] nums = {0};
        Assert.assertEquals(0, containsGoodPair(nums));

    }


    @Test
    public void test2(){
        int[] nums = {1,2};
        Assert.assertEquals(0, containsGoodPair(nums));

    }


    @Test
    public void test3(){
        int[] nums = {1,2,3,4,5,6,7,8,9,1};
        Assert.assertEquals(1, containsGoodPair(nums));

    }


    @Test
    public void test4(){
        int[] nums = {1,2,3,4,5,6,7,8,9,1,1,2,3,4,5};
        Assert.assertEquals(7, goodPairNumsHashMap(nums));

    }


}
