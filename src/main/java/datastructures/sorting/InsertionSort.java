package datastructures.sorting;

import org.junit.Assert;
import org.junit.Test;

public class InsertionSort {

    @Test
    public void tets(){
        int[] nums = {19,17,20,13,11,18};
        Assert.assertArrayEquals(new int[]{11,13,17,18,19,20}, insertionSort(nums));
    }

    private int[] insertionSort(int[] nums){
        for(int i = 1; i < nums.length; i++){
            int j = i - 1;
            int keyNum = nums[i];
            while(j >= 0 && nums[j] > keyNum){
                nums[j+1] = nums[j];
                j --;
             }
            nums[j+1] = keyNum;
        }
        return nums;
    }

}
