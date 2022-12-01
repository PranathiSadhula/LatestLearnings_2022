package datastructures.week7.daywise.nov28th;

import org.junit.Assert;
import org.junit.Test;

public class GroupFirstLastElts {
    /**
     * 4. input arr= [1,2,3,4,5,6]
     * Output- [1,6,2,5,3,4]
     * Write a code to group first and last index together
     */


    private int[] groupFirstLastElt(int[] nums){ //1,6,3,4,5,2
        if(nums.length < 1) throw new RuntimeException("Invalid array");
        int start = 1;
        int end = nums.length-1;
        while(start < end-1){
            nums[start] = nums[start]+ nums[end];
            nums[end] = nums[start] - nums[end];
            nums[start] = nums[start++] - nums[end];

                for(int j = end; j > start; j--){
                    nums[j] = nums[j]+ nums[j-1];
                    nums[j-1] = nums[j] - nums[j-1];
                    nums[j] = nums[j] - nums[j-1];
                }
              start++;
        }
        return nums;
    }


    @Test
    public void test(){
        int[] nums = {1,2,3,4,5,6};
        Assert.assertArrayEquals(new int[]{1,6,2,5,3,4}, groupFirstLastElt(nums));

    }



    @Test
    public void test2(){
        int[] nums = {1,2,3,4,5,6,1,2,3,4,5,6};
        Assert.assertArrayEquals(new int[]{1,6,2,5,3,4,4,3,5,2,6,1}, groupFirstLastElt(nums));

    }
}
