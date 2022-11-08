package datastructures.week4.day1;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class LongestSubStrWithUniqChars {
    /**
     * Similar problems :
     * Longest Substring with out Repeating Character
     * Longest Substring with Repeating Character
     * Longest Substring with k values
     * Output Format
     * Substring length
     * first Substring
     * last Substring
     */
    /**
     * Given a string s, find the length of the longest substring without repeating characters.
     *
     *
     *
     *
     * Example 1:
     *
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     * Example 2:
     *
     * Input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * Example 3:
     *
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     *
     *
     * Constraints:
     *
     * 0 <= s.length <= 5 * 104
     * s consists of English letters, digits, symbols and spaces.
     */


    /**
     * - check if length of given str > 0 and < 5*104, else return 0.
     * - initialize maxLength = Integer.Min_Value.
     * - initialize curIndx = 0.
     * - initialize hasset to hold uniq chars forming a subStr.
     * - check if hashset contains char at i,
     *
     *
     *
     *
     */

    private int getLongestUniqSubStr(String s) {
        if (s.length() < 1 || s.length() > 5 * 10 * 10 * 10 * 10) return 0;

      //  HashSet<Character> set = new HashSet<>();
        int maxLength = Integer.MIN_VALUE;
        int start = 0;
        int end = 1;
        String subStr = s.charAt(start)+"";
       // set.add(s.charAt(start));
        while (start < end && end < s.length()) {
            if (subStr.contains(s.charAt(end)+"")) {
                maxLength = Math.max(maxLength, end - start );
               // set.remove(s.charAt(start++));
                subStr = subStr.substring(start++ + 1);

             }
            subStr = subStr+s.charAt(end++);
         //   if(subStr.contains(s.charAt(end++)+"")) start = end - 1;
           // if(!set.add(s.charAt(end++))) start++;
        }
        return maxLength /*> set.size() ? maxLength : set.size()*/;
    }

    private int getLongestUniqSubStr1(String s){
        int start = 0;
        int end = 0;
        int curMax = 0;
        int maxLength = 0;

        HashSet<Character> set = new HashSet<>();
        while(end < s.length()){
            if(set.contains(s.charAt(end))) {
                curMax = end - start;
                 set.remove(s.charAt(start++));

            }
            else {
                set.add(s.charAt(end++));
                curMax = set.size();
            }
            maxLength = Math.max(maxLength, curMax);
        }
        return maxLength;
    }

    @Test
    public void test(){
        String s = "pwwkew";
        Assert.assertEquals(3, getLongestUniqSubStr(s));
    }

    @Test
    public void test1(){
        String s = "AbcCDBSFGDFH".toLowerCase();
        Assert.assertEquals(6, getLongestUniqSubStr(s));
    }

    @Test
    public void test2(){
        String s = "abcabcbb";
        Assert.assertEquals(3, getLongestUniqSubStr1(s));
    }
}

