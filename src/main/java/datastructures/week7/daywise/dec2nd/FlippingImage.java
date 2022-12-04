package datastructures.week7.daywise.dec2nd;

import org.junit.Assert;
import org.junit.Test;

public class FlippingImage {
    /**
     * Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.
     *
     * To flip an image horizontally means that each row of the image is reversed.
     *
     * For example, flipping [1,1,0] horizontally results in [0,1,1].
     * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
     *
     * For example, inverting [0,1,1] results in [1,0,0].
     *
     *
     * Example 1:
     *
     * Input: image = [[1,1,0],[1,0,1],[0,0,0]]
     * Output: [[1,0,0],[0,1,0],[1,1,1]]
     * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
     * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
     * Example 2:
     *
     * Input: image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
     * Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
     * Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
     * Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
     *
     *
     * Constraints:
     *
     * n == image.length
     * n == image[i].length
     * 1 <= n <= 20
     * images[i][j] is either 0 or 1.
     */

    /**
     * - iterate through each image(int []) in given images(int[][]).
     * - reverse each array.
     *      - start 2 pointers : start =0; end = image.length.
     *      - swap elts at start and end.
     *  - now, flip 0 to 1 and 1 to 0.
     */

    private int[][] flipAndInvertImage(int[][] images){
        int length = images.length;

        for(int[] eachImage : images){
            reversArray(eachImage);
            for(int i = 0; i < eachImage.length;i++){
                if(eachImage[i] == 0) eachImage[i]  = 1;
                else if(eachImage[i]  == 1) eachImage[i]  = 0;

            }
        }
        return  images;
    }

    private void reversArray(int[] nums){
        int start = 0;
        int end = nums.length-1;

        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }

    @Test
    public void test(){
      int[][] images = {{1,1,0},{1,0,1},{0,0,0}};
        Assert.assertArrayEquals(new int[][] {{1,0,0},{0,1,0},{1,1,1}},flipAndInvertImage(images));
    }
}
