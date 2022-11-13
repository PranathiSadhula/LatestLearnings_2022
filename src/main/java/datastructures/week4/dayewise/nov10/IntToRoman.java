package datastructures.week4.dayewise.nov10;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class IntToRoman {
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
     * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
     *
     * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
     *
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     * Given an integer, convert it to a roman numeral.
     *
     *
     *
     * Example 1:
     *
     * Input: num = 3
     * Output: "III"
     * Explanation: 3 is represented as 3 ones.
     * Example 2:
     *
     * Input: num = 58
     * Output: "LVIII"
     * Explanation: L = 50, V = 5, III = 3.
     * Example 3:
     *
     * Input: num = 1994
     * Output: "MCMXCIV"
     * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     *
     *
     * Constraints:
     *
     * 1 <= num <= 3999
     */
    /**
     * - create a hashmap with number and its equivalent roman as key value pair.
     * -
     *
     */


    private String convertIntToRoman(int num){
        HashMap<Integer, Character> map = new HashMap<Integer, Character>(){
            {
                put(1, 'I');
                put(5,'V');
                put(10, 'X');
                put(50, 'L');
                put(100, 'C');
                put(500,'D');
                put(1000, 'M');
            }
        };

        char[] romanDigits = {'I','V','X','L','C','D','M'};
        int[] numerals = {1,5,10,50,100,500,1000};

        String result = "";
        char prevRomanDigit = 'I';

           for(int i = 0; i < numerals.length; i++){  //1994
              while(num > 0){
                  int digit =  num % 10; //4  90
                  if(digit <= numerals[i]){
                        result += ""+prevRomanDigit+""+romanDigits[i];
                  }
                  else{
                      prevRomanDigit = romanDigits[i];
                  }
              }
           }


        return result;
   }



   @Test
    public void test(){
        int num = 1994;
       Assert.assertEquals("MCMXCIV", convertIntToRoman(num));
   }

}
