package datastructures.week1.daywise.assignments.oct20th;

public class ReverseWords {
/**
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

 

Example 1:

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Example 2:

Input: s = "God Ding"
Output: "doG gniD"
 * 
 */
	
	/**
	 * approach
	 * 
	 * - convert given string into tokens by splitting words based on " ".
	 * 
	 * - iterate through each token to reverse each of them.
	 * 
	 * - to reverse each token, call reverseStr method.
	 * 
	 * - finally return the modified str.
	 * 
	 */
	
	private String reverseWords(String s) {
		String revWords = "";
		String[] tokens = s.split(" ");
		for(String word : tokens) {
			revWords += reverseStr(word)+" ";
		}
		
		return revWords.trim();
	}
	
	
	
	
	/**
	 * approach to reverse a String***
	 * 
	 * - initialise a new string rev.
	 * 
	 * - loop through inputStr starting from lastIndex.
	 * 
	 * - keep adding charAt lastIndex to rev until lastIndex == 0.
	 * 
	 * - finally return the revStr.
	 * 
	 */
	
	private String reverseStr(String str) {
		String rev = "";
		for(int i = str.length() - 1; i >= 0; i--) {
			rev += str.charAt(i)+"";
		}
		return rev;
		
	}
}

