package datastructures.week4.dayewise.nov10;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class RomantoInt {
    /**
     * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
     *
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
     *
     * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
     *
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     * Given a roman numeral, convert it to an integer.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "III"
     * Output: 3
     * Explanation: III = 3.
     * Example 2:
     *
     * Input: s = "LVIII"
     * Output: 58
     * Explanation: L = 50, V= 5, III = 3.
     * Example 3:
     *
     * Input: s = "MCMXCIV"
     * Output: 1994
     * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     */

    /**
     * - create a hashmap with romanNum and its equivalent number as key value pair.
     * - initialize 2 int variables : result = 0; and previous = 1.
     * - start iterating given String from length -1 to 0.
     * - check if charAt currIndex >= previous
     *      if yes, add map.get(charAt(currIndx)) to result.
     *      else, remove map.get(charAt(currIndx)) from result.
     *  - assign charAt currIndx to previous to continue loop.
     *  - finally return result.
     */

 //MCMXCIV
    private int romanToInt(String roman){
        HashMap<Character, Integer> map = new HashMap<Character, Integer>(){
            {
                put('I',1);
                put('V',5);
                put('X',10);
                put('L',50);
                put('C',100);
                put('D',500);
                put('M',1000);
            }
        };
        int result = 0;
        int prev = 1;
        for(int i = roman.length()-1; i >= 0; i--){
            if(map.get(roman.charAt(i)) >= prev) result += map.get(roman.charAt(i)); //5 104 1094 1894
            else result -= map.get(roman.charAt(i));   // 4  94  994 894
            prev = map.get(roman.charAt(i)); // 5 104 94 1094 994 894
        }
        return result;
    }

    @Test
    public void test()
    {
        String roman = "MCMXCIV";
        Assert.assertEquals(1994, romanToInt(roman));
    }
}
