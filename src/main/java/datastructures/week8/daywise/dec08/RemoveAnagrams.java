package datastructures.week8.daywise.dec08;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class RemoveAnagrams {
    /**
     * "code","doce","ocde","framer","frame" --> remove anagrams and return the remaining strings
     */

    @Test
    public void test(){
        ArrayList<String> words = new ArrayList<>();
        words.add("code");
        words.add("doce");words.add("ocde");
        words.add("framer");words.add("frame");


      //  Arrays.asList("code","doce","ocde","framer","frame");
        System.out.println(removeAnagrams(words));
    }

    @Test
    public void test1(){
        ArrayList<String> words = new ArrayList<>();
        words.add("farmer");
        words.add("more");words.add("roem");
        words.add("framer");words.add("frame");

        ArrayList<String> expected = new ArrayList<>();
        expected.add("frame");
        Assert.assertEquals(expected,removeAnagramsMap(words));
        System.out.println(removeAnagramsMap(words));
    }
    /**
     *  - check if given list of strings size is > 1
     *  - if not, return string.
     *
     *  - check if any 2 strs are anagrams.
     *      - for given 2 strs, check if both having same set of chars with same occurance.
     *      - if yes, return true.
     *      else, return false.
     *  - if false, add both the strs to output list.
     *  - finally return the list of strs.
     *
     */

    private ArrayList<String> removeAnagrams(ArrayList<String> strs){
        if(strs.size() == 1) return strs;
        if(strs.size() == 2 && isAnagram(strs.get(0), strs.get(1))) return strs;
        Set<String> anagrams = new HashSet<>();

            for(int i = 0; i < strs.size()-1; i++){
                for(int j = i+1; j < strs.size(); j++) {
                    if (isAnagram(strs.get(i), strs.get(j))) {
                        anagrams.add(strs.get(i));
                        anagrams.add(strs.get(j));
                    }

                }
            }
        strs.removeAll(anagrams);
        return strs;
    }

    private boolean isAnagram(String s, String t){
        int[] sChars = new int[26];
        int[] tChars = new int[26];
        for(char c : s.toCharArray()){
            sChars[c-'a']++;
        }
        for(char c : t.toCharArray()){
            tChars[c-'a']++;
        }
        return Arrays.equals(tChars, sChars) ;
    }

    private List<String> removeAnagrams(List<String> list) {
        HashSet<String>set=new HashSet<>();
        List<String> output=new ArrayList<>();
        for (int i=0;i<list.size();i++){
            char[] chars = list.get(i).toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            if(!set.contains(s))output.add(list.get(i));
            set.add(s);
        }

        Collections.sort(output);
        return output;
    }

    private List<String> funAnagram(List<String> input){
        List<String> op = new ArrayList<>();
        Set<Map<Character,Integer>> set = new HashSet<>();
        for (String each : input) { //n
            Map<Character, Integer> map = new HashMap<>();
            for(char c : each.toCharArray()) //m
                map.put(c, map.getOrDefault(c, 0)+1);
            if(!set.contains(map)) {
                op.add(each);
                set.add(map);
            }
        }
        Collections.sort(op); //
        return op;
    }


    private ArrayList<String> removeAnagramsMap(ArrayList<String> strs){
        if(strs.size() == 1) return strs;
        if(strs.size() == 2 && isAnagram(strs.get(0), strs.get(1))) return strs;
        Map<String, ArrayList<String>> map = new HashMap<>();
        for(String word : strs){ //n
            int[] sChars = new int[26];
            for(char c : word.toCharArray()){ //m
                sChars[c-'a']++;
            }

            String sNew = String.valueOf(Arrays.toString(sChars));

            if(map.containsKey(sNew)){
                map.get(sNew).add(word);
            }
            else{
               ArrayList al= new ArrayList<>();
                al.add(word);
                map.put(sNew, al);
            }
         }
        ArrayList<String> out = new ArrayList<>();
        for(Map.Entry<String, ArrayList<String>> entries : map.entrySet()){ // k
            if(entries.getValue().size() == 1){
                out.add(entries.getValue().get(0));
            }
        }
        return out;
    }
}
