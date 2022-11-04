package datastructures.week3.daywise.assignments.nov3rd;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class UniqueMorseCode {
    /**
     * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows:
     *
     * 'a' maps to ".-",
     * 'b' maps to "-...",
     * 'c' maps to "-.-.", and so on.
     * For convenience, the full table for the 26 letters of the English alphabet is given below:
     *
     * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
     * Given an array of strings words where each word can be written as a concatenation of the Morse code of each letter.
     *
     * For example, "cab" can be written as "-.-..--...", which is the concatenation of "-.-.", ".-", and "-...". We will call such a concatenation the transformation of a word.
     * Return the number of different transformations among all words we have.
     *
     *
     *
     * Example 1:
     *
     * Input: words = ["gin","zen","gig","msg"]
     * Output: 2
     * Explanation: The transformation of each word is:
     * "gin" -> "--...-."
     * "zen" -> "--...-."
     * "gig" -> "--...--."
     * "msg" -> "--...--."
     * There are 2 different transformations: "--...-." and "--...--.".
     * Example 2:
     *
     * Input: words = ["a"]
     * Output: 1
     *
     *
     * Constraints:
     *
     * 1 <= words.length <= 100
     * 1 <= words[i].length <= 12
     * words[i] consists of lowercase English letters.
     */

    /**
     - create an array morsecodes with size 26
     - Initialize hasSet to hold concatenated morseCodes for each word.
     - iterate through each word given :
     - extracte morsecode for each char and conacate with eachother and add into set.
     - finally return set.size
     */

    public int uniqueMorseRepresentations(String[] words) {

        String[] mc = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        HashSet<String> set = new HashSet<>();
        for(String word : words){
           String mcWord = "";
           char[] chars =  word.toCharArray();
           for(char c: chars){
               mcWord += mc[c-'a'];
           }
           set.add(mcWord);
        }

        return set.size();
    }

    @Test
    public void test(){
        String[] words = {"gin","zen","gig","msg"};
        Assert.assertEquals(2, uniqueMorseRepresentations(words));
    }
}
