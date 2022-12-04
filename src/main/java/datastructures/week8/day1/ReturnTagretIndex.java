package datastructures.week8.day1;

import org.junit.Assert;
import org.junit.Test;

public class ReturnTagretIndex {
    /**
     * Given an array of integers nums which is sorted in ascending order,
     * and an integer target, write a function to search target in nums.
     * If target exists, then return its index. Otherwise, return -1.
     * Input: nums = [-1,0,3,5,9,12], target = 9
     */


    @Test
    public void test1(){
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        Assert.assertEquals(4, getIndexOfEltMatchingTargetBS(nums, target));
    }

    @Test
    public void test2(){
        int[] nums = {-1,0,3,5,9,9,9,9,12};
        int target = 9;
        Assert.assertEquals(5, getIndexOfEltMatchingTargetBS(nums, target));
    }

    @Test
    public void test3(){
        int[] nums = {-1,0,3,9,5,9,12};
        int target = 19;
        Assert.assertEquals(-1, getIndexOfEltMatchingTargetBS(nums, target));
    }

    @Test
    public void test5(){
        int[] nums = {2,5};
        int target = 5;
        Assert.assertEquals(1, getIndexOfEltMatchingTargetBS(nums, target));
    }


    /**
     * - check given array length.
     * - if < 0 return exception
     * - if == 0 and elt[0] == target, return 0.
     * - start iterating through given array starting from 0 to length.
     * - check if elt at index i matches with target, if yes return index.
     * - finally out of iteration return -1.
     */

    private int getIndexOfEltMatchingTarget(int[] nums, int target) {
        if(nums.length < 1) throw new RuntimeException("invalid input");
        if(nums.length == 1 && nums[0] == target) return 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target) return i;
        }
        return -1; // time : o[n]
    }

    /**
     * Binary Search :
     * start 3 pointers : low = 0; high = nums.length-1 and mid = low+high/2
     * check if value at mid matches with target ==> return mid as index.
     * else if value at mid < target ==> move low to mid+1
     * else if value at mid > target ==> move high to mid-1
     *
     */

    private int getIndexOfEltMatchingTargetBS(int[] nums, int target){
        if(nums.length < 1) throw new RuntimeException("invalid input");
        if(nums.length == 1 && nums[0] == target) return 0;
        int low = 0;
        int high = nums.length-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) low = mid+1;
            else high = mid -1;
        }
        return -1;
        //time : o[logN]
    }
}
