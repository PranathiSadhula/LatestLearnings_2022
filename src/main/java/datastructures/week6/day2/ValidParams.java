package datastructures.week6.day2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class ValidParams {
    /**
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     *
     * An input string is valid if:
     *
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * Every close bracket has a corresponding open bracket of the same type.
     *
     *
     * Example 1:
     *
     * Input: s = "()"
     * Output: true
     * Example 2:
     *
     * Input: s = "()[]{}"
     * Output: true
     * Example 3:
     *
     * Input: s = "(]"
     * Output: false
     */

    /**
     * Stack approach :
     * - check if given str.length < 2. if yes return false.
     * - Convert given Str into char array.
     * - Initialize a Stack with CHaracter
     * - Keep adding char if it is matching with open param ==>(,{,[
     * - check if char matches with close param, then pop from stack. ==> should return matching open param,else return false.
     * - this way, stack should be empty.
     * - finally is stack is empty, return true. else false.
     */

    private boolean isvalid(String s){
        if(s.length() < 2) return false;
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c : chars){
            if(c == ']') {
                if(stack.isEmpty() || stack.pop() != '[') return false;
            }
            else if(c == '}'){
                if(stack.isEmpty() || stack.pop() != '{') return false;
            }
            else if(c == ')'){
                if(stack.isEmpty()  || stack.pop() != '(') return false;
            }
            else{
                stack.push(c); //{
            }
        }
        return stack.isEmpty();
    }


    @Test
    public void test(){
        String s = "(}";
        Assert.assertTrue(isvalid(s));
    }


    @Test
    public void test1(){
        String s = ")(){}";
        Assert.assertFalse(isvalid(s));
        Assert.assertFalse(isValid1(s));
    }

    @Test
    public void test3(){
        String s = "[{}()]"; //{}[]()
      //  Assert.assertFalse(isvalid(s));
        Assert.assertFalse(isValid1(s));
    }

    private boolean isValid1(String s) {
        // }
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) { // [{}]
            if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');  // }
            } else if (c == '(') {
                stack.push(')');  //
            } else if (stack.isEmpty() || c != stack.pop()) return false;
        }
        return stack.isEmpty();
    }
}
