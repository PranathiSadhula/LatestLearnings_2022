package datastructures.week11.codeathon;

import org.junit.Assert;
import org.junit.Test;

public class ReverseOnlyLetters {
    /**
     * ab-cd ==> dc-ba
     */

    /**
     * - convert given str into charArray.
     * - start 2 pointers : start = 0, end = s.length-1
     * - check if each char's ascii value at indices start and end is within range [33,122]
     * - if yes, swap both chars and increment start, decrement end.
     * - else if char's ascii value at index start is within range[]33,122], decrement end.
     * - else increment start.
     * - finally convert updated charArray to string and return as output/
     *
     * Time : 5min
     */

    private String reverseLettersOnly(String s){
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length()-1;
        while (start < end){
            if(((chars[start] > 64 && chars[start] < 91) || (chars[start] > 96 && chars[start] < 123))
                    && ((chars[end] > 64 && chars[end] < 91) || (chars[end] > 96 && chars[end] < 123))){
                char temp = chars[start];
                chars[start++] = chars[end];
                chars[end--] = temp;
            }
            else if(((chars[start] > 64 && chars[start] < 91) || (chars[start] > 96 && chars[start] < 123)) ){
                end--;
            }
            else{
                start++;
            }
        }

        return new String(chars); // time taken : 12min along with debug.
    }

    @Test
    public void test(){
        String s = "Test1ng-Leet=code-Q!";
        Assert.assertEquals("Qedo1ct-eeLg=ntse-T!", reverseLettersOnly(s));
    }
}
