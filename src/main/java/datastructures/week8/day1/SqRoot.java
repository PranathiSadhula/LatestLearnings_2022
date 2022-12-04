package datastructures.week8.day1;

import org.junit.Assert;
import org.junit.Test;

public class SqRoot {
    /**
     * Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
     * The returned integer should be non-negative as well.
     *
     * You must not use any built-in exponent function or operator.
     *
     * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
     *
     *
     * Example 1:
     *
     * Input: x = 4
     * Output: 2
     * Explanation: The square root of 4 is 2, so we return 2.
     * Example 2:
     *
     * Input: x = 8
     * Output: 2
     * Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
     *
     *
     * Constraints:
     *
     * 0 <= x <= 231 - 1
     */

    /**
     * - check if given num == 0, return 0
     * - check if given num == 1, return 1.
     * - initialize int sqRoot = Integer_MinValue;
     * - start iteration starting from i = 0 to num/2
     * - check if i*i <= num then using Math.max hold on to either sqRoot or i.
     * - finally return sqRoot value.
     */
    @Test
    public void test1(){
        int num = 4;
        Assert.assertEquals(2, getSqRt(num));
    }
    private int getSqRt(int num){
        if(num == 0) return 0;
        if(num == 1) return 1;
        int sqRt = 0;
        for(int i = 1; i < num/2; i++){
            if(i <= num/i) {
                sqRt = i;//Math.max(sqRt, i);
            }
        }
        return sqRt;
    }


    /**
     * Binary Search :
     * - check if given num == 0, return 0
     * - check if given num == 1, return 1.
     * - start 2 pointers low = 0, high = num/2.
     * - in a loop until low < high,
     * - calculate mid = low+high/2
     * - check if mid * mid == num, return mid.
     * - else if mid* mid < num, move high to mid-1
     * - else if mid*mid > num, move low to mid +1
     * - finally return low.
     */

    private int returnSqRt(int num){
        if(num == 0) return 0;
        if(num <= 3) return 1;
        int low = 1;
        int high = num/2+1;
        int sqRt = 0;
        int mid = 0;
        while(low <= high){
            mid = (low+high)/2;
            if(mid  <= num/mid) {
                sqRt = mid;
                low = mid + 1;
            }
            else high = mid-1;
        }
        return sqRt;
    }


    private int returnSqRtLong(int num){
        if(num == 0) return 0;
        if(num <= 3) return 1;
        long low = 1;
        long high = num/2+1;
        long sqRt = 0;
        long mid = 0;
        while(low <= high){
            mid = (low+high)/2;
            if(mid *mid <= num) {
                sqRt = mid;
                low = mid + 1;
            }
            else high = mid-1;
        }
        return (int)sqRt;
    }

    @Test
    public void test(){
        int num = 2147395599;
        Assert.assertEquals(46339, returnSqRtLong(num));
    }

}
