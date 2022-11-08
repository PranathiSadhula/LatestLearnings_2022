package datastructures.week4.day2;

import org.junit.Test;

import java.util.Arrays;

public class DuplicateZeroes {
    /**
     * Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.
     *
     * Note that elements beyond the length of the original array are not written. Do the above modifications to the input array in place and do not return anything.
     *
     *
     *
     * Example 1:
     *
     * Input: arr = [1,0,2,3,0,4,5,0]
     * Output: [1,0,0,2,3,0,0,4]
     * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
     * Example 2:
     *
     * Input: arr = [1,2,3]
     * Output: [1,2,3]
     * Explanation: After calling your function, the input array is modified to: [1,2,3]
     *
     *Constraints:
     *
     * 1 <= arr.length <= 104
     * 0 <= arr[i] <= 9
     */


    /**
     * - find no.of zeroes present in given array.
     * - create an array output with length nums.length+zeroesCount
     * - iterate through nums to find if nums[i] == 0
     * - if yes, keep adding 0 in i and i+1 index
     * - else, keep add elt in i.
     * - finally return output with length from 0 to input.length
     */

    private void duplicateZeroes(int[] nums){

        int[] output = new int[nums.length];
        int inIndx = 0;
        for(int i  = 0; i < output.length; i++){
            if(nums[inIndx] == 0){
                output[i] = nums[inIndx];
                output[i++] = 0;
            }
            else{
                output[i] = nums[inIndx];
            }
            inIndx++;
        }
        System.out.println(Arrays.toString(output));
    }

    private void duplicateZeroesInPlace(int[] nums){

        for(int i  = 0; i < nums.length- 1; i++){
          if(nums[i] == 0){
              for(int j = nums.length- 2; j >= i; j--){
                 nums[j+1] = nums[j];
              }i++;
          }
        }
    }

    @Test
    public void test(){
        int[] nums ={1,0,2,3,0,4,5,0};
        duplicateZeroesInPlace(nums);
    }
}
