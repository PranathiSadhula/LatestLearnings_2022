package datastructures.week11.codeathon;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ReverseWords {
    /**
     * https://leetcode.com/problems/reverse-words-in-a-string/description/
     *
     *
     * a good   example
     * example good a
     */
    /**
     * - remove trail and end spaces in given str.
     * - convert given str to string[] based on space as delimiter.
     * - start 2 pointers : start = 0; end = str[].length-1
     * - keep swaping each words at index start with index end.
     *
     * 5min
     */

    private String reverseWords(String s){
        s = s.trim();

        String[] words = s.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String eachWord : words){
            if(!eachWord.isEmpty()) list.add(eachWord);
        }
        s = new String();
        int start = 0;
        int end = list.size()-1;
        while(start < end){
            String temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++;
            end--;
        }
        for (String eachWord : list){
            s += eachWord+" ";
        }

        return s.trim();
    }

    @Test
    public void test(){
        String s = "a good   example";
        Assert.assertEquals("example good a", reverseWords(s));
    }

    private String reverseWordsSB(String s){
        s = s.trim();
        StringBuffer sb = new StringBuffer(s);
        int start = 0;
        int end = s.length()-1;
        int startLength = 0;
        while (start < end){
            if(s.charAt(start) == 32 && s.charAt(end) == 32){
                sb.insert(startLength, s.substring(end));

            }
        }

        return s.trim();
    }
}
