import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AllStringsMatchingPattern {
    /**
     * Given a dictionary of words,
     * find all strings that match the given pattern where every character in the pattern is uniquely mapped to a character in the dictionary.
     *
     * Examples:
     *
     * Input:
     * dict = ["abb", "abc", "xyz", "xyy"];
     * pattern = "foo"
     * Output: [xyy abb]
     * xyy and abb have same character at
     * index 1 and 2 like the pattern
     *
     * Input:
     * dict = ["abb", "abc", "xyz", "xyy"];
     * pat = "mno"
     * Output: [abc xyz]
     * abc and xyz have all distinct characters,
     * similar to the pattern.
     *
     * Input:
     * dict = ["abb", "abc", "xyz", "xyy"];
     * pattern = "aba"
     * Output: []
     * Pattern has same character at index 0 and 2.
     * No word in dictionary follows the pattern.
     *
     * Input:
     * dict = ["abab", "aba", "xyz", "xyx"];
     * pattern = "aba"
     * Output: [aba xyx]
     * aba and xyx have same character at
     * index 0 and 2 like the pattern
     */


   @Test
   public void test(){
       String[] dict = {"abab", "aba", "xyz", "xyx"};
       String pattern = "aba";
       Assert.assertArrayEquals(new String[]{"aba","xyx"}, findAllStringsMatchingPattern(dict,pattern));
   }

    private String[] findAllStringsMatchingPattern(String[] dict, String pat){
        if(dict.length == 0) throw new RuntimeException("invalid dict");
        if(dict.length == 1 && dict[0].length() != pat.length()) throw new RuntimeException("invalid dict");

        HashMap<Character, Integer> pMap = new HashMap<>();
        String patEnc = "";
        int pos = 0;
        for(char c : pat.toCharArray()){
            if(!pMap.containsKey(c)) pMap.put(c, pos++);
            patEnc += pMap.get(c);
        }
        List<String> output = new ArrayList<>();

        for(String eachWord : dict){
            pMap = new HashMap<>();
            String wrdEnc = "";
            pos = 0;
            for(char c : eachWord.toCharArray()){
                if(!pMap.containsKey(c)) pMap.put(c, pos++);
                wrdEnc += pMap.get(c);
            }
            if(wrdEnc.equals(patEnc)) output.add(eachWord);
        }
        return output.toArray(new String[output.size()]);
    }


    /**
     * given a word = "god".
     * find all permutations of given word.
     * ouptut = {god, gdo, ogd, odg, dgo, dog}
     *
     *  g o d
     *
     *
     */

    private String[] returnAllPermWords(String word){
        if(word.length() == 0) return new String[]{};
        List<String> output = new ArrayList<>();
        allPermStrToList(word,"", output);

        return output.toArray(new String[output.size()]);
    }


    private void allPermStrToList(String s, String pStr, List<String> allPStrs){
        if(s.length() == 0) allPStrs.add(pStr);
        for(int i = 0; i < s.length(); i++){
            String curStr = s.substring(0, i)+s.substring(i+1);
            allPermStrToList( curStr,pStr+s.charAt(i), allPStrs);
        }
    }


    @Test
    public void test1(){
        String s = "abcd";
        System.out.println(Arrays.toString(returnAllPermWords(s)));
    }
}
