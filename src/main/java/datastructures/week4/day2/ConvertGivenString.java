package datastructures.week4.day2;

import org.junit.Assert;
import org.junit.Test;

public class ConvertGivenString {
    /**
     * input = ZAAVVDDSSSG
     * output = 1Z2A2V2D3S1G
     */

    /**
     * - create a string output
     * - start 2 pointers start = 0. end = 0.
     * - iterate through given str until start < end.
     * - initialize count = 0.
     * - check if charAt[start] == charAt[end]
     *      count++ , start++
     * - else, end++
     *
     */

    private String decodeString(String s){
        String output = "";
        int start = 0;
        int end = 0;
        int count = 0;
        while(end < s.length()) {

                if (s.charAt(start) == s.charAt(end)) {
                    end++;
                    count++;
                } else {
                    output += count + "" + s.charAt(start) + "";
                    start = /*end;*/start + count;
                    count = 0;
                }


        }
        output += count + "" + s.charAt(start) + "";

        return output;
    }

    @Test
    public void test(){
        String s = "ZZAAVVDDSSSGGH";
        Assert.assertEquals("2Z2A2V2D3S2G1H", decodeString(s));
    }
}
