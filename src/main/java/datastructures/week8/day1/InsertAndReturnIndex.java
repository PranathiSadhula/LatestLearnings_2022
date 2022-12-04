package datastructures.week8.day1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class InsertAndReturnIndex {

    /**
     * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
     *
     * You must write an algorithm with O(log n) runtime complexity.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,3,5,6], target = 5
     * Output: 2
     * Example 2:
     *
     * Input: nums = [1,3,5,6], target = 2
     * Output: 1
     * Example 3:
     *
     * Input: nums = [1,3,5,6], target = 7
     * Output: 4
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums contains distinct values sorted in ascending order.
     * -104 <= target <= 104
     */

    /**
     *
     * [1,3,5,6] target = 2 outputIndex = 1
     * low = 0, high = 4-1 = 3, mid = 0+3/2 = 1
     * 2 < 3 ==> high = mid -1; = 0
     * 2 > 1 ==> low = mid + 1; = 1
     *
     *
     * start 3 pointers : low = 0; high = nums.length-1 and mid = low+high/2
     * check if value at mid matches with target ==> return mid as index.
     * else if value at mid < target ==> move low to mid+1
     *      check if val at mid - 1 < target
     *
     *    //1,3,5,7,9 targte = 6
     *    low = 0
     *    high = 4
     *    mid = 2
     *
     * public int searchInsert(int[] nums, int target) {
     *
     *         int low=0, high=nums.length-1, mid=-1;
     *
     *         while(low<=high){
     *             mid= (low+high)/2;
     *
     *             if(nums[mid]==target)return  mid;
     *             else if(nums[mid]> target && nums[mid-1]< target) return mid;
     *             else if(nums[mid]< target && nums[mid+1]> target) return mid;
     *             else if(nums[mid]> target && nums[mid-1]> target) high=mid-1;
     *             else if(nums[mid]< target && nums[mid+1]< target) low=mid+1;
     *         }
     *
     *         return 0;
     *     }
     *
     * from Krishna to everyone in this session:    11:29 AM
     *  public int searchInsert(int[] nums, int target) {
     *
     *         int low=0, high=nums.length-1, mid=-1;
     *
     *         while(low<=high){
     *             mid= (low+high)/2;
     *
     *             if(nums[mid]==target)return  mid;
     *             else if(nums[mid]> target && nums[mid-1]< target) return mid;
     *             else if(nums[mid]< target && nums[mid+1]> target) return mid;
     *             else if(nums[mid]> target ) high=mid-1;
     *             else if(nums[mid]< target ) low=mid+1;
     *         }
     *
     *         return 0;
     *     }
     *
     *
     * Sagar :
     * int left = 0, right=nums.length-1, mid;
     *         while(left<=right){
     *             mid = (left+right)/2;
     *             if(nums[mid]<target){
     *                 if(mid!=nums.length-1 && nums[mid+1]>target) return mid+1;
     *                 else if(mid==nums.length-1 && nums[mid]<target) return mid+1;
     *                 else left=mid+1;
     *             } else if (nums[mid]>target) {
     *                 if(mid!=0 && nums[mid-1]<target) return mid;
     *                 else if(mid==0 && nums[mid]>target) return 0;
     *                 else right=mid-1;
     *             } else if(nums[mid]==target) return mid;
     *         }
     *         return -1;
     */

    private int searchInsertReturnIndex(int[] nums, int target){
        if(nums.length < 1) throw new RuntimeException("invalid input");
        if(nums.length == 1 && nums[0] == target) return 0;
        int low = 0;
        int high = nums.length-1;

        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) low = mid+1;
            else high = mid -1;
        }
        return low;
        }




    @Test
    public void test(){
        int[] nums = {1,3,5,7,9};
        int target = 2;
        Assert.assertEquals(1, searchInsertReturnIndex(nums, target));
    }

    @Test
    public void test1(){
        int[] nums = {1,3,5,7,9};
        int target = 8;
        Assert.assertEquals(4, searchInsertReturnIndex(nums, target));
    }

    @Test
    public void test3(){
        int[] nums = {1,3,5,6};
        int target = 7;
        Assert.assertEquals(4, searchInsertReturnIndex(nums, target));
    }


    private int searchInsertReturnIndexBS(int[] nums, int target){
        int index = Arrays.binarySearch(nums, target);
        return (-1*index)-1;
    }

}
