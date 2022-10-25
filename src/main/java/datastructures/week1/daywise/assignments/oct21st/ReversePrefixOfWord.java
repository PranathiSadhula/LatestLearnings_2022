package datastructures.week1.daywise.assignments.oct21st;

import org.junit.Test;

public class ReversePrefixOfWord {
    /**
     * Given a 0-indexed string word and a character ch, reverse the segment of word that starts at index 0 and ends at the index of the first occurrence of ch (inclusive). If the character ch does not exist in word, do nothing.
     *
     * For example, if word = "abcdefd" and ch = "d", then you should reverse the segment that starts at 0 and ends at 3 (inclusive). The resulting string will be "dcbaefd".
     * Return the resulting string.
     *
     *
     *
     * Example 1:
     *
     * Input: word = "abcdefd", ch = "d"
     * Output: "dcbaefd"
     * Explanation: The first occurrence of "d" is at index 3.
     * Reverse the part of word from 0 to 3 (inclusive), the resulting string is "dcbaefd".
     * Example 2:
     *
     * Input: word = "xyxzxe", ch = "z"
     * Output: "zxyxxe"
     * Explanation: The first and only occurrence of "z" is at index 3.
     * Reverse the part of word from 0 to 3 (inclusive), the resulting string is "zxyxxe".
     * Example 3:
     *
     * Input: word = "abcd", ch = "z"
     * Output: "abcd"
     * Explanation: "z" does not exist in word.
     * You should not do any reverse operation, the resulting string is "abcd".
     *
     *
     * Constraints:
     *
     * 1 <= word.length <= 250
     * word consists of lowercase English letters.
     * ch is a lowercase English letter.
     */


    /**
     * approach
     *
     * - initialise 2 pointers start = 0, end = first Index of char c.
     *
     * - cnvert string s to charArray
     *
     * - loop over the string from start to end.
     *
     * - reverse segment starting from 0 till end.
     *
     * - finally return the updated string
     */

    private  String reversePrefix(String s, char c){

        if(s.length() < 1) return "invalid sting";

        int start = 0;
        int end = s.indexOf(c);
        if(end < 0) return s;

        char[] charArray = s.toCharArray();

        while(start < end){
            charArray[start] = s.charAt(end);
            charArray[end--] = s.charAt(start++);
        }

        return new String(charArray);
    }

    @Test
    public void test() {
        String s = "abcded";
        char c = 'd';
        reversePrefix(s,c);
    }
}
