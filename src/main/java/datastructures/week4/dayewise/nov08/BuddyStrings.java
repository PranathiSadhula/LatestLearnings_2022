package datastructures.week4.dayewise.nov08;

import org.junit.Test;

public class BuddyStrings {

    /**
     * Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal,
     *  otherwise, return false.
     *
     * Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].
     *
     * For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
     *6
     *
     * Example 1:
     *
     * Input: s = "ab", goal = "ba"
     * Output: true
     * Explanation: You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.
     * Example 2:
     *
     * Input: s = "ab", goal = "ab"
     * Output: false
     * Explanation: The only letters you can swap are s[0] = 'a' and s[1] = 'b', which results in "ba" != goal.
     * Example 3:
     *
     * Input: s = "aa", goal = "aa"
     * Output: true
     * Explanation: You can swap s[0] = 'a' and s[1] = 'a' to get "aa", which is equal to goal.
     *
     *
     * Constraints:
     *
     * 1 <= s.length, goal.length <= 2 * 104
     * s and goal consist of lowercase letters.
     */

    /**
     * - Check if 2 strings are of same length, if not return false.
     * - start iteration from i = 0 to s.length and inner iteration from j = s.length to 0.
     * - swap the s.charAt[i] and s.charAt[j] and check if equals to goal.
     * - if yes, return true.
     * - finally return false.
     *
     */

    private boolean checkBuddyStrs(String s, String goal){
        if(s.length() != goal.length()) return false;

        for(int i = 0; i < s.length(); i++){

            for(int j = s.length()-1; j >= 0; j--){
                char[] chrStr = s.toCharArray();
                char temp = chrStr[i];
                chrStr[i] = chrStr[j];
                chrStr[j] = temp;
                if(new String(chrStr).equals(goal)) return true;

            }
        }

        return false;
    }

    @Test
    public void test(){
        String s = "abcd";
        String goal = "cbad";
        checkBuddyStrs(s, goal);
    }
}
