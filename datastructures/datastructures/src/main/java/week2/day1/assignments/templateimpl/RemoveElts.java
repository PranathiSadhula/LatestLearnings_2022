package week2.day1.assignments.templateimpl;

import java.util.Arrays;

import org.junit.Test;

public class RemoveElts {
	/**
	 * Given an integer array nums and an integer val, remove all occurrences of val
	 * in nums in-place. The relative order of the elements may be changed.
	 * 
	 * Since it is impossible to change the length of the array in some languages,
	 * you must instead have the result be placed in the first part of the array
	 * nums. More formally, if there are k elements after removing the duplicates,
	 * then the first k elements of nums should hold the final result. It does not
	 * matter what you leave beyond the first k elements.
	 * 
	 * Return k after placing the final result in the first k slots of nums.
	 * 
	 * Do not allocate extra space for another array. You must do this by modifying
	 * the input array in-place with O(1) extra memory.
	 * 
	 * Custom Judge:
	 * 
	 * The judge will test your solution with the following code:
	 * 
	 * int[] nums = [...]; // Input array int val = ...; // Value to remove int[]
	 * expectedNums = [...]; // The expected answer with correct length. // It is
	 * sorted with no values equaling val.
	 * 
	 * int k = removeElement(nums, val); // Calls your implementation
	 * 
	 * assert k == expectedNums.length; sort(nums, 0, k); // Sort the first k
	 * elements of nums for (int i = 0; i < actualLength; i++) { assert nums[i] ==
	 * expectedNums[i]; }
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [3,2,2,3], val = 3 Output: 2, nums = [2,2,_,_] Explanation:
	 * Your function should return k = 2, with the first two elements of nums being
	 * 2. It does not matter what you leave beyond the returned k (hence they are
	 * underscores). Example 2:
	 * 
	 * Input: nums = [0,1,2,2,3,0,4,2], val = 2 Output: 5, nums = [0,1,4,0,3,_,_,_]
	 * Explanation: Your function should return k = 5, with the first five elements
	 * of nums containing 0, 0, 1, 3, and 4. Note that the five elements can be
	 * returned in any order. It does not matter what you leave beyond the returned
	 * k (hence they are underscores).
	 * 
	 * 
	 * Constraints:
	 * 
	 * 0 <= nums.length <= 100 0 <= nums[i] <= 50 0 <= val <= 100
	 * 
	 * 
	 * 
	 */
	//@Test
	public void test() {

		int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
		int valToRemove = 2;
		int[] expected = { 0, 1, 3, 0, 4, -1 - 1, -1 };
		removeEltWith2Pointer(nums, valToRemove);
		/*
		 * System.out.println(Arrays.toString(nums)); int k =
		 * returnKEltsAfterRemovingDuplicates(nums, valToRemove);
		 * System.out.println(Arrays.toString(nums));
		 * System.out.println(Arrays.toString(Arrays.copyOf(nums, k + 1)));
		 */

	}
	@Test
	public void test1() {

		int[] nums = { 3,3 };
		int valToRemove = 3;
		int[] expected = { };
		removeEltWith2Pointer(nums, valToRemove);
		/*
		 * System.out.println(Arrays.toString(nums)); int k =
		 * returnKEltsAfterRemovingDuplicates(nums, valToRemove);
		 * System.out.println(Arrays.toString(nums));
		 * System.out.println(Arrays.toString(Arrays.copyOf(nums, k + 1)));
		 */

	}
	public void test2() {

		int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
		int valToRemove = 5;
		int[] expected = { 0, 1, 2, 2, 3, 0, 4, 2 };
	}

	public void test3() {

		int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
		int valToRemove = 5;
		int[] expected = { 0, 1, 2, 2, 3, 0, 4, 2 };
	}

