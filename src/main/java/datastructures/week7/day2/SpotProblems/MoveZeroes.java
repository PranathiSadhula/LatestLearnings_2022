package datastructures.week7.day2.SpotProblems;

import org.junit.Test;

import java.util.Arrays;

public class MoveZeroes {

    private int[] moveZeroes(int[] nums){
        int start = 0;
        int end = nums.length-1;
        while(start < end){ // 1,5 // 0,5 ==> 5,0
            if(nums[start] == 0){
                if(nums[end] != 0){
                    nums[start] = nums[end];
                    nums[end] = 0;
                    start++;
                    end--;
                }

            }
            else{
                start++;
            }
        }
        return nums;
    }

    @Test
    public void test(){
        int[] nums = {1,2,0,3,5,0,4};
        System.out.println(Arrays.toString(moveZeroes(nums)));
    }
}
