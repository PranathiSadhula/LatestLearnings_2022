package datastructures.week8.day2.recursion;

import org.junit.Test;

public class ReverseString {
    /**
     * https://leetcode.com/problems/reverse-string/description/
     */


    /**
     * recurrsion :
     * - call reverse method with given chars[] and startIndex as 0 and endIndx as length -1.
     * - in reverse method, check if startIndex crosses endIndex, if yes, return.
     * - else keep swaping chars at startIndx and endIndx
     * - keep calling same reverse mthd with chars, incremented startIndx and decremented endIndx.
     */

    private void reverseStr(char[] chars){

        reverse(chars, 0, chars.length-1);
        System.out.println(chars);
    }

    private void reverse(char[] chars, int startIndex, int endIndex){
        if(startIndex >= endIndex) return;
        char temp = chars[startIndex] ;
        chars[startIndex++] = chars[endIndex];
        chars[endIndex--] = temp;
        reverse(chars, startIndex, endIndex);
    }


    @Test
    public void test(){
        char[] chars = {'h','e','l','l','o'};
        reverseStr(chars);
    }

    @Test
    public void test1(){
        char[] chars = {'H','a','n','n','a','h'};
        reverseStr(chars);
    }
}
