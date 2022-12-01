package datastructures.week7.day1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class MakeStringGreat {
/**
 * Given a string s of lower and upper case English letters.
 *
 * A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:
 *
 * 0 <= i <= s.length - 2
 * s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
 * To make the string good, you can choose two adjacent characters that make the string bad and remove them. You can keep doing this until the string becomes good.
 *
 * Return the string after making it good. The answer is guaranteed to be unique under the given constraints.
 *
 * Notice that an empty string is also good.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leEeetcode"
 * Output: "leetcode"
 * Explanation: In the first step, either you choose i = 1 or i = 2, both will result "leEeetcode" to be reduced to "leetcode".
 * Example 2:
 *
 * Input: s = "abBAcC"
 * Output: ""
 * Explanation: We have many possible scenarios, and all lead to the same answer. For example:
 * "abBAcC" --> "aAcC" --> "cC" --> ""
 * "abBAcC" --> "abBA" --> "aA" --> ""
 * Example 3:
 *
 * Input: s = "s"
 * Output: "s"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 100
 * s contains only lower and upper case English letters.
 */


    private String makeStrGreat(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
     //   for(char c : chars) stack.push(c);

        for(int i = 0; i < chars.length; i++){
            if(!stack.isEmpty() && Character.isLowerCase(chars[i]) && stack.peek() ==  Character.toUpperCase(chars[i])){
                stack.pop();
            }
            else if(!stack.isEmpty() &&  Character.isUpperCase(chars[i]) && stack.peek() ==  Character.toLowerCase( chars[i])){
                stack.pop();
            }
            else{
                stack.push(chars[i]);
            }
        }
        StringBuffer output = new StringBuffer();
        while(!stack.isEmpty()){
            output.append(stack.pop());
        }

        return output.reverse().toString();
    }


    @Test
    public void test(){
        String s = "lEeetcCodEe";
        Assert.assertEquals("letod", makeStrGreat(s));
    }


    @Test
    public void test1(){
        String s = "leEeetcode";
        Assert.assertEquals("leetcode", makeStrGreatAsciiAbsDiff(s));
    }


    //using Ascii
    private String makeStrGreatAsciiAbsDiff(String s){

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        //   for(char c : chars) stack.push(c);

        for(char c : chars){
            if(!stack.isEmpty() && Math.abs(stack.peek() - c) == 32){
                stack.pop();
            }
            else{
                stack.push(c);
            }
        }


        StringBuffer output = new StringBuffer();
        while(!stack.isEmpty()){
            output.append(stack.pop());
        }

        return output.reverse().toString();
    }
}
