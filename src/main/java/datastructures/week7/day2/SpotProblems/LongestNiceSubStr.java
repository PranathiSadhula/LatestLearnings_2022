package datastructures.week7.day2.SpotProblems;

import org.junit.Test;

public class LongestNiceSubStr {
    /**
     *  https://leetcode.com/problems/longest-nice-substring/
     *
     *     A string s is nice if, for every letter of the alphabet that s contains, it appears both in uppercase and lowercase. For example, "abABB" is nice because 'A' and 'a' appear, and 'B' and 'b' appear. However, "abA" is not because 'b' appears, but 'B' does not.
     *
     *     Given a string s, return the longest substring of s that is nice. If there are multiple, return the substring of the earliest occurrence. If there are none, return an empty string.
     *
     *
     *
     *             Example 1:
     *
     *     Input: s = "YazaAay"
     *     Output: "aAa"
     *     Explanation: "aAa" is a nice string because 'A/a' is the only letter of the alphabet in s, and both 'A' and 'a' appear.
     * "aAa" is the longest nice substring.
     *             Example 2:
     *
     *     Input: s = "Bb"
     *     Output: "Bb"
     *     Explanation: "Bb" is a nice string because both 'B' and 'b' appear. The whole string is a substring.
     *     Example 3:
     *
     *     Input: s = "c"
     *     Output: ""
     *     Explanation: There are no nice substrings.
     *
     *
     *             Constraints:
     *
     *             1 <= s.length <= 100
     *     s consists of uppercase and lowercase English letters.
     */


/*
	s = "YazaAbay" out = "aA"
	s = "YazaAaZy" out = "azaAaZ"
	s = "baB" out = ""

*/

    /**
     - start iteration from i = 0 to s.length.
     - for each char given in str at index i, check if its counter alphabet(if lower -> upper, vise virsa) available in subString starting from i+1.
     - if not


     - start 2 pointers from 0 : start = 0; end = 0.
     - iterate until start < end.
     - for each char at end, check if subStr string from end+1 till s.length having its counter alphabet.
     - if yes, increment end++
     - if no, increment start++ and reset end = start.

     */

    @Test
    public void test(){
        String s = "YazaAaZy";
        System.out.println(longestNicSubStr(s));
    }

    private String longestNicSubStr(String s){

        int start = 0;
        int end = 1;
        String longSubStr = "";
        while(start < end){
            String subStr = getNiceSubStr(s.substring(start, end+1));
            if(longSubStr.length() < subStr.length()) longSubStr = subStr;
            end++;
            if(end == s.length()){
                start++;
                end = start+1;
            }
        }

        return longSubStr;

    }

        private String getNiceSubStr(String s){

        boolean isNice = false;
        char[] chars = s.toCharArray();
        for(int end = 0; end < s.length(); end++){ // YazaAaZy
            String curSub = "";
            if(Character.isLowerCase(chars[end]) && !s.substring(end+1).contains(Character.toUpperCase(chars[end])+"")){
                return "";
            }
            else if(Character.isUpperCase(chars[end]) && !s.substring(end+1).contains(Character.toLowerCase(chars[end])+"")){
                return "";
            }
            else{
               isNice = true;
            }

        }
        return isNice? s : "";
    }
}
