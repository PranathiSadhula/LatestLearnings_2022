package datastructures.week6.daywise.nov25th.prefixSum;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class CountAllSubArraysSumMatchingK {


    private int countAllSubArraysSumMatchingK(int[] nums, int k){
        int sum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int num : nums){
            sum += num;
            map.put(sum, map.getOrDefault(sum, 0)+1);
            if(map.containsKey(sum-k)) count += map.get(sum-k);
        }

        return count;
    }

    @Test
    public void test(){
        int[] nums = {1,1,1};
        int k = 2;
        Assert.assertEquals(2, countAllSubArraysSumMatchingK(nums,k));
    }
}
