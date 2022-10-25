package week3.daywise.assignments.oct25th;

import org.junit.Assert;
import org.junit.Test;

public class NoOfSubArraysProducingGivenK {
    /**
     * Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [10,5,2,6], k = 100
     * Output: 8
     * Explanation: The 8 subarrays that have product less than 100 are:
     * [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
     * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
     * Example 2:
     *
     * Input: nums = [1,2,3], k = 0
     * Output: 0
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 3 * 104
     * 1 <= nums[i] <= 1000
     * 0 <= k <= 106
     */

    /**approach
     *
     * - check if the length of nums is == 1
     *
     * - if yes check if nums[0] < k return 1 else return 0.
     *
     * - create a variable to hold no.of subArrays  'noOfSubArrays'
     *
     * - create currProduct to hold product of elts
     *
     * - iterate through nums starting i = 0 to nums.length
     *
     * - with inner iteration starting from j = i+1 to muns.length
     *
     * - keep adding product of each elt to currProduct.
     *
     * - check if currProduct is < given k.
     */

    private int getCountOfSubArrays(int[] nums, int target) {
        int noOfSubArrays = 0;
        if (nums.length == 1) {  //o[1]
            if (nums[0] < target) return 1;
            else return 0;
        }


        for (int i = 0; i < nums.length; i++) {  //o[n]
          int  prod = 1;
          prod *= nums[i];
            if(prod < target) noOfSubArrays++;
            else continue;
            for(int j = i+1; j < nums.length; j++){ //o[n]
                prod *= nums[j];
                if(prod < target) noOfSubArrays++;
                else break;
            }
        }

        return noOfSubArrays;  //o[n2]
    }




    @Test
    public void test(){
        int[] nums = {10,9,10,4,3,8,3,3,6,2,10,10,9,3};

        int target = 19;
        int output =  18;
        Assert.assertEquals(output, getCountOfSubArraysSW(nums, target));

    }

   // @Test
    public void test3() {
        int[] nums = {10,5,2,6};

        int target = 100;
        int output = 8;
        Assert.assertEquals(output, getCountOfSubArraysSW(nums, target));

    }
        // @Test
    public void test2(){
        int[] nums = {3,3,1,6,2};

        int target = 19;
        int output =  11;
        Assert.assertEquals(output, getCountOfSubArraysSW(nums, target));



    }


    /**
     * sliding window
     * - check if the length of nums is == 1
     *
     * - if yes check if nums[0] < k return 1 else return 0.
     *
     * - create a variable to hold no.of subArrays  'noOfSubArrays'
     *
     * - create currProduct to hold product of elts
     *
     * - initialize 2 pointers start = 0 and end = strt+1
     *
     * - keep multiplying nums[start] with currProd until end reaches nums.length
     *
     * - while multiplying check if currProd < k
     *
     * - if yes --> end++ and count++
     *
     * - else start++
     *
     * - when end reaches nums.length -> keep dividng currProd / nums[start++]
     */


    private int getCountOfSubArraysSW(int[] nums, int k) {

        if (nums.length == 1) {  //o[1]
            if (nums[0] < k) return 1;
            else return 0;
        }
        int noOfSubArrays = 0;
        long prod = 1;
        long locProd = nums[0];
        int start = 0;
        int end = 0;

        while (end < nums.length) prod *= nums[end++];  //o[n]

        int index = 0;
        while (start < nums.length - 1) {
            if (nums[start] < k) noOfSubArrays++;
            prod /= nums[start];
            if (prod < k) noOfSubArrays++;
            locProd *= nums[start + 1];
            if (locProd < k) noOfSubArrays++;
            else {
                locProd /= nums[index++];

            }
            start++;

        }
        return noOfSubArrays;
    }
}
