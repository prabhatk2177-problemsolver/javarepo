package project1;

import java.util.*;

public class Boggle_1 {

    // function to perform dfs on the grid
    static boolean dfs(char[][] letters, 
                       String word, int i, int j, int index) {

        // check if the current cell is out of bounds
        if (i < 0 || i >= letters.length || j < 0 || j >= letters[0].length) {
            return false;
        }

        // check if the current cell matches 
        // the character in the word
        if (letters[i][j] != word.charAt(index)) {
            return false;
        }

        // check if we have found the complete word
        if (index == word.length() - 1) {
            return true;
        }

        // mark the current cell as visited
        char temp = letters[i][j];
        letters[i][j] = '#';

        // perform dfs on all 8 directions
        for (int row = -1; row <= 1; row++) {
            for (int col = -1; col <= 1; col++) {

                // skip the current cell
                if (row == 0 && col == 0) continue;
                if (dfs(letters, word, i + row, j + col, index + 1)) {

                    // unmark the current cell as visited
                  //  letters[i][j] = temp;
                    return true;
                }
            }
        }

        // unmark the current cell as visited
        letters[i][j] = temp;

        return false;
    }

    // find all words in a given grid of characters
    // and a given dictionary
    static List<String> findWords(List<String> words, 
                                  char[][] letters) {
        int n = letters.length, m = letters[0].length;
        int r = words.size();
        List<String> ans = new ArrayList<>();

        // store the unique words in the hashSet
        Set<String> result = new HashSet<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (dfs(letters, words.get(i), j, k, 0)) {
                        result.add(words.get(i));
                    }
                }
            }
        }

        // convert the set to vector
        for (String word : result) {
            ans.add(word);
        }

        return ans;
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("geeks", "for", "quiz", "go");
        char[][] letters = {
            {'g', 'i', 'z'},
            {'u', 'e', 'k'},
            {'q', 's', 'e'}
        };
        List<String> ans = findWords(words, letters);
        for (String word : ans) {
            System.out.print(word + " ");
        }
    }
}

