package GP;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OracleTech {
    public static void main(String[] args) {
        String input = "cba";
        List<String> output = helper(input);
        System.out.println(output);
    }
    public static List<String> helper(String s ) {
        List<String> result = new ArrayList<>();
        generateAllSubsequences(s, 0, "", result);
        Collections.sort(result);
        return result;

    }
    private static void generateAllSubsequences(String s, int index, String current, List<String> result) {
        if(index == s.length()) {
            if(!current.isEmpty()) {
                result.add(current);
            }
            return;
        }
        generateAllSubsequences(s, index +1, current + s.charAt(index), result);
        generateAllSubsequences(s, index +1, current, result);
    }
}
//A subsequence is obtained by deleting zero or more characters from the string while
// maintaining the original order. Your task is to generate an array of all subsequences
// sorted in alphabetically ascending order, omitting the empty string.

//Example 1
//Input: s= 'xyz'
//Output:['x', 'xy', 'xyz', 'xz', 'y', 'yz', 'z']
//
//Example 2
//Input:s = 'ba'
//Output:['a', 'b', 'ba']
//
//Constraints
//1<length of s <16
//s is a string of distinct lowercase English letters ascii[a-z].