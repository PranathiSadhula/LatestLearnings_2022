package datastructures.dailypractice.jan10;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class TownJudge {
    /**
     * https://leetcode.com/problems/find-the-town-judge/description/
     *Given  1 to n no.of people
     * conditions : town judge dont trust anybody
     *              expect townjudge, others trust townjudge
     *
     *  n = 2
     *  trust =[[1,2]]  --> 1 is trusting 2, since 2 is not trusting anybody, 2 is judge
     *
     *
     *  extract possible judges from given 2d array
     *  use HashSet to store possible judge(value to index 1) in given town
     *  use ArrayList to store town members(value at index 0)
     *  now, check if element in hashSet is not a part of arraylist. if yes yes, return that elt.
     *  else return -1
     *
     */


    public int findJudge(int n, int[][] trust) {
        int judge = -1;
        HashSet<Integer> possibleJudge = new HashSet<>();
        ArrayList<Integer> townMembers = new ArrayList<>();

        for(int i = 0; i < trust.length; i++){
            townMembers.add(trust[i][0]);
            possibleJudge.add(trust[i][1]);
        }
       if(possibleJudge.size() == 1 ) {
            for(int mem : possibleJudge){
                return mem;
            }
        }
        else{
            for(int mem : possibleJudge){
                if(!townMembers.contains(mem)) judge = mem;/*return mem*/;
            }
        }



        return judge;
    }


    @Test
    public void test(){
        int n = 3;
        int[][] trust = {{1,3},{2,3},{3,1}};
        Assert.assertEquals(-1, findJudge(n, trust));
    }

    @Test
    public void test1(){
        int n = 3;
        int[][] trust = {{1,3},{2,3}};
        Assert.assertEquals(3, findJudge(n, trust));
    }

    @Test
    public void test2(){

        int n = 3;
        int[][] trust = {{1,2},{2,3}};
        Assert.assertEquals(-1, findJudgeHashMap(n, trust));
    }



    public int findJudgeHashMap(int n, int[][] trust) {
        int judge = -1;
        HashSet<Integer> possibleJudge = new HashSet<>();
        HashMap<Integer, ArrayList<Integer>> townMembers = new HashMap<Integer, ArrayList<Integer>>();

        for(int i = 0; i < trust.length; i++){

            if(townMembers.containsKey(trust[i][0])){
                ArrayList<Integer> list = townMembers.get(trust[i][0]);
                        list.add(trust[i][1]);
                townMembers.put(trust[i][0], list);
            }
            else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(trust[i][1]);
                townMembers.put(trust[i][0], list);
            }
            possibleJudge.add(trust[i][1]);
        }
        if(possibleJudge.size() == 1 ) {
            for(int mem : possibleJudge){
                return mem;
            }
        }
        else{
            for(int mem : possibleJudge){// 1,2  2,3   // 2,3
                if(!townMembers.containsKey(mem)) {

                    for(Map.Entry<Integer, ArrayList<Integer>> entries: townMembers.entrySet()){
                        if(!entries.getValue().contains(mem))  possibleJudge.remove(mem);//return -1;
                        else judge = mem;
                    }
                }
            }
        }

        if(possibleJudge.size() != 1 ) return -1;
        if(!possibleJudge.contains(judge)) return -1;
        return judge;
    }

    @Test
    public void test3(){

        int n = 11;
        int[][] trust = {{1,8},{1,3},{2,8},{2,3},{4,8},{4,3},{5,8},{5,3},{6,8},{6,3},{7,8},{7,3},{9,8},{9,3},{11,8},{11,3}};
        Assert.assertEquals(-1, findJudgeHashMap(n, trust));
    }



}
