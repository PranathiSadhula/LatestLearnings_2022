package datastructures.week2.day2.assessment;

import org.junit.Assert;
import org.junit.Test;

public class PolindromeII {
    /**
     *Given a string s, return true if the s can be palindrome after deleting at most one character from it.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "aba"
     * Output: true
     * Example 2:
     *
     * Input: s = "abca"
     * Output: true
     * Explanation: You could delete the character 'c'.
     * Example 3:
     *
     * Input: s = "abc"
     * Output: false
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 105
     * s consists of lowercase English letters.
     */

    /**2 pointer apprach :
     *
     * - check the size of given string.
     *
     * - if size <= 2 and > 1 return true
     *
     * - initialise 2 pointers : start = 0 end = s.length-1
     *
     * - initialise a counter = 0
     *
     * - in a loop start till end,
     *
     * - check if chars at start and end matches.
     *
     * - if not --> increment counter
     *
     * - at the of loop , if counter == 1 return true else false.
     */



    private boolean isPolindromeII(String s){
        if(s.length() <=2 ) return true;

        int start = 0;
        int end = s.length() - 1;
        int count = 0;

        while(start < end){
            if(s.charAt(start++) != s.charAt(end--)) count++;
        }
        if(s.length() % 2 != 0 && s.charAt(start) != s.charAt(start-1)) count++;
        return count > 1? false : true;
    }

   // @Test
    public void test(){
        String s = "eedede";
        Assert.assertTrue(isPolindromeUsingSubStr(s));
    }

    @Test
    public void test2(){
        String s = "aba";
        Assert.assertTrue(isPolindromeUsingSubStr(s));
    }

    private boolean isPolindromeUsingSubStr(String s){
        int start = 0;
        int end = s.length() - 1;

        while(start < end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }
            else{
                if(start < end) {
                    if(isPolindrom(s.substring(start, end-1)) || isPolindrom(s.substring(start+1, end)))
                        return true;
                }
                else{
                    return true;
                }
            }
        }
        return false;

    }

    private boolean isPolindrom(String s){
        int start = 0;
        int end = s.length() - 1;

        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }

        return true;
    }
}
