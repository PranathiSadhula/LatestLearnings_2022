package datastructures.week3.daywise.assignments.nov2nd;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class majorityElt {
    /**
     * Given an array nums of size n, return the majority element.
     *
     * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [3,2,3]
     * Output: 3
     * Example 2:
     *
     * Input: nums = [2,2,1,1,1,2,2]
     * Output: 2
     *
     *
     * Constraints:
     *
     * n == nums.length
     * 1 <= n <= 5 * 104
     * -109 <= nums[i] <= 109
     *
     */

    /**
     * approach :
     *
     * - initialize expectedOccOfMajorityElt = nums.length/2
     *
     * - initialize hashmap to hold elt and its occurances
     *
     * - iterate through nums starting from i = 0 to nums.length
     *
     *      - for each elt, keep adding itself and its occurances in map
     *
     * - now, after map generated, iterate through map to get that elt whose value is greater than expectedOccOfMajorityElt
     *
     * - finally return above elt.
     *
     *
     */

    private int getMajorityElt(int[] nums){
        int expectedOccOfMajorityElt = nums.length/2;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > expectedOccOfMajorityElt) return entry.getKey();
        }

        throw new RuntimeException("Invalid testcase");
    }
}
