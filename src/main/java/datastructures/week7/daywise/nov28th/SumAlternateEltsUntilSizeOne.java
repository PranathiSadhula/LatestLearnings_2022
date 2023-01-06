package datastructures.week7.daywise.nov28th;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumAlternateEltsUntilSizeOne {

    @Test
    public void test(){
        int[] nums = {1,2,3,4,5};//1+3+5 = 9 //2,4 ==> 2
        Assert.assertEquals(11, sum(nums));
    }

    private int sum(int[] nums){
        ArrayList<Integer> list =  new ArrayList<>();
        int result = 0;
        for(int j = 0; j < nums.length;j++){
            result += nums[j++];
        }
        list = new ArrayList<>();

        for(int i = 1; i < nums.length; i++){
           list.add(nums[i++]);
        }

        for(int j = 0; j < list.size();j++){
            result += list.get(j++);
        }


        return result;

    }
}
