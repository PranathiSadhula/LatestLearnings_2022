package datastructures.week7.daywise.nov29th;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MergeArrays {
    /**
     * given nums1 =[1,2,3,0,0,0] m =3
     * nums2 = [2,5,6] n = 3
     * int[] output = [1,2,2,3,5,6]
     */

    /**
     * Using arrays copy of.
     * - copy nums2 into nums1 starting from m.
     * - now, sort the new modified nums1.
     */

    private int[] mergeArrays(int[] nums1, int m, int[] nums2, int n){

        int index = 0;
        for(int i = m; i < nums1.length; i++){
            nums1[i] = nums2[index++];
        }

        for(int i = 0; i < nums1.length; i++){
            for(int j = i+1; j < nums1.length; j++){
                if(nums1[i] > nums1[j])
                {
                    nums1[i] = nums1[i] + nums1[j];
                    nums1[j] = nums1[i] - nums1[j];
                    nums1[i] = nums1[i] - nums1[j];
                }
            }
        }



        return nums1;
    }

    @Test
    public void test(){
        int[] nums1 = {1,2,3,0,0,0};
        int m =3;
        int[] nums2 = {2,5,6};
        int n = 3;
        Assert.assertArrayEquals(new int[]{1,2,2,3,5,6}, mergeSortedArrays2Pointer(nums1,m,nums2,n));
    }


    private int[] mergeSortedArrays2Pointer(int[] nums1, int m, int[] nums2, int n){
        int end = m+n-1;//nums1.length-1;
        m--; n--;
        while(m >= 0 && n >= 0){
            if(nums1[m] > nums2[n]) nums1[end--] = nums1[m--];
            else nums1[end--] = nums2[n--];
        }
        while(m >= 0)
            nums1[end--] = nums1[m--];
        while(n >= 0)
            nums1[end--] = nums2[n--];
        return nums1;
    }




}
