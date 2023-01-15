package datastructures.week14.jan08;

import org.junit.Assert;
import org.junit.Test;

public class ReduceString {
    @Test
    public void test(){
        String s = "aab";
        Assert.assertEquals("b", superReducedString(s));
    }

    @Test
    public void test1(){
        String s = "abba";
        Assert.assertEquals("Empty String", superReducedString(s));
    }

    @Test
    public void test2(){
        String s = "abaa";
        Assert.assertEquals("ab", superReducedString(s));
    }
    private String superReducedString(String s) {
        boolean cond = true;
        for(int i = 0; i < s.length()-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                s = s.substring(0,i)+s.substring(i+2);
                if(s.isEmpty()) return "Empty String";
                cond = false;
            }
        }

        if(cond) return s;

        return superReducedString(s);

    }

    @Test
    public void test4(){

        String s = "aaabccddd";
        Assert.assertEquals("abd", superReducedString(s));
    }
}


