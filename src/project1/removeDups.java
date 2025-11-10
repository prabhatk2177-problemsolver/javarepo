package project1;

import java.util.*;

public class removeDups {
    public static String removeDuplicates(String s) {
        // If the string is empty, return it
        if (s.isEmpty()) {
            return s;
        }

        // Initialize the result string
        StringBuilder result = new StringBuilder();

        // Iterate through the string with the sliding window
        for (int i = 0; i < s.length(); i++) {
            // If the result is empty or the last character in result is not the same as current character
            if (i == 0 || s.charAt(i) != s.charAt(i-1)) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s1 = "geeksforgeeks";
        System.out.println(removeDuplicates(s1));

        String s2 = "aabcca";
        System.out.println(removeDuplicates(s2));
    }
}
