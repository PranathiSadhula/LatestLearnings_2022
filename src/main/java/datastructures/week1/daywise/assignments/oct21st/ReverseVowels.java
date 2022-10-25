package datastructures.week1.daywise.assignments.oct21st;

import org.junit.Assert;
import org.junit.Test;

public class ReverseVowels {
	/**
	 * 
	 * Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

 

Example 1:

Input: s = "hello"
Output: "holle"
Example 2:

Input: s = "leetcode"
Output: "leotcede"
 

Constraints:

1 <= s.length <= 3 * 105
s consist of printable ASCII characters.
	 * 
	 */
	
	@Test
	public void test() {
		String input = "ai";
		String expected = "ia";
		Assert.assertEquals(expected, reverseVowels(input));
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
	 * - in loop check if char at start and last are vowels by checking usinf isCharVowel method. 
	 * 
	 * - if yes -> swap the chars using a temp char on charArray.
	 * 
	 * - else check if char at start is not a vowel -> if yes do nothing but increment start
	 * 
	 * - else decrement last and do nothing.
	 * 
	 * - finally convert this charArray to string and assign back to inputStr to return final value.
	 *
	 */
	
	private String reverseVowels(String input) {
		char[] chars = input.toCharArray();
		int start = 0;
		int last = input.length() - 1;
		
		while(start < last) {
			if(isCharVowel(input.charAt(start)) && isCharVowel(input.charAt(last)) ) {
				char c = input.charAt(last);
				chars[last] = input.charAt(start);
				chars[start] = c;
				start++;
				last--;
			}
			else if(!isCharVowel(input.charAt(start))) {
				start++;
			}
			else {
				last--;
			}
		}
		input = new String(chars);
		return input;
	}
	
	
	
	/**
	 * 
	 * - hold a string containing vowels.
	 * 
	 * - using indexOf char, return true if indexOf c > 0 else false.
	 * 
	 * 
	 */
	
	
	private boolean isCharVowel(char c) {
		
		String vowels = "aeiouAEIOU";
		return vowels.indexOf(c) >= 0 ? true: false;
	
	}

}
