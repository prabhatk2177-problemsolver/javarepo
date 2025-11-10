package project1;

import java.util.ArrayList;
import java.util.List;

public class CountOFSubs  {

    public static int countBinarySubstrings(String s) {
        // List to store the lengths of consecutive groups of identical characters
        List<Integer> groups = new ArrayList<>();
        int count = 1;

        // Iterate through the string to find consecutive groups
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                groups.add(count);
                count = 1;
            }
        }
        groups.add(count); // Add the last group's count

        int totalCount = 0;
        // Iterate through the list of group lengths
        // The number of valid substrings formed by two adjacent groups is the minimum of their lengths
        for (int i = 1; i < groups.size(); i++) {
            totalCount += Math.min(groups.get(i - 1), groups.get(i));
        }

        return totalCount;
    }

    public static void main(String[] args) {
        String s = "1010";
        int count = countBinarySubstrings(s);
        System.out.println("Count = " + count);
    }
}



