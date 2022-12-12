package datastructures.week9.day2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    /**
     * https://leetcode.com/problems/merge-intervals/
     */

    /**
     * [[1,3],[2,6],[8,10],[15,18],[10,14]]
     *
     * out [1,6] [8,14][15,18]
     */
    /**
     * - initialize a list of int[] of size 2.
     * - sort given input using
     *   Arrays.sort(nums,(a,b)-> {if (a[1]!=b[1]) return a[1]-b[1]; else return a[0]-b[0];});
     * - iterate through given input
     * - intiailzie start = input[i][0]
     * - while assign end, check if input[i][1] <= input[i+1][0]
     * - if yes, update end with input[i+1][1]
     * - else, add interval[0] = start, interval[1] = end
     * - finally add interval to list.
     */


    private int[][] merge(int[][] intervals){
        ArrayList<int[]> out = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            else return a[0] - b[0];
        });
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            int[] overlaped = new int[2];
            overlaped[0] = start;
            overlaped[1] = end;

            if(end >= intervals[i][0]){
                end = Math.max(end, intervals[i][1]);
            }
            else{
                out.add(overlaped);
                start = intervals[i][0];
                end = intervals[i][1];
            }
         }
      //  out.add(Arrays.asList(start, end));

        int[][] output = new int[out.size()-1][2];
        for(int i = 0; i < output.length; i++){
            output[i][0] = out.get(i)[0];
            output[i][1] = out.get(i)[1];
        }
        return output;
    }

    @Test
    public void test(){
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18},{10,14}};
        merge1(intervals);
    }


    private int[][] merge1(int[][] intervals){
       List<List<Integer>> out = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            else return a[1] - b[1];
        });
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){

            if(end >= intervals[i][0]){
                end = Math.max(end, intervals[i][1]);
            }
            else{
                out.add(Arrays.asList(start, end));
                start = intervals[i][0];
                end = intervals[i][1];
            }

        }
        out.add(Arrays.asList(start, end));

       // out.stream().c//forEach(x -> x.get(0));


        int[][] output = new int[out.size()][2];
        for(int i = 0; i < output.length; i++){
            output[i][0] = out.get(i).get(0);
            output[i][1] = out.get(i).get(1);
        }
        return output;
    }


    @Test
    public void test1(){
        int[][] intervals = {{1,4},{2,3}};
        merge1(intervals);
    }

}
