package datastructures.week2.daywise.assignments.oct24th;

import org.junit.Assert;
import org.junit.Test;

public class LongestPolindromSubStr {
    /**
     * Given a string s, return the longest palindromic substring in s.
     *
     * A string is called a palindrome string if the reverse of that string is the same as the original string.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "babad"
     * Output: "bab"
     * Explanation: "aba" is also a valid answer.
     * Example 2:
     *
     * Input: s = "cbbd"
     * Output: "bb"
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 1000
     * s consist of only digits and English letters.
     *
     */

    /**
     * - check if given string is null or empty, if yes return "".
     * - initialize 2 pointers : left = s.length/2; end = s.length/2
     * -
     *
     */
    @Test
    public void test(){
        String s = "bacad";
        Assert.assertEquals("aca", longestPolindrom(s));
    }

    @Test
    public void test1(){
        String s = "bacbd";
        Assert.assertEquals("c", longestPolindrom(s));
    }

    @Test
    public void test2(){
        String s = "babad";
        Assert.assertEquals("aba", longestPolindrom(s));
    }

    @Test
    public void test3(){
        String s = "babab";
        Assert.assertEquals("babab", longestPolindrom(s));
    }

    @Test
    public void test4(){
        String s = "cbba";
        Assert.assertEquals("bb", longestPolindrom(s));
    }
      private String longestPolindrom(String s){
        if(s == null || s.isEmpty() || s.length() == 0) return "";


        String res = "";
        for(int i = 0; i < s.length();i++){
            String len1 = polindrom(s, i, i);
            String len2 = polindrom(s, i, i+1);
            if(len1.length() < len2.length())
                len1 =len2;
            if(len1.length() > res.length()) res = len1;

        }
        return res;
    }

    private String polindrom(String s, int left, int right){

       for(; left >= 0 && right <s.length();left--, right++){
           if(s.charAt(left) != s.charAt(right)) break;
       }

        return s.substring(left+1, right);

    }



}
