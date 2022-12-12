package datastructures.week9.day2;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FindTargetIndicesAfterSorting {
    /**
     * https://leetcode.com/problems/find-target-indices-after-sorting-array/
     */
    @Test
    public void test(){
        int[] nums = {0,0,0,0};
        int target = 0;
        int[] expected = {0,1,2,3};
    }

    @Test
    public void test1(){
        int[] nums = {0,0,0,0};
        int target = 1;
        int[] expected = {};
    }

    private List<Integer> targetIndices(int[] nums, int target){
        List<Integer> out = new ArrayList<>();
        sortArray(nums);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target) out.add(i);
        }
        return out;
    }

    private void sortArray(int[] nums){
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] > nums[i+1]){
                int temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;
                for(int j = 0; j < i; j++){
                    if(nums[j] > nums[i]){
                        temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }
                }
            }
        }
    }
}
