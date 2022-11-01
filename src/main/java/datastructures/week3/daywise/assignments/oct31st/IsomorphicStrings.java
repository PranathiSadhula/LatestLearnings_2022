package datastructures.week3.daywise.assignments.oct31st;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {

    @Test
    public void test() {
        String s = "badc";
        String t = "baba";
        isIsomorphic(s,t);


    }

    /**
     * - check if both strings are of equal length. if not return false
     *
     * - convert given 2 strings into char arrays : sChars, tChars
     *
     * - create a hashMap with char, char as key value pair.
     *
     * - while adding key value pair into hashMap, check if map contains key and value for that key is equal to tChar at index i
     *
     * - if no, return false
     *
     */

    private boolean isIsomorphicMap(String s, String t){
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        HashMap<Character, Character> map = new HashMap<Character, Character>();

        for (int i = 0; i < sChars.length; i++) {
            if (map.containsKey(sChars[i]) && map.get(sChars[i]) != tChars[i])
                return false;
            if (map.containsKey(tChars[i]) && map.get(tChars[i]) != sChars[i])
                return false;
            System.out.println("test put :" + map.put(sChars[i], tChars[i]));
        }
        return true;
    }


    /**
     * - check if both strings are of same size. else return false
     *
     * - create a hashMap to hold char from s as keu and char from t as va;ue
     *
     * - iterate through i to s.length to:
     *
     * - check if a key already exists in map and its value matches with char in string t.
     *
     *      - if no, return false
     *  - keep adding entries key (sChars[i]) and value (tCHars[i])
     *
     *  - finally return true
     */

    private boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < tChars.length; i++) { //o[n]
            if (map.containsKey(sChars[i]) && map.get(sChars[i]) != tChars[i]) return false; //o[n]
            if (map.containsValue(tChars[i])) { //o[
                Set<java.util.Map.Entry<Character, Character>> entries =  map.entrySet();
                for(java.util.Map.Entry<Character, Character> eachEntry : entries){
                    if(eachEntry.getValue() == tChars[i] && eachEntry.getKey() != sChars[i]) return false;
                }
            }
            map.put(sChars[i], tChars[i]);
        }
        return true;
    }
}
