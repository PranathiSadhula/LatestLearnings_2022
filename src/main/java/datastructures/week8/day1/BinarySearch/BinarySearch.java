package datastructures.week8.day1.BinarySearch;

public class BinarySearch {
    /**
     * divide and conquer
     * - sorted is must.
     * - works efficiently when to identify occurances of n elt in given array.
     * - time : o[logn]
     * - space : o[1]
     * - how to work :
     *      steps: start 3 pointers : low = 0, high = length-1, mid = low+high/2.
     *          - if midvalue == target ==> return mid.
     *          - check if midvalue > target ==> then low shoud move to mid+1
     *          - check if midvalue < tagret ==> then move high to mid-1
     *
     *
     * {1,3,4,2,2}
     */
}
