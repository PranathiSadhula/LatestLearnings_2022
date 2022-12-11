package datastructures.week9.day1;

public class GroupAnagrams {
    /**
     * Given an array of strings strs, group the anagrams together.
     * You can return the answer in any order.
     * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
     * typically using all the original letters exactly once.
     *
     * Example 1:
     * Input: strs = ["eat","tea","tan","ate","nat","bat"]
     * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     */

    /**
     * - check if given array of strs length <= 1, if yes, return str[].
     * - initialize a map of char, integer to hold each str char occurances.
     * - now, initialize a anagramMap of above map and List of strings as key values.
     * - finally,retrive anagramMap.values and add into an array to return out.
     */

    private String[] groupAnagrams(String[] words){
        if(words.length <= 1) return words;
        return null;
    }
}
