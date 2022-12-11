package datastructures.week9.day1.sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class OptimizedMergeSort {
    /**
     * merge sort is optimized
     * - divide and conquer
     * time : o[nlongn]
     * 5 6 3 1 7 2 4
     */

    @Test
    public void test(){
        int[] nums = {5, 6 ,3, 1 ,7, 2, 4};
        mergeSort(nums);
        Assert.assertArrayEquals(new int[]{1,2,3,4,5,6,7}, nums);
    }
    private void mergeSort(int[] nums){

        recurCallSortAndMerge(nums, 0, nums.length-1);
    }
    /**
     * 1. find mid
     * 2. recursive call for start to mid
     * 3. recursive call for mid+1 to end
     * 4. merge arrays
     */

    private void recurCallSortAndMerge(int[] nums, int start, int end){
        if(start < end) {
            int mid = (start + end) / 2;
            recurCallSortAndMerge(nums, start, mid);
            recurCallSortAndMerge(nums, mid + 1, end);
            sortAndMergeArrays(nums,start, mid, end );
        }

    }

    private void sortAndMergeArrays(int[] nums, int start,int mid, int end){
        int[] temp = new int[end-start+1];
        int leftSubArrIndex = start;
        int rightSubArrIndex = mid+1;
        int tempIndex = 0;
        while(leftSubArrIndex <= mid && rightSubArrIndex <= end){
            if(nums[leftSubArrIndex] < nums[rightSubArrIndex]){
                temp[tempIndex++] = nums[leftSubArrIndex++];
            }
            else{
                temp[tempIndex++] = nums[rightSubArrIndex++];
            }
        }
        while(leftSubArrIndex <= mid ){
            temp[tempIndex++] = nums[leftSubArrIndex++];

        }
        while(rightSubArrIndex <= end ){
            temp[tempIndex++] = nums[rightSubArrIndex++];
        }

        for(int i = start; i <= end; i++){
            nums[i] = temp[i-start];
        }

    }
}
