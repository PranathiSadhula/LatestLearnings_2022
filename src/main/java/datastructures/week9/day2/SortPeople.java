package datastructures.week9.day2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortPeople {
    /**
     * https://leetcode.com/problems/sort-the-people/
     */

@Test
public void test(){
    String[] names = {"Mary","John","Emma"};
    int[] heights = {180,165,170};
    Assert.assertArrayEquals(new String[]{"Mary", "Emma", "John"}, sortPeople(names, heights));
}

    private String[] sortPeople(String[] names, int[] heights){
            insertionSort(names, heights);
            return names;
    }








    private void insertionSort(String[] names, int[] heights){

        for(int i = 0; i < heights.length-1; i++){
            if(heights[i] < heights[i+1]){
                int temp = heights[i];
                heights[i] = heights[i+1];
                heights[i+1] = temp;
                String tName = names[i];
                names[i] = names[i+1];
                names[i+1] = tName;
                for(int j = 0; j < i; j++){
                    if(heights[j] < heights[i]) {
                        temp = heights[i];
                        heights[i] = heights[j];
                        heights[j] = temp;

                        tName = names[i];
                        names[i] = names[j];
                        names[j] = tName;
                    }
                }
            }
        }
    }



    @Test
    public void test1(){
        String[] names = {"IEO","Sgizfdfrims","QTASHKQ","Vk","RPJOFYZUBFSIYp","EPCFFt","VOYGWWNCf","WSpmqvb"};
        int[] heights = {17233,32521,14087,42738,46669,65662,43204,8224};
        //"RPJOFYZUBFSIYp","IEO","EPCFFt","Vk","VOYGWWNCf","Sgizfdfrims","QTASHKQ","WSpmqvb"
        Assert.assertArrayEquals(new String[]{"EPCFFt","RPJOFYZUBFSIYp","VOYGWWNCf","Vk","Sgizfdfrims","IEO","QTASHKQ","WSpmqvb"}, sortPeople(names, heights));
    }




    @Test
    public void testMap(){
        String[] names = {"Mary","John","Emma"};
        int[] heights = {180,165,190};
        Assert.assertArrayEquals(new String[]{"Emma", "Mary", "John"}, sortPeopleMap(names, heights));
    }




    private String[] sortPeopleMap(String[] names, int[] heights){

        HashMap<String , Integer> map = new HashMap<>();
        for(int i = 0; i < names.length; i++){
            map.put(names[i], heights[i]);
        }
        System.out.println(map);
        HashMap<String, Integer> sortedMap = map.entrySet()
                                            .stream()
                                            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                                            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                                    (oldValue, newValue)-> oldValue, LinkedHashMap :: new))
                ;

        Map<String, Integer> lMap = new LinkedHashMap<>();

                map.entrySet()
                                    .stream()
                                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                                    .forEachOrdered(x -> lMap.put(x.getKey(), x.getValue()));

        System.out.println(sortedMap);
        int indx = 0;
        for(Map.Entry<String, Integer> entries : sortedMap.entrySet()){
            names[indx++] = entries.getKey();
        }
        return names;
    }




}
