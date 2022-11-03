package datastructures.week3.daywise.assignments.nov3rd;

import org.junit.Assert;
import org.junit.Test;

public class JewelsStones {
    /**
     * You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.
     *
     * Letters are case sensitive, so "a" is considered a different type of stone from "A".
     *
     *
     *
     * Example 1:
     *
     * Input: jewels = "aA", stones = "aAAbbbb"
     * Output: 3
     * Example 2:
     *
     * Input: jewels = "z", stones = "ZZ"
     * Output: 0
     *
     *
     * Constraints:
     *
     * 1 <= jewels.length, stones.length <= 50
     * jewels and stones consist of only English letters.
     * All the characters of jewels are unique.
     */


    /**
     * - check if jewels.length > 1 && stones.length > 1, else return 0.
     * - check if jewels.length > 50 && stones.length > 50, if yes return 0.
     * - intialaize coount = 0.
     * - convert stones to char[].
     * - iterate through stones starting from 0 to stones.length
     * - check if char at each indx in stones matches with char in jewels.
     * - if matches, count++
     * - finally return count.
     */

    private int jewelsFoundInStones(String stones, String jewels){
        if(jewels.length() < 1 || stones.length() < 1) return 0;
        if(jewels.length() > 50 || stones.length() > 50) return 0;

        int count = 0;

        char[] sChars = stones.toCharArray();

        for(int i = 0; i < sChars.length; i++){
            if(jewels.contains(sChars[i]+""))    count++;
        }
          return count;
    }


    /**
     * regExp approach :
     * - check if jewels.length > 1 && stones.length > 1, else return 0.
     * - check if jewels.length > 50 && stones.length > 50, if yes return 0.
     * - store stones.length in a variable.
     * - replace all jewels from stones.
     * - finally return currStones.length - prevStones.length
     *
     */

    private int jewelsFoundInStonesRegExp(String stones, String jewels){
        if(jewels.length() < 1 || stones.length() < 1) return 0;
        if(jewels.length() > 50 || stones.length() > 50) return 0;

        int prevLength = stones.length();

        stones =  stones.replaceAll("["+jewels+"]", "");
        int curLength = stones.length();

        return Math.abs(curLength - prevLength);
    }


    @Test
    public void test(){
        String jewels = "aA";
        String stones = "aAAbbbb";

        Assert.assertEquals(0,jewelsFoundInStonesRegExp(stones, jewels) );
    }
}
