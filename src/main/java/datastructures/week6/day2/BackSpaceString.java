package datastructures.week6.day2;

import datastructures.week6.day1.singleLL.Node;
import org.junit.Test;

import java.util.Stack;

public class BackSpaceString {
    /**
     * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
     *
     * Note that after backspacing an empty text, the text will continue empty.
     *
     *"y#fo##f"
     * "y#f#o##f"
     *
     * Example 1:
     *
     * Input: s = "ab#c", t = "ad#c"
     * Output: true
     * Explanation: Both s and t become "ac".
     * Example 2:
     *
     * Input: s = "ab##", t = "c#d#"
     * Output: true
     * Explanation: Both s and t become "".
     * Example 3:
     *
     * Input: s = "a#c", t = "b"
     * Output: false
     * Explanation: s becomes "c" while t becomes "b".
     *
     *
     * Constraints:
     *
     * 1 <= s.length, t.length <= 200
     * s and t only contain lowercase letters and '#' characters.
     */

    @Test
    public void test(){
        String s = "y#fo##f"; //f
        String t = "y#f#o##f"; //f
        backSpaceStrStack(s, t);
    }

    private boolean backSpaceStrStack(String s, String t){
       char[] sChars = s.toCharArray();
        Stack<Character> sStack = new Stack<>();
        String finalSStr = "";
        for(char c : sChars){
            if( c == '#' ) {
                if (!sStack.isEmpty()) sStack.pop();
            } else{
                sStack.push(c);
            }
        }

        char[] tChars = t.toCharArray();
        Stack<Character> tStack = new Stack<>();
        for(char c : tChars){
            if( c == '#' ){
                if(!tStack.isEmpty())
                    tStack.pop();
            }
            else{
                tStack.push(c);
            }
        }


        return sStack.equals(tStack);
    }
    /**
     * - LinkedList Approach :
     * - convert given strings into 2 linked lists (SingleLL)
     * - for each list, remove elt(char) appear before # and remove elt  matching #.
     * - finally compare the lists. if matches return true.
     */

    public boolean backSpaceCompareStr(String s, String t){

        char[] sChars = s.toCharArray();
        Node sHead = null ;
        for(char c : sChars){
            if(c == '#'){
                if(sHead != null){
                    backSpaceChar();
                }
            }
            else
            sHead = add(c);
        }
        char[] tChars =  t.toCharArray();
        Node tHead = null;
         for(char c : tChars){
             if(c == '#'){
                 if(tHead != null){
                     backSpaceChar();
                 }
             }
             else
                 tHead = add(c);
        }
        return tHead.equals(sHead);
    }


   Node head;
   Node tail;
   int length;



    public Node add(char input) {
        if (tail == null) {
            Node temp = new Node(input);
            tail = temp;
            head = temp;
        } else {
            Node temp = new Node(input);
            tail.nextNode = temp;
            tail = temp;
        }
        length++;

        return head;
    }

    public void backSpaceChar(){
        Node temp = head;
        while (temp.nextNode!= null){
            if(temp.nextNode.nextNode == null){
                temp.nextNode = null;  //1,2,3,5
                length--;
            }
            tail.nextNode = temp;
            tail = temp;
            if(temp.nextNode == null) return;

            }
    }




    class Node {
        char nodeChar;
       Node nextNode;
        Node(char nodeChar) {
            this.nodeChar = nodeChar;
            this.nextNode = null;
        }
    }

}
