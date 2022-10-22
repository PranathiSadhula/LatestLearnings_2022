package week2.daywise.assignments.oct19th;

import java.util.HashMap;
import java.util.HashSet;

import org.junit.Test;

public class LongPressedChar {

	/**
	 * 
	 * Your friend is typing his name into a keyboard. Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.

You examine the typed characters of the keyboard. Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.

 

Example 1:

Input: name = "alex", typed = "aaleex"
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.
Example 2:

Input: name = "saeed", typed = "ssaaedd"
Output: false
Explanation: 'e' must have been pressed twice, but it was not in the typed output.
 

Constraints:

1 <= name.length, typed.length <= 1000
name and typed consist of only lowercase English letters.
	 * 
	 */
	
	
	/*
	 * pseudo code
	 * 
	 * - check size of 2 strs : name and typed
	 * 
	 * - if name.size > typed.size return false.
	 * 
	 * - sizes are equal and name == typed return true.
	 * 
	 * - else check if each char in name is present no.OfTimesOccuredInName or more times in typed. if yes return true. 
	 * 
	 * saeed 
	 * 
	 *  a - 1 e =2 d 1 s 1
	 *  
	 *  
	 *  sssaeddd
	 *  
	 *  
	 *  s = -2 a  = 0  e = 1  d -2
	 */
	
	@Test
	public void test() {
		String name = "alex";
		String typed = "aaleexa";
		isTypedAName(name, typed);
				
	}
	
	
	
	private boolean isTypedAName(String name, String typed)
	{
		if(name.length() > typed.length()) return false;
		
		if(name.length() == typed.length() && !name.equals(typed)) return false;
		
	//	HashMap<Character, Integer> charOccurs = new HashMap<Character, Integer>();
		
		int[] chars = new int[26];
		
		for(int i = 0; i < name.length(); i++) {
		//	charOccurs.put(name.charAt(i), charOccurs.getOrDefault(name.charAt(i), 1)+1);
		
			chars[name.charAt(i) - 'a']++;
		}
		int nIndex = 0;
		for(int j = 0; j < typed.length(); j++) {
			chars[typed.charAt(j) - 'a']--;
			
			if(!typed.substring(j+1).contains(name.charAt(nIndex)+"") && chars[name.charAt(nIndex) - 'a'] > 0)
				return false;
			nIndex++;
		}
		
		
		return true;
	}
}
