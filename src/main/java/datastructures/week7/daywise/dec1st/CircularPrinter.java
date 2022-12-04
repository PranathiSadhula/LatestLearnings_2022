package datastructures.week7.daywise.dec1st;

import org.junit.Assert;
import org.junit.Test;

public class CircularPrinter {
    /**
     *
     */
    private int findMinTimeToType(String s){
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        int totalDifToType =  Math.min(s.charAt(0)-'a', 26-(s.charAt(0)-'a'));
        for(int i = 0; i < chars.length-1; i++){
            int charDiff = Math.abs(chars[i] - chars[i+1]);
            totalDifToType += Math.min(charDiff, 26- charDiff);

        }

        return totalDifToType;
    }

    @Test
    public void test(){
        String s = "BZAB";
        Assert.assertEquals(5,findMinTimeToType(s));
    }
}
