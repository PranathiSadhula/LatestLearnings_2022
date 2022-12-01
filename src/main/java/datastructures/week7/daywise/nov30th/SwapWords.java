package datastructures.week7.daywise.nov30th;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collector;

public class SwapWords {
    /**
     * String s="today is a beautiful day";
     * String out = "day beautiful a is today";
     */
@Test
public void test(){
    String s = "today is a beautiful day";
    String out = "day beautiful a is today";
    Assert.assertEquals(out, swapWords(s));
}

    private String swapWords(String s){
        String[] words = s.split(" ");

        int start = 0;
        int end = words.length-1;
        while(start < end){
            String tem = words[start];
            words[start] = words[end];
            words[end] = tem;
            start++;
            end--;
        }
           return String.join(" ", words);
    }
}
