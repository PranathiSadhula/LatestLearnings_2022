package datastructures.dailypractice.jan11;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Sum1ToGivenDigits {

    private int[] returnNumsAddedTo1(int[] nums) {

        if (nums.length == 1) {
            if (nums[0] < 9) return new int[]{nums[0] + 1};
            else return new int[]{1, 0};
        }

        int[] output = new int[nums.length + 1];
        int index = output.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) { //o[n] //9,9,9
            if (nums[i] < 9) output[index--] = nums[i] + 1; //
            else {
                output[index--] = 0;
                nums[i - 1] += 1;
            }
        }

        // if(output[0] == 0){ return Arrays.copyOfRange(output[1], output[output.length-1]); //o[m]
        //else return output;

        // o[n]+o[m] = o[n+m] o[2n] =o[n]
        //space = o[n]
        return null;

    }


    private int[] returnNumsAddedTo1UsingStr(int[] nums) {

       String temp = new String();
       for(int i = 0; i < nums.length;i++){
           temp += nums[i]+"";
       }

       int out = Integer.parseInt(temp)+1;

       String outStr = String.valueOf(out);

        int[] output = new int[outStr.length()];

        for(int i = 0; i < outStr.length();i++){
            output[i] = Integer.parseInt(outStr.charAt(i)+"");
        }


        return output;

    }



    private int[] returnNumsAddedTo1UsingModule(int[] nums) {

        String temp = new String();
        for(int i = 0; i < nums.length;i++){
            temp += nums[i]+"";
        }

        int out = Integer.parseInt(temp)+1;

        String outStr = String.valueOf(out);

        int[] output = new int[outStr.length()];
        int index = output.length-1;
        while(out > 0){
            int curDigit = out % 10; // 235%10=5 // 23%10 = 3 // 2%10 =2
            out /= 10; //235/10= 23 // 23/10 =2  2/10 = 0
            output[index--] = curDigit;
        }


        return output;

    }

    @Test
    public void test(){
        int[] nums = {2,3,4};
        Assert.assertArrayEquals(new int[]{2,3,5}, returnNumsAddedTo1UsingModule(nums));
    }


    @Test
    public void test1(){
        int[] nums = {2,3,4,9};
        Assert.assertArrayEquals(new int[]{2,3,5,0}, returnNumsAddedTo1UsingStr(nums));
    }


    @Test
    public void test2(){
        int[] nums = {9};
        Assert.assertArrayEquals(new int[]{1,0}, returnNumsAddedTo1UsingStr(nums));
    }


    @Test
    public void test3(){
        int[] nums = {9,9};
        Assert.assertArrayEquals(new int[]{1,0,0}, returnNumsAddedTo1UsingStr(nums));
    }

}