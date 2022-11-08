package datastructures.week4.day1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagrams {
    /**
     * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
     *
     * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "cbaebabacd", p = "abc"
     * Output: [0,6]
     * Explanation:
     * The substring with start index = 0 is "cba", which is an anagram of "abc".
     * The substring with start index = 6 is "bac", which is an anagram of "abc".
     * Example 2:
     *
     * Input: s = "abab", p = "ab"
     * Output: [0,1,2]
     * Explanation:
     * The substring with start index = 0 is "ab", which is an anagram of "ab".
     * The substring with start index = 1 is "ba", which is an anagram of "ab".
     * The substring with start index = 2 is "ab", which is an anagram of "ab".
     *
     *
     */

    /**
     * - add each char from p to a map1.
     * - iterate through s starting from 0 to s.length
     * - initialize 2 pointers start = 0; end = p.length
     * - keep adding chars from s starting start to end and check map1.equals map2.
     * - if yes, add start to output list.
     * - finally return output list.
     *
     *
     */

    private List<Integer> anagramUsingSW(String s, String p){
        List<Integer> outList = new ArrayList<>();
        HashMap<Character, Integer> mapP = new HashMap<>();
        for(char c : p.toCharArray()){
            mapP.put(c, mapP.getOrDefault(c,0)+1);
        }
        HashMap<Character, Integer> mapS = new HashMap<>();
        int start = 0;
        int end = p.length()-1;

        while(start < s.length() ){
            mapS.put(s.charAt(start), mapS.getOrDefault(s.charAt(start),0)+1);
            if(mapS.equals(mapP)) {
                outList.add(start - p.length()+1);
            }
            if(start == end){
                   mapS.clear();
                    end ++;
                    start = end - p.length() ;
            }
            start++;


        }
        return outList;
    }





    @Test
    public void test1() {
        String s1 = "cbaebabacd";
        String s2 = "abc";
        anagramUsingSW(s1, s2);
    }

    @Test
    public void test2() {
        String s1 = "abab";
        String s2 = "ab";
        anagramUsingSW(s1, s2);
       // Assert.assertArrayEquals(anagramUsingSW(s1, s2), new int[] { 0, 1, 2 });
    }
}
