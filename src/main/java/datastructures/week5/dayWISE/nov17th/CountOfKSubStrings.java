package datastructures.week5.dayWISE.nov17th;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class CountOfKSubStrings {
    /**
     * return the count of all substrings with atmost k unique chars in it s="abc", k=2
     *
     * abc
     * a, b, c, ab, bc
     *
     * abbcd
     * a,b,b, c, d, ab,abb, bb, bbc, bc, cd
     */

    /**
     * - check if str.length == 1, if yes, return 1.
     * - initialize count = str.lentgth.
     * - initialize a HashMap with char and integer as key value pair to hold char and its occurances.
     * - convert given str into a char array.
     * - iterate through charArray starting from i = 0 to length.
     * - keep adding chars into hashMap.
     * - increment count until hashmap size <= k
     * - once size crosses k, reset map.
     */

    private int countAllSubStrWithAtmostKUniqChars(String str, int k){
        if(str.length() == 1) return 1;
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        int start = 0;
        int end = 0;
        while(end < chars.length){
            map.put(chars[end], map.getOrDefault(chars[end++], 0)+1);
             count++;
            if(map.size() >= k ){
                count++;
               if(map.keySet().size() <= k) continue;
                if(map.get(chars[start])>1)   map.put(chars[start], map.getOrDefault(chars[start], 0)-1);
                else map.remove(chars[start]);
                start++;
            }
        }

        /*
        for(int i  = 0; i < chars.length; i++){
            map.put(chars[i], map.getOrDefault(chars[i], 0)+1);
            if(map.size() == k){
               // if(map.get(chars[i]) <= k) count++;
              map.values().stream().toArray(new Integer[map.values().size()]);
            }
            if(map.size() > k) map.clear();
        }
        */

        return count;
    }

    @Test
    public void test(){
        String s = "abbcd";
        int k = 2;
        Assert.assertEquals(11, countAllSubStrWithAtmostKUniqChars(s, k));
    }
}
