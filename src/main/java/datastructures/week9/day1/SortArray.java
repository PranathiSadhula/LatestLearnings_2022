package datastructures.week9.day1;

import org.junit.Assert;
import org.junit.Test;

public class SortArray {
    /**
     * Sort given array
     */

    @Test
    public void test(){
        int[] nums = {1,0,3,6,8,5,4,2};
        Assert.assertArrayEquals(new int[]{0,1,2,3,4,5,6,8}, sortArray(nums));
        Assert.assertArrayEquals(new int[]{8,6,5,4,3,2,1,0}, sortArrayDes(nums));
    }
    @Test
    public void test1(){
        int[] nums = {1,0,0,0};
        Assert.assertArrayEquals(new int[]{0,0,0,1}, sortArray(nums));
        Assert.assertArrayEquals(new int[]{1,0,0,0}, sortArrayDes(nums));
    }
    @Test
    public void test3(){
        int[] nums = {8,8,7,6,7,5};
        Assert.assertArrayEquals(new int[]{5,6,7,7,8,8}, sortArray(nums));
        Assert.assertArrayEquals(new int[]{8,8,7,7,6,5}, sortArrayDes(nums));
    }

    @Test
    public void test4(){
        int[] nums = {-8,8,7,-6,-7,-5};
        Assert.assertArrayEquals(new int[]{-8,-7,-6,-5,7,8}, sortArray(nums));
        Assert.assertArrayEquals(new int[]{8,7,-5,-6,-7,-8}, sortArrayDes(nums));
    }

    private int[] sortArray(int[] nums) {
        for(int i = 0; i < nums.length-1; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] > nums[j]){
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return nums;
    }

    private int[] sortArrayDes(int[] nums) {
        for(int i = 0; i < nums.length-1; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] < nums[j]){
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return nums;
    }

    private int[] sort(int[] nums){


        return nums;
    }
}
