package datastructures.week7.day2.SpotProblems;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class YubiInterviewPrb {
    /**
     * String s = "aaabbccaad";
     *         String out = "a3b2c2a2d1";
     */


    private String convertStrMap(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        String output = "";
        int i = 0;
        for(; i < chars.length;i++){
            if(chars[i] == chars[i+1]){
                map.put(chars[i], map.getOrDefault(chars[i],1)+1);
            }
            else{
                output += chars[i]+""+ map.get(chars[i]);
                map.clear();
            }
           }
        if(i < chars.length){
            map.put(chars[i], map.getOrDefault(chars[i],0)+1);
        }
        output += chars[i]+""+ map.get(chars[i]);
        return output;
    }

    @Test
    public void test(){
        String s = "aaabbccaadd";
        String out = "a3b2c2a2d2";
        Assert.assertEquals(out, convertStrMap(s));
    }


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
}
