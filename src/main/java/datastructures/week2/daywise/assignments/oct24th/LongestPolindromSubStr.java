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
        String s = "babad";
        Assert.assertEquals("bab", longestPolindrom(s));
    }


    private String longestPolindrom(String s){
        if(s == null || s.isEmpty() || s.length() == 0) return "";
        int left = s.length()/2;
        int right = s.length()/2;
        String res = "";
        while(left >= 0 && right < s.length()){
            int len1 = polindrom(s, left, right);
            int len2 = polindrom(s, left, right+1);
            if(len1 < len2) res = s.substring(left, right);
            else res = s.substring(left,right+1);
            left--;
            right++;
        }
        return res;
    }

    private int polindrom(String s, int left, int right){

        while(left <= right){
            if(s.charAt(left) != s.charAt(right)) return -1;
            left--;
            right++;
        }

        return right-left+1;

    }
}
