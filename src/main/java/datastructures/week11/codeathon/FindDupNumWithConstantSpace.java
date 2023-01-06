package datastructures.week11.codeathon;

import org.junit.Assert;
import org.junit.Test;

public class FindDupNumWithConstantSpace {
    /**
     * https://leetcode.com/problems/find-the-duplicate-number/
     *
     *
     * - start 2 pointers slow = 0; fast = slow+1
     * - iterate until slow reaches nums.length
     * - check if nums[slow] == nums[fast],if yes return nums[slow]
     * - else increment fast
     * - once fast reaches nums.length,increment slow &  reset fast to slow+1
     *
     */

    private int findDup(int[] nums){
        int slow = 0;
        int fast = slow+1;
        while (slow < nums.length){
            if(nums[slow] == nums[fast++]) return nums[slow];
            if(fast == nums.length){
                slow++;
                fast = slow+1;
            }
        }
        return -1;
    }

    @Test
    public void test(){
        int[] nums = {1,3,4,2,2,10};
        Assert.assertEquals(2, findDupBinarySearch(nums));
    }


    private int findDupBinarySearch(int[] nums){
        int low = 0;
        int high = nums.length-1;

        while(low < high){
            int mid = (low+high)/2;
            if(nums[mid] == nums[low] || nums[mid] == nums[high]) return nums[mid];
            else if(nums[mid] > nums[high]) {
                nums[mid] += nums[high];
                nums[high] = nums[mid] - nums[high];
                nums[mid] = nums[mid] - nums[high];
                high--;
            }
            else if(nums[mid] < nums[low]) {
                nums[mid] += nums[low];
                nums[low] = nums[mid] - nums[low];
                nums[mid] = nums[mid] - nums[low];
                low++;
            }
            else{
                high--;
                low++;
            }
        }

        return -1;
    }
}
