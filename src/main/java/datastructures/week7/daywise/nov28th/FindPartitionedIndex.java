package datastructures.week7.daywise.nov28th;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class FindPartitionedIndex {
    /**
     * Given an array you need to find the parition index where the left and right sum is equal.
     * arr[] = { 5,2 ,2 ,2,5}
     * 5+2 =7 , 2+5 = 7
     * if found = partionIndex
     * if not found = -1
     */

    private int findPartitionedIndex(int[] nums){

        int[] left = new int[nums.length];
        int sum = 0;
        for(int i = 0; i < left.length; i++){
            sum += nums[i];
            left[i] = sum;
        }
        int[] right = new int[nums.length];
        sum = 0;
        for(int i = left.length-1; i >= 0; i--){
            sum += nums[i];
            right[i] = sum;
        }

        for(int i = 0; i < nums.length; i++){
            if(left[i] == right[i]) return i;
        }
        return -1;
    }

    @Test
    public void test(){
        int[] nums = {2,1,-1};
        Assert.assertEquals(-1, findPartitionedIndex(nums));
    }

    private int pivotIndexByPrefixSum(int[] nums){
        int sum = 0;
        int curSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int num : nums){
            sum += num;
            curSum = num;
            map.put(sum, map.getOrDefault(sum, 0)+1);

        }

        return -1;
    }

}

