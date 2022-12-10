package datastructures.week9.day1.sorting;

import org.junit.Assert;
import org.junit.Test;

public class InsertionSort {
    /**
     * combination for both bubble and select sort
     * <p>
     * compare adj values.
     * if(value at i < j)
     * then swap values at i and j
     * and find correct postion for value at j in left subArray.
     */

    private int[] insertionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) { //o[n]
            if (nums[i] > nums[i + 1]) {
                int temp = nums[i + 1];
                nums[i + 1] = nums[i];
                nums[i] = temp;
                for (int j = 0; j < i; j++) { //o[m]
                    if (nums[j] > nums[i]) {
                        temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }
                }
            }

        }
        return nums;
    }


    @Test
    public void test5(){
        int[] nums = {3,-2,6,7,-5};
        Assert.assertArrayEquals(new int[]{-5,-2,3,6,7}, insertionSort(nums));
      //  Assert.assertArrayEquals(new int[]{7,6,3,-2,-5}, selectinsertionSortDes(nums));

    }

    @Test
    public void test(){
        int[] nums = {1,0,3,6,8,5,4,2};
        Assert.assertArrayEquals(new int[]{0,1,2,3,4,5,6,8}, insertionSort(nums));
       // Assert.assertArrayEquals(new int[]{8,6,5,4,3,2,1,0}, insertionSortDes(nums));
    }
    @Test
    public void test1(){
        int[] nums = {1,0,0,0};
        Assert.assertArrayEquals(new int[]{0,0,0,1}, insertionSort(nums));
     //   Assert.assertArrayEquals(new int[]{1,0,0,0}, insertionSortDes(nums));
    }
    @Test
    public void test3(){
        int[] nums = {8,8,7,6,7,5};
        Assert.assertArrayEquals(new int[]{5,6,7,7,8,8}, insertionSort(nums));
     //   Assert.assertArrayEquals(new int[]{8,8,7,7,6,5}, insertionSortDes(nums));
    }

    @Test
    public void test4(){
        int[] nums = {-8,8,7,-6,-7,-5};
        Assert.assertArrayEquals(new int[]{-8,-7,-6,-5,7,8}, insertionSort(nums));
     //   Assert.assertArrayEquals(new int[]{8,7,-5,-6,-7,-8}, insertionSortDes(nums));
    }
}