	// @Test
	public void test4() {

		int[] nums = { 3, 2, 2, 3 };
		int valToRemove = 3;
		int[] expected = { 2, 2, -1, -1 };
		System.out.println(Arrays.toString(nums));
		int k = returnKEltsAfterRemovingDuplicates(nums, valToRemove);
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(Arrays.copyOf(nums, k + 1)));

	}
	/**
	 * pseudo code with 2 pointer
	 * 
	 * 1.initialise 2 pointers : start = 0 and end = length - 1.
	 * 
	 * 2.initialise matchesFound to 0.
	 * 
	 * 3.iterate through array until start < end.
	 * 
	 *  	- check if elt at start index and end index matches with val.
	 *  			-> if yes -> do nothing to start but decrement end index.
	 *              -> increment matchesFound as there is a match
	 *  	- check if elt at start matches with val & elt at end doesnt match .
	 *  			-> if yes -> swap values and increament start, decrement end.
	 *  			-> increment matchesFound as there is a match.
	 *  
	 *  	- check if elt at start and end doesnt match with val.
	 *  			-> if yes -> increment start but do nothing to end.
	 *      - check if elt at start doesnt match but elt at end match
	 *      		-> if yes -> increment start, decrment end.
	 *      		-> increment matchesFound as there is a match.
	 *    
	 *  4. finally return matchesFound.  
	 * 
	 */
	
	public void removeEltWith2Pointer(int[] nums, int val) {
		int start = 0;
		int end = nums.length-1;
		int matchesFound = 0;
		while (start <= end) {
			if (nums[start] == val && nums[end] == val) {
				end--;
				matchesFound++;
			}
			else if (nums[start] == val && nums[end] != val) {
				nums[start] = nums[start] + nums[end];
				nums[end] = nums[start] - nums[end];
				nums[start] = nums[start] - nums[end];
				start++;
				end--;
				matchesFound++;

			}
			else if (nums[start] != val && nums[end] != val) {
				start++;
			}
			else if (nums[start] != val && nums[end] == val) {
				start++;
				end--;
				matchesFound++;
			}
		}
		System.out.println(matchesFound);
		System.out.println(Arrays.toString(Arrays.copyOf(nums, nums.length-1 - matchesFound)));
	}
	
	public int xyz(int[] nums, int val) {
		int index=0;
        for(int i=0;i<nums.length;i++){
            int temp=0;
            if(nums[i]!=val){
                temp=nums[index];
                nums[index++]=nums[i];
                nums[i]=temp;
            }
        }
        
        return Arrays.copyOfRange(nums,0,index).length;
	}
	
public int removeElementShivaram(int[] nums, int val) {
        

        int count=0; 
		//if(nums.length==1) return nums[0];

        for(int i=0; i< nums.length; i++)
        {
            if(nums[i]!=val)
            {
             nums[count]=nums[i];
             count++;
            }
        }
        return count;
    }
	

	/**
	 * pseduo code :
	 * 
	 * 1. create an output array with length of input array and fill with -1 as
	 * default values.
	 * 
	 * 2. start outIndex from 0.
	 * 
	 * 3. travesre input array from i = 0 to input.length
	 * 
	 * 4. check if elt at index i is not matching with valToRemove -if doesnt
	 * matches -> add it into output array at outIndex and increment outIndex. - if
	 * does match -> do nothing.
	 * 
	 * 5.finally override input array with output array.
	 * 
	 * 6.return outIndex.
	 */
	private int returnLengthOfArrayAfterRemovingDuplicates(int[] nums, int valToRemove) {
		int[] output = new int[nums.length];
		Arrays.fill(output, -1);
		int outndex = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != valToRemove)
				output[outndex++] = nums[i];
		}
		nums = output;
		return outndex;
	}

	/**
	 * psuedo code
	 * 
	 * 1.use 2 loops
	 * 
	 * 2. first loop to iterate through all elts starting from i = 0 to
	 * input.length.
	 * 
	 * 3. second loop to check if the elt matches with given valToRemove. -> if
	 * matches, swap with last elt in input. -> if doesnt matches, do nothing.
	 */

	private int returnKEltsAfterRemovingDuplicates(int[] nums, int valToRemove) {
			//[0, 1, 2, 2, 3, 0, 4, 2]
		//[0,1,3,0,4]
		int matchesFound = 0;
		int start = 0;
		int last = nums.length - 1;
		boolean stop = false;

		for (int i = start; i < nums.length; i++) {
			if (stop)
				break;

			for (int j = last; j > 0; j--) {
				if (nums[i] == valToRemove && nums[j] == valToRemove) {
					//nums[j] = -1;
					matchesFound++;
				} else if (nums[i] != valToRemove && nums[j] != valToRemove) {
					start++;
					break;
				} else if (nums[i] != valToRemove && nums[j] == valToRemove) {
				//	nums[j] = -1;
					matchesFound++;
					last--;
					break;
				} else if (nums[i] == valToRemove && nums[j] != valToRemove) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
					matchesFound++;
					break;
				} else if (i == j) {
					stop = true;
					break;
				}
			}
		}
		return nums.length - matchesFound;
	}

}
