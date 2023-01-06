package datastructures.week11.codeathon;

import org.junit.Assert;
import org.junit.Test;

public class ContainerWithMostWater {
    /**
     * https://leetcode.com/problems/container-with-most-water/description/
     *
     * - check if given array size < 2. if yes, return error msg.
     * - initialize area = Integer.MinValue.
     * - start 2 pointers start = 0; end = array.length.
     * - check if ht at index start >= ht at end
     * - if yes, hold onto maxArea btw area and calucated area(ht[start] *(end-start))
     * - else hold onto maxArea btw area and calucated area(ht[end] *(end-start))
     */

    private int maxArea(int[] heights){
        int maxArea = Integer.MIN_VALUE;
        int start = 0;
        int end = heights.length-1;
        while (start < end){
            if(heights[start] >= heights[end]){
                int localArea = (heights[end] * (end-start));
                maxArea = Math.max(maxArea, localArea);
                start++;
            }
            else{
                int localArea =  (heights[start] * (end-start));
                maxArea = Math.max(maxArea,localArea);
                end--;
            }
        }
        return maxArea;
    }

    @Test
    public void test(){
        int[] heights = {1,8,6,2,5,4,8,3,7};
        Assert.assertEquals(49, maxArea(heights));
    }
}
