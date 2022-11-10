package datastructures.week4.dayewise.nov09;

import org.junit.Test;

import java.util.*;

public class UncommonWords {


    /**
     * map approach :
     * - concat 2 given stmts with " " as delimiter.
     * - convert concated Str to words based on " " split.
     * - create a map with String, Integer as key value to hold each word and its occurances in both the sentences.
     * - keep adding each word and its occurances into the map.
     * - create List<String> output.
     * - iterate through entrySet on map to add key into output whose value matches with 1.
     * - finally return output as List.toArray.
     */


    private String[]  uncommonWords(String s1, String s2){
        s1 =  s1+" "+s2;
        String[] words = s1.split(" ");
        HashMap<String, Integer> map = new HashMap();
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        List<String> output = new ArrayList();

       for( Map.Entry<String, Integer> entries: map.entrySet()){
           if(entries.getValue() == 1) output.add(entries.getKey());
       }
       return output.toArray(new String[output.size()]);
    }


    @Test
    public void test(){
        String s1 = "this apple is sweet sour";
        String s2 = "this apple is";
        System.out.println(Arrays.toString(uncommonWords(s1,s2)));

    }

    @Test
    public void test1(){
        String s1 = "this apple is sweet sour";
        String s2 = "this apple is";
        System.out.println(Arrays.toString(uncommonWords(s1,s2)));

    }
}
