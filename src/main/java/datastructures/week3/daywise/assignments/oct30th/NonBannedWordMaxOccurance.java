package datastructures.week3.daywise.assignments.oct30th;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NonBannedWordMaxOccurance {

    /**
     *
     * Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned. It is guaranteed there is at least one word that is not banned, and that the answer is unique.
     *
     * The words in paragraph are case-insensitive and the answer should be returned in lowercase.
     *
     *
     *
     * Example 1:
     *
     * Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
     * Output: "ball"
     * Explanation:
     * "hit" occurs 3 times, but it is a banned word.
     * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
     * Note that words in the paragraph are not case sensitive,
     * that punctuation is ignored (even if adjacent to words, such as "ball,"),
     * and that "hit" isn't the answer even though it occurs more because it is banned.
     * Example 2:
     *
     * Input: paragraph = "a.", banned = []
     * Output: "a"
     *
     *
     * Constraints:
     *
     * 1 <= paragraph.length <= 1000
     * paragraph consists of English letters, space ' ', or one of the symbols: "!?',;.".
     * 0 <= banned.length <= 100
     * 1 <= banned[i].length <= 10
     * banned[i] consists of only lowercase English letters.
     */


    @Test
    public void test1(){
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";

        String[] banned =  {"hit"};
        String expected = "ball";
        Assert.assertEquals(expected, getOccurOfNonBannedWord(paragraph,banned));
    }

    @Test
    public void test2(){
        String paragraph = "Bob. hIt, baLl";

        String[] banned =  {"bob", "hit"};
        String expected = "ball";
        Assert.assertEquals(expected, getOccurOfNonBannedWord(paragraph,banned));
    }

    @Test
    public void test3(){
        String paragraph = "a, a, a, a, b,b,b,c, c";

        String[] banned =  {"a"};
        String expected = "b";
        Assert.assertEquals(expected, getOccurOfNonBannedWord(paragraph,banned));
    }

    /**
     *
     * - on accepting paragrah and banned  as inputs, convert parapgrah to lowercase and remove/replace banned from paragraph
     *
     * - now, convert this paragraph to tokens : split(" ")
     *
     * - next remove all pancutations from paragraph
     *
     * - initialize a map to book keep each word and its occurance
     *
     * - finally, return that word occured more times
     *
     */


    private String getOccurOfNonBannedWord(String paragraph, String[] banned) {


        paragraph = paragraph.toLowerCase().replaceAll("\\p{Punct}", " ").trim();
            String[] words = paragraph.split(" ");

        HashMap<String, Integer> wordOccurances = new HashMap<>();

        for (String word : words){
            if(word.isEmpty() || word == "") continue;
            word = word.trim();
            wordOccurances.put(word, wordOccurances.getOrDefault(word, 0)+1);
        }
        for(String bannedWord : banned){
           // paragraph = paragraph.toLowerCase().replace(bannedWord, "");
            wordOccurances.remove(bannedWord);
        }
        int maxOcc = 0;
        String maxWord = "";

        Set<Map.Entry<String, Integer>> entries = wordOccurances.entrySet();

        for(Map.Entry<String, Integer> entry : entries){
            maxOcc = Math.max(maxOcc, entry.getValue());
            if(maxOcc <= entry.getValue()) maxWord = entry.getKey();

        }

        return maxWord;

    }
}
