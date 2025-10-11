package project1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Boggle {
	
 final static	int[] dx = {1, 1, 0, -1, -1, -1,  0, 1};
 final static	int[] dy = {0, 1, 1,  1,  0, -1, -1, -1};

	static void dfs(char[][] letters, boolean[][] visited, int i, int j, StringBuilder str, Set<String> wordSet,
			List<String> ans) {
		if (i < 0 || i >= letters.length ||
	            j < 0 || j >= letters[0].length) {
	            return;
	        }
		
		visited[i][j] = true;
		str.append(letters[i][j]);
		
		if (wordSet.contains(str.toString()))
			ans.add(str.toString());
		
		
		//perform dfs in all valid directions
		for (int count =0 ; count < 8; count++) {
			int newi = i + dx[count];
			int newj = j + dy[count];
			if (newi < 0 || newi >= letters.length ||
		            newj < 0 || newj >= letters[0].length) {
		            continue;
		        }
			
			if (!visited[newi][newj]) {
				dfs(letters, visited, newi, newj, str, wordSet,ans);
			}
		}
		
		//backtrack
		visited[i][j] = false;
		
		str.deleteCharAt(str.length() - 1);
		
	}

	static List<String> findWords(List<String> words, char[][] letters) {

		int n = letters.length, m = letters[0].length;
		List<String> ans = new ArrayList<>();

		// store the words in the hashSet
		Set<String> wordSet = new HashSet<>(words);

		// to mark the cell visited
		boolean[][] visited = new boolean[n][m];

		// perform dfs on each cell of the grid
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				StringBuilder str = new StringBuilder();
				if (!visited[i][j]) {
					dfs(letters, visited, i, j, str, wordSet, ans);
				}
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		List<String> words = Arrays.asList("geeks", "for", "quiz", "go");
		char[][] letters = { { 'g', 'i', 'z' }, { 'u', 'e', 'k' }, { 'q', 's', 'e' } };
		List<String> ans = findWords(words, letters);
		for (String word : ans) {
			System.out.print(word + " ");
		}
	}

}
