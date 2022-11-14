package datastructures.week5.day2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class PermutationsOfString {
    /**
     * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
     *
     * In other words, return true if one of s1's permutations is the substring of s2.
     *
     *
     *
     * Example 1:
     *
     * Input: s1 = "ab", s2 = "eidbaooo"
     * Output: true
     * Explanation: s2 contains one permutation of s1 ("ba").
     * Example 2:
     *
     * Input: s1 = "ab", s2 = "eidboaoo"
     * Output: false
     *
     *
     * Constraints:
     *
     * 1 <= s1.length, s2.length <= 104
     * s1 and s2 consist of lowercase English letters.
     */

    /**

     */

    private boolean isS2PermutationS1(String s1, String s2){
        HashMap<Character, Integer> s1Map = new HashMap<>();
        for(char c : s1.toCharArray()){
            s1Map.put(c, s1Map.getOrDefault(c,0)+1);
        }

        for(int i = 0; i <= s2.length()-s1.length(); i++){
            HashMap<Character, Integer> s2Map = new HashMap<>();
            for(int j = i; j < s1.length()+i; j++){
                s2Map.put(s2.charAt(j), s2Map.getOrDefault(s2.charAt(j),0)+1);
            }
            if(s1Map.equals(s2Map)) return true;
        }

        return false;
    }

    @Test
    public void test(){
        String s1 = "ab";
        String s2 = "eidbaooo";
        Assert.assertTrue(isS2PermutationS1(s1, s2));
    }

    @Test
    public void test1(){
        String s1 = "adc";
        String s2 = "dccda";
        Assert.assertTrue(isS2PermutationS1SW(s1, s2));
    }


    private boolean isS2PermutationS1SW(String s1, String s2){
        HashMap<Character, Integer> s1Map = new HashMap<>();
        for(char c : s1.toCharArray()){
            s1Map.put(c, s1Map.getOrDefault(c,0)+1);
        }
        HashMap<Character, Integer> s2Map = new HashMap<>();
        int start = 0;
        int end = 0;
        while(end < s2.length()){
            s2Map.put(s2.charAt(end), s2Map.getOrDefault(s2.charAt(end++),0)+1);
            if(end - start ==  s1.length()){
                if(s2Map.equals(s1Map)) return true;
                if(s2Map.get(s2.charAt(start)) > 1){
                    s2Map.put(s2.charAt(start), s2Map.get(s2.charAt(start++))-1);
                }else{
                    s2Map.remove(s2.charAt(start++));
                }

            }
        }


        return false;
    }


    private boolean isStringPermutationPresentAscii(String s1, String s2) {

        if (s1.length() > s2.length())
            return false;
        if (s1.length() == 0 || s2.length() == 0)
            return false;
        int[] s1AsciiArr = new int[128];
        int[] s2AsciiArr = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            s1AsciiArr[s1.charAt(i)]++;
            s2AsciiArr[s2.charAt(i)]++;
        }
        if (Arrays.equals(s1AsciiArr, s2AsciiArr))
            return true;
        for (int i = 1; i <= s2.length() - s1.length(); i++) {
            s2AsciiArr[s2.charAt(i - 1)]--;
            s2AsciiArr[s2.charAt(i + s1.length() - 1)]++;
            if (Arrays.equals(s1AsciiArr, s2AsciiArr))
                return true;
        }
        return false;

    }

    private boolean isStringPermutationPresentBruteForce(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        if (s1.length() == 0 || s2.length() == 0)
            return false;
        char[] s1CharArr = s1.toCharArray();
        Arrays.sort(s1CharArr);
        char[] s2CharArr = new char[s1.length()];
        for (int i = 0; i <= s2.length()-s1.length(); i++) {
            int index = 0;
            for (int j = i; j < i+s1.length(); j++) {
                s2CharArr[index++] = s2.charAt(j);
            }
            Arrays.sort(s2CharArr);
            if (Arrays.equals(s1CharArr, s2CharArr)) return true;
        }
        return false;
    }


    private boolean isStringPermutationPresent(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        if (s1.length() == 0 || s2.length() == 0)
            return false;
        HashMap<Character, Integer> s1Map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i), 0) + 1);
        }
        HashMap<Character, Integer> s2Map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            s2Map.put(s2.charAt(i), s2Map.getOrDefault(s2.charAt(i), 0) + 1);
        }
        for (int i = 1; i <= s2.length() - s1.length(); i++) {
            if (s2Map.get(s2.charAt(i - 1)) > 1) {
                s2Map.put(s2.charAt(i - 1), s2Map.getOrDefault(s2.charAt(i - 1), 0) - 1);
            } else
                s2Map.remove(s2.charAt(i - 1));
            s2Map.put(s2.charAt(i + s1.length() - 1), s2Map.getOrDefault(s2.charAt(i + s1.length() - 1), 0) + 1);
            if (s1Map.equals(s2Map))
                return true;
        }
        return false;
    }

}
