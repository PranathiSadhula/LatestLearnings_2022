package datastructures.week7.day2.SpotProblems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
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
     * - accept given array of Strings.
     * - create 3 strings row1=qwertyuiop, row2=asdfghjkl and row3=zxcvbnm.
     * -
     */

    public String[] findWords(String[] words) {
        String row1 = "qwertyuiop", row2 = "asdfghjkl", row3 = "zxcvbnm";

        List<String> output = new ArrayList<>();

        for (String eachWord : words) {
            if(eachWord.toLowerCase().replaceAll("["+row1+"]", "").isEmpty()){
                output.add(eachWord);
            }
            else if(eachWord.toLowerCase().replaceAll("["+row2+"]", "").isEmpty()){
                output.add(eachWord);
            }
            else if(eachWord.toLowerCase().replaceAll("["+row3+"]", "").isEmpty()){
                output.add(eachWord);
            }
          }
        return output.toArray(new String[output.size()]);
    }

    @Test
    public void test(){
        String[] words = {"Hello","Alaska","Dad","Peace"};
        findWords(words);
    }




}
