package datastructures.week4.day2;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class GroupAnagrams {
    /**
     * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
     *
     * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
     *
     *
     *
     * Example 1:
     *
     * Input: strs = ["eat","tea","tan","ate","nat","bat"]
     * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * Example 2:
     *
     * Input: strs = [""]
     * Output: [[""]]
     * Example 3:
     *
     * Input: strs = ["a"]
     * Output: [["a"]]
     *
     *
     * Constraints:
     *
     * 1 <= strs.length <= 104
     * 0 <= strs[i].length <= 100
     * strs[i] consists of lowercase English letters.
     */

    /**
     *
     * - Initialize a hashmap to hold char and occurances of a zeroth word in given array.
     *
     * - initialize a list of list of strings output
     *
     * - start iteration from index 1 (1st word) to add chars and occurance to localmap.
     *
     * - check if hashmap.equals(localmap), if yes add word[i] to ouput.
     *
     * - if not, clear localmap, and repeat the iteratation.
     */


    private List<List<String>> groupAnagrams(String[] words) {
        Map<Map<Character, Integer>, List<String>> hmap = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            HashMap<Character, Integer> lmap = new HashMap();

            for (char c : words[i].toCharArray()) {
                lmap.put(c, lmap.getOrDefault(c, 0) + 1);
            }
            if (hmap.containsKey(lmap)) {
                hmap.get(lmap).add(words[i]);
            } else {
                hmap.put(lmap, Arrays.asList(words[i]));
            }
        }
        List<List<String>> outList = new ArrayList<>();
        outList.addAll(hmap.values());
        return outList;


    }





    /**
     *
     *     /* If String[] is empty, return empty.
     *      * Create a HashMap out with HashMap<Character,Integer> as key and List<String> as value.
     *      * Iterate the input
     *      *   Create a Hashmap and add each item to hashmap.
     *      *   Check if its already in hashmap, if yes get the value of the hashmap and append the current item to the list.
     *      *   else add to HashMap out
     *      * return values of the HashMap
     *      *
     *          Map<Map<Character, Integer>, List<String>> outMap = new HashMap<>();
     *      */

    @Test
    public void test1(){
        String[] words = {"eat","tea","tan","ate","nat","bat"};
        //  List<String> wordList = Arrays.asList("eat","tea","tan","ate","nat","bat");
        System.out.println(returnGroupAnagrams(words));
    }

    private List<List<String>> returnGroupAnagrams(String[] words) {

        if (words.length == 0) return new ArrayList();

        Map<Map<Character, Integer>, List<String>> outMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            HashMap<Character, Integer> lmap = new HashMap();
            for (char c : words[i].toCharArray()) {
                lmap.put(c, lmap.getOrDefault(c, 0) + 1);
            }
            if (outMap.containsKey(lmap)) {
                outMap.get(lmap).add(words[i]);
             /*   List<String> matchedWord = outMap.get(lmap);
                matchedWord.add(words[i]);

              */
            } else {
                outMap.put(lmap, Arrays.asList(words[i]));
               /*
                List<String> tList = new ArrayList<>(Arrays.asList(words[i]));
                 outMap.put(lmap, tList);
                */

            }


        }

        List<List<String>> outList = new ArrayList<>();
        outList.addAll(outMap.values());

        return outList;
    }

}
