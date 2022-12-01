package datastructures.week7.revise.arrayprobs;

import org.junit.Assert;
import org.junit.Test;

public class TwoSum {
    /**
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
     */

    private int[] getIndicesOfEltsSumToTarget(int[] nums, int target){
        if(nums.length < 2) throw new RuntimeException("invalid array");
        if(nums.length == 2 && nums[0]+nums[1] == target) return new int[]{0,1};
        else if(nums.length == 2 && nums[0]+nums[1] != target) throw new RuntimeException("Solution either does not exist or is not unique");

        for(int start = 0; start < nums.length; start++){
            for(int end = start+1; end < nums.length; end++){
                if(nums[start]+ nums[end] == target) return new int[]{start, end};
               }
        }
        throw new RuntimeException("Solution either does not exist or is not unique");

    }



    @Test
    public void test(){
        int[] nums = {3,2,3};
        int target = 6;
        Assert.assertArrayEquals(new int[] {0,2}, getIndicesOfEltsSumToTarget(nums, target));
    }
}
