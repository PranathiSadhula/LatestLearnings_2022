package datastructures.week3.daywise.assignments.oct31st;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class DestinationCity {

    /**
     *
     *You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi. Return the destination city, that is, the city without any path outgoing to another city.
     *
     * It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.
     *
     *
     *
     * Example 1:
     *
     * Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
     * Output: "Sao Paulo"
     * Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city. Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".
     * Example 2:
     *
     * Input: paths = [["B","C"],["D","B"],["C","A"]]
     * Output: "A"
     * Explanation: All possible trips are:
     * "D" -> "B" -> "C" -> "A".
     * "B" -> "C" -> "A".
     * "C" -> "A".
     * "A".
     * Clearly the destination city is "A".
     * Example 3:
     *
     * Input: paths = [["A","Z"]]
     * Output: "Z"
     *
     *
     * Constraints:
     *
     * 1 <= paths.length <= 100
     * paths[i].length == 2
     * 1 <= cityAi.length, cityBi.length <= 10
     * cityAi != cityBi
     * All strings consist of lowercase and uppercase English letters and the space character.
     */




   @Test
    public void test1() {


        List<List<String>> inputPaths = new ArrayList<List<String>>();
        List<String> paths = new ArrayList<String>();
        paths.add("jMgaf WaWA");
        paths.add("iinynVdmBz");
        inputPaths.add(paths);

        paths = new ArrayList<String>();
        paths.add(" QCrEFBcAw");
        paths.add("wRPRHznLWS");
        inputPaths.add(paths);

        paths = new ArrayList<String>();
        paths.add("iinynVdmBz");
        paths.add("OoLjlLFzjz");
        inputPaths.add(paths);

        paths = new ArrayList<String>();
        paths.add("OoLjlLFzjz");
        paths.add("QCrEFBcAw");
        inputPaths.add(paths);

        paths = new ArrayList<String>();
        paths.add("IhxjNbDeXk");
        paths.add("jMgaf WaWA");
        inputPaths.add(paths);

        paths = new ArrayList<String>();
        paths.add("jmuAYy vgz");
        paths.add("IhxjNbDeXk");
        inputPaths.add(paths);

/**
 *   List<List<String>>  inputPaths1 =  Arrays.asList(Arrays.asList("B","C"),Arrays.asList("D","B"),Arrays.asList("C","A"));
 *
 *         List<List<String>> paths1 = Arrays.asList(Arrays.asList("B","C"),Arrays.asList("D","B"),Arrays.asList("C","A"));
 */

       String ouput = "wRPRHznLWS";
        Assert.assertEquals(ouput, getDestination(inputPaths));
    }

    @Test
    public void test2() {


        List<List<String>> inputPaths = new ArrayList<List<String>>();
        List<String> paths = new ArrayList<String>();
        paths.add("B");
        paths.add("C");
        inputPaths.add(paths);

        paths = new ArrayList<String>();
        paths.add("D");
        paths.add("B");
        inputPaths.add(paths);

        paths = new ArrayList<String>();
        paths.add("C");
        paths.add("A");
        inputPaths.add(paths);

        /**
         *
         *  List<List<String>> inputPaths = new ArrayList<List<String>>();
         *
         *
         *
         * List<List<String>> paths = Arrays.asList(Arrays.asList(new String[] {"B","C"}));
         *
         * 	List<List<String>> paths = Arrays.asList(Arrays.asList("B","C"),Arrays.asList("D","B"),Arrays.asList("C","A"));
         * 	String s = destCity(paths);
         * 	Assert.assertEquals(s, "A");
         */

        String ouput = "A";
        Assert.assertEquals(ouput, getDestinationIterate(inputPaths));
    }
    /**
     * - initialize a linkedhashMap with String, String as key value pair.
     *
     * -
     *
     *
     *
     *
     *
     */
//[["jMgaf WaWA","iinynVdmBz"],[" QCrEFBcAw","wRPRHznLWS"],
// ["iinynVdmBz","OoLjlLFzjz"],["OoLjlLFzjz"," QCrEFBcAw"],
// ["IhxjNbDeXk","jMgaf WaWA"],["jmuAYy vgz","IhxjNbDeXk"]]
    private String getDestination(List<List<String>> inputPaths) {
        HashMap<String, String> lMap = new HashMap<String, String>();
        String finalDest = "";
        for (int i = 0; i < inputPaths.size(); i++) {
            String origin = inputPaths.get(i).get(0);
            String dest = inputPaths.get(i).get(1);


            lMap.put(origin, dest);
        }
        return finalDest;

    }


    private String getDestinationIterate(List<List<String>> inputPaths) {
        HashMap<String, String> lMap = new HashMap<String, String>();
        String finalDest = "";
        for (int i = 0; i < inputPaths.size(); i++) {
            String origin = inputPaths.get(i).get(0);
            String dest = inputPaths.get(i).get(1);
            System.out.println("test put :"+lMap.put(origin, dest));

        }
        finalDest = lMap.get(lMap.keySet().iterator().next());
        while(lMap.get(finalDest) != null){
            finalDest = lMap.get(finalDest);
        }
        return finalDest;

    }






}