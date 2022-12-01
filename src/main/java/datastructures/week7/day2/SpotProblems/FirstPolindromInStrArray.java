package datastructures.week7.day2.SpotProblems;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FirstPolindromInStrArray {
    /**
     * Given an array of strings words, return the first palindromic string in the array. If there is no such string, return an empty string "".
     *
     * A string is palindromic if it reads the same forward and backward.
     *
     *
     *
     * Example 1:
     *
     * Input: words = ["abc","car","ada","racecar","cool"]
     * Output: "ada"
     * Explanation: The first string that is palindromic is "ada".
     * Note that "racecar" is also palindromic, but it is not the first.
     * Example 2:
     *
     * Input: words = ["notapalindrome","racecar"]
     * Output: "racecar"
     * Explanation: The first and only string that is palindromic is "racecar".
     * Example 3:
     *
     * Input: words = ["def","ghi"]
     * Output: ""
     * Explanation: There are no palindromic strings, so the empty string is returned.
     *
     *
     * Constraints:
     *
     * 1 <= words.length <= 100
     * 1 <= words[i].length <= 100
     * words[i] consists only of lowercase English letters.
     */

    /**
     * - check if given string array length > 1. else trhouw exception.
     * - iterate through each word in given string array
     * - check if eachWord is polindrom using
     *      isPolindrom(String s)
     * - if true, return word, else continue.
     * - finally once iteration done and still no word found to be polindrom, return "".
     *
     */

    private String firstPolindromFound(String[] words){
        if(words.length < 1) throw  new RuntimeException("atleast 1 string is needed");
        for(String eachWord : words){
            if(isPolindrom(eachWord)) return eachWord;
        }
        return "";
    }

    /**
     * isPolindrom(String s)
     * - check if given str is empty, if yes return false.
     * - start 2 pointers : start = 0, end = s.length-1
     * - iterate thorufh string until start reaches end
     * - check if char at start and end are same.
     * - if not return false.
     * - else keep continuing.
     *
     */

    private boolean isPolindrom(String s){
        if(s.length() < 1) return false;
        int start = 0;
        int end = s.length()-1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }


    @Test
    public void test(){
        String[] words = {"abc","car","adb","adb","racecar","cool"};

        Arrays.asList(words).stream().forEach(item -> item.equals("adb"));
        List<String> filteredList = Arrays.asList(words).stream().filter(item -> item.equals("adb")).collect(Collectors.toList());
        System.out.println(filteredList);

      //  Assert.assertEquals("racecar", firstPolindromFound(words));
    }
}
