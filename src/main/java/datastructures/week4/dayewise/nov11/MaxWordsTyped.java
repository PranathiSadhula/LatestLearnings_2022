package datastructures.week4.dayewise.nov11;

import org.junit.Assert;
import org.junit.Test;

public class MaxWordsTyped {
    /**
     * There is a malfunctioning keyboard where some letter keys do not work. All other keys on the keyboard work properly.
     *
     * Given a string text of words separated by a single space (no leading or trailing spaces) and a string brokenLetters of all distinct letter keys that are broken, return the number of words in text you can fully type using this keyboard.
     *
     *
     *
     * Example 1:
     *
     * Input: text = "hello world", brokenLetters = "ad"
     * Output: 1
     * Explanation: We cannot type "world" because the 'd' key is broken.
     * Example 2:
     *
     * Input: text = "leet code", brokenLetters = "lt"
     * Output: 1
     * Explanation: We cannot type "leet" because the 'l' and 't' keys are broken.
     * Example 3:
     *
     * Input: text = "leet code", brokenLetters = "e"
     * Output: 0
     * Explanation: We cannot type either word because the 'e' key is broken.
     *
     *
     * Constraints:
     *
     * 1 <= text.length <= 104
     * 0 <= brokenLetters.length <= 26
     * text consists of words separated by a single space without any leading or trailing spaces.
     * Each word only consists of lowercase English letters.
     * brokenLetters consists of distinct lowercase English letters.
     */

    /**
     * - check if text.length is >= 1 and <= 10^4. else return invalid input.
     * - check if borkenLetters.length >= 0 and < 26, else return not unique broken letters.
     * - initialize a counter to hold no. of words that can actually typed.
     * - convert brokenLetters into char array.
     * - split text into words using " " as delimiter.
     * - check if each word contains char from brokenLetters, if yes increment counter.
     * -finally return words.length- count as no. of words can be typed.
     */

    private int canBeTypedWords(String text, String brokenLetters){
        if(text.length() < 1 || text.length() > 10*10*10*10) throw new RuntimeException("not a valid text");
        if(brokenLetters.length() < 0 || brokenLetters.length() > 26) throw new RuntimeException("broken letters are not valid");
        int count = 0;

        char[] brokenKeys =  brokenLetters.toCharArray();
        String[] words =  text.split(" ");
        for(String word : words){
            for(char bKey : brokenKeys){
                if(word.contains(bKey+"")){
                    count++;
                    break;
                }
            }

        }
        return words.length - count;
    }


    @Test
    public void test(){
        String text = "hello world";
        String brokenLetters = "";
        Assert.assertEquals(1, canBeTypedWordsRegExp(text, brokenLetters));
    }


    /**
     * approach with regExp:
     * - check if text.length is >= 1 and <= 10^4. else return invalid input.
     * - check if borkenLetters.length >= 0 and < 26, else return not unique broken letters.
     * - initialize a counter to hold no. of words that can actually typed.
     * - split text into words using " " as delimiter.
     * - iterate through each word, and hold onto prevWordlength.
     * - using replaceAll regExp syntax, replace all those chars from brokenLetters matching in eachword.
     * - now, check if prevWordlength != curWordLength, increment count.
     *  -finally return words.length- count as no. of words can be typed.
     */

    private int canBeTypedWordsRegExp(String text, String brokenLetters){
        if(text.length() < 1 || text.length() > 10*10*10*10) throw new RuntimeException("not a valid text");
        String[] words =  text.split(" ");
        if(brokenLetters.isEmpty()) return words.length;
        int count = 0;


        for(String word : words){
            int prevLength = word.length();
            word = word.replaceAll("["+brokenLetters+"]", "");
            if(prevLength != word.length()) count++;
        }
        return words.length - count;
    }
}
