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
        returnAnagramIndices1(s1, s2);
    }

    @Test
    public void test2() {
        String s = "abab";
        String p = "ab";
        anagramUsingSW(s,p);
       // Assert.assertArrayEquals(anagramUsingSW(s1, s2), new int[] { 0, 1, 2 });
    }


    /**
     * slidingWindow approach:
     * - load p string into pMap with each character and its occurance.
     * - initialize smap with character and integer as key value pair.
     * - initialize list of integers to output indices.
     * - first for loop, take window length of p.length startign from 0 to add each chars and its occureance into smap.
     * - check if smap.equals pmap, if yes -> add startIndx to output.
     * - initialize end = p.length -1.
     * - in 2nd for loop starting from start = 1 until end < s.length
     * - keep adding each chars and its occureance into smap.
     * - when start reaches end, check if smap equala with pmap. if yes, add start to output.
     * - else, remove elt at start from smap, and add elt at end indices resp.
     */

    private List<Integer> returnAnagramIndices(String s, String p){
        HashMap<Character, Integer> pMap = new HashMap<>();
        for(char c : p.toCharArray()){
            pMap.put(c, pMap.getOrDefault(c,0)+1);
        }
        HashMap<Character, Integer> sMap = new HashMap<>();

        List<Integer> output = new ArrayList<>();
        int start = 0;
        int end = p.length()-1;
        while(start <= end){
            sMap.put(s.charAt(start), sMap.getOrDefault(s.charAt(start++),0)+1);
        }
        start = 0;
        if(pMap.equals(sMap))  output.add(start);

        start = 1;
        end  = start;
        sMap.clear();
        while(end < s.length()){
            sMap.put(s.charAt(end), sMap.getOrDefault(s.charAt(end++),0)+1);
            if(end - start == p.length()) {
                if(pMap.equals(sMap))  output.add(start);
                if(sMap.get(s.charAt(start)) > 1){
                    sMap.put(s.charAt(start), sMap.get(s.charAt(start++))-1);
                }else{
                    sMap.remove(s.charAt(start++));
                }
            }

        }
        return output;

    }


    private List<Integer> returnAnagramIndices1(String s, String p) {
        if (s.length() < p.length()) {
            String temp = s;
            s = p;
            p = temp;
        }
        HashMap<Character, Integer> pMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> sMap = new HashMap<>();

        List<Integer> output = new ArrayList<>();
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            if (sMap.containsKey(s.charAt(end))) {
                sMap.put(s.charAt(end), sMap.get(s.charAt(end++)) - 1);

            }
            while (start <= end) {
                sMap.put(s.charAt(start), sMap.getOrDefault(s.charAt(start++), 0) + 1);
            }
            start = 0;
            if (pMap.equals(sMap)) output.add(start);

            start = 1;
            end = start;
            sMap.clear();
            while (end < s.length()) {
                sMap.put(s.charAt(end), sMap.getOrDefault(s.charAt(end++), 0) + 1);
                if (end - start == p.length()) {
                    if (pMap.equals(sMap)) output.add(start);
                    if (sMap.get(s.charAt(start)) > 1) {
                        sMap.put(s.charAt(start), sMap.get(s.charAt(start++)) - 1);
                    } else {
                        sMap.remove(s.charAt(start++));
                    }
                }

            }
            return output;

        }
        return null;
    }
}
