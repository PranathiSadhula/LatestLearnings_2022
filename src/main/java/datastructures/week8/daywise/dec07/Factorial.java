package datastructures.week8.daywise.dec07;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class Factorial {
    /**
     * int n =5
     * 5! = 5*4*3*2*1
     *      (n)*(n-1)*(n-2)(n-3)(n-4)
     *
     */

    /**
     * - initialize fact = 1.
     * - loop until n >=1
     * - keep adding multiplied reslut of n-1 to n-(n-1) to fact
     */

    private int getFactorial(int n){
        int fact = 1;
        while(n > 1){
            fact *= n;
            n--;
        }

        return fact;
    }


    @Test
    public void test(){
        int n = 5;
        Assert.assertEquals(120, getFactorial(n));
    }

    @Test
    public void test1(){
        int n = 100;
        getFactorialOfBigInt(n);
    }

    private String getFactorialOfBigInt(int n){
        BigInteger fact =  BigInteger.ONE;

        while(n > 2){
            fact = fact.multiply(BigInteger.valueOf(n));
            n--;
        }

        return fact.toString();
    }
}
