package datastructures.week4.day2;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class RemoveDuplicates {
    /**
     * input = {1,2,3,4,1,2,3,2,1}
     * output = 4
     */

    /**
     * - initialize a list to hold non duplicate values.
     * - initialise a set to add elts.
     *      while adding into set, check if set contains elt at index, if yes, remove from list.
     *      else, add to list
     *
     *  finally return list
     * @param nums
     * @return
     */
    private void removeDuplicates(int[] nums){
        List<Integer> output = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(!set.contains(nums[i]) && !output.contains(nums[i])){
                set.add(nums[i]);
                output.add(nums[i]);
            }
            else {
                set.remove(nums[i]);
            }
        }
        System.out.println(set);
       // return output;
    }


    @Test
    public void test(){
        int[] nums = {1,2,3,4,1,2,3,2,1};
        removeDuplicates(nums);// Assert.assertEquals(Arrays.asList(4), removeDuplicates(nums));
    }

}
