package datastructures.week3.daywise.assignments.nov4;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class DisappearingNums {
    /**
     * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [4,3,2,7,8,2,3,1]
     * Output: [5,6]
     * Example 2:
     *
     * Input: nums = [1,1]
     * Output: [2]
     *
     *
     * Constraints:
     *
     * n == nums.length
     * 1 <= n <= 105
     * 1 <= nums[i] <= n
     */


    /**approach :
     * - initialize a list of integers output.
     * - start iteration from i = 1 to nums.length
     * - check if i presents in nums, if not add to list
     */

    @Test
    public void test1(){
        int[] nums = {1};
        List<Integer> expected = Arrays.asList();
        Assert.assertEquals(expected,getDisappearingNums(nums));
    }

    @Test
    public void test2(){
        int[] nums = {1,2};
        List<Integer> expected = Arrays.asList();
        Assert.assertEquals(expected,getDisappearingNums(nums));
    }

    @Test
    public void test3(){
        int[] nums = {1,1};
        List<Integer> expected = Arrays.asList(2);
        Assert.assertEquals(expected,getDisappearingNums(nums));
    }

    @Test
    public void test4(){
        int[] nums = {2,2};
        List<Integer> expected = Arrays.asList(1);
        Assert.assertEquals(expected,getDisappearingNums(nums));
    }

    @Test
    public void test5(){
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> expected = Arrays.asList(5,6);
        Assert.assertEquals(expected,getDisappearingNumsSet(nums));
    }

    private List getDisappearingNums(int[] nums) {
        List output = new ArrayList();
        int n = nums.length;

        for(int i = 1; i <= n; i++){
            for(int j = 0; j < nums.length; j++){
                if(nums[0] != i) output.add(i);
            }
        }

        return output;
    }

    /**
     *- initialize a list of integers output.
     *- initialize a set and add all nums into set.
     *- start iteration starting from i = 1 to nums.length
     * - check if set.contains(i), if not add i to list.
     *
     */

    private List<Integer> getDisappearingNumsSet(int[] nums){
        List<Integer> output = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        for(int i = 1; i <= nums.length; i++){
            if(!set.contains(i)) output.add(i);
        }
        return output;
    }
}
