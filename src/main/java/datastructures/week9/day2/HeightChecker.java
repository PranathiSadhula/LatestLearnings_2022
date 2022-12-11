package datastructures.week9.day2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class HeightChecker {
    /**
     * https://leetcode.com/problems/height-checker/
     */

    @Test
    public void test(){
        int[] heights = {1,1,4,2,1,3};
        Assert.assertEquals(2, heightChecker(heights));
    }

    @Test
    public void test1(){

        int[] heights = { 5,1,2,3,4};
        Assert.assertEquals(2, heightChecker(heights));
    }
    /**
     * - check if given array of heights length == 1. if yes return 0.
     * - sort the given array using merge sort and assign to new int[] arr
     * - then compare input arr and new arr to check input[i] != out[i].
     * - if yes return i.
     * 
     */
    private int heightChecker(int[] heights){
        int[] heightsBefore = heights.clone();
        mergeSort(heights);  //o[nlogn]
        int count = 0;
        for(int i = 0; i < heights.length; i++){ //o[n]
            if(heightsBefore[i] != heights[i]){
                count++;
            }
        }
        //o[nlogn]
        return  count;
    }
    
    private void mergeSort(int[] heights){
       recurCallSortAndMerge(heights, 0, heights.length-1);
    }

    private int[] recurCallSortAndMerge(int[] heights, int start, int end) {
        if(start < end)
        {
            int mid = (start + end) / 2;
            recurCallSortAndMerge(heights, start, mid);
            recurCallSortAndMerge(heights, mid + 1, end);
            sortAndMergeArrays(heights,start, mid, end );
        }
        return heights;
    }

    private void sortAndMergeArrays(int[] heights, int start, int mid, int end) {
        int[] temp = new int[end-start+1];
        int leftIndex = start;
        int rightIndex = mid+1;
        int tempIndx = 0;
        while(leftIndex <= mid && rightIndex <= end){
            if(heights[leftIndex] < heights[rightIndex]){
                temp[tempIndx++] = heights[leftIndex++];
            }
            else{
                temp[tempIndx++] = heights[rightIndex++];
            }
        }

        while(leftIndex <= mid){
            temp[tempIndx++] = heights[leftIndex++];
        }

        while(rightIndex <= end){
            temp[tempIndx++] = heights[rightIndex++];
        }

        for(int i = start; i <= end; i++){
            heights[i] = temp[i-start];
        }
    }


}
