package week2.daywise.assignments.oct21st;

import org.junit.Test;

public class ReverseLetters {

	/**
	 * 
	 * Given a string s, reverse the string according to the following rules:

All the characters that are not English letters remain in the same position.
All the English letters (lowercase or uppercase) should be reversed.
Return s after reversing it.

 

Example 1:

Input: s = "ab-cd"
Output: "dc-ba"
Example 2:

Input: s = "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:

Input: s = "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"
 

Constraints:

1 <= s.length <= 100
s consists of characters with ASCII values in the range [33, 122].
s does not contain '\"' or '\\'.
	 */
	
	@Test
	public void test() {
		String s = "ab-cd";
		System.out.println(reverseLetters(s));
	}
	
	/**
	 * approach :
	 * 
	 * - convert given inputStr into charArray.
	 * 
	 * - initialise 2 pointers : start = 0 and last = inputStr.length - 1.
	 * 
	 * - loop until start < last
	 * 
	 * - in loop check if char at start and last are letters using Character.isLetter method.
	 * 
	 * - if yes -> swap the chars using a temp char on charArray.
	 * 
	 * - else check if char at start is not a letter -> if yes do nothing but increment start
	 * 
	 * - else decrement last and do nothing.
	 * 
	 * - finally convert this charArray to string and assign back to inputStr to return final value.
	 *
	 */
	private String reverseLetters(String inputStr) {
		char[] chars = inputStr.toCharArray();
		int start = 0;
		int last = inputStr.length() - 1;
		while(start < last) {
			if(Character.isLetter(inputStr.charAt(start)) && Character.isLetter(inputStr.charAt(last))) {
				char c = inputStr.charAt(last);
				chars[last] = inputStr.charAt(start);
				chars[start] = c;
				start++;
				last--;
			}
			else if (!Character.isLetter(inputStr.charAt(start))) {
				start++;
			}
			else {
				last--;
			}
			
			
		}
		inputStr = new String(chars);
		return inputStr;
	}
}
