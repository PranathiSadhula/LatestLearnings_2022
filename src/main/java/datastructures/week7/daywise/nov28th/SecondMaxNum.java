package datastructures.week7.daywise.nov28th;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SecondMaxNum {
    /**
     * [5,3,2,4,1,8]
     *
     * out = 5
     *
     * [5,3,2,5,4,1,8]
     * out = 5
     *
     * [5,5,5,5]
     * out = ?
     *
     */

    private int findNthMaxNum(int[] nums){
       // o[nlogn] Arrays.sort();
       /* int nMax = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length-1; j++){
                nums[i] = nums[i] + nums[j];
                nums[j] = nums[i] - nums[j];
                nums[i] = nums[i] - nums[j];
            }

        }*/

       int max = Math.max(nums[0], nums[1]);
       int sMax = Math.min(nums[0], nums[1]);
       for(int i = 2; i < nums.length; i++){
           if(max < nums[i]){
               sMax = max;
               max = nums[i];
           }
           else if(sMax < nums[i] && max > nums[i]){
                sMax = nums[i];

           }
       }

        return sMax;
    }


    @Test
    public void test(){
        int[] nums = {7,5,3,2,6,4,1,8};
        Assert.assertEquals(7, findNthMaxNum(nums));
    }
}
