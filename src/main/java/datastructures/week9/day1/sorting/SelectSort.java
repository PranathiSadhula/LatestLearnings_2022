package datastructures.week9.day1.sorting;

import org.junit.Assert;
import org.junit.Test;

public class SelectSort {
    /**
     * not optimised
     * this is kind of bruteforce approach
     * iterate from i=0 to length-1 of array
     */

    private int[] selectSortArray(int[] nums) {
        for(int i = 0; i < nums.length-1; i++){
            int lowIndex = i;
            for(int j = i+1; j < nums.length; j++){
                if(nums[j] < nums[lowIndex]) lowIndex = j;
            }
            if(i != lowIndex) {
                int temp = nums[lowIndex];
                nums[lowIndex] = nums[i];
                nums[i] = temp;
            }
        }
        return nums;
    }

    @Test
    public void test(){
        int[] nums = {1,0,3,6,8,5,4,2, -8};
        Assert.assertArrayEquals(new int[]{-8,0,1,2,3,4,5,6,8}, selectSortArray(nums));
        Assert.assertArrayEquals(new int[]{8,6,5,4,3,2,1,0,-8}, selectSortArrayDes(nums));

    }

//3,-2,6,7,-5
@Test
public void test1(){
    int[] nums = {3,-2,6,7,-5};
    Assert.assertArrayEquals(new int[]{-5,-2,3,6,7}, selectSortArray(nums));
    Assert.assertArrayEquals(new int[]{7,6,3,-2,-5}, selectSortArrayDes(nums));

}
    private int[] selectSortArrayDes(int[] nums) {
        for(int i = 0; i < nums.length-1; i++){
            int highIndex = i;
            for(int j = i+1; j < nums.length; j++){
                if(nums[j] > nums[highIndex]) highIndex = j;
            }
            if(i != highIndex) {
                int temp = nums[highIndex];
                nums[highIndex] = nums[i];
                nums[i] = temp;
            }
        }
        return nums;
    }
}
