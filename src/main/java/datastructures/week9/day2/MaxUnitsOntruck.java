package datastructures.week9.day2;

import org.junit.Test;

import java.util.Arrays;

public class MaxUnitsOntruck {
    /**
     * https://leetcode.com/problems/maximum-units-on-a-truck/description/
     *
     * Input: boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
     * Output: 8
     * Explanation: There are:
     * - 1 box of the first type that contains 3 units.
     * - 2 boxes of the second type that contain 2 units each.
     * - 3 boxes of the third type that contain 1 unit each.
     * You can take all the boxes of the first and second types, and one box of the third type.
     * The total number of units will be = (1 * 3) + (2 * 2) + (1 * 1) = 8.
     */


    private int maxUnitsOnTruck(int[][] boxTypes, int truckSize){ //[[1,3],[2,2],[3,1]]
        Arrays.sort(boxTypes, (a,b)->{
            return (a[1] != b[1]) ? a[1]-b[1] : b[1]-a[1];
        });
        // 1,3, 2,2,3,1

        int maxunits = 0;

        for(int[] eachBox : boxTypes){
            if(truckSize > 0){
                int boxesAdded = 0;
                for(int i = 0; i < eachBox[0] && boxesAdded < truckSize; i++){
                    if(truckSize > 0){
                       maxunits += eachBox[1];
                       boxesAdded++;
                    }
                }
                truckSize -= boxesAdded;
            }
        }
        return maxunits;

    }
    @Test
    public void test(){
        int[][] boxTypes = {{1,3},{2,2},{3,1}};
        int truckSize = 4;
        maxUnitsOnTruck(boxTypes, truckSize);

    }
}
