package datastructures.week5.dayWISE;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SpotProb_ConvertNumToDigitsArray {
    /**
     * convert number into array n=85, output[8,5]
     */

    /**
     * qustns asked :
     * - what if n is -ve num what should be returned
     *      ex : n = -45 -> possible outputs : [-4,5] or [4,-5]
     * - what if n is 0 what should be return
     *
     *
     */

    /**
     * Using String :
     * - check if given num is == 0, if yes return an exp saying invalid num.
     * - check if num < 0, if yes, assign int sign = -1.
     * - else sign = 1.
     * - now convert given int into a String using String.valueOf(num)
     * - initialize an int array with size == str.
     * - then iterate through each char in the str and add into array.
     * - finally return array.
     */

    /**
     * test data :
     * 1. n = 85 output = [8,5]
     * 2. n = -85 , output = [-8,5]
     * 3. n = 0, output = error msg / empty array.
     * 4. n = 100, output = [1,0,0]
     *
     */

    private Integer[] digitsArray(int num){
        if(num == 0) return new Integer[] {};
        int sign = 1;
        if(num < 0) sign = -1;
        num *= sign;
        String str = String.valueOf(num);
        Integer[] output = new Integer[str.length()];
        int index = 0;
        for(char c : str.toCharArray()){
            output[index++] = Integer.valueOf(c+"");
        }
        if(sign == -1) output[0] *= sign;
        return output;
    }

    /**
     * Using % 10
     * - check if given num is == 0, if yes return an exp saying invalid num.
     * - check if num < 0, if yes, assign int sign = -1.
     * - else sign = 1.
     * - initialize a list of Integer to return output.
     * - convert given num into digits usign % 10 and keep adding each digit into list.
     * - finally return array converted list.
     *
     */
    private Integer[] digitsArrayUsingMod(int num){
        if(num == 0) return new Integer[] {};
        int sign = 1;
        if(num < 0) sign = -1;
        List<Integer> output = new ArrayList<>();
        num *= sign ;

        while(num > 0){
            int digit = num % 10;
            num = num /10;
            output.add(digit);
         }
        if(sign == -1) output.set(0,sign* output.get(0));
        return output.toArray(new Integer[output.size()]);
    }

    @Test
    public void test(){
        int num = -85;
        Assert.assertArrayEquals(new Integer[]{-5,8}, digitsArrayUsingMod(num));
        Assert.assertArrayEquals(new Integer[]{-8,5}, digitsArray(num));
    }

    @Test
    public void test1(){
        int num = 0;
        Assert.assertArrayEquals(new Integer[]{}, digitsArrayUsingMod(num));
        Assert.assertArrayEquals(new Integer[]{}, digitsArray(num));
    }
}