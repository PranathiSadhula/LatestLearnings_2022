package datastructures.week7.daywise.nov29th;

import org.junit.Test;

public class RemoveDigitNToMakeNumMax {
    /**
     * input = 15958
     * n =5
     * expected output should a max number
     * here 1958 and 1598 are two new nums but 1958 should be returned.
     */


    private int returnMaxNumAfterDigitKRemoved(int num, int K){
        if(num == K) return 0;
        int[] digits = new int[String.valueOf(num).length()];
        int index = digits.length-1;

        int placeValue = 1;
        while(num > 0){
            digits[index] = num % 10;
            num /= 10;
            if(index > 0)
                placeValue *= 10; // 1000
            index--;
        }

        int maxNum = Integer.MIN_VALUE;
        placeValue /= 10;
        int nNum = 0;
        for(int i = 0; i < digits.length; i++){

            int digit = placeValue * digits[i];
            if(digits[i] == K){
                continue;
            }
            nNum += digit;
            placeValue /= 10;
        }

        return maxNum;
    }

    @Test
    public void test(){
        int input = 15958;
        int k = 5;
        returnMaxNumAfterDigitKRemoved(input, k);
    }
}
