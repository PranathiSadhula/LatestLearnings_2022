package datastructures.week8.day2;

import org.junit.Assert;
import org.junit.Test;

public class KthMissingPosNum {
    /**
     * Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
     *
     * Return the kth positive integer that is missing from this array.
     *
     *
     *
     * Example 1:
     *
     * Input: arr = [2,3,4,7,11], k = 5
     * Output: 9
     * Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
     * Example 2:
     *
     * Input: arr = [1,2,3,4], k = 2
     * Output: 6
     * Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
     *
     *
     * Constraints:
     *
     * 1 <= arr.length <= 1000
     * 1 <= arr[i] <= 1000
     * 1 <= k <= 1000
     * arr[i] < arr[j] for 1 <= i < j <= arr.length
     */

    /**
     * Binary search approach
     * - initialize an array with size k - outArray.
     * - initialize low, high and mid to search thorugh given array.
     * - iterate through given array until outIndex reaches k.
     * - keep adding elt missing at low to outArray.
     * - finally return outAray[k] as output.
     */

    private int getKthMissPosNum(int[] nums, int k){
        int[] out = new int[k];
        int start = 0;
        int outIndex = 0;
        for(int i = 1; i <= 1000;i++ ){
            if(start < i){
                if(nums[start++] != i){
                    out[outIndex++] = i;
                }
            }
            else{
                i++;
            }
            if(outIndex == k) return out[k-1];
        }
        return -1;
    }
    private int getKthMissingPositveNum(int[] nums, int k){
        int[] out = new int[k];
        int start = 0;
        int outIndex = 0;
        int numsToIterate = 1;//nums.length + k;
       // while(numsToIterate < nums.length + k){
         while (outIndex < out.length){
            if(start < nums.length){
                if(nums[start] != numsToIterate) {
                    out[outIndex++] = numsToIterate++;
                }
                else {
                    start++;
                    numsToIterate++;
                }
            }
            else{
                out[outIndex++] = numsToIterate++;
            }
           // numsToIterate++;

        }
        return out[k-1];
    }


    @Test
    public void test(){
        int[] nums = {1,2,3,4};
        int k = 2;
        Assert.assertEquals(6, getKthMissingPositveNum(nums,k));
    }

    @Test
    public void test1(){
        int[] nums = {2,3,4,7,11};
        int k = 5;
        Assert.assertEquals(9, getKthMissingPositveNum(nums,k));
    }
}
