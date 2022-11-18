package datastructures.sorting;

import org.junit.Assert;
import org.junit.Test;

public class BubbleSort {
    @Test
    public void test(){
        int[] nums = {19,17,20,13,11,18};
        Assert.assertArrayEquals(new int[]{11,13,17,18,19,20}, bubbleSort(nums));
    }

    private int[] bubbleSort(int[] nums){
        for(int i = 0; i < nums.length; i++){
            for(int j = 1; j < nums.length; j++){
                if(nums[j-1] > nums[j]){
                    nums[j-1] = nums[j-1] + nums[j];
                    nums[j] = nums[j-1] - nums[j];
                    nums[j-1] = nums[j-1] - nums[j];
                }


            }
        }
        return nums;
    }
}
