package datastructures.week6.daywise.nov25th;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class CountAllSubArraysSumDivisibleByK {
    /**
     * int[] nums={4,5,0,-2,-3,1};
     *         int k=5;
     * count number of sub arrays whose sum is divisible by k
     */
    private int countAllSubArraysSumDivisibleByKRemTheorm(int[] nums, int k){
        int sum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int num : nums){
            sum += num;
            int rem = sum % k;
            if(map.containsKey(rem)) count += map.get(rem);

            map.put(rem, map.getOrDefault(rem, 0)+1);

        }

        return count;
    }
    private int countAllSubArraysSumDivisibleByK(int[] nums, int k){

        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
       for(int i = 0; i < nums.length; i++){
           int sum = nums[i];
           if(sum % k == 0) count++;
           for(int j = i+1; j < nums.length; j++){

                sum += nums[j];
               if(sum % k == 0) count++;
           }
       }

        return count;
    }

    /**
     * 4+5+0+-2+-3+1 = 5
     * 5
     * 5,0
     * 0
     *5,0 -2,-3
     * 0,-2,-3
     * -2,-3
     */

    @Test
    public void test(){
        int[] nums = {4,5,0,-2,-3,1};
        int k = 5;
        Assert.assertEquals(7, countAllSubArraysSumDivisibleByKRemTheorm(nums,k));
    }
}
