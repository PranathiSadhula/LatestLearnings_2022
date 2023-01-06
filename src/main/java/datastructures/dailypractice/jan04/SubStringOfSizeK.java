package datastructures.dailypractice.jan04;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class SubStringOfSizeK {
    /**
     * https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/
     */


    /**
     * Test Data :
     *
     * 1. abbacdacd,
     *    bac, acd, cda,dac,acd
     *  output = 5
     *
     *  2. abcde
     *  abc, bcd,cde
     *  output = 3
     *
     *  3. aaa
     *  output = 0
     *
     *
     * 4.aaaaaaabc
     * output = 1
     */

    /**
     * - check if given string length < 3. if yes return 0
     * - initialize count = 0.
     * - initialize hashSet with char to hold onto charCount.
     * - intialize 2 pointers : start = 0 and end = start+3-1
     * - loop through given str starting from start to end
     * - while looping, keep adding each char to hasSet. at the end of loop, check if hashSet.size == 3, if yes increment count.
     * - reset hashSet.
     * - Now, start looping until end reaches str.length
     * - remove charAt start and add charAt end. check if size == 3, increment count.
     */


    private int subStrCountOfSizeK(String s){ // aaaaaaabc  //abbacdacd
        if(s.length() < 3) return 0;
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        for(int i = 0; i < 3; i++){
            if(s.length() == 3 && !set.add(chars[i])) return 0;
            set.add(chars[i]);
        }
        if(set.size() == 3) count++; // ab
        int start = 0;
        int end = start+3-1; // 2

        while(end < s.length()-1){
            if(set.contains(chars[start]) )
            set.remove(chars[start++]); //[b]
            set.add(chars[++end]); // [ba]
            if(set.size() == 3) count++;
        }

        return count;
    }


    @Test
    public void test(){
        String s = "abbacdacd";
        Assert.assertEquals(5, subStrCountOfSizeK(s));
    }

    @Test
    public void test1(){
        String s = "aaaaaaabc";
        Assert.assertEquals(1, subStrCountOfSizeK(s));
    }

    @Test
    public void test2(){
        String s = "abcde";
        Assert.assertEquals(3, subStrCountOfSizeK(s));
    }
}
