package datastructures.week9.daywise.dec16;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class FirstOccuringDuplicate {
    /**
     * int=[1,2,3,4,4,5,6,6]
     * output = 4
     */

    @Test
    public void test(){
        int[] nums = {1,2,3,4,4,5,6,6};
        Assert.assertEquals(4, getFirstDuplicate(nums));
    }
    /**
     * int=[1,2,3,4,5,6]
     * output = -1
     */
    @Test
    public void test1(){
        int[] nums = {1,2,3,4,5,6};
        Assert.assertEquals(-1, getFirstDuplicate(nums));
    }
    /**
     * int=[1,1,1,1]
     * output = 1
     */
    @Test
    public void test2(){
        int[] nums = {1,1,1,1};
        Assert.assertEquals(1, getFirstDuplicate(nums));
    }

    /**
     * int=[1,1,2,2,3,3]
     * output = 1
     */
    @Test
    public void test3(){
        int[] nums = {1,1,2,2,3,3};
        Assert.assertEquals(1, getFirstDuplicate(nums));
    }

    /**
     * int=[1]
     * output = -1
     */
    @Test
    public void test4(){
        int[] nums = {1};
        Assert.assertEquals(-1, getFirstDuplicate(nums));
    }


    /**
     * hashing with hashset
     * - check if given array length < 2, if yes return -1.
     * - initialize a hashset set.
     * - iterate through each elt in given array
     *      - keep adding elt into set.
     *      - while adding keep a check if set.add returns false, if yes return elt.
     * - finally return -1.
     */

    private int getFirstDuplicate(int[] nums){
        if(nums.length < 2) return -1;
        HashSet<Integer> set = new HashSet<>();
        for(int elt : nums){
            if(!set.add(elt)) return elt;
        }
        return -1;
    }
}
