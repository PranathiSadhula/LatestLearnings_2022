import org.junit.Assert;
import org.junit.Test;

public class Pranathi {

    /**
     * [15, 20, 28, 25, 11, 16]   //-ve.
     *
     * max =  28
     *
     * 15, 20, 28, 25, 11, 16
     *
     * curMax --> 15,20 --> 20.
     *
     * 20, 25 --> 25.
     *
     * 25, 11 --> 25.
     *
     * 25, 16 -> 25.
     *
     *
     *
     * -
     *
     *
     *
     *
     */

    private int maxVal(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(max < nums[i]){
                max = nums[i];
            }
        }
        return max;
    }


    private int getNthMaxValue(int[] nums, int n){
        int max = maxVal(nums);
        int secMax = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(secMax < nums[i] ){


            }
        }


        return max;
    }


    @Test
    public void test(){
        int[] nums = {15, 20, 28, 25, 11, 16};
        Assert.assertEquals(28, maxVal(nums));
    }
}
