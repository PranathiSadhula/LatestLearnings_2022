package datastructures.week7.daywise.nov28th;

import org.junit.Test;

public class SquareRootOfNum {
    /**
     * find the square root of given number n=25
     */

    private int findSquareRoot(int num){
        System.out.println(Math.sqrt(num));
        int sqRt = Integer.MIN_VALUE;
        for(int i = 1; i < (num/2)+1; i++){
            if(i*i <= num){
              // return i;
                sqRt = Math.max(sqRt, i);
            }
         }
        return sqRt;
    }

    @Test
    public void test(){
        int num = 8;
        System.out.println(findSqRtByBinarySearch(num));
    }


    private int findSqRtByBinarySearch(int num){
        int low = 0;
        int high = num;

        int sqRt = Integer.MIN_VALUE;
       while(low < high){
           int mid = (low+high)/2;
           if(mid * mid == num){
               return mid;
           }
           else if(mid*mid  < num){
               low = mid+1;
           }
            else{
               high = mid-1;
           }

           sqRt = Math.max(sqRt, mid);
       }

        return sqRt;
    }
}
