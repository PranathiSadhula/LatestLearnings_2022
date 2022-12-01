package datastructures.week7.day2.SpotProblems;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagrams {
    /**
     * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
     *
     * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
     * typically using all the original letters exactly once.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "anagram", t = "nagaram"
     * Output: true
     * Example 2:
     *
     * Input: s = "rat", t = "car"
     * Output: false
     *
     *
     * Constraints:
     *
     * 1 <= s.length, t.length <= 5 * 104
     * s and t consist of lowercase English letters.
     *
     *
     *
     * s = anagrram , t = naagaram
     */

    /**
     *
     * - check if given strs length >=1 and <= 5
     * - create a map to store each char and its occurances from str s.
     * - create another map to store each char and its occurances from str t.
     * - finally check if both maps are equal. if yes return true else return false.
     */

    private boolean isAnagram(String s, String t){
        if(s.length() < 1 || t.length() < 1) return false;
        HashMap<Character, Integer> sMap = new HashMap<>();
        for(char c : s.toCharArray()){
            sMap.put(c, sMap.getOrDefault(c,0)+1);
        }
        HashMap<Character, Integer> tMap = new HashMap<>();
        for(char c :t.toCharArray()){
            tMap.put(c, tMap.getOrDefault(c,0)+1);
        }
        return tMap.equals(sMap);
    }

    /**
     *
     * - check if given strs length >=1 and <= 5
     * - create a char[] with size 26.
     * - first iterate through str t and increament each chars occurances in char[].
     * - then while iterating through str s, decremenet each char occurances in char[].
     * - finally check if char[] matches with default array with size 26.
     * - if matches return true, else false.
     *
     * */

    private boolean isAnagaramAscii(String s, String t){
        int[] chars = new int[26];
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        for(int i = 0; i < sChars.length; i++){
            chars[sChars[i]-'a']++;
            chars[tChars[i]-'a']--;
        }

        return Arrays.equals(chars, new int[26]);
    }

    @Test
    public void test(){
        String s = "anagram";
        String t = "nagaram";
        Assert.assertTrue(isAnagaramAscii(s,t));
    }

}
