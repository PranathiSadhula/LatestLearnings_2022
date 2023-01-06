package datastructures.week9.daywise.dec12;

import org.junit.Test;

public class ShortestPolindrom {
    /**
     * https://leetcode.com/problems/shortest-palindrome/description/
     */

    @Test
    public void test(){
        String s = "aacecaaa";
        String expected = "aaacecaaa";

    }

    @Test
    public void test1(){
        String s = "aaceca";
        String expected = "acecaaceca";
    }

    @Test
    public void test2(){
        String s = "a";
        String expected = "a";
    }

    /**
     * - check if given String is of length 1, if yes return s.
     * - check if given str is polindeom, if yes return s.
     * - initialize a string output with given input str.
     *          String output = s;
     * - iterate input str from length-1 to 0
     * - keep appending s.charAt[i] infront of output and check if newly formed output is polindrom.
     * - if yes, return output, else keep continue with above steps.
     */


    private String getShortestPolindrom(String s){
        if(s.length() == 1 || isPolindrome(s)) return s;
        StringBuffer output = new StringBuffer(s);
        for(int i = s.length()-1; i>= 0; i--){
            if(isPolindrome(output.insert(0, s.charAt(i)).toString())){
                return output.toString();
            }
        }
        return output.toString();
    }


    private boolean isPolindrome(String s){
        int start = 0;
        int end =  s.length()-1;
        while (start < end){
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
