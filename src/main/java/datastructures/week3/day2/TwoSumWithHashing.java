package datastructures.week3.day2;

import java.util.HashMap;
import java.util.HashSet;

public class TwoSumWithHashing{
/*
	 * Given input array, find out sum of 2 elts summing up to match given target and return the indices of those elts
	 *

     *Examples to try out :
	 * int[] input = {1,3,2,5, 4, 0}; 
	 * 
	 * int target = 4   // 2 pairs I found : {0,1}, {4,5}
	 *
	 * int[] expectedIndices = {}; // return first found indices. here {0,1}
	 * 
	 * 
	 * 
	 * 
	 * int[] input = {1,3,2,5, 4, 0}; 
	 * 
	 * int target = 10   // 2 pairs I found : none
	 *
	 * int[] expectedIndices = {}; // return first found indices. here {}
	 * 
	 * 
	 * int[] input = {1,1,1}; 
	 * 
	 * int target = 1   // 2 pairs I found : none
	 *
	 * int[] expectedIndices = {}; // return first found indices. here {}
	 * 
	 * 
	 * int[] input = {1,1,1}; 
	 * 
	 * int target = 1   // 2 pairs I found : none
	 *
	 * int[] expectedIndices = {}; // return first found indices. here {}
     /



/* * 
	 * Two-Pointer Approach
	 * - create an output array with size 2.
	 * 
	 * - initialise 2 pointers : start = 0, end = array.length.
	 * 
	 * - sum up the elts at both pointers and check if sum matches with target.
	 * 
	 * - if matches, add start and end to output array.
	 * 
	 * -if doesnt matches, 
	 *    
	 *    - check if sum < target, move start
	 * 
	 *    - check if sum > target, move end
	 * 
	 */




     /**
        Hashmap approach :

        - create a hashMap with  i and nums[i] i as key value

        - iterate through nums and check if target - nums[i] present in hashMap

        - if yes return i, getValue.hashMap
     
      */

    
    private int[] returnIndicesOfEltsSummingUpTarget(int[] nums, int target){

        int[] output = new int[2];

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    /*    for(int i = 0; i < nums.length; i++){
            map.put( nums[i], i);
        }
    */
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                output[0] = map.get(target - nums[i]);
                output[1] = i;
            }
            else
                map.put(nums[i],i);
        }
        return output;

    }


    /**
        return nums instead of indices
        input = {2,4,5,3,7}, taget =9
        output = [2,7]
     */


      private int[] returnEltsSummingUpTarget(int[] nums, int target){

        int[] output = new int[2];

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    /*    for(int i = 0; i < nums.length; i++){
            map.put( nums[i], i);
        }
    */
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                output[0] = map.get(target - nums[i]);
                output[1] = i;
            }
            else
                map.put(nums[i],i);
        }
        return output;

    }

    private int[] returnEltsSummingUpTargetHashSet(int[] nums, int target){

        int[] output = new int[2];

        HashSet<Integer> set = new HashSet<Integer>();

    /*    for(int i = 0; i < nums.length; i++){
            map.put( nums[i], i);
        }
    */
        for(int i = 0; i < nums.length; i++){
            if(set.contains(target - nums[i])){
                output[0] = target - nums[i];
                output[1] = nums[i];
            }
            else
            set.add(nums[i]);
        }
        return output;

    }

}