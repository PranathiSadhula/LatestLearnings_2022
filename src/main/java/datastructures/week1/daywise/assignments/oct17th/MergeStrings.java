package datastructures.week1.daywise.assignments.oct17th;

import org.junit.Test;

public class MergeStrings {
	/**
	 * You are given two strings word1 and word2. 
	 * Merge the strings by adding letters in alternating order, starting with word1. 
	 * If a string is longer than the other, append the additional letters onto the end of the merged string.

Return the merged string.

 

Example 1:

Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r
Example 2:

Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
Explanation: Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b 
word2:    p   q   r   s
merged: a p b q   r   s
Example 3:

Input: word1 = "abcd", word2 = "pq"
Output: "apbqcd"
Explanation: Notice that as word1 is longer, "cd" is appended to the end.
word1:  a   b   c   d
word2:    p   q 
merged: a p b q c   d
 

Constraints:

1 <= word1.length, word2.length <= 100
word1 and word2 consist of lowercase English letters.
	 */

	
	/**
	 * Questns to ask :
	 * 
	 * - 
	 */
	
	/**
	 * approach :
	 * 
	 *  
	 * - start index = 0.
	 * 
	 * - traverse through shortest string and keep adding chars to outString at index from both strs.
	 * 
	 * - once traversing reaches shortest string.length, --> add remaining chars from longest string to outString.
	 */
	
	
	private String mergeStrings(String word1, String word2) {
		String output = new String();
		
		int start = 0;
		int end = word1.length() < word2.length() ? word1.length() : word2.length();
		
		while(start < end) {
			output = output+word1.charAt(start)+word2.charAt(start);
			start++;
			
		}
		String remStr = word1.length() < word2.length()? word2.substring(start) : word1.substring(start);
		
		output += remStr ;
		return output;
		
	}
	
	
	@Test
	public void test() {
		System.out.println(mergeStrings("abcd","pqrs"));
	}
}
