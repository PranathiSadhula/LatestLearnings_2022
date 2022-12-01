package datastructures.interviewready;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPermutationOfGivenWord {

    /**
     * 11.Find Permutation of given string
     * input str="god"
     * output = "god gdo ogd odg dgo dog"
     */


    private String[] allPermutationsOfStr(String s){
        if(s.length() < 1) return new String[]{} ;
        List<String> output = new ArrayList<>();
        String permutatedStr = "";
        returnPermutation(s, permutatedStr, output);
        return output.toArray(new String[output.size()]);
    }

    private void returnPermutation(String s, String pStr, List<String> output){

        if(s.length() == 0)  output.add(pStr);// return pStr;//System.out.println(pStr);

        for(int i = 0; i < s.length(); i++){
            String res = s.substring(0,i)+s.substring(i+1);
            returnPermutation(res, pStr+s.charAt(i), output);
        }
    }


    @Test
    public void test(){
        String s = "abcd";
        System.out.println(Arrays.toString(allPermutationsOfStr(s)));
    }

    private void returnPermutationChars(String s,char[] chars, List<String> output){

        if(s.length() == 0)  output.add(new String(chars));// return pStr;//System.out.println(pStr);

        for(int i = 0; i < s.length(); i++){
            String res = s.substring(0,i)+s.substring(i+1);
            chars[chars.length] = s.charAt(i);
            returnPermutationChars(res, chars, output);
        }
    }


    private String[] allPermutationsOfStrChars(String s){
        if(s.length() < 1) return new String[]{} ;
        List<String> output = new ArrayList<>();
        char[] permutatedChar = new char[s.length()];
        returnPermutationChars(s, permutatedChar, output);
        return output.toArray(new String[output.size()]);
    }

    @Test
    public void testChars(){
        String s = "abc";
        System.out.println(Arrays.toString(allPermutationsOfStrChars(s)));
    }
}

