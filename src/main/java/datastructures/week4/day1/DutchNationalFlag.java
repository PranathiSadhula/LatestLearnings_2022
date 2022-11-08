package datastructures.week4.day1;

import org.junit.Test;

import java.util.Arrays;

public class DutchNationalFlag {
    /**
     * You have an unsorted array of integers and a function
     * string getCategory(integer), which deterministically returns 1 of three possible strings: "low", "medium", or "high", depending on the input integer.
     * You need to output an array with all the "low" numbers at the bottom, all the "medium" numbers in the middle, and all the "high" numbers at the top.
     * This is basically a partial sort. Within each category, the order of the numbers does not matter.
     *
     * For example, you might be give the array [5,7,2,9,1,14,12,10,5,3].
     * For input integers 1 - 3, getCategory(integer) returns "low", for 4 - 10 it returns "medium," and for 11 - 15 it returns "high".
     *
     * You could output an array (or modify the given array) that looks like this: [3,1,2,5,5,9,7,10,14,12]
     */

/*

    private void sortrRangeByDutchFlag(int[] nums){
        int lowIndex = 0;
        int middleIndex = 0;
        int highIndex = nums.length-1;

        int[] lowRange = {1,2,3};
        int[] highRange = {11,12,13,14,15};
        int[] midrange = {4,5,6,7,8,9,10};

        while(middleIndex < highIndex){
            if(nums[middleIndex] >= lowValue && nums[middleIndex]  < midValue)
            {

            }
            else if(nums[middleIndex] <= highValue && nums[middleIndex]  > midValue)
            {

            }
            else


        }

        System.out.println(Arrays.toString(nums));
    }
*/

    private void sortByDutchFlag(int[] nums){
        int lowIndex = 0;
        int middleIndex = 0;
        int highIndex = nums.length-1;

        int lowValue = nums[0];
        int highValue = nums[0];
        int midValue = nums.length/2;

        for(int i = 0; i < nums.length; i++){
            lowValue = Math.min(lowValue, nums[i]);
            highValue = Math.max(highValue, nums[i]);
        }

        while(middleIndex < highIndex){
            if(nums[middleIndex] >= lowValue && nums[middleIndex]  < midValue)
            {
                int temp = nums[lowIndex];
                nums[lowIndex] = nums[middleIndex];
                nums[middleIndex] = temp;
                middleIndex++;
                lowIndex++;
            }
            else if(nums[middleIndex] <= highValue && nums[middleIndex]  > midValue)
            {
                int temp = nums[highIndex];
                nums[highIndex] = nums[middleIndex];
                nums[middleIndex] = temp;
                middleIndex++;
                highIndex--;
            }
            else
                middleIndex++;

        }

        System.out.println(Arrays.toString(nums));
    }


    @Test
    public void testDF(){
        int[] nums = {5,7,2,9,1,14,12,10,5,3};
        System.out.println(Arrays.toString(nums));
        sortByDutchFlag(nums);
    }



}
