package datastructures.week3.daywise.assignments.nov2nd;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicateii {
    /**
     * Given an integer array nums and an integer k,
     * return true if there are two distinct indices i and j in the array
     * such that nums[i] == nums[j] and abs(i - j) <= k.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,3,1], k = 3
     * Output: true
     * Example 2:
     *
     * Input: nums = [1,0,1,1], k = 1
     * Output: true
     * Example 3:
     *
     * Input: nums = [1,2,3,1,2,3], k = 2
     * Output: false
     */

    /**
     * sliding window : HashMap
     * - check if k > 0, else return false
     *
     * - initialize map to hold elt and its index as key value pair.
     *
     * - iterate through nums starting from 0 to nums.length
     *
     *      - check if map contains elt at indx and indx - map.get(nums[i]) <= k, if yes return true.
     *
     *      - keep adding elts into map.
     *
     *  - finally return false.
     */

    private boolean containsDupiiHashMap(int[] nums, int k){
        if(k <= 0) return false;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]) && Math.abs(i - map.get(nums[i])) <= k) return true;
            map.put(nums[i], i);
        }

        return false;
    }



    /**
     * sliding window approach : HashSet
     *
     *  - check if k > 0, else return false
     *
     *  - initialize a hashset to hold elts for every i to k window.
     *
     *  - take a window of size i = 0 to k and i < nums.length to add elt into set and also, before adding elt, check if set already having matching elt, if yes return true.
     *
     *  - in another loop, starting from i = k and i < nums.length check if elt alreay presnet in set, if yes retrun true.
     *
     *  - otherwise add nums[i] elt into set and remove nums[i-k] elt to keep moving forward.
     *
     *  - finally, if none of the above conditions satisfied, return false.
     */

    private boolean containsDuplicateSWHashSet(int[] nums, int k){

        if (k <= 0) return false;

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < k && i < nums.length; i++){  //o[k]
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
        }

        for(int i = k; i < nums.length; i++){  //on]
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
            set.remove(nums[i-k]);
        }

        return false;
    }






    /**
     * - iterate through nums starting from 0 to length
     *
     * - check if nums[i-k] or nums[i+k] exists and check if nums[i] == nums[i-k] or nums[i+1]
     *
     *      - if yes, return true
     *
     *  - finally return false
     *
     */


    private boolean isNumsContainsDuplicates(int[] nums, int k) {

        for (int i = 0; i < nums.length - 1; i++) { //o[n]
            for (int j = i+1; j <= i+k && j < nums.length; j++) { //o[m\
                if (Math.abs((j - i)) <= k && nums[j] == nums[i]) return true;
            }
        }
        return false;
        //on*m]

    }




    @Test
    public void test(){
        int[] nums ={99,99};
        int k = 2;
        Assert.assertTrue(containsDuplicateSWHashSet(nums, k));
    }


    @Test
    public void tes2t(){
        int[] nums ={1,2,3,1,2,3};
        int k = 2;
        Assert.assertFalse(containsDupiiHashMap(nums, k));
    }

}
