package datastructures.week8.daywise.dec07;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ReArrangeString {
    /**
     * Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
     * Return any possible rearrangement of s or return "" if not possible.
     * Example 1:
     * Input: s = "aab"
     * Output: "aba"
     * Example 2:
     * Input: s = "aaab"
     * Output: ""
     *
     */

    private String noAdjacentCharsSame(String s){
        if(s.length() == 1) return s;
        if(s.length() == 2 && s.charAt(0) != s.charAt(1)) return s;
        else if(s.length() == 2 && s.charAt(0) == s.charAt(1)) return "";
        char[] chars = s.toCharArray();
        String res = "";
        char[] outChars = new char[chars.length];
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : chars){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        if(map.size() == 1) return "";
        int end = chars.length-1;
        for(int i = 0; i < chars.length-2; i++){
            if(map.get(chars[i]) >= chars.length/2) return "";
            else{
                if(chars[i] == chars[i+1]){
                    char c = chars[i+1];
                    chars[i+1] = chars[end];
                    chars[end--] = c;
                }
            }
        }
        res = new String(chars);

        return res;
    }

    @Test
    public void test(){
        String s = "aab";
        Assert.assertEquals("aba", noAdjacentCharsSame1(s));
    }

    @Test
    public void test1(){
        String s = "aaab";
        Assert.assertEquals("", noAdjacentCharsSame1(s));
    }

    @Test
    public void test2(){
        String s = "aaabc";
        Assert.assertEquals("acaba", noAdjacentCharsSame1(s));
    }

    @Test
    public void test3(){
        String s = "aaa";
        Assert.assertEquals("", noAdjacentCharsSame1(s));
    }


    private String noAdjacentCharsSame1(String s) {
        if (s.length() == 1) return s;
        if (s.length() == 2 && s.charAt(0) != s.charAt(1)) return s;
        else if (s.length() == 2 && s.charAt(0) == s.charAt(1)) return "";
        char[] chars = s.toCharArray();
        String res = "";
        char[] outChars = new char[chars.length];
        int[][] occ = new int[26][2];
        for(char c : chars){
            occ[c-'a'][0] = c-'a';
            occ[c-'a'][1]++;
        }
        Arrays.sort(occ,(a,b)-> {if (b[1]!=a[1]) return b[1]-a[1]; else return b[0]-a[0];});

        int maxCharOccur = occ[0][1];

        if(maxCharOccur > (chars.length+1) /2) return "";
        int i = 0;
        while(maxCharOccur > 0){
            outChars[i] = (char) (97+occ[0][0]);
            i = i+2;
            maxCharOccur--;
        }
        int j = 1;
        for(i = 1; i < chars.length; i++){
            outChars[i++] = (char) (97+occ[j++][0]);

        }


        res = new String(outChars);

        return res;
    }

}
