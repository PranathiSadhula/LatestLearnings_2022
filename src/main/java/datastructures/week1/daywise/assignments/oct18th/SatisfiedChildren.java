package datastructures.week1.daywise.assignments.oct18th;

import org.junit.Test;

import junit.framework.Assert;

public class SatisfiedChildren {
	/**
	 * Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.

Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with; and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.

 

Example 1:

Input: g = [1,2,3], s = [1,1]
Output: 1
Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3. 
And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
You need to output 1.
Example 2:

Input: g = [1,2], s = [1,2,3]
Output: 2
Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2. 
You have 3 cookies and their sizes are big enough to gratify all of the children, 
You need to output 2.
 

Constraints:

1 <= g.length <= 3 * 104
0 <= s.length <= 3 * 104
1 <= g[i], s[j] <= 231 - 1
	 */

	
	
	//@Test
	public void test() {
		int[] greedFactorForEachChild = {2,1,1,1};
		int[] cookieSize = {1,2};
		
		int expectedSatisfiedChild = 2;
		
		Assert.assertEquals(expectedSatisfiedChild, getSatisfiedChilds(greedFactorForEachChild, cookieSize));
		
		
	}
	



		
		@Test
		public void test1() {
			int[] greedFactorForEachChild = {10,9,8,7};
			int[] cookieSize = {5,6,7,8};
			
			int expectedSatisfiedChild = 2;
			
			Assert.assertEquals(expectedSatisfiedChild, getSatisfiedChildsFor(greedFactorForEachChild, cookieSize));
			
			
		}
	
	/**
	 *  - initialise satisfiedKids = 0;
	 *  
	 *  - initialize 2 pointers : greed = 0. cookie = 0.
	 *  
	 *  - iterate through 2 arrays until greed < greedFactorForEachChild.length && cookie < cookieSize.length
	 *  
	 *  - check if greedFactor <= cookieSize
	 *  
	 *  	- if yes -> increment satisfiedKids.
	 *  
	 *      - if no ->  check if greedFactor > cookies --> then move cookie
	 * 		
	 * 							else  --> move greed
	 *
	 * 
	 * 	 
	 **/
	

	private int getSatisfiedChilds(int[] greedFactor, int[] cookieSize) {
		 int noOfSatisfiedKids = 0;
			
			int greed = 0; 
			int cookie = 0;
			
			while(greed < greedFactor.length && cookie < cookieSize.length) {
				
				if(greedFactor[greed] <= cookieSize[cookie]) {
					noOfSatisfiedKids++;
					greed++;
					cookie++;
				}
				else if(cookieSize[cookie] < greedFactor[greed]) {
					greed++;
				}
				else {
					cookie++;
				}
				
			}
			
			return noOfSatisfiedKids;
	}
	

	
	private int getSatisfiedChildsFor(int[] greedFactor, int[] cookieSize) {
		 int noOfSatisfiedKids = 0;

		 for(int gIndx = 0; gIndx < greedFactor.length; gIndx++) { //o[n]
				
				for(int cIndx = 0; cIndx < cookieSize.length; cIndx++) { //o[m]
					if(greedFactor[gIndx] <= cookieSize[cIndx]) {
						noOfSatisfiedKids++;
						greedFactor[gIndx] = Integer.MAX_VALUE;
						cookieSize[cIndx] = Integer.MIN_VALUE;
					}
				}
			}
			
			return noOfSatisfiedKids;
	}
	

	
	
	
	
}
