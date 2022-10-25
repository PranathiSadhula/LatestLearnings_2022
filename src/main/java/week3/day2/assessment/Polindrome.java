package week3.day2.assessment;

import org.junit.Assert;
import org.junit.Test;

public class Polindrome {

    /**
     * initialize start = 0, end = s.length-1
     * 
     * loop 
     */
    
    private boolean isPolindrome(String s){
        int start = 0;
        int end = s.length() - 1;
        
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }

        return true;
    }

    @Test
    public void test(){
        String s = "rader";
        Assert.assertTrue(isPolindromeBF(s));
    }


    private boolean isPolindromeBF(String s){
        char[] chars = s.toCharArray();

        for(int i = 0; i < chars.length; i++){
            for(int j = chars.length-1; j >= 0; j--){
                if(chars[i] != chars[j]) return false;
            }
        }


        return true;
    }
}
