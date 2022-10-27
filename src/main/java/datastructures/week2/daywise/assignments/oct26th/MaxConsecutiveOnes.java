package datastructures.week2.daywise.assignments.oct26th;

import org.junit.Assert;
import org.junit.Test;

public class MaxConsecutiveOnes {
    /**
     * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
     * Output: 6
     * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
     * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
     * Example 2:
     *
     * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
     * Output: 10
     * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
     * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 105
     * nums[i] is either 0 or 1.
     * 0 <= k <= nums.length
     */

   // @Test
    public void test1(){
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}; //1,1,0,0,1,1,1,0,1,1
        int k = 3;                                            //1,1,0,0,0,1,1,1,1
        int output = 10;
        Assert.assertEquals(output, getMaxConsecutiveOnes(nums,k));
    }

    @Test
    public void test2(){
        int[] nums = {0,0,1,1,1,1,0,1,1,1,1,1,1};
        int k = 0;
        int output = 6;
        Assert.assertEquals(output, getMaxConsOnesLength(nums,k));

    }

    @Test
    public void test4(){
        int[] nums = {0,0,1,1,1,0,0};
        int k = 0;
        int output = 3;
        Assert.assertEquals(output, getMaxConsOnesLength(nums,k));

    }

   // @Test
    public void edge(){
        int[] nums = {0,0,0,1,0,0};
        int k = 2;

    }

    /**
     * pseudo code
     *
     * - initialize maxLength
     *
     * - iterate through nums starting i from 0 to nums.length
     *
     * - in another loop start j from 0 until nums.length
     *
     * - check if nums[j] == 0 then k--
     *
     * - maxLength should hold value as j-i+1
     *
     * - if k < 0 break inner loop.
     *
     * - in outer loop, check if nums[i] == 1 ==> k++
     *

     *
     */
    private int getMaxConsOnesLength(int[] nums, int k) {
        int maxLength = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            int temp = k;

           for(int j = i; j < nums.length; j++){
               if(nums[j] == 0 && temp > 0) temp--;

               if(temp < 0) break;
               maxLength =  Math.max(maxLength, j-i+1);
           }
          // maxLength =  Math.max(maxLength, j-i+1);
          // if(nums[i] == 1) temp++;// = k;
        }

        return maxLength;
    }




    private int getMaxConsecutiveOnes(int[] nums, int k){
        int maxLength =  Integer.MIN_VALUE;


        int i = 0;
        int j = 0;
        for(;j < nums.length;i++){ //0,1,1,0,0,1,1,1
            int count = 0;
            j = i;
            while(count < k ){
                if(nums[j++] == 0) count++;
                while(count == k && j != nums.length && nums[j] != 0) j++;

            }
            maxLength = Math.max(maxLength, j-i);

           // i = j - 1;

        }

        return maxLength;
    }
}
