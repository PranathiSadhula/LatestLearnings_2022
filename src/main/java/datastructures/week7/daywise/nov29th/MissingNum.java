package datastructures.week7.daywise.nov29th;

import org.junit.Assert;
import org.junit.Test;

public class MissingNum {
    /**
     * int[] nums = 1,2,5,3,5
     * given 1 to n numbers, find missing number.
     *
     */

    private int getMissingNum(int[] nums){
        int n = nums.length+1;
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] > nums[j]){
                    nums[i] = nums[i]+nums[j];
                    nums[j] = nums[i]-nums[j];
                    nums[i] = nums[i]-nums[j];
                }
            }
        }

        for(int i = 1; i < n; i++){
           if(nums[i-1] != i) return i;
        }
        return -1;
    }

    @Test
    public void test(){
        int[] nums = {1,2,3,5};
        Assert.assertEquals(4, getMissingNumBySumOfNaturalNums(nums));
    }


    private int getMissingNumBySumOfNaturalNums(int[] nums){
        int n = nums.length+1;
        int nSum = (n*(n+1))/2;

        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }

        return nSum-sum;
    }
}
