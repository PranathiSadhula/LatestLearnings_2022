package datastructures.week4.dayewise.nov10;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeyBoardRow {
    /**
     * Given an array of strings words, return the words that can be typed using letters of the alphabet on only one row of American keyboard like the image below.
     *
     * In the American keyboard:
     *
     * the first row consists of the characters "qwertyuiop",
     * the second row consists of the characters "asdfghjkl", and
     * the third row consists of the characters "zxcvbnm".
     *
     *
     *
     * Example 1:
     *
     * Input: words = ["Hello","Alaska","Dad","Peace"]
     * Output: ["Alaska","Dad"]
     * Example 2:
     *
     * Input: words = ["omk"]
     * Output: []
     * Example 3:
     *
     * Input: words = ["adsdf","sfd"]
     * Output: ["adsdf","sfd"]
     *
     *
     * Constraints:
     *
     * 1 <= words.length <= 20
     * 1 <= words[i].length <= 100
     * words[i] consists of English letters (both lowercase and uppercase).
     */

    /**
     * - create 3 boolean flags : isRow1, isRow2, isRow3.
     * - create 3 Strings : row1 = "qwertyuiop", row2 ="asdfghjkl" , row3 ="zxcvbnm"
     * - create a list<String> to hold output words.
     * - iterate through each word and check if each char in eachWord satifies only one boolean flag above.
     * - condition to check :
     *      convert each word into charArray.
     *      check if eachChar presents in a single row by using contains either ro1.contains or row2.contains or ro3.contains
     * - finally return array converted List
     *
     */

    private String[] singleRowWords(String[] words) {
        boolean isrow1 = false;
        boolean isrow2 = false;
        boolean isrow3 = false;
        String row1 = "qwertyuiop", row2 = "asdfghjkl", row3 = "zxcvbnm";

        List<String> output = Arrays.asList(words);
        ArrayList<String> removedList = new ArrayList<>();
        for (String eachWord : words) {
            char[] charArray = eachWord.toLowerCase().toCharArray();
            for (char c : charArray) {
                if(row1.contains(c+"")) isrow1 = true;
                if(row2.contains(c+"")) isrow2 = true;
                if(row3.contains(c+"")) isrow3 = true;

                if (isrow1 && (isrow2 || isrow3)) {
                   // output.remove(eachWord);
                    removedList.add(eachWord);
                    break;
                }
            }
        }
        output.removeAll(removedList);

        return output.toArray(new String[output.size()]);
    }


    private String[] singleRowWordsCount(String[] words) {

        String row1 = "qwertyuiop", row2 = "asdfghjkl", row3 = "zxcvbnm";

        List<String> output = new ArrayList<>();
        ArrayList<String> removedList = new ArrayList<>();
        for (String eachWord : words) {
            int row1Count = 0;
            int row2Count = 0;
            int row3Count = 0;
            char[] charArray = eachWord.toLowerCase().toCharArray();
            for (char c : charArray) {
                if(row1.contains(c+"")) row1Count++;
                if(row2.contains(c+"")) row2Count++;
                if(row3.contains(c+"")) row3Count++;

            }
            if(eachWord.length() == row1Count || eachWord.length() == row2Count || eachWord.length() == row3Count)
                output.add(eachWord);
        }


        return output.toArray(new String[output.size()]);
    }


    @Test
    public void test(){
        String[] words = {"Hello","Alaska","Dad","Peace"};
        String[] output = {"Alaska","Dad"};
        Assert.assertArrayEquals(output, singleRowWordsCount(words));
    }
}
