package datastructures.week9.day1.sorting;

import org.junit.Assert;
import org.junit.Test;

public class BubbleSort {
    @Test
    public void test4(){
        int[] nums = {-8,8,7,-6,-7,-5};
        Assert.assertArrayEquals(new int[]{-8,-7,-6,-5,7,8}, bubbleSort(nums));

    }

    @Test
    public void test(){
        int[] nums = {1,0,3,6,8,5,4,2};
        Assert.assertArrayEquals(new int[]{0,1,2,3,4,5,6,8}, bubbleSort(nums));

    }

    private int[] bubbleSort(int[] nums){
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length-1; j++){
                if(nums[j] > nums[j+1]){
                    nums[j+1] = nums[j+1] + nums[j];
                    nums[j] = nums[j+1] - nums[j];
                    nums[j+1] = nums[j+1] - nums[j];
                }
            }
        }
        return nums;
    }

}
