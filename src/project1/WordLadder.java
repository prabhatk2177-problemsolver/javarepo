package project1;



import java.util.*;

public class WordLadder {
	
	static int count = 1;

    // Recursive function to find the shortest transformation chain
    public static int minWordTransform(String start, String target, 
                                    Map<String, Integer> mp) {
        // If start word is the same as target, no transformation is needed
        if (start.equals(target)) return 1;

        int mini = Integer.MAX_VALUE;

        // Mark current word as visited
        mp.put(start, 1);

        // Try changing each character of the word
        for (int i = 0; i < start.length(); i++) {
            char[] chars = start.toCharArray();
            char originalChar = chars[i];

            // Try all possible lowercase letters at position i
            for (char ch = 'a'; ch <= 'z'; ch++) {
                chars[i] = ch;
                String transformed = new String(chars);
               // mp.put(transformed, 1);
                //System.out.println( count + " Transformed String =" + transformed);
                count ++;
                // If the new word exists in dictionary and is not visited
               if (mp.containsKey(transformed) && mp.get(transformed) == 0) {
                    // Recursive call for next transformation
             //   if (mp.containsKey(transformed) ) 
            	   System.out.println( count + " Transformed String =" + transformed + " PASSED");
                    mini = Math.min(mini, 1 + 
                               minWordTransform(transformed, target, mp));
               }
               System.out.println( count + " Transformed String ="  +  transformed+ " FAILED");
            }

            // Restore original character before moving to the next position
            chars[i] = originalChar;
        }

        // Mark current word as unvisited (backtracking)
       mp.put(start, 0);

        return mini;
    }

    // Wrapper function to prepare the map and call recursive function
    public static int wordLadder(String start, String target,
                                      ArrayList<String> arr) {
        
        Map<String, Integer> mp = new HashMap<>();

        // Initialize all words from the dictionary as unvisited
        for (String word : arr) {
            mp.put(word, 0);
        }

        int result =  minWordTransform(start, target, mp);
        if(result==Integer.MAX_VALUE)
            result = 0;
            
        return result;
    }

    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>(Arrays.asList(
            "poon", "plee", "same", "poie", "plie", "poin", "plea"));
       // ArrayList<String> arr = new ArrayList<>(Arrays.asList(
           //     "poo", "ple", "sam", "poi", "pli", "poi", "plea"));   
        String start = "toon";
        String target = "plea";

        System.out.println(wordLadder(start, target, arr));
    }
}