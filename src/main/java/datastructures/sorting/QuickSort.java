package datastructures.sorting;

import org.junit.Assert;
import org.junit.Test;

public class QuickSort {
    /**
     * QuickSort is achieved based recursing.
     * - first we need a pivot elt which needs to be acted as a keyElt futher elts < keyELt and elts >keyElt are divided and sorted again.
     *
     * - we can consider elt at lastIndex as our keyElt and continue.
     * - the partition[elts > keyElt and elts < keyElt] of given array can be acheived in a recurrsion.
     * - and partitioned elts can further be swapped to sort accordingly.
     */


        private int[] quickSort(int[] nums){
            sortArrayByPartition(nums, 0, nums.length-1);
            return nums;
        }

    private void sortArrayByPartition(int[] nums, int lowIndx, int highIndx){
        int keyEltIndx =  findPivotEltIndx(nums,lowIndx, highIndx );
        sortArrayByPartition(nums,0, keyEltIndx );
        sortArrayByPartition(nums, keyEltIndx+1, highIndx );
    }



    private int findPivotEltIndx(int[] nums, int lowIndx, int highIndx) {
        int keyElt =  nums[highIndx];
        int keyEltIndx = highIndx;
        for(int j = lowIndx; j < highIndx; j++ ){
            if(nums[j] < keyElt){
                nums[j] = nums[j] + nums[j-1];
                nums[j-1] =  nums[j] - nums[j-1];
                nums[j] =  nums[j] - nums[j-1];
            }
        }
        nums[lowIndx] = nums[lowIndx] + nums[highIndx];
        nums[highIndx] = nums[lowIndx] - nums[highIndx];
        nums[lowIndx] = nums[lowIndx] - nums[highIndx];

        return lowIndx;
    }

    @Test
    public void test(){
        int[] nums={11,4,17, 18, 2,22,1,8};
        Assert.assertArrayEquals(new int[]{1,2,4,8,11,17,18,22}, quickSort(nums));
    }
}
