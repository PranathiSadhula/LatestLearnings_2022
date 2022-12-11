package datastructures.week8.day2.recursion;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciSum {
    /**
     * https://leetcode.com/problems/fibonacci-number/
     */

    /**
     * recursion :
     * - for given n, return sum of (n-1)+(n-2)
     * - keep calling fib(n-1)+fib(n-2).
     * - when n reches n == 0 return 0 and n == 1 return 1.
     */
    private int fib(int n){
        int sum = 0;
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        if(n > 1){
           sum = recFib(n);
        }
        return sum;
    }

    private int recFib(int n) {
        if(n == 0) return 0;
        if( n == 1 || n == 2) return 1;
        return recFib(n-1)+ recFib(n-2);
    }
    @Test
    public void test(){
        int n = 3;
        Assert.assertEquals(2, fib(n));
    }




}
