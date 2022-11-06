package datastructures.week4.day1;

import org.junit.Assert;
import org.junit.Test;

public class FirstUniqueChars {
    /**
     * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "leetcode"
     * Output: 0
     * Example 2:
     *
     * Input: s = "loveleetcode"
     * Output: 2
     * Example 3:
     *
     * Input: s = "aabb"
     * Output: -1
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 105
     * s consists of only lowercase English letters.
     */

    /**
     * - check if s.lentgh == 1, if yes return 0.
      * - convert given string to char array.
     * - iterate through each char starting from i = 0 to s.length
     * - in loop create a tempStr to store subStr starting from indexOf(c) to end
     * - check if tempStr having indexOf matching with curr char c.
     * - if no, return index, else continue.
     * - finally return -1. which means no uniq chars.
     */

    private int getFirstUniqCharIndex(String s) {
        if(s.length() == 1) return 0;
        String finalStr = s;
        char[] chars = s.toCharArray();
      //  int subIndx = 1;
        for(int i = 0; i < s.length(); i++){
            String temp = s.substring(1/*subIndx++*/);
            if(temp.indexOf(chars[i]) == -1) return i;

            s = s.replaceAll("["+chars[i]+"]", "");

        }
        if(s.length() == 1) return finalStr.indexOf(s);

        return -1;
    }

    private int getIndexOfUniqChar(String s){
        if(s.length() == 1) return 0;
        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if(s.indexOf(temp) == s.lastIndexOf(temp)) return i;
        }

        return -1;
      }

    @Test
    public void test1(){
        String s = "aabb";
        Assert.assertEquals(-1, getFirstUniqCharIndex(s));
    }


    @Test
    public void test2(){
        String s = "loveleetcode";
        Assert.assertEquals(2, getFirstUniqCharIndex(s));
    }

    @Test
    public void test3(){
        String s = "lovvoly";
        Assert.assertEquals(6, getFirstUniqCharIndex(s));
    }


    /**
     * - intialize a map with character, integer as key value
     * - Iterate through s starting from 0 to s.length
     * - before adding char and its index into map, check if map already contains key as char.
     * - if yes, update char value as -1
     * - else keep adding char and its index to map.
     * - after map
     */

}

