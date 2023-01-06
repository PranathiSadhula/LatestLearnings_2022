package datastructures.week7.daywise.nov28th;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RotateNumberByK {
    /**
     * int n=1234;
     *         int k=1; rotate the number k times
     *         output = 2341
     */

    /**
     * - convert given num into digits.
     * -
     */

    private int rotateNumBykDigits(int num, int k){

        int sign = 1;
        if(num < 0) sign =-1;
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
        System.out.println(Arrays.toString(digits));


        for(int i = 0; i < k; i++){
            for(int j = 0; j < digits.length-1; j++){
                int temp = digits[j];
                digits[j] = digits[j+1];
                digits[j+1] = temp;
            }
        }
        int newNum = 0;
        for(int i = 0; i < digits.length; i++){
            int curDigit =  placeValue * digits[i];
            newNum +=curDigit;
            placeValue /= 10;
        }

        int div=1, count=1;
        while (num/div>=10){
            div=div*10;
            count++;
        }

        System.out.println(newNum);




        Arrays.stream(digits).forEach(value -> System.out.println(value));


        int[] nums1 = new int[10];
        System.out.println(Arrays.toString(nums1));
        Arrays.fill(nums1, 100);
        int[] arr = IntStream.range(0,13).toArray();
        int[] arr2 = IntStream.range(0,13).toArray();

        int[] fin = new int[26];


        System.out.println(Arrays.toString(IntStream.range(0,11).toArray()));


        return newNum;
    }

    private int shiftDigit(int n, int k){
        String result="";
        String digit=String.valueOf(n);
        String toBeRotated=digit.substring(0,k);
        String remainingDigits=digit.substring(k);
        result+=remainingDigits+toBeRotated;
        return Integer.valueOf(result);
    }

    @Test
    public void test(){
        int num = 123400;
        int k = 2; // 3412 //1
        Assert.assertEquals(340012,rotateNumBykDigits(num, k));

    }

    @Test
    public void test1(){
        int num = 12003400;
        int k = 2; // 3412 //1
        Assert.assertEquals(340012,rotateNumBykDigits(num, k));

    }

    @Test
    public void test3(){
        int num = 12013400; //
        int k = 3; // 3412 //1
        Assert.assertEquals(13400120,rotateNumBykDigits(num, k));

    }


    private int rotateNumBykDigits1(int num, int k) {

        int sign = 1;
        if (num < 0) sign = -1;
        int[] digits = new int[String.valueOf(num).length()];
        int index = digits.length - 1;

        int placeValue = 1;
        while (num > 0) {
            digits[index] = num % 10;
            num /= 10;
            if (index > 0)
                placeValue *= 10; // 1000
            index--;
        }
        System.out.println(Arrays.toString(digits));



        return 0;

    }
    }
