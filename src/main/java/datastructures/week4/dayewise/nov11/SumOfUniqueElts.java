package datastructures.week4.dayewise.nov11;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SumOfUniqueElts {
    /**
     * You are given an integer array nums. The unique elements of an array are the elements that appear exactly once in the array.
     *
     * Return the sum of all the unique elements of nums.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,3,2]
     * Output: 4
     * Explanation: The unique elements are [1,3], and the sum is 4.
     * Example 2:
     *
     * Input: nums = [1,1,1,1,1]
     * Output: 0
     * Explanation: There are no unique elements, and the sum is 0.
     * Example 3:
     *
     * Input: nums = [1,2,3,4,5]
     * Output: 15
     * Explanation: The unique elements are [1,2,3,4,5], and the sum is 15.
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 100
     * 1 <= nums[i] <= 100
     */

    /**
     * - create a hashSet to hold elts in given array.
     * - initialize sum to hold the sum of all elts in given array.
     * - iterate through each elt now, to add into set.
     * - while addign elt into set, check if set.add returns false
     * - if true -> remove sum - elt.
     * -finally return sum
     */

    private int sumOfUniqElts(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
           for(int elt : nums){
            if(!set.add(elt)){
                set.remove(elt);
            }
        }
           for(Integer elt : set){
               sum += elt;
           }

        return sum;
    }

    @Test
    public void test(){
        int[] nums = {1,1,1,1,1};
        Assert.assertEquals(0, sumOfUniqElts(nums));
    }

    private int sumOfUniqEltsHM(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int elt : nums){
            map.put(elt, map.getOrDefault(elt, 0)+1);
        }
       for( Map.Entry<Integer, Integer> entries :  map.entrySet())
       {
           if(entries.getValue() == 1) sum += entries.getKey();
       }


        return sum;
    }


    /**
     * approach : int[] array.
     * - find out maxvalue in given array of nums and store it in max.
     * -
     *
     */
}
