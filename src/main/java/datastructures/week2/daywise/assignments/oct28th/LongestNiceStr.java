


package datastructures.week2.daywise.assignments.oct28th;

import org.junit.Assert;
import org.junit.Test;

public class  LongestNiceStr{
    
    /**


A string s is nice if, for every letter of the alphabet that s contains, it appears both in uppercase and lowercase. For example, "abABB" is nice because 'A' and 'a' appear, and 'B' and 'b' appear. However, "abA" is not because 'b' appears, but 'B' does not.

Given a string s, return the longest substring of s that is nice. If there are multiple, return the substring of the earliest occurrence. If there are none, return an empty string.

 

Example 1:

Input: s = "YazaAay"
Output: "aAa"
Explanation: "aAa" is a nice string because 'A/a' is the only letter of the alphabet in s, and both 'A' and 'a' appear.
"aAa" is the longest nice substring.
Example 2:

Input: s = "Bb"
Output: "Bb"
Explanation: "Bb" is a nice string because both 'B' and 'b' appear. The whole string is a substring.
Example 3:

Input: s = "c"
Output: ""
Explanation: There are no nice substrings. */


@Test 
public void test1(){
    String s = "YazaAay";
    String expected = "aAa";
    Assert.assertEquals(expected, lognestNiceSubStr(s));
}


@Test 
public void test2(){
    String s = "aaB";
    String expected = "";
    Assert.assertEquals(expected, lognestNiceSubStr(s));
}


@Test 
public void test3(){
    String s = "aBa";
    String expected = "";
    Assert.assertEquals(expected, lognestNiceSubStr(s));
}


@Test 
public void test4(){
    String s = "aabB";
    String expected = "bB";
    Assert.assertEquals(expected, lognestNiceSubStr(s));
}

/**
 - check if length of str is <= 1, if yes return ""

 - check if length of str == 2, check if str is nice and return str else return ""

 - initialize longestNiceSubStr =""

 - iterate through each char in the given string starting i = 0 to s.length

 - in inner loop, j starts from i+1 to s.length

 - for each subStr starting from i to j, check if its nice Str

 - hold onto longest nice subStr

 - finally return longestSubStr

 */

        private String lognestNiceSubStr(String s){
            if(s.length() <= 1) return "";

            if(s.length() == 2 ) return getNiceStrng(s);

            String longestNiceSubStr = "";

            for(int i = 0; i < s.length(); i++){
                for(int j = i+1; j <= s.length(); j++){
                    String subStr = getNiceStrng(s.substring(i, j));
                    if (longestNiceSubStr.length() < subStr.length()) {
                        longestNiceSubStr = subStr;
                    }

                }
            }

            return longestNiceSubStr;

        }


        /**
         isNiceStr solution :

         - check if char at i in given is upper or lower.

         - if lower, check if upper case of char is present in i+1 to subStr.length, if yes true.

         - if upper, check if lower case of char is present in i+1 to subStr.length, if yes true.

         */

        private String getNiceStrng(String s) {
            boolean isNiceSubStr = false;
            for (int i = 0; i < s.length(); i++) {
                char curChar = s.charAt(i);
                if (Character.isLowerCase(curChar) && s.indexOf(Character.toUpperCase(curChar)) == -1) {
                    return "";
                } else if (Character.isUpperCase(curChar) && s.indexOf(Character.toLowerCase(curChar)) == -1) {
                    return "";
                } else
                    isNiceSubStr = true;
            }

            if (isNiceSubStr)
                return s;
            return "";
        }



    }
    