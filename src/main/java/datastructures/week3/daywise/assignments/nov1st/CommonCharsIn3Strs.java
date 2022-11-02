package datastructures.week3.daywise.assignments.nov1st;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CommonCharsIn3Strs {
    /**
     * Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: words = ["bella","label","roller"]
     * Output: ["e","l","l"]
     * Example 2:
     *
     * Input: words = ["cool","lock","cook"]
     * Output: ["c","o"]
     *
     *
     * Constraints:
     *
     * 1 <= words.length <= 100
     * 1 <= words[i].length <= 100
     * words[i] consists of lowercase English letters.
     */


    /**
     * - initialize 2d array to hold eachWord's char count : int[][] charAscii = new int[words.length][26];
     *
     * - iterate through words for eachWord and keep adding charAscii occurance
     *
     * - In another loop, iterate through each word starting i = 1 to words.length-1
     *
     * - check if ascii values for word[i-1]  > 0 and matches with word[i]. if yes add to list
     *
     * - else remove
     *
     *
     */

    private List<String> commonChars(String[] words){

        List<String> output = new ArrayList<>();
        int[][] charAscii = new int[words.length][26];
        int curWordInx = 0;
        for(String word : words){
            char[] chars = word.toCharArray();
            for(char c : chars){
                charAscii[curWordInx][c-'a']++;
           }
            curWordInx++;
        }

        for(int i = 1; i < words.length-1; i++){

            for(int cInx = 0; cInx < 26; cInx++){
                if(charAscii[i-1][cInx] > 0 && charAscii[i-1][cInx] == charAscii[i][cInx]){
                    output.add(String.valueOf('a'+charAscii[i][cInx]));
                }
                else {
                    output.remove(String.valueOf('a'+charAscii[i][cInx]));
                }
                //if(charAscii[i][cInx] > 0){
                //                    if(charAscii[i-1][cInx] > 0 && Collections.frequency(output, String.valueOf('a'+charAscii[i][cInx])) > charAscii[i][cInx] ){
                //
                //                    }
               // else if(charAscii[i-1][cInx] > 0 && Collections.frequency(output, String.valueOf('a'+charAscii[i][cInx])) > charAscii[i][cInx] ){

                //}
            }
        }

        return output;
    }


    /*
        - create an ascii array of size 26 to hold common chars also initialise a list of strings to store common strings
        - iterate over the first string element chars and update char occurrences in the array
        - iterate the words array from 1st index until the end of array
        - Initialise a new current ascii array of size 26 and update the ascii array with the occurrences of the current string
        - Iterate over the common chars ascii array and update the common chars ascii array with the min value between the current and common ascii array at any given index
        - now iterate the common ascii array and add the character in the form of string as many times as it occurred in the common ascii array
        - return the list of string as an output
        */

    private List<String> commonCharsAscii(String[] words) {
        int[] ascii = new int[26];
        List<String> commCharList = new ArrayList<>();

        for (char c : words[0].toCharArray()) {  //o[n]
            ascii[c - 'a']++;
        }

        for (int i = 1; i < words.length; i++) { //o[n]
            int[] curascii = new int[26];

            for (char c : words[i].toCharArray()) { //o[n]
                curascii[c - 'a']++;
              //  ascii[c - 'a'] = Math.min(curascii[c - 'a'], ascii[c - 'a']);
            }

            for (int aIndx = 0; aIndx < ascii.length; aIndx++) { //o[n]
                ascii[aIndx] = Math.min(curascii[aIndx], ascii[aIndx]);
            }
        }
        // o[n^2 * 26]

        for (int aIndx = 0; aIndx < ascii.length; aIndx++) {  //0[26]
            for (int count = 0; count < ascii[aIndx]; count++) { //0[m]
                commCharList.add(String.valueOf((char )('a' + aIndx)));
            }
        }
        //o[26*m]

        //time : o[n^2*26] + o[26*m] ==> o[n3]+o[n2]
        return commCharList;

    }

    @Test
    public void test(){
        String[] words = {"bella","label","roler"};
         commonCharsAscii(words);
    }
}
