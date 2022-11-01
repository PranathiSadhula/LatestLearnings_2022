package datastructures.week3.day2;

import java.util.stream.IntStream;

public class Anagram {
/*
     * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
     * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
     * typically using all the original letters exactly once.
     * Constrains: s and t consist of lowercase English letters.
     * Input: s = "anagram", t = "nagaram"
     * Output: true
     */


     private boolean isAnagram(String s, String t){
            if(s.length() != t.length()) return false;

            //int[] sChars = new int[128];
         //   int[] tChars = new int[128];
                int[] sChars = new int[26];
            for(int i = 0; i < s.length(); i++){
                sChars[s.codePointAt(i)-'a']++;
                sChars[t.codePointAt(i)-'a']--;
            }

           // return sChars.equals(new int[26]);
          
            return IntStream.of(sChars).allMatch(n -> n == 0);

    }
}