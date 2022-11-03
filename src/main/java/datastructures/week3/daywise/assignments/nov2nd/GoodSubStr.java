package datastructures.week3.daywise.assignments.nov2nd;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class GoodSubStr {

    /**
     * A string is good if there are no repeated characters.
     *
     * Given a string s​​​​​, return the number of good substrings of length three in s​​​​​​.
     *
     * Note that if there are multiple occurrences of the same substring, every occurrence should be counted.
     *
     * A substring is a contiguous sequence of characters in a string.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "xyzzaz"
     * Output: 1
     * Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz".
     * The only good substring of length 3 is "xyz".
     * Example 2:
     *
     * Input: s = "aababcabc"
     * Output: 4
     * Explanation: There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
     * The good substrings are "abc", "bca", "cab", and "abc".
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 100
     * s consists of lowercase English letters.
     */

    /**
     * - check if str.length < 3, if yes return 0.
     *
     * - initialize hashset to hold chars from subStr
     *
     * - check if str.length == 3 and add chars to hashset,if hashset.size == 3, return 1 else return 0.
     *
     * - initialize count = 0;
     *
     * - iterate trhough each char in str starting i = 1 to i+3
     *
     * - keep adding chars to hashset and check if set.size == 3 when i reached i = i+3, if yes, count++
     *
     * -
     */


    private int goodSubStrs(String s){
        if(s.length() < 3) return 0;

        HashSet<Character> set = new HashSet<>();

        for(int i = 0; i < 3; i++){
            if(s.length() == 3 && set.contains(s.charAt(i))) return 0;
            set.add(s.charAt(i));
        }

        int count = set.size() == 3 ? 1 : 0;
        set.clear();
        int start = 1;
        int end = 1;
        while(start < s.length() && end < s.length()){
            if(set.contains(s.charAt(end))) {
                set.clear();
                start++;
                end = start;
                continue;
            }
            set.add(s.charAt(end++));
            if(end == start+3){
                if(set.size() == 3) count++;
                start++;
                end = start;
                set.clear();
            }

        }
        return count;

    }


    @Test
    public void test(){
        String s = "aababcabc";
        Assert.assertEquals(4, goodSubStrs(s));
    }
}
