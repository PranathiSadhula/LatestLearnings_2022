package datastructures.week4.dayewise.nov08;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class FindTownJudge {
    /**
     * In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.
     *
     * If the town judge exists, then:
     *
     * The town judge trusts nobody.
     * Everybody (except for the town judge) trusts the town judge.
     * There is exactly one person that satisfies properties 1 and 2.
     * You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi.
     *
     * Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
     *
     *
     *
     * Example 1:
     *
     * Input: n = 2, trust = [[1,2]]
     * Output: 2
     * Example 2:
     *
     * Input: n = 3, trust = [[1,3],[2,3]]
     * Output: 3
     * Example 3:
     *
     * Input: n = 3, trust = [[1,3],[2,3],[3,1]]
     * Output: -1
     *
     *
     * Constraints:
     *
     * 1 <= n <= 1000
     * 0 <= trust.length <= 104
     * trust[i].length == 2
     * All the pairs of trust are unique.
     * ai != bi
     * 1 <= ai, bi <= n
     */


    /**
     * -create a map with Integer, List<Integer> as key value pair.
     * -iterate through trust[][] array to assign each trust[i] to map.
     * -initailize int variable trustCount = n-1.
     * -now, get all values from the map generated above.
     * - iterate through each value list to get the count of each town member occurances.
     * - return whom matches with trustcount ==  n-1.
     */
    /**
     *       List<Integer> integers = map.getOrDefault(trust[i][0],new ArrayList<>());
     *             integers.addAll(Arrays.asList(trust[i][1]));
     *             map.put(trust[i][0], integers);*/
    public int judgeOfTown(int n, int[][] trust){
        if(n == 1 && trust.length == 0) return 1;
        HashMap<Integer, List<Integer>> map = new HashMap();
        for(int i = 0; i < trust.length; i++){
          // List<Integer> judgeList = map.getOrDefault(trust[i][0], Arrays.asList());

            List<Integer> judgeList = map.getOrDefault(trust[i][0], new ArrayList());
            judgeList.add(trust[i][1]);
            map.put(trust[i][0],judgeList);
       }
        List<List<Integer>> finalJudges = map.values().stream().collect(Collectors.toList()); //{{1,3},{2,3},{4,3},{1,2}}
//  {3,2},{3},{3}
        HashSet<List<Integer>> set = new HashSet<>(); //set.add(judge)
        finalJudges.stream().forEach(judge -> set.add(judge) );


        if(set.size() == 1) {
            for(List<Integer> result : set){
                return result.get(0);
            }
        }
        int judgeToReturn = -1;
        for(int townMember = 1; townMember <= n; townMember++){
            if(!map.containsKey(townMember)){
                for(List<Integer> eachJudge : finalJudges){
                    if(eachJudge.contains(townMember)) judgeToReturn = townMember;//return townMember;
                }
            }


        }
        return judgeToReturn;

    }
    @Test
    public void test1(){
        int[][] trust = {{1,3},{2,3},{4,3}};
        int n = 4;
        Assert.assertEquals(3, judgeOfTown(n,trust));
    }

    @Test
    public void test2(){
        int[][] trust = {{1,3},{2,3},{3,4},{1,2}};
        int n = 4;
        Assert.assertEquals(-1, judgeOfTown(n,trust));
    }

    @Test
    public void test3(){
        int[][] trust = {{1,3},{2,3}};
        int n =3;
        Assert.assertEquals(3, judgeOfTown(n,trust));
    }

    @Test
    public void test4(){
        int[][] trust = {};
        int n = 1;
        Assert.assertEquals(1, judgeOfTown(n,trust));
    }

    @Test
    public void test5(){
        int[][] trust = {{1,3},{1,4},{2,3}};
        int n = 4;
        Assert.assertEquals(-1, judgeOfTown(n,trust));
    }





}
