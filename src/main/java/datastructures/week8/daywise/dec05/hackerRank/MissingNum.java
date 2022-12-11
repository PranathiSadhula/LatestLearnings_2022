package datastructures.week8.daywise.dec05.hackerRank;

import org.junit.Test;

import java.util.*;

public class MissingNum {

    @Test
    public void test(){
      //ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(11, 4 ,11, 7, 13, 4, 12, 11, 10, 14));
      //ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(11, 4, 11, 7, 3, 7, 10, 13, 4, 8, 12, 11, 10, 14, 12));
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(203, 204, 205, 206, 207, 208, 203, 204, 205, 206));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(203, 204, 204, 205, 206, 207 ,205, 208, 203, 206 ,205 ,206 ,204));
      ArrayList<Integer> out = new ArrayList<>();
      int aIndx = 0;
      for(int i = 0; i < list2.size(); i++){
          if(list1.get(aIndx) != list2.get(i)){
              if(!out.contains(list2.get(i))) out.add(list2.get(i));
          }
          else{
              if(aIndx < list1.size()-1)
                aIndx++;
          }
      }


    /*    HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < list1.size(); i++){
            map.put(list1.get(i), map.getOrDefault(list1. get(i), 0)+1);
        }
        for(int i = 0; i < brr.size(); i++){
            if(map.containsKey(brr.get(i))){
                if( Collections.frequency(brr, brr.get(i)) > map.get(brr.get(i))){
                    if(!out.contains(brr.get(i))) out.add(brr.get(i));
                }
            }
            else{
                if(!out.contains(brr.get(i))) out.add(brr.get(i));
            }
        }
        */
        Collections.sort(out);
        System.out.println(out);
    }
}
