package datastructures.week9.daywise.dec12;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ZigzagStrings {
    /**
     * https://leetcode.com/problems/zigzag-conversion/description/
     *
     */
    @Test
    public void test(){
        String s = "PRANATHI";
        int rows = 3;
        Assert.assertEquals("PARNTIAH",convertStrToZigZagStr(s, rows));
    }

    @Test
    public void test2(){
        String s = "PRANATHI";
        int rows = 4;
        Assert.assertEquals("PHRTIAAN",convertStrToZigZagStr(s, rows));
    }

    private String convertStrToZigZagStr(String s, int rows){
        String[] zipZagStr = new String[rows];
        char[] chars = s.toCharArray();
        int indx = 0;
        if(s.length() < rows || rows == 1)return s;

        while(indx < chars.length){
            for(int i = 0; i < rows && indx < chars.length; i++){
                if(zipZagStr[i] == null){
                    zipZagStr[i] = chars[indx++]+"";
                }
                else  zipZagStr[i] += chars[indx++]+"";
            }
            for(int i = rows-2; i >= 1 && indx < chars.length; i--){
                zipZagStr[i] += chars[indx++]+"";
            }

        }

        String output = "";
        for(String rowStr : zipZagStr){
            output += rowStr;
        }
        return output;
    }

    @Test
    public void test3(){
        String s = "A";
        int rows = 1;
        Assert.assertEquals("A", convertStrToZigZagStr(s, rows));
    }
}
