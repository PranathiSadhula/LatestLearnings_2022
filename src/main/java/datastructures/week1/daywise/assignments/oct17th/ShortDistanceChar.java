package datastructures.week1.daywise.assignments.oct17th;

import org.junit.Assert;
import org.junit.Test;

public class ShortDistanceChar {
	/**
	 * Given a string s and a character c that occurs in s,
	 * return an array of integers answer where answer.length == s.length 
	 * and answer[i] is the distance from index i to the closest occurrence of character c in s.

The distance between two indices i and j is abs(i - j), where abs is the absolute value function.

 

Example 1:

Input: s = "loveleetcode", c = "e"
Output: [3,2,1,0,1,0,0,1,2,2,1,0]
Explanation: The character 'e' appears at indices 3, 5, 6, and 11 (0-indexed).
The closest occurrence of 'e' for index 0 is at index 3, so the distance is abs(0 - 3) = 3.
The closest occurrence of 'e' for index 1 is at index 3, so the distance is abs(1 - 3) = 2.
For index 4, there is a tie between the 'e' at index 3 and the 'e' at index 5, but the distance is still the same: abs(4 - 3) == abs(4 - 5) = 1.
The closest occurrence of 'e' for index 8 is at index 6, so the distance is abs(8 - 6) = 2.
Example 2:

Input: s = "aaab", c = "b"
Output: [3,2,1,0]
 

Constraints:

1 <= s.length <= 104
s[i] and c are lowercase English letters.
It is guaranteed that c occurs at least once in s.
	 */

	
	@Test
	public void test() {
		String inputStr = "lowercase";
		char c = 'e';
		int[] expectedDistancesFromChar = {3,2,1,0, 1,2,2,1,0};
		//getDistances(inputStr, c);
		Assert.assertArrayEquals(expectedDistancesFromChar,shortestDist(inputStr, c));
	}
	
	/**
	 * 
	 * 
	 * - create an output array with length as str.length.
	 * 
	 * - initialise 2 pointers : 
	 * 
	 * 		firstIndex with first occuring index of char in given str.
	 * 		nextIndex with first occuring index of char in subStr of str starting from firstIndex to length of str.
	 * 
	 * - do a check if nextIndex value is greater than 0(as if no occurances found indexOf returns -val).
	 * 
	 * 	- nextIndex is less thn 0 then assign firstIndex to nextIndex. 
	 * 
	 * - loop through the string for each char
	 * 
	 *  -- keep adding min value of abs of subtraction of current char index with firstIndex and nextIndex.
	 */
	
	private int[] getDistances(String str, char c) {  //lowercase c = e
		int[] output = new int[str.length()];
	
		int firstIndex = str.indexOf(c); //rcas 
		int nextIndex = str.indexOf(c, firstIndex+1); //-1
		
		nextIndex = nextIndex < 0 ? firstIndex : nextIndex;  
	
		for(int i = 0; i < str.length(); i++) {

			if(str.charAt(i) == c) {
				
				firstIndex = i;
				nextIndex = str.indexOf(c, firstIndex+1);
				nextIndex = nextIndex < 0 ? firstIndex : nextIndex;
				
			}
			else {
				output[i] = Math.min(Math.abs(firstIndex - i), Math.abs(nextIndex - i));
			}
			
		}
		
		return output;
	}
	
	
	/**
	 * 2nd approach //String = loveleetcode c= e
	 * 
	 * - create an outputArray with length of string.
	 * 
	 * - initialise pointer p = length.
	 * 
	 * - loop over String  from i = 0
	 * 
	 * - check if char at index i is matching char c
	 *  
	 *  - if yes ->  set p with 0 add update outputArray with p=0
	 *  
	 *  - else add p++ to outputArray 
	 *  
	 *  - after above loop, set p = length.
	 *  
	 *  - loop over string from i = length till 0.
	 *  
	 *  - check if char at index i is matching char c
	 *  
	 *  - if yes -> set p with 0 add update outputArray with p=0
	 *  
	 *  - if not - > take min value btw value at i and p++
	 *  
	 *  - finally return outputArray
	 */
	
	private int[] shortestDist(String s, char c) {
		
		int[] output = new int[s.length()];
		
		int distance = s.length();
		
		for(int start = 0;start < s.length(); start++) {
			if(s.charAt(start) == c) {
				distance = 0;
			}
			output[start] = distance++;
		}
		
		 distance = s.length();
		 for(int last = s.length()-1; last >= 0; last--) {
			 if(s.charAt(last) == c) {
					distance = 0;
				}
			 output[last] = Math.min(output[last],  distance++);
		 }
		 
		 return output;
		
	}
	
	
}
