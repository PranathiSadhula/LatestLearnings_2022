package datastructures.week7.day2.SpotProblems;

public class JewelsStones {
    /**
     * You're given strings jewels representing the types of stones that are jewels,
     * and stones representing the stones you have. Each character in stones is a type of stone you have.
     * You want to know how many of the stones you have are also jewels.
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
     * - check if jewels.length > 1 else, return 0.
     * - check if stones.length > 1, else return 0.
     * - create a string called nonJewels.
     * - now replace jewels from stones and assgined it to nonJewels.
     * - then return length of stones-nonJewels.
     *
     */

    private int countJewels(String stones, String jewels){
        if(jewels.length() < 1 || stones.length() < 1) return 0;
        String nonJewels = stones.replaceAll("["+jewels+"]","");
        return stones.length()-nonJewels.length();
    }
}
