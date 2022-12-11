package datastructures.week8.daywise.dec06;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NoPairsAllowed {

    @Test
    public void test(){

        List<String> list = Arrays.asList("ab","aab","abb", "abab", "abaaaaba");
        List<Integer> out = Arrays.asList(0,1,1, 0, 1);
        System.out.println(minimalOperations(list));

    }

    public static List<Integer> minimalOperations(List<String> words) {
        List<Integer> list = new ArrayList<>();
        for(String word : words){
            list.add(operationsPerformedPassed(word));
        }

        return list;
    }

    /**
     - accept given word and convert into char array.
     - initialize minOperations = 0.
     - iterate through each char and check if char at i and i +1 are equal
     */
    public static int operationsPerformedFailed(String word){
        char[] chars = word.toCharArray();
        int minOperations = 0;

        for(int i = 0; i < chars.length-2; i++){
            if(chars[i] == chars[i+1] && chars[i] == chars[i+2]){
                minOperations++;
                i = i+2;
            }
            else if(chars[i] == chars[i+1]){
                minOperations++;
               i++;
            }
        }

        return minOperations;
    }

    public static int operationsPerformedPassed(String word){
        char[] chars = word.toCharArray();
        int minOperations = 0;

        for(int i = 0; i < chars.length-2; i++){
            if(chars[i] == chars[i+1]){
                minOperations++;
                i++;
            }
        }

        return minOperations;
    }
}
